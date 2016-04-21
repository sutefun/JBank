import java.util.*;
import java.text.*;
import java.io.*;

/**
 * @author (steven susanto) 
 * @version (5/3/16)
 */
public class Customer implements Comparable<Customer>,Serializable
{
    private Account[] accounts = new Account[4];
    private String  cityAddress;
    private Integer     custID;
    private Date    dateOfBirth;
    private String  email;
    private String  firstName;
    private String  lastName;
    private int     numOfAccounts;
    private String  streetAddress;
    private String  phoneNumber;
    private String  state;
    private String  zip;
    private static String cek = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    private static java.util.regex.Pattern p = java.util.regex.Pattern.compile(cek);
    private static DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
    
    public Customer()
    {
        
    }
    
   public Customer(String fname, String lname)
   {
       this(fname,lname,(new GregorianCalendar().getTime()));
   } 
    
   public Customer(String fname, String lname, Date dob)
   {
       firstName    =fname;
       lastName     =lname;
       dateOfBirth  =dob;
       custID       =Bank.getNextID();
   }
   
   public Customer(String fname, String lname, String dob)
   {
       SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
       
       firstName           =fname;
       lastName            =lname;
       
       try{
           dateOfBirth         =df.parse(dob);
       }
       catch(Exception e){}
       
       custID              =Bank.getNextID();
   } 
   
    /**@return alamat jalan*/
   public String getAddress()
   {
       return streetAddress;   
    }
    
   public String getCity()
   {
       return cityAddress;
   }
   
   public String getState()
   {
       return state;
   }
   
   public String getZip()
   {
       return zip;
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
       return custID;
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
  public void setAddress(String street, String city, String st,String code)
  {
      streetAddress=street;
      cityAddress=city;
      state = st;
      zip=code;
      
      
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
  public void setName(String fname, String lname)
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
  public boolean addAccount(double balance, char type) throws AccountTypeAlreadyExistsException,AccountTypeNotFoundException
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
               
                accounts[notUsed] = new Savings(this,balance);
            }
            if(type=='I')
            {
                accounts[notUsed] = new Investment(this,balance,6);
            }
            if(type=='L')
            {
                accounts[notUsed] = new LineOfCredit(this,balance,1000);
            }
            
                if(type=='O')
                {
                    accounts[notUsed] = new OverDraftProtection(this,balance,(Savings)getAccount('S'));
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
    custID=id;
    
   }
  
  /**
   * @return String:lastName
   */
  public String getLastName()
  {
      return lastName;
  }
  
  /**
   * @return String:firstName
   */
  public String getFirstName()
  {
     return firstName;
  }
  
  /**
   * @return dateOfBirth
   */
  public Date getDateOfBirth()
  {
      return dateOfBirth;
   }
   
  public String getDateOfBirthInString()
  {
      
      return df.format(dateOfBirth);
   }
  
  public void setDateOfBirth(Date d)
  {
      dateOfBirth = d;
  }
   
  public void setDateOfBirthInString(String s)
  {
      try{
          dateOfBirth = df.parse(s);
        }
        catch(Exception e){
          dateOfBirth = new Date();
        }
  }
  
  public String toString()
  {
    return firstName +" "+lastName+" "+custID;
  }
  
  public int compareTo(Customer c)
  {
    return custID.compareTo(c.getCustID());
  }
}
