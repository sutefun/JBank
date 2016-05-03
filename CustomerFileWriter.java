import java.util.*;
import java.io.*;
import java.nio.file.*;
import javax.crypto.*;
import java.security.*;
import java.security.spec.KeySpec;
import javax.crypto.spec.*;

/**
 * Write a description of class CustomerFileWriter here.
 * 
 * @author steven susanto
 * @version 21 April 2016
 */
public class CustomerFileWriter
{
    static private FileOutputStream fileOutputStream;
    static private File             objectFile  = new File("customer.crypto");
    static private ObjectOutputStream objectOutputStream;
    
    
    /**
     * -untuk menyimpan file customers menjadi .dat
     * @param Object
     * @throws IOException
     * 
     */
    static synchronized public void saveCustomers(Object l) throws IOException
    {
       saveCustomersFile((Serializable)l, objectFile, "steven_susanto_1306412035") ;
       
    }
    
    /**
     * -untuk menyimpan file customers menjadi file
     * @param Object , File
     * @throws IOException
     * 
     */
    static synchronized public void saveCustomersFile(Object l,File file) throws IOException
    {
       fileOutputStream = new FileOutputStream(file);
       objectOutputStream = new ObjectOutputStream(fileOutputStream);
       try{
        objectFile.delete();
       }
       catch(SecurityException e)
       {
        System.out.println("CFW - " + e.getMessage()); 
       }
       finally
       {
        objectOutputStream.writeObject(l);
        objectOutputStream.close();
        fileOutputStream.close();
       }
       
        
    }
    
    
    /**
     * -untuk menyimpan file customers menjadi file dengan enkripsi
     * @param Object , File
     * 
     */
    static synchronized public void saveCustomersFile(Serializable object,  File file, String password) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            SecretKey secret = new SecretKeySpec( md.digest() ,"AES" );
            
            cipher.init(Cipher.ENCRYPT_MODE, secret , new IvParameterSpec(md.digest()));
            SealedObject sealedObject = new SealedObject(object, cipher);
            CipherOutputStream cipherOutputStream = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(file)), cipher);
            
            ObjectOutputStream outputStream = new ObjectOutputStream(cipherOutputStream);
            outputStream.writeObject(sealedObject);
            cipherOutputStream.close();
            outputStream.close();  
        }
        catch(Exception e){
            System.out.println("CFW - crypto warning ! " +e.getMessage());
        }
    }
    
    
}
