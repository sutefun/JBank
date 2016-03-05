
/**
 * @author (steven susanto) 
 * @version (5/3/16)
 */
public class Customer
{
    private Account accounts= new Account();
    private String  cityAddress;
    private int     custId;
    private String  dateOfBirth;
    private String  email;
    private String  firstName;
    private String  lastName;
    private int     numberOfCurrentAccounts;
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
       this(fname,lname,"none");
   } 
    
   public Customer(String fname, String lname, String dob)
   {
       firstName=fname;
       this.lastName=lname;
       this.dateOfBirth=dob;
       this.custId=Bank.getNextId();
   }
    
   public Customer(String firstName, String lastName, String dateOfBirth, int custId)
   {
    }
    
    /**@return alamat jalan, nama kota, dan kode pos */
   public String getAddress()
   {
       return streetAddress+','+cityAddress+','+zipOrPostalCode;   
    }
   /**@return accounts */
   public Account getAccount()
   {
       return accounts;
    }
    
    /**@return custId , merupakan id kustomer*/
   public int getCustId()
   {
       return custId;
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
       return numberOfCurrentAccounts;
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
  public void setAccount(Account account)
  {
    accounts=account;
    }
    
  public void setCustId(int id)
  {
    custId=id;
    
   }
  
  public boolean removeAccount(char type)
  {
      return false;
  }
   
  public String toString()
  {
    return null;
  }
}
