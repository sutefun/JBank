
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
       a1.setBalance(10000);
       System.out.println("" +a1.getBalance());
    }
    

    public Teller()
    {
       
    }

}
