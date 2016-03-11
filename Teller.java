
/**
 * @author (steven susanto) 
 * @version (5/3/16)
 */
import java.util.*;
import java.text.*;
import java.math.*;

public class Teller
{
    /**@param belum ada */
    public static void main(String[] args) throws ParseException
    {
        Account saving      = new Account('S',1000);
        Account invest      = new Account('I',1000);
        Account creditline  = new Account('L',500);
        
        BigDecimal savingBalance = new BigDecimal(saving.getBalance());
        BigDecimal n             = new BigDecimal(360.0);
        BigDecimal t             = new BigDecimal(1.0);
        BigDecimal r             = new BigDecimal(.03);
        
        BigDecimal f1            = r.divide(n,BigDecimal.ROUND_HALF_EVEN).add(BigDecimal.ONE));
        BigDecimal f2            = n.multiply(t); 
        double     f3            = Math.pow(f1.doubleValue(),f2.doubleValue());
        saving.setBalance(saving.getBalance()*f3);
        System.out.println(saving.getBalance());
        
        r   = BigDecimal.valueOf(.05);
        f1  = r.divide(n,10,BigDecimal.ROUND_UNNECESSARY).add(BigDecimal.ONE);
        t   = BigDecimal.valueOf(0.5);
        f2  = n.multiply(t);
        f3  = Math.pow(f1.doubleValue(),f2.doubleValue());
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        invest.setBalance(invest.getBalance()*f3);
        
        r   = BigDecimal.valueOf(.06);
        f1  = r.divide(n,200,BigDecimal.ROUND_UNNECESSARY).add(BigDecimal.ONE);
        t   = BigDecimal.valueOf(0.5);
        f2  = n.multiply(t);
        f3  = Math.pow(f1.doubleValue(),f2.doubleValue());
        System.out.println(n);
        invest.setBalance(invest.getBalance()*f3);
        System.out.println(invest.getBalance());
        
     /**  setStartTime(8,15);
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

    public void tes()
    {
    
    }
    
    public static void setStartTime(int hour,int minute)
    {
        
       Bank.setStartTime(hour,minute);
    }
    
    public static Date getStartTime()
    {
        return Bank.getStartTime();
    }
    
    public static void setCloseTime(int hour,int minute)
    {
        Bank.setCloseTime(hour,minute);
    }
    
    public static Date getCloseTime()
    {
        return Bank.getCloseTime();
    }
    
    
}
