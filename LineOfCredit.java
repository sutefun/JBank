import java.util.*;
import java.io.*;
/**
 * Write a description of class LineOfCredit here.
 * 
 * @author steven susanto
 * @version 26 Maret 2016
 */
public class LineOfCredit extends Checking implements Serializable
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
    
    public double getCreditLeft()
    {
        return creditBalance + creditLimit;
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
        if(amount <= balance) //bila amount di bawah balance, langsung tarik
        {
            balance -= amount;
        }
        else if(amount > balance && amount-balance <= creditLimit + creditBalance)
        {  // bila amount melebihi balance, tetapi selisihnya tidak melebihi credit limit dikurangi credit balance
            creditBalance -= (amount - balance);
            balance = 0;
            
        }
        else
        {
            throw new AmountOverDrawnException(this);
        }
    }
}
