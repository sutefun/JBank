import java.util.*;
import java.io.*;

/**
 * Write a description of class CustomerFileReader here.
 * 
 * @author steven susanto
 * @version 21 April 2016
 */
public class CustomerFileReader implements Serializable
{
    private FileInputStream fileInputStream;
    private File            objectFile;
    private ObjectInputStream objectInputStream;
    
    /**
     * konstruktor CustomerFileReader
     */
    public CustomerFileReader()
    {
        
        
    }
    
    /**
     * -untuk membaca customer.dat
     * @throws IOException, ClassNotFoundException, NullPointerException
     * 
     */
    public Object readCustomer() throws IOException,ClassNotFoundException,NullPointerException
    {
        Object customers = null;
        
            fileInputStream = new FileInputStream("customer.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);
            customers = objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        System.out.println("CFR - berhasil import");
        return customers;
        
    }
    
}
