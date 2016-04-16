
/**
 * @author (steven susanto) 
 * @version (12/3/16)
 */
import java.util.*;
import java.text.*;
import java.math.*;

public class Teller
{
    /**@param belum ada */
    public static void main(String[] args)
    {
        
        
        
        Customer c = new Customer ("steven","susanto","1995/2/8");
        c.setEmail("steven.susanto31@ui.ac.id");
        c.setPhoneNumber("082112688821");
        c.setAddress("dimana yah","Jakarta Barat","DKI Jakarta","1234");
        
        
        buat4akun(c);
        System.out.println("nama\t" +c.getCustName());
        print4akun(c);
        try{
            Bank.addCustomer(c);
        }
        catch(Exception e){}
        ATMGUI atmgui = new ATMGUI();
        CustomerGUI custgui = new CustomerGUI();
      
        /*  setStartTime(9,0);
       setCloseTime(17,0);
       String fname,lname,telpon,indikator;
       char type;
       double balance;
       int i=0,j=0;
       Date dob;
       SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
       Scanner in = new Scanner(System.in);
       System.out.println(Bank.getHoursOfOperation());
       System.out.println("apakah ingin membuat customer ? [y/n]");
       indikator = in.nextLine(); 
      if(indikator.equals("n"))
      {
          System.out.println("bye");
          System.exit(0); 
       }
      do{
         
       System.out.println("First Name : ");
       fname = in.nextLine();
       System.out.println("Last Name : ");
       lname = in.nextLine();
       System.out.println("Year birth :");
       int year=in.nextInt();
       System.out.println("month birth :");
       int month=in.nextInt()-1;
       System.out.println("day birth :");
       int day=in.nextInt();
       Customer customer = new Customer(fname,lname,(new GregorianCalendar(year,month,day).getTime()));
       System.out.println("No Telpon :");
       telpon=in.nextLine();
       customer.setPhoneNumber(telpon);
       System.out.println("Jenis account saving? [S/O/I/L/n-tidak membuat]");
       type=in.next().trim().charAt(0);
       while(type!='S'&&type!='O'&&type!='I'&&type!='L'&&type!='n')
       {
        System.out.println("input salah");
        type=in.next().trim().charAt(0);
        }
       if(type!='n')
        {
            String id = String.valueOf(customer.getCustId()+""+type);
            Account account=new Account();
            account.setID(id);
            customer.setAccount(account);
            
            System.out.println("balance awal ?");
            balance=in.nextDouble();
            while(balance<10)
            {
                System.out.println("balance kurang, masukkan lagi");
                balance=in.nextDouble();
            }
        
            customer.getAccount().setBalance(balance);
        }
        else
        {
            customer.getAccount().setBalance(0);
        }
        
        System.out.println(customer);
        System.out.println("apakah ingin membuat customer ? [y/n]");
        indikator = in.nextLine(); 
        indikator = in.nextLine(); 
        }while(indikator.equals("y"));
       
        System.out.println("----------------------------------------");
      in.close();   
      
      */
    }
    

    public Teller()
    {
       
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
        catch(AccountTypeAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            c.addAccount(1000,'I');
        }
        catch(AccountTypeAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            c.addAccount(1500,'L');
        }
        catch(AccountTypeAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            c.addAccount(2000,'O');
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
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
}
