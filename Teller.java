
/**
 * @author (steven susanto) 
 * @version (12/3/16)
 */
import java.util.*;
import java.text.*;
import java.math.*;
import java.io.*;

public class Teller
{
    public TreeSet<Customer> customers = new TreeSet<Customer>();
    
    public Teller()
    {
        
        try{
            CustomerFileReader cfr = new CustomerFileReader();
            customers = (TreeSet)cfr.readCustomer() ;
            customers.forEach(System.out::println);
            System.out.println("------hasil pembacaan customer.dat di atas, di bawah bukan----------");
        }
        catch(Exception e)
        {
            customers = new TreeSet<Customer>();
        }
    }
    
    /**@param belum ada */
    public static void main(String[] args)
    {
        /*
        Teller t = new Teller();
        t.createNewCustomer(new Customer("susanto","steven"));
        t.createNewCustomer(new Customer("susanto2","steven2"));
        t.createNewCustomer(new Customer("susanto3","steven3"));
        t.createNewCustomer(new Customer("susanto4","steven4"));
        t.createNewCustomer(new Customer("susanto5","steven5"));
        t.createNewCustomer(new Customer("susanto6","steven6"));
        t.createNewCustomer(new Customer("susanto7","steven7"));
        
        System.out.println("membuat susanto ..... susanto7");
        //System.out.println("mencari kustomer dengan id 1000 : " +t.getCustomer(1000) );
        //System.out.println("mencari kustomer dengan id 1001 : " +t.getCustomer(1001) );
        
        //System.out.println("print semua isi treeSet");
        //t.customers.forEach(System.out::println);
        
        
        try{
            CustomerFileWriter fileWriter = new CustomerFileWriter();
            fileWriter.saveCustomers(t.customers);
        }
        catch(IOException e)
        {
            
            System.out.println("teller - writer - " +e.getMessage());
        }
        */
       
        /*
       for(char i='a';i<='z';i++)
       {
           
           buatCustDummy(String.valueOf(i));
       }
       Bank.exportCustomer();
        */
       Bank.importCustomer();
       new ATMGUI();
       new CustomerGUI();
    }
    
    /**
     * @param int:hour,int:minute , waktu mulai kerja bank dalam jam dan menit
     */
    public static void setStartTime(int hour,int minute)
    {
        
       Bank.setStartTime(hour,minute);
    }
    
    /**
     * @return int:hour,int:minute , waktu mulai kerja bank dalam jam dan menit
     */
    public static Date getStartTime()
    {
        return Bank.getStartTime();
    }
    
    /**
     * @param int:hour,int:minute , waktu tutup bank dalam jam dan menit
     */
    public static void setCloseTime(int hour,int minute)
    {
        Bank.setCloseTime(hour,minute);
    }
    
    /**
     * @return int:hour,int:minute , waktu tutup bank dalam jam dan menit
     */
    public static Date getCloseTime()
    {
        return Bank.getCloseTime();
    }
    
    static private void buat4akun(Customer c)
    {
        try{
            c.addAccount(500,'S');
        }
        catch(AccountTypeNotFoundException e)
                  {
                      
                  }
        catch(AccountTypeAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            c.addAccount(1000,'I');
        }
        catch(AccountTypeNotFoundException e)
                  {
                     
                  }
        catch(AccountTypeAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            c.addAccount(1500,'L');
        }
        catch(AccountTypeNotFoundException e)
                  {
                     
                  }
        catch(AccountTypeAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            c.addAccount(2000,'O');
        }
        catch(AccountTypeNotFoundException e)
                  {
                      
                  }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    private static void buatCustDummy(String s)
    {
       
        Customer c = new Customer(s,s);
        buat4akun(c);
        byte a[] = s.getBytes();
        String ascii = new String(a);
        c.setAddress("street "+s, "city "+s, "state "+s, ascii);
        c.setEmail(s+"@"+s+".com");
        c.setPhoneNumber(ascii);
        try{
           Bank.addCustomer(c);
        }
        catch(Exception e)
        {
        }
    }
    
    static private void print4akun(Customer c)
    {
        
        try{
            System.out.println("saldo saving\t" +c.getAccount('S').getBalance());
        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            System.out.println("saldo investment\t" +c.getAccount('I').getBalance());
        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            System.out.println("saldo Line of credit\t" +c.getAccount('L').getBalance());
        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
       try{
            System.out.println("saldo Overdraft protection\t" +c.getAccount('O').getBalance());
       
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void createNewCustomer(Customer c)
    {
        customers.add(c);
    }
    
    public Customer getCustomer(int custID)
    {
        Customer c;
        Iterator itr = customers.iterator();
        while(itr.hasNext())
        {
            c = (Customer)itr.next();
            if(c.getCustID() == custID)
            {
                return c;
            }
        }
        return null;
    }
}
