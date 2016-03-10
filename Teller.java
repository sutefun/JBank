
/**
 * @author (steven susanto) 
 * @version (5/3/16)
 */
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
public class Teller
{
    /**@param belum ada */
    public static void main(String[] args) throws ParseException
    {
       setStartTime(8,15);
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
       int month=in.nextInt();
       System.out.println("day birth :");
       int day=in.nextInt();
       System.out.println("No Telpon :");
       telpon=in.nextLine();
       Customer customer = new Customer(fname,lname,(new GregorianCalendar(year,month,day).getTime()));
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
