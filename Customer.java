import java.util.*;
import java.text.*;
/**
 * @author (steven susanto) 
 * @version (5/3/16)
 */
public class Customer
{
    private Account[] accounts = new Account[4];
    private Savings savings;
    private String  cityAddress;
    private int     CustID;
    private Date    dateOfBirth;
    private String  email;
    private String  firstName;
    private String  lastName;
    private int     numOfAccounts;
    private String  streetAddress;
    private String  phoneNumber;
    private String  zipOrPostalCode;
    private static String cek = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    private static java.util.regex.Pattern p = java.util.regex.Pattern.compile(cek);
    
    public Customer()
    {
        
    }
    
   public Customer(String fname, String lname)
   {
       this(fname,lname,(new GregorianCalendar().getTime()));
   } 
    
   public Customer(String fname, String lname, Date dob)
   {
       firstName=fname;
       lastName=lname;
       dateOfBirth=dob;
       CustID=Bank.getNextID();
   }
    
   public Customer(String firstName, String lastName, String dateOfBirth, int CustID)
   {
    }
    
    /**@return alamat jalan, nama kota, dan kode pos */
   public String getAddress()
   {
       return streetAddress+','+cityAddress+','+zipOrPostalCode;   
    }
   /**@return accounts */
   public Account getAccount(char type)  throws AccountTypeNotFoundException
   {
       for(int i=0;i<accounts.length;i++)
       {
           if(accounts[i] !=null)
           {
               if(type =='I' && accounts[i] instanceof Investment)
               {
                   return accounts[i];
                }
               if(type =='S' && accounts[i] instanceof Savings && accounts[i] instanceof Investment == false )
               {
                   return accounts[i];
                }
               
               if(type =='L' && accounts[i] instanceof LineOfCredit)
               {
                   return accounts[i];
                }
               if(type =='O' && accounts[i] instanceof OverDraftProtection)
               {
                   return accounts[i];
                }
           } 
        }
       
        throw new AccountTypeNotFoundException(type);
    }
    
    public boolean removeAccount(char type) throws AccountTypeNotFoundException
  {
      for(int i=0;i<accounts.length;i++)
       {
           if(accounts[i] !=null)
           {
               if(type =='S' && accounts[i] instanceof Savings && accounts[i] instanceof Investment == false )
               {
                   accounts[i] = null;
                   savings     = null;
                   numOfAccounts--;
                   return true;
                }
               if(type =='I' && accounts[i] instanceof Investment)
               {
                   accounts[i] = null;
                   numOfAccounts--;
                   return true;
                }
               if(type =='L' && accounts[i] instanceof LineOfCredit)
               {
                   accounts[i] = null;
                   numOfAccounts--;
                   return true;
                }
               if(type =='O' && accounts[i] instanceof OverDraftProtection)
               {
                   accounts[i] = null;
                   numOfAccounts--;
                   return true;
                }
           } 
        }
       
      
      throw new AccountTypeNotFoundException(type);
  }
    
    /**@return CustID , merupakan id kustomer*/
   public int getCustID()
   {
       return CustID;
    }
    
    /**@return email    ,merupakan email kustomer*/
   public String getEmail()
   {
       return email;
    }
    
    /**@return lastName,firstName   ,mengembalikan nama lengkap, tapi terbalik*/
   public String getCustName()
   {
       return lastName+','+firstName;
    }
    
    /**@return numberOfCurrentAccounts  ,jumlah akun sekarang*/
   public int getNumOfAccounts()
   {
       return numOfAccounts;
    }
    
    /**@return phoneNumber      ,nomor telpon kustomer*/
   public String getPhoneNumber()
   {
       return phoneNumber;
    }
    
    /**@param String street, String city, String code   */
  public void setAddress(String street, String city, String code)
  {
      streetAddress=street;
      cityAddress=city;
      zipOrPostalCode=code;
      
      
    }
    
    /**@param String emailAddress
     * @return true , bila email valid  */
     
  public boolean setEmail(String emailAddress)
  {
     
      java.util.regex.Matcher m = p.matcher(emailAddress);
       
      if(m.matches())
      {
      email=emailAddress;
      return true;
      }
      else
      {
        return false;
        }
      
    }
  
    /**@param String lname, String fname    */
  public void setName(String lname, String fname)
  {
      lastName=lname;
      firstName=fname;
    }   
    
    /**@param String phoneNum   */
  public void setPhoneNumber(String phoneNum)
  {
     phoneNumber=phoneNum; 
    }
    
    /**@param Account account   */
  public boolean addAccount(double balance, char type) throws AccountTypeAlreadyExistsException
  {
    boolean accountAdded=false;
    int notUsed = -1;
    if(numOfAccounts<5)
    {
        for(int i=0;i<accounts.length;i++)
        {
            if(accounts[i]==null && notUsed==-1)
            {
                notUsed=i;
            }
            else if(accounts[i] != null)
            {
                if(type =='S' && accounts[i] instanceof Savings && accounts[i] instanceof Investment == false )
               {
                   throw new AccountTypeAlreadyExistsException('S');
                }
               if(type =='I' && accounts[i] instanceof Investment)
               {
                   throw new AccountTypeAlreadyExistsException('I');
                }
               if(type =='L' && accounts[i] instanceof LineOfCredit)
               {
                   throw new AccountTypeAlreadyExistsException('L');
                }
               if(type =='O' && accounts[i] instanceof OverDraftProtection)
               {
                  throw new AccountTypeAlreadyExistsException('O');
                }
            }
        }
        
        if(notUsed!=-1 && !accountAdded)
        {
            if(type=='S')
            {
                savings           = new Savings(this,balance);
                accounts[notUsed] = savings;
            }
            if(type=='I')
            {
                accounts[notUsed] = new Investment(this,balance,6);
            }
            if(type=='L')
            {
                accounts[notUsed] = new LineOfCredit(this,balance,1000);
            }
            try{
                if(type=='O')
                {
                    accounts[notUsed] = new OverDraftProtection(this,balance,(Savings)getAccount('S'));
                }
            }
            catch(AccountTypeNotFoundException e)
            {
                System.out.println(e.getMessage() + ", can't create OverDraft Protect !!");
            }
            numOfAccounts++;
            accountAdded=true;
        }
        
    }
    
    return accountAdded;
    }
    
    
   /**
    * @param Id
    */ 
  public void setCustID(int id)
  {
    CustID=id;
    
   }
  
  
  /**
   * @return dateOfBirth
   */
  public Date getDateOfBirth()
  {
      return dateOfBirth;
   }
  
  public String toString()
  {
    return "hehe salah";
  }
}
