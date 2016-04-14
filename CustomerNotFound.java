
/**
 * @author steven susanto 
 * @version 14 April 2016
 */
public class CustomerNotFound extends Exception
{
    private int id;
    
    public CustomerNotFound(int i)
    {
       super("customer with id ");
       id = i;
    }

    public String getMessage()
    {
        
        return super.getMessage() + id + " does not exist";
    }
}
 