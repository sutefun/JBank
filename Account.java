
/**
 * @author (steven susanto) 
 * @version (24 Maret 2016)
 */
public  abstract class Account
{
    protected double balance;
    protected String ID;
    
       /** 
        * @return true,false , true bila jumlah uang yang deposit positif*
        * 
        */
    public boolean deposit(double amount)
    {
        if(amount < 0)
        {
            return false;
        }
        else
        {
            balance += amount;
            return true;
        }
        
    }
    
    
    /**
     * @return double:balance  ,mengembalikan jumlah saldo
     */
    public double getBalance()
    {
        return balance;     
    }
    
    /** 
     * @return String:ID, mengembalikan ID  dari akun  
     */
    public String getID()
    {
        return ID;      
    }
    
    /**
     * @param amount , mengatur balance
     */
    public void setBalance(double amount)
    {
        balance=amount;     
    }
  
    
    /**@return true,false   , true bila jumlah uang yang ditarik tidak 
     * menyebabkan balance menjadi negatir  
     */
    public abstract boolean withdraw(double amount);
    
    
    /**
     * @return String:ID , merupakan override dari toString yang default terdapat pada setiap objek (dalam hal ini acocunt)
     * diatur agar mengembalikan ID dari suatu akun yang sama dengan nilai pemilik/kustomernya.
     */
    public String toString()
    {
        return ID;
    }
}
