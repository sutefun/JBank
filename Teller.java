
/**
 
 * @author (steven susanto) 
 * @version (amodul1)
 */
public class Teller
{
    /**@param belum ada */
    public static void main(String[] args)
    {
       Customer c1 = new Customer();
       c1.setName("Sutandi","Sanadhi");
       System.out.println("" +c1.getCustomerName());
       
       Account a1=new Account();
       c1.setAccount(a1);
       c1.getAccount().setBalance(10000);
       System.out.println("" +c1.getAccount().getBalance());
    }
    

    public Teller()
    {
       
    }

}
