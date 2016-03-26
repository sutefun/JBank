import java.util.*;
import java.text.*;
import java.math.*;

/**
 * Write a description of class Investment here.
 * 
 * @author steven susanto 
 * @version 24 Maret 2016
 */

public final class Investment extends Savings
{
    private Date   endDate;
    private double interestRate;
    private Date   startDate;
    private int    term;
    
    /**
     * @param Customer:cust , double:amount, int:months
     * merupakan reference ke kustomer, uang sejumlah tertentu, dan waktu investasi dalam bulan integer
     * 
     */
    public Investment(Customer cust, double amount, int months)
    {
        super(cust,amount);
        if(months>6)
        {
            term = months;
        }
        else
        {
            term = 6;
        }
        Calendar s = new GregorianCalendar();
        startDate = s.getTime();
        s.add(Calendar.MONTH , term);
        endDate = s.getTime();
        if(term>12)
        {
            interestRate = 0.07;
        }
        else if(term<=12 && term >6)
        {
            interestRate = 0.06;
        }
        else
        {
            interestRate = 0.05;
        }
    }
    
    /**
     * @param int:days , untuk melakukan pembungaan dengan waktu dalam hari dengan bunga tertentu
     * 
     */
    public void addDailyInterest(int days)
    {
           System.out.println(interestRate);
           double f            = Math.pow( (1 + (interestRate/365)), days); //hasilnya merupakan koefisien pengali balance 
           System.out.println(f);                                           //yang menghasilkan balance+interest
           interestEarned      = balance * (f-1);             //untuk mendapatkan bunga maka dikurangi 1
           balance            *= f;                        //balance dikali dengan koefisien f yang merupakan
                                                          //koefisien hasil pembungaan
    }
    
    
    /**
     * @param double:amount , merupakan jumlah uang yang ditarik
     * @return true/false , true bila jumlah uang yang ditarik tidak melebihi balance bila sudah melewati batas investasi
     * atau true bila jumlah uang yang ditarik dan penalti tidak melebihi balance bila kurang dari batas waktu investasi
     */
    public boolean withdraw(double amount)
    {
        if(amount>balance)      
        {
            return false;
        }
        else if(Calendar.getInstance().after(endDate))  //bila pada saat penarikan waktu sudah melewati
        {                                               // term maka tidak dikenanakan penalti
            balance -= amount;
            return true;
        }
        else if(balance>(amount*1.2))       //waktu penarikan sebelum endDate, maka kena penalti
        {
            balance -= (amount*1.2);
            return true;
        }
        return false;
        
    }

}
