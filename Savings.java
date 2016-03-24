import java.util.*;
import java.text.*;
/**
 * Write a description of class Savings here.
 * 
 * @author steven susanto 
 * @version 24 Maret 2016
 */
public class Savings extends Account
{
  protected double interestEarned;  
    
  public Savings(Customer cust, double amount)
  {
    super();
    ID        = Integer.toString(cust.getCustID());
    balance   = amount;
  }
  
  /**
   * @param double:amount , merupakan jumlah uang yang akan ditarik
   * @return true/false , true bila jumlah amount tidak melebihi balance
   */
  public boolean withdraw(double amount)
  {
    if(amount>=0&&amount<=balance)
        {
            balance-=amount;
            return true;
        }
        else
        {
            return false;
        }
  }
  
  /**
   * @return double:interestEarned , merupakan jumlah bunga setelah periode tertentu
   */
  public double getInterestEarned()
  {
      return interestEarned;
  }
  
  /**
   * @param int:days , lamanya waktu untuk melakukan pembungaan
   */
  public void addDailyInterest(int days)
  {
      double interestRate = Bank.getPremiumRate();
      System.out.println(interestRate);
      double f            = Math.pow( (1 + (interestRate/365)), days); //hasilnya merupakan koefisien pengali balance 
      System.out.println(f);                                           //yang menghasilkan balance+interest
      interestEarned      = balance * (f-1);             //untuk mendapatkan bunga maka dikurangi 1
      balance            *= f;                        //balance dikali dengan koefisien f yang merupakan
                                                          //koefisien hasil pembungaan
  }
}
