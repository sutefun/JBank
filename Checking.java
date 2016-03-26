import java.util.*;
import java.text.*;

/**
 * Write a description of class Checking here.
 * 
 * @author steven susanto
 * @version 26 Maret 2016
 */
public abstract class Checking extends Account
{
    protected double monthlyFee;
    
    protected abstract void feeAssessment();
    
    /**
     * mereset monthly Fee menjadi 0
     * @param none
     * @return none
     * 
     */
    public void resetMonthlyFee()
    {
        monthlyFee = 0;
    }
    
    /**
     * @return double:monthlyFee
     */

    public double getMonthlyFee()
    {
        return monthlyFee;
    }
}
