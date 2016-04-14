import java.util.*;

/**
 * Write a description of class LineOfCredit here.
 * 
 * @author steven susanto
 * @version 26 Maret 2016
 */
public class LineOfCredit extends Checking
{
    private double creditBalance;
    private double creditLimit;
    
    
    public LineOfCredit(Customer cust, double amount, double limit)
    {
       super();
       balance     = amount;
       creditLimit = limit;
       ID          = Integer.toString(cust.getCustID());
    }

    public double getCreditBalance()
    {
        return creditBalance;
    }
    
    public double getCreditLimit()
    {
        return creditLimit;
    }
    
    public void setCreditBalance(double amount)
    {
        creditBalance = amount;
    }
    
    public void setCreditLimit(double amount)
    {
        creditLimit = amount;
    }
    
    public void feeAssessment()
    {
        int days       = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
        double deficit = -creditBalance;
        System.out.println("deficit " +deficit);
        double amt     = deficit * Math.pow( (1 + .21/365) , (days) );
        monthlyFee     = amt - deficit;
    }
    
    public void withdraw(double amount) throws AmountOverDrawnException
    {
        if(amount <= balance)
        {
            balance -= amount;
        }
        else if(creditLimit + creditBalance >0)
        {
            creditBalance -= amount;
        }
        else
        {
            throw new AmountOverDrawnException(this);
        }
    }
}
