
/**
 * 
 * @author steven susanto    
 * @version (14 April 2016
 */
public class AmountOverDrawnException extends Exception
{
    private Account account;
    
    public AmountOverDrawnException(Account acc)
    {
        super("Insufficient funds");
        account = acc;
    }
    
    public String getMessage()
    {
        String s = super.getMessage() + " ";
        
        if(account instanceof Investment)   // investment dulu baru saving, karena investment sub class saving
        {
            s += "In Investment Account" ;
        }
        else if(account instanceof Savings)
        {
            s += "In Savings Account" ;
        }
        else if(account instanceof LineOfCredit)
        {
            s += "In Line-Of-Credit Account" ;
        }
        else if(account instanceof OverDraftProtection)
        {
            s += "In Overdraft Protect Account" ;
        }
        
        return s;
    }
    
}
