import java.util.*;
import java.text.*;

/**
 * Write a description of class Bank here.
 * 
 * @author (steven susanto) 
 * @version (5/3/16)
 */
public class Bank
{
  
    
    private static Date   startTime;
    private static Date   closeTime;
    private static double investmentInterestRate;
    private static double creditInterestRate;
    private static double premiumInterestRate   = 0.03;
    private static int    lastCustID;
    private static int    nextCustID;
    private static String phone;
    public  static String website;
    public  static final  String BANK_ADDRESS          ="1234 JavaStreet,AnyCity,ThisState,34567";
    public  static final  int    MAX_NUM_OF_ACCTS_PER_CUSTOMER=4;
    
    public  static final  String BANK_NAME             ="JBANK";
    private static int    numOfCurrentCustomers=0;
    
  /*    static
      {
        System.out.println("masukkan MAX_NUM_OF_CUSTOMERS");
        Scanner in = new Scanner(System.in);
        MAX_NUM_OF_CUSTOMERS = in.nextInt();
      }
      
   */
    private static final int    MAX_NUM_OF_CUSTOMERS=30;
    //private static Customer customer[] = new Customer[MAX_NUM_OF_CUSTOMERS];
    private static ArrayList<Customer> customer = new ArrayList<Customer>();
    
    private Bank()
    {
    }
    
    /**@return bankAddress 
    public static String getAddress()
    {
        return bankAddress;
    }
    */
    /**@return creditInterestRate */
    public static double getCreditRate()
    {
        return creditInterestRate;
    }
    
    /**@return investmentInterestRate */
    public static double getInvestmentRate()
    {
        return investmentInterestRate;
    }
    
    /**@return closeTime */
    public static String getHoursOfOperation()
    {
        SimpleDateFormat startTimeFormat = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat closeTimeFormat = new SimpleDateFormat("hh:mm a");
        return startTimeFormat.format(Bank.getStartTime())+"   TO  "+closeTimeFormat.format(Bank.getCloseTime());
       
    }
    
    /**@return lastCustID */
    public static int getLastID()
    {
        return lastCustID;
    }
    
    /**@return maxNumOfCustomer */
    public static int getMaxCustomers()
    {
        return MAX_NUM_OF_CUSTOMERS;
    }
    
    /**@return bankName 
    public static String getName()
    {
        return bankName;
    }
    */
    /**@return website */
    public static String getWebsite()
    {
        return website;
    }
    
    /** @return premiumInterestRate*/
    public static double getPremiumRate()
    {
        return premiumInterestRate;
    }
    
    /** @return phone*/
    public static String getPhone()
    {
        return phone;
    }
    
    /** rate */
    public static void setCreditRate(double rate)
    {
       
    }
    
    /**@param rate */
    public static void setInvestmentRate(double rate)
    {
        
    }
    
    /**@param rate  */
    public static void setPremium(double rate)
    {
        
    }
    
    /**@return numOfCurrentCustomer , jumlah kustomer sekarang  */
    public static int getNumOfCurrentCustomers()
    {
        return numOfCurrentCustomers;
    }
    /**
    public static int getMaxNumOfCustomers()
    {
        return maxNumOfCustomers;
    }
    */
    /**@return nextCustID   */
    public static int getNextID()
    {
        int nextID=0;
        if(numOfCurrentCustomers>=MAX_NUM_OF_CUSTOMERS)
        {
           
        }
        else
        {
            //numOfCurrentCustomers ++;
            if(nextCustID==0)
            {   
                nextCustID=1000;
                nextID=nextCustID;
            }
            else
            {   
                lastCustID=nextCustID;
                nextCustID++;
                nextID=nextCustID;
                
                
            }
            
        }
        return nextID;
    }
    /**
     * @param Date
     */
    public static void setStartTime(int hours, int minute)
    {
        startTime = new GregorianCalendar(1970,0,0,hours,minute).getTime();
    }
    
    /**
     * @return startTime
     */
    public static Date getStartTime()
    {
        return startTime;
    }
    
    /**
     * @param Date
     */
    public static void setCloseTime(int hours, int minute)
    {
        closeTime = new GregorianCalendar(1970,0,0,hours,minute).getTime();
    }
    /**
     * @return closeTime
     */
    public static Date getCloseTime()
    {
        return closeTime;
    }
    
    /**
     * @param Customer:customer
     * @throws MaxCustReached
     * 
     */
    public static void addCustomer(Customer customer) throws MaxCustReached
    {
        if(numOfCurrentCustomers<MAX_NUM_OF_CUSTOMERS)
        {
            Bank.customer.add ( customer );
            System.out.println("-------BANK : customer ditambahkan----------");
            numOfCurrentCustomers++;
        }
        else
        {
            throw new MaxCustReached();
        }
    }
    
    /*
    public static Customer getCustomer(int custID) throws CustomerNotFound
    {
        for(int i=0;i<numOfCurrentCustomers;i++)
        {
            if(customer.get(i).getCustID()== custID)
            {
                return Bank.customer.get(i);
            }
        }
        
        throw new CustomerNotFound(custID);
    }
    */
   
   /**
    * @param int:custID
    * @return Customer:customer
    * @throws CustomerNotFound
    */
   public static Customer getCustomer(int custID) throws CustomerNotFound
    {
        
        Customer c;
        Iterator itr = customer.iterator();
        while(itr.hasNext())
        {
            c = (Customer)itr.next();
            if(c.getCustID() == custID)
            {
                return c;
            }
        }
        throw new CustomerNotFound(custID);
    }
   
   /**
    * untuk mengambil data dari customer.dat
    * @return boolean
    */
   public static boolean importCustomer()
   {
    try
    {
        CustomerFileReader cfr = new CustomerFileReader();
        customer = (ArrayList)cfr.readCustomer() ;
        customer.forEach(System.out::println);
        return true;
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
        return false;
    }
   }
   
   /**
    * untuk menyimpan menjadi customer.dat
    * @return boolean
    */
   public static boolean exportCustomer()
   {
    try{
            CustomerFileWriter fileWriter = new CustomerFileWriter();
            fileWriter.saveCustomers(customer);
            return true;
        }
        catch(Exception e)
        {
            System.out.println("Writer - " + e.getMessage());
            return false;
        }
    
   }
   
   public static ArrayList getArray()
   {
       return customer;
    }
   
}
