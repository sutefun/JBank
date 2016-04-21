import java.util.*;
import java.io.*;
import java.nio.file.*;

/**
 * Write a description of class CustomerFileWriter here.
 * 
 * @author steven susanto
 * @version 21 April 2016
 */
public class CustomerFileWriter implements Serializable
{
    private FileOutputStream fileOutputStream;
    private File             objectFile;
    private ObjectOutputStream objectOutputStream;
    
    
    public CustomerFileWriter()
    {
        
    }

    public void saveCustomers(ArrayList l) throws IOException
    {
       fileOutputStream = new FileOutputStream("customer.dat");
       objectOutputStream = new ObjectOutputStream(fileOutputStream);
       objectOutputStream.writeObject(l);
       objectOutputStream.close();
       fileOutputStream.close();
       System.out.println("Writer - <arrayList> save berhasil");
        
    }
    
    public void saveCustomers(SortedSet l) throws IOException
    {
       fileOutputStream = new FileOutputStream("customer.dat");
       objectOutputStream = new ObjectOutputStream(fileOutputStream);
       objectOutputStream.writeObject(l);
       objectOutputStream.close();
       fileOutputStream.close();
       System.out.println("Writer - <sortedSet> save berhasil");
        
    }
    
}
