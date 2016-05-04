
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
    public SortedSet customers;
    
    public Teller()
    {
        
    }
    
    /**@param belum ada */
    public static void main(String[] args)
    {
       
       
       //buatDummy();
       //Bank.exportCustomerSQL();
       //Bank.exportCustomer();
       
       Bank.importCustomerSQL();
       //Bank.importCustomer();
       
       (new Thread( new ATMGUI() ) ).start();
       (new Thread( new CustomerGUI() ) ).start();
    }
    
    /**
     * untuk buat dummy customer
     */
    private static void buatDummy(){
        for(char i='a';i<='z';i++)
       {
           
           buatCustDummy(String.valueOf(i));
       }
       
       
    
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
    
    /**
     * buat 4 akun dari customer dummy
     */
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
    
    /**
     * buat objek customer dummy
     */
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
    
    /**
     * 
     * untuk cek masing2 akun kustomer
     */
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
    
    /**
     * menambahkan customer ke arrayList/set customers
     */
    public void createNewCustomer(Customer c)
    {
        customers.add(c);
    }
    
    /**
     * untuk mendapatkan reference customer
     * @param int custID
     * @return Customer
     */
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
