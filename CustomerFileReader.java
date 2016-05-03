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
     * -untuk membaca customer file dari yang dipilih
     * @param File
     * @throws IOException, ClassNotFoundException, NullPointerException
     * 
     */
    synchronized static public Object readCustomerFile(File file) throws IOException,ClassNotFoundException,NullPointerException
    {
        Object customers ;
        
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            customers = objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        return customers;
        
    }
    
    
    /**
     * -untuk membaca customer file dari yang dipilih dengan password enkripsi
     * @param File
     * 
     */
    synchronized public static Serializable readCustomerFile(File file, String password) {
        try{
            Serializable userList = null;
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            SecretKey secret = new SecretKeySpec( md.digest() ,"AES" );
            
            cipher.init(Cipher.DECRYPT_MODE, secret , new IvParameterSpec(md.digest()));
            CipherInputStream cipherInputStream = null;
            cipherInputStream = new CipherInputStream(new BufferedInputStream(new FileInputStream(file)), cipher);
    
            ObjectInputStream inputStream = null;
            inputStream = new ObjectInputStream(cipherInputStream);
            SealedObject sealedObject = null;
            sealedObject = (SealedObject) inputStream.readObject();
            userList = (Serializable) sealedObject.getObject(cipher);  
            cipherInputStream.close();
            inputStream.close();
            return userList;
        }
        catch(Exception e){
            System.out.println("CFR - crypto warning ! " +e.getMessage());
        }
        
        return null;
    }
    
}
