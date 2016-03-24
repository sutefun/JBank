
/**
 * @author (steven susanto) 
 * @version (5/3/16)
 */
public  abstract class Account
{
    protected double balance;
    protected String ID;

       /** @return true,false    , true bila jumlah uang yang dideposit positif*/
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
    
    
    /**@return balance  mengembalikan jumlah saldo  */
    public double getBalance()
    {
        return balance;     
    }
    
    /** @return ID  mengembalikan ID    */
    public String getID()
    {
        return ID;      
    }
    
    /**@param amount    mengatur balance*/
    public void setBalance(double amount)
    {
        balance=amount;     
    }
  
    /**@return true,false   , true bila jumlah uang yang ditarik tIDak menyebabkan balance menjadi negatir  */
    public abstract boolean withdraw(double amount);
    /*{
        if(amount>=0&&amount<=balance)
        {
            balance-=amount;
            return true;
        }
        else
        {
            return false;
        }
    }*/
    
    /**
     * @return String:ID , merupakan override dari toString yang default terdapat pada setiap objek (dalam hal ini acocunt)
     * diatur agar mengembalikan ID dari suatu akun yang sama dengan nilai pemilik/kustomernya.
     */
    public String toString()
    {
        return ID;
    }
}
