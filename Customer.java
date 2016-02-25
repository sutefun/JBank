
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

   public Customer(String fname, String lname, String dob)
   {
   }
    
   public Customer(String firstName, String lastName, String dateOfBirth, int custId)
   {
    }
   
   private String getAddress()
   {
       return streetAddress+cityAddress+zipOrPostalCode;
    }
   
   private Account getAccount()
   {
       return accounts;
    }
    
   private int getCustomerId()
   {
       return custId;
    }
    
   private String getEmail()
   {
       return email;
    }
    
   private String getCustomerName()
   {
       return lastName+','+firstName;
    }
    
   public int getNumOfAccounts()
   {
       return numberOfCurrentAccounts;
    }
    
   private String getPhoneNumber()
   {
       return phoneNumber;
    }
    
  private void setAddress(String street, String city, String code)
  {
      streetAddress=street;
      cityAddress=city;
      zipOrPostalCode=code;
      
      
    }
    
  private void setEmail(String emailAddress)
  {
      email=emailAddress;
      
    }
  
  private void setName(String lname, String fname)
  {
      lastName=lname;
      firstName=fname;
    }   
    
  private void setPhoneNumber(String phoneNum)
  {
     phoneNumber=phoneNum; 
    }
    
  private void setAccount(Account account)
  {
    accounts=account;
    }
}
