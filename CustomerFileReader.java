import java.util.*;
import java.io.*;
import java.nio.file.*;
import javax.crypto.*;
import java.security.*;
import java.security.spec.KeySpec;
import javax.crypto.spec.*;


/**
 * Write a description of class CustomerFileReader here.
 * 
 * @author steven susanto
 * @version 21 April 2016
 */
public class CustomerFileReader
{
    static private FileInputStream fileInputStream;
    static private File            objectFile       = new File("customer.crypto");
    static private ObjectInputStream objectInputStream;
    
    
    /**
     * -untuk membaca customer.dat
     * @throws IOException, ClassNotFoundException, NullPointerException
     * 
     */
    static synchronized public Object readCustomer() throws IOException,ClassNotFoundException,NullPointerException
    {
        Object customers = readCustomerFile(objectFile, "steven_susanto_1306412035") ;
        return customers;
        
    }
    
    
    /**
     * -untuk membaca customer file dari yang dipilih dengan password enkripsi
     * @param File
     * 
     */
    synchronized public static Serializable readCustomerFile(File file, String password) {
        if(file == null || password == null){
            return null;
        }
        
        CipherInputStream cipherInputStream = null;
        ObjectInputStream inputStream = null;
        SealedObject sealedObject = null;
        Serializable userList = null;
        Cipher cipher = null;
        
        try{
            
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    
            MessageDigest md  = MessageDigest.getInstance("MD5");
            MessageDigest md2 = MessageDigest.getInstance("MD5");
            
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            
            SecretKey secret = new SecretKeySpec( bytes ,"AES" );
            
            md2.update(bytes);
            
            cipher.init(Cipher.DECRYPT_MODE, secret , new IvParameterSpec(md2.digest()));
            
            cipherInputStream = new CipherInputStream(new BufferedInputStream(new FileInputStream(file)), cipher);
    
            
            inputStream = new ObjectInputStream(cipherInputStream);
            
            sealedObject = (SealedObject) inputStream.readObject();
            userList = (Serializable) sealedObject.getObject(cipher);  
            cipherInputStream.close();
            inputStream.close();
        }
        catch(Exception e){
            System.out.println("CFR - crypto warning ! " +e.getMessage());
        }
        finally{
            
            
            return userList;
        
        }
        
    }
    
}
