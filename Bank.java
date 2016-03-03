
/**
 * Write a description of class Bank here.
 * 
 * @author (steven susanto) 
 * @version (modul1)
 */
public class Bank
{
    private static double creditInterestRate;
    private static String closeTime;
    private static double investmentInterestRate;
    private static int    lastCustId            =0;
    private static int    nextCustId            =0;
    private static String phone;
    private static double premiumInterestRate;
    private static String startTime;
    public  static String website;
    public  static final String BANK_ADDRESS          ="1234 JavaStreet,AnyCity,ThisState,34567";
    public  static final int    maxNumOfAcctsPerCustomer=4;
    public  static int    maxNumOfCustomers     =20;
    public  static final  String BANK_NAME             ="JBANK";
    private static int    numOfCurrentCustomers;
    
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
        return closeTime;
    }
    
    /**@return lastCustId */
    public static int getLastID()
    {
        return lastCustId;
    }
    
    /**@return maxNumOfCustomer */
    public static int getMaxCustomers()
    {
        return maxNumOfCustomers;
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
    /**@return nextCustId   */
    public static int getNextId()
    {
        int nextId=0;
        if(numOfCurrentCustomers>=maxNumOfCustomers)
        {
           
        }
        else
        {
            numOfCurrentCustomers ++;
            if(nextCustId==0)
            {   
                nextCustId=1000;
                nextId=nextCustId;
            }
            else
            {
                lastCustId=nextCustId;
                nextCustId++;
                nextId=nextCustId;
            }
            
        }
        return nextId;
    }
}
