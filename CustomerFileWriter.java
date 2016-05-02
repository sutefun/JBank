import java.util.*;
import java.io.*;
import java.nio.file.*;

/**
 * Write a description of class CustomerFileWriter here.
 * 
 * @author steven susanto
 * @version 21 April 2016
 */
public class CustomerFileWriter
{
    private FileOutputStream fileOutputStream;
    private File             objectFile;
    private ObjectOutputStream objectOutputStream;
    
    /**
     * konstruktor CustomerFileWriter
     */
    public CustomerFileWriter()
    {
        objectFile = new File("customer.dat");
    }

    /**
     * -untuk menyimpan file customers menjadi .dat
     * @param Object
     * @throws IOException
     * 
     */
    public void saveCustomers(Object l) throws IOException
    {
       fileOutputStream = new FileOutputStream("customer.dat");
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
        System.out.println("CFW - berhasil export");
       }
       
        
    }
    
    /**
     * -untuk menyimpan file customers menjadi file
     * @param Object , File
     * @throws IOException
     * 
     */
    public void saveCustomersFile(Object l,File file) throws IOException
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
    
    
}
