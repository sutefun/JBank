
/**
 
 * @author (steven susanto) 
 * @version (amodul1)
 */
import java.util.Scanner;

public class Teller
{
    /**@param belum ada */
    public static void main(String[] args)
    {
       String fname,lname,dob,telpon,indikator;
       char type;
       int balance;
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
       dob=in.nextLine();
       System.out.println("No Telpon :");
       telpon=in.nextLine();
       Customer customer = new Customer(fname,lname,dob);
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
            balance=in.nextInt();
            while(balance<0)
            {
                System.out.println("balance tidak boleh negatif, masukkan lagi");
                balance=in.nextInt();
            }
        
            customer.getAccount().setBalance(balance);
        }
        else
        {
            customer.getAccount().setBalance(0);
        }
        
        System.out.println("Nama    " +customer.getCustomerName());
        System.out.println("phone   " +customer.getPhoneNumber());
        System.out.println("akun    " +customer.getAccount().getId());
        System.out.println("balance " +customer.getAccount().getBalance());
        
        System.out.println("apakah ingin membuat customer ? [y/n]");
        indikator = in.nextLine(); 
        indikator = in.nextLine(); 
        }while(indikator.equals("y"));
      
      in.close();   
    }
    

    public Teller()
    {
       
    }

}
