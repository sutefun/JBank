import java.util.GregorianCalendar;
import java.util.Date;
/**
 * @author (steven susanto) 
 * @version (5/3/16)
 */
public class Customer
{
    private Account[] accounts = new Account[4];
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
            static java.util.regex.Pattern p = java.util.regex.Pattern.compile(cek);
    
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
   public Account getAccount(char type)
   {
       for(int i=0;i<accounts.length;i++)
       {
           if(accounts[i] !=null)
           {
           if(accounts[i].getID().lastIndexOf(type) != -1)
           {
               return accounts[i];
            }
           } 
        }
       
       return null;
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
   public String getCustomerName()
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
  public boolean addAccount(double balance, char type)
  {
    boolean accountAdded=false;
    int notUsed = -1;
    System.out.println(accounts.length);
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
                if(accounts[i].getID().endsWith(Character.toString(type)))
                {
                    System.out.println("ketemu sama");
                    return false;
                }
            }
        }
        
        if(notUsed!=-1 && !accountAdded)
        {
            accounts[notUsed] = new Account(this,balance,type);
            numOfAccounts++;
            System.out.println("added");
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
  
  public boolean removeAccount(char type)
  {
      for(int i=0;i<accounts.length;i++)
       {
           if(accounts[i] !=null)
           {
           if(accounts[i].getID().lastIndexOf(type) != -1)
           {
               accounts[i] = null;
               numOfAccounts--;
               return true;
            }
           } 
        }
       
      
      return false;
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
