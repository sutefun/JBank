
/**
 * 
 * @author steven susanto    
 * @version (14 April 2016
 */
public class AmountOverDrawnException extends Exception
{
    private Account account;
    private double j = 0;
    
    public AmountOverDrawnException(Account acc)
    {
        super("Insufficient funds");
        account = acc;
    }
    
    public AmountOverDrawnException(Account acc , double i)
    {
        super("Kena Penalty, penarikan ditambah 20% menjadi");
        account = acc;
        j = i;
    }
    
    
    public String getMessage()
    {
        String s = super.getMessage() + " ";
        
        if(account instanceof Investment && j == 0)   // investment dulu baru saving, karena investment sub class saving
        {
            s += "In Investment Account , balance " + account.getBalance() ;
        }
        
        if(account instanceof Investment && j != 0)
        {
            s += j + " , sedangkan balance " + account.getBalance();
        }
        
        if(account instanceof Savings && account instanceof Savings == false)
        {
            s += "In Savings Account , balance " + account.getBalance();
        }
        else if(account instanceof LineOfCredit)
        {
            LineOfCredit l = (LineOfCredit)account;
            double cr = l.getCreditLeft();
            s += "In Line-Of-Credit Account , balance " + account.getBalance() +" , allowable credit left " + cr;
        }
        else if(account instanceof OverDraftProtection)
        {
            s += "In Overdraft Protect Account , balance " + account.getBalance();
        }
        
        return s;
    }
    
}
