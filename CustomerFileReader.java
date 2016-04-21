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
    
    
    public CustomerFileReader()
    {
        
        
    }

    public ArrayList readCustomer() throws IOException,ClassNotFoundException,NullPointerException
    {
        Object customers = null;
        
            fileInputStream = new FileInputStream("customer.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);
            customers = objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        
        return (ArrayList)customers;
        
    }
    
}
