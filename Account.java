
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
        
       
    }

    /**@param type,amount       menerima type dan amount*/
    public Account(char type,double amount)
    {
        
    }
    
    private void deposit(double amount)
    {
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
    
    private void withdraw(double amount)
    {
    }
}