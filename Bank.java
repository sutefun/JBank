
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
    private static int    lastCustId            =1000;
    private static int    nextCustId            =1000;
    private static String phone;
    private static double premiumInterestRate;
    private static String startTime;
    public  static String website;
    public  static String bankAddress          ="1234 JavaStreet,AnyCity,ThisState,34567";
    public  static int    maxNumOfCustomer     =20;
    public  static String bankName             ="JBANK";
    private static int    numOfCurrentCustomer;
    private static int    nextID;
    
    /**@return bankAddress */
    public static String getAddress()
    {
        return bankAddress;
    }
    
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
        return maxNumOfCustomer;
    }
    
    /**@return bankName */
    public static String getName()
    {
        return bankName;
    }
    
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
        return numOfCurrentCustomer;
    }
    
    /**@return nextCustId   */
    public static int getNextId()
    {
        nextCustId=lastCustId+1;
        return nextCustId;
    }
}
