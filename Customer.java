
/**
 * @author (steven susanto) 
 * @version (modul 1)
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
    
    
    public Customer()
    {
        
    }
    /** tess tss */
   public Customer(String fname, String lname, String dob)
   {
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
   public int getCustomerId()
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
    
    /**@param String emailAddress   */
  public void setEmail(String emailAddress)
  {
      email=emailAddress;
      
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
}
