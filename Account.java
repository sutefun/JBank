
/**
 * @author (steven susanto) 
 * @version (5/3/16)
 */
public class Account
{
    
    private char acctType;
    private double balance;
    private String ID;
/*
    public Account()
    {
        acctType='S';
        balance=10;
       
    }
*/
    /**@param type,amount       menerima type dan amount*/
    public Account(Customer cust, double amount ,char type)
    {
        ID       = Integer.toString(cust.getCustID()) + Character.toString(type);
        acctType =type;
        balance  =amount;
        
    }
    
    
    
       /** @return true,false    , true bila jumlah uang yang dIDeposit positif*/
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
    
    /**@return acctType mengembalikan karakter tipe akun    */
    public char getAcctType()
    {
        return acctType;  
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
    
    /*@param acctID    mengatur ID
    public void setID(String acctID)
    {
        ID=acctID;          
    }
    */
    /**@param type  mengatur tipe akun*/
    public void setAcctType(char type)
    {
        acctType=type;      
    }
    /**@return true,false   , true bila jumlah uang yang ditarik tIDak menyebabkan balance menjadi negatir  */
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
}
