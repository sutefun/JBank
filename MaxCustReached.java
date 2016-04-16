
/**
 * @author steven susanto
 * @version 16 April 2016
 */
public class MaxCustReached extends Exception
{
   
    /**
     * Constructor for objects of class MaxCustReached
     */
    public MaxCustReached()
    {
        super("Max customer allowed reached");
    }
    
    public String getMessage()
    {
        return  super.getMessage();
    }

}
