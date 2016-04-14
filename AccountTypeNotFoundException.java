
/**
 * @author steven susanto 
 * @version 14 April 2016
 */
public class AccountTypeNotFoundException extends Exception
{
    private char accType;
    
    public AccountTypeNotFoundException(char acc)
    {
       super(" account does not exist");
       accType = acc;
    }

    public String getMessage()
    {
        String s = null;
    
        switch(accType)
        {
        case 'S' : s="Savings" + super.getMessage();
                   break;
                   
        case 'I' : s = "Investments" + super.getMessage();
                    break;
                    
        case 'L' : s = "Line-Of-Credit" + super.getMessage();
                    break;
                    
        case 'O' : s = "OverDraft Protect" + super.getMessage();
                    break;
                    
        }
        
        return s;
    }
}
