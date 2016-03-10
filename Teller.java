
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
      // Customer[] customer = new Customer[Bank.maxNumOfCustomers]; 
       String fname,lname,telpon,indikator;
       char type;
       double balance;
       int i=0,j=0;
       Date dob;
       SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
       Scanner in = new Scanner(System.in);
       
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
       System.out.println("DOB :");
       dob=dateFormatter.parse(in.nextLine());
       System.out.println("No Telpon :");
       telpon=in.nextLine();
       Customer customer = new Customer(fname,lname,dob);
       //Customer c = new Customer(fname,lname,(new GregorianCalendar(dob).getTime()));
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
       // System.out.println(customer.getDateOfBirth());
        System.out.println("apakah ingin membuat customer ? [y/n]");
        indikator = in.nextLine(); 
        indikator = in.nextLine(); 
        i++;
        }while(indikator.equals("y"));
       
       /* System.out.println("\n----------------------------------------");
       for(j=0;j<i;j++){
        System.out.println(customer[j]);
        }
       */ 
        System.out.println("----------------------------------------");
      in.close();   
    }
    

    public Teller()
    {
       
    }

    public void tes()
    {
    
    }
    
    public static void setStartTime()
    {
        
       Bank.setStartTime(8,15);
    }
    
    public static Date getStartTime()
    {
        return Bank.getStartTime();
    }
    
    public static void setCloseTime()
    {
        Bank.setCloseTime(17,0);
    }
    
    public static Date getCloseTime()
    {
        return Bank.getCloseTime();
    }
    
    
}
