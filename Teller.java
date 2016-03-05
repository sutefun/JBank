
/**
 
 * @author (steven susanto) 
 * @version (5/3/16)
 */
import java.util.Scanner;

public class Teller
{
    /**@param belum ada */
    public static void main(String[] args)
    {
       Customer[] customer = new Customer[Bank.maxNumOfCustomers]; 
       String fname,lname,dob,telpon,indikator;
       char type;
       int balance,i=0,j=0;
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
       customer[i] = new Customer(fname,lname,dob);
       customer[i].setPhoneNumber(telpon);
       System.out.println("Jenis account saving? [S/O/I/L/n-tidak membuat]");
       type=in.next().trim().charAt(0);
       while(type!='S'&&type!='O'&&type!='I'&&type!='L'&&type!='n')
       {
        System.out.println("input salah");
        type=in.next().trim().charAt(0);
        }
       if(type!='n')
        {
            String id = String.valueOf(customer[i].getCustId()+""+type);
            Account account=new Account();
            account.setID(id);
            customer[i].setAccount(account);
            
            System.out.println("balance awal ?");
            balance=in.nextInt();
            while(balance<10)
            {
                System.out.println("balance kurang, masukkan lagi");
                balance=in.nextInt();
            }
        
            customer[i].getAccount().setBalance(balance);
        }
        else
        {
            customer[i].getAccount().setBalance(0);
        }
        
        System.out.println("Nama    " +customer[i].getCustomerName());
        System.out.println("phone   " +customer[i].getPhoneNumber());
        System.out.println("akun    " +customer[i].getAccount().getId());
        System.out.println("balance " +customer[i].getAccount().getBalance());
        
        System.out.println("apakah ingin membuat customer ? [y/n]");
        indikator = in.nextLine(); 
        indikator = in.nextLine(); 
        i++;
        }while(indikator.equals("y"));
       
        System.out.println("\n----------------------------------------");
       for(j=0;j<i;j++){
        System.out.println("Nama    " +customer[j].getCustomerName());
        System.out.println("phone   " +customer[j].getPhoneNumber());
        System.out.println("akun    " +customer[j].getAccount().getId());
        System.out.println("balance " +customer[j].getAccount().getBalance());
        System.out.println("");
        }
        
        System.out.println("----------------------------------------");
      in.close();   
    }
    

    public Teller()
    {
       
    }

}
