
/**
 * @author steven susanto 
 * @version 14 April 2016
 */
public class AccountTypeAlreadyExistsException extends Exception
{
   private char accType;
   
   public AccountTypeAlreadyExistsException(char acc )
   {
       super("Unable to create duplicate account of type");
       accType = acc;
   }
   
   public String getMessage()
   {
        String s = super.getMessage() + " ";
        switch(accType)
        {
        case 'S' : s += "Savings";
                   break;
                   
        case 'I' : s += "Investments"; 
                    break;
                    
        case 'L' : s += "Line-Of-Credit";
                    break;
                    
        case 'O' : s += "OverDraft Protect";
                    break;
                    
        }
        return s;
   }
   
}
