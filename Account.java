
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

    public Account(char type,double amount)
    {
        
    }
    
    private void deposit(double amount)
    {
    }
    
    public char getAcctType()
    {
        return acctType;  //mengembalikan karakter tipe akun
    }
    
    private double getBalance()
    {
        return balance;     //mengembalikan jumlah saldo
    }
    
    public String getId()
    {
        return id;      //mengembalikan id
    }
    
    private void setBalance(double amount)
    {
        balance=amount;     //mengatur balance
    }
    
    public void setID(String acctId)
    {
        id=acctId;          //mengatur id
    }
    
    public void setAcctType(char type)
    {
        acctType=type;      //mengatur tipe akun
    }
    
    private void withdraw(double amount)
    {
    }
}
