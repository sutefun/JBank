import java.util.*;
import java.io.*;
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
    
    /**
     * konstruktor LOC
     * @param Customer, double amount, double limit
     */
    public LineOfCredit(Customer cust, double amount, double limit)
    {
       super();
       balance     = amount;
       creditLimit = limit;
       ID          = Integer.toString(cust.getCustID());
    }

    /**
     * aksesor creditBalance
     * @return double credit balance
     */
    public double getCreditBalance()
    {
        return creditBalance;
    }
    
    /**
     * aksesor creditLimit
     * @return double credit limit
     */
    public double getCreditLimit()
    {
        return creditLimit;
    }
    
    /**
     * aksesor credit untuk mengetahui sisa kredit yang dapat digunakan
     * @return double credit
     */
    public double getCreditLeft()
    {
        return creditBalance + creditLimit;
    }
    
    /**
     * untuk menset creditBalance
     * @param double : amount
     */
    public void setCreditBalance(double amount)
    {
        creditBalance = amount;
    }
    
    /**
     * untuk menset creditLimit
     * @param double : amount
     */
    public void setCreditLimit(double amount)
    {
        creditLimit = amount;
    }
    
    /**
     * untuk melakukan fee assessment
     */
    public void feeAssessment()
    {
        int days       = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
        double deficit = -creditBalance;
        System.out.println("deficit " +deficit);
        double amt     = deficit * Math.pow( (1 + .21/365) , (days) );
        monthlyFee     = amt - deficit;
    }
    
    /**
     * penarikan dana
     * @param double : amount
     * @throws AmountOverDrawnException
     */
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
