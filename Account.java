
/**
 * @author (steven susanto) 
 * @version (modul 1)
 */
public class Account
{
    
    private char acctType;
    private double balance;
    private String id;

    public Account()
    {
        acctType='S';
        balance=10;
       
    }

    /**@param type,amount       menerima type dan amount*/
    public Account(char type,double amount)
    {
        acctType=type;
        balance=amount;
        
    }
    
    
    
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
    
    /** @return id  mengembalikan id    */
    public String getId()
    {
        return id;      
    }
    
    /**@param amount    mengatur balance*/
    public void setBalance(double amount)
    {
        balance=amount;     
    }
    
    /**@param acctId    mengatur id*/
    public void setID(String acctId)
    {
        id=acctId;          
    }
    
    /**@param type  mengatur tipe akun*/
    public void setAcctType(char type)
    {
        acctType=type;      
    }
    /**@return true,false   , true bila jumlah uang yang ditarik tidak menyebabkan balance menjadi negatir  */
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
