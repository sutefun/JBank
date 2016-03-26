
/**
 * Write a description of class OverDraftProtection here.
 * 
 * @author steven susanto
 * @version 26 Maret 2016
 */
public class OverDraftProtection extends Checking
{
    private Savings savingsAccount;
    
    public OverDraftProtection(Customer cust, double amount, Savings savings)
    {
        super();
        balance        = amount;
        savingsAccount = savings;
        ID             = Integer.toString(cust.getCustID());
        
    }

    public void feeAssessment()
    {
        monthlyFee += 3;
        
    }
    
    public boolean withdraw(double amount)
    {
        if(amount > balance + savingsAccount.getBalance() - 10)
        {
            return false;
        }
        else if(amount > balance)
        { 
            savingsAccount.withdraw(amount - balance);
            balance = 0;
            feeAssessment();
            return true;
        }
        else
        {
            balance -= amount;
            return true;
        }
    }
}
