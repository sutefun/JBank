import java.io.*;
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

    /**
     * untuk menambah biaya fee
     */
    public void feeAssessment()
    {
        monthlyFee += 3;
        
    }
    
    /**
     * penarikan dana
     * @param double : amount
     * @throws AmountOverDrawnException
     */
    public void withdraw(double amount)  throws AmountOverDrawnException
    {
        if(amount > balance + savingsAccount.getBalance() - 10)
        {
             throw new AmountOverDrawnException(this);
        }
        else if(amount > balance)
        { 
            savingsAccount.withdraw(amount - balance);
            balance = 0;
            feeAssessment();
        }
        else
        {
            balance -= amount;
        }
    }
}
