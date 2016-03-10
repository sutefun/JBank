import java.util.Date;
import java.text.DateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
 * Write a description of class Bank here.
 * 
 * @author (steven susanto) 
 * @version (5/3/16)
 */
public class Bank
{
    private static Date startTime;
    private static Date closeTime;
    private static double investmentInterestRate;
    private static double creditInterestRate;
    private static double premiumInterestRate;
    private static int    lastCustId;
    private static int    nextCustId;
    private static String phone;
    public  static String website;
    public  static final String BANK_ADDRESS          ="1234 JavaStreet,AnyCity,ThisState,34567";
    public  static final int    MAX_NUM_OF_ACCTS_PER_CUSTOMER=4;
    public  static final int    MAX_NUM_OF_CUSTOMERS     =20;
    public  static final  String BANK_NAME             ="JBANK";
    private static int    numOfCurrentCustomers;
    public int tes=99;
    
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
    
    /**@return lastCustId */
    public static int getLastID()
    {
        return lastCustId;
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
    /**@return nextCustId   */
    public static int getNextId()
    {
        int nextId=0;
        if(numOfCurrentCustomers>=MAX_NUM_OF_CUSTOMERS)
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
}
