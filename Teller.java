
/**
 * @author (steven susanto) 
 * @version (12/3/16)
 */
import java.util.*;
import java.text.*;
import java.math.*;

public class Teller
{
    
    
    /**@param belum ada */
    public static void main(String[] args)
    {
        
        
        
        Customer c = new Customer ("steven","susanto");
        try{
            c.addAccount(500,'S');
        }
        catch(AccountTypeAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            c.addAccount(1000,'I');
        }
        catch(AccountTypeAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            c.addAccount(1500,'L');
        }
        catch(AccountTypeAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            c.addAccount(2000,'O');
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("nama\t" +c.getCustName());
        
        try{
            System.out.println("saldo saving\t" +c.getAccount('S').getBalance());
        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            System.out.println("saldo investment\t" +c.getAccount('I').getBalance());
        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            System.out.println("saldo Line of credit\t" +c.getAccount('L').getBalance());
        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            System.out.println("saldo Overdraft protection\t" +c.getAccount('O').getBalance());
       
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
         Bank.addCustomer(c);
         
        try
        {
        System.out.println("percobaan penarikan saving 1000");
        c.getAccount('S').withdraw(1000);
        
        }
        catch(Exception e)
        {
            
            System.out.println(e.getMessage());
        }
        try
        {
        System.out.println("percobaan penarikan Investment 2000");
        c.getAccount('I').withdraw(2000);
        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
             System.out.println("percobaan penarikan Overdraft 2000");
        c.getAccount('O').withdraw(2000);
        
        }
        catch(Exception e)
        {
             System.out.println("percobaan penarikan Overdraft 2000");
            System.out.println(e.getMessage());
        }
        
        
        
        try{
            System.out.println("saldo saving\t" +c.getAccount('S').getBalance());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            c.addAccount(1000,'I');
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            c.addAccount(1500,'L');
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        try{
            c.addAccount(2000,'O');
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
       // ATMGUI atmgui = new ATMGUI();
       
     /*  Customer c = new Customer ("steven","susanto");
       Savings s  = new Savings (c,500);
       System.out.println("nama " +c.getCustomerName());
       s.addDailyInterest(280);
       System.out.println("balance " +s.getBalance());
       */
      
     /*  Customer c = new Customer ("steven","susanto");
       Investment i  = new Investment (c,1000,12);
       System.out.println("nama " +c.getCustomerName());
       i.addDailyInterest(365);
       System.out.println("balance " +i.getBalance());
      */
     
      /*  Customer c = new Customer ("steven" , "susanto");
        Savings s  = new Savings (c,500);
        OverDraftProtection o = new OverDraftProtection (c,1500,s);
        System.out.println("Saldo awal ODP " + o.getBalance());
        o.withdraw(1000);
        System.out.println("Saldo ODP setelah penarikan 1000 " + o.getBalance());
        o.withdraw(800);
        System.out.println("Saldo ODP setelah penarikan 800 " + o.getBalance());
        System.out.println("Saldo savings " +s.getBalance());
     */
    /*
        Customer c = new Customer ("steven" , "susanto");
        LineOfCredit l = new LineOfCredit(c,3000,1000);
        System.out.println("balance " +l.getBalance() +" creditBalance " +l.getCreditBalance() + " monthlyFee " +l.getMonthlyFee());
        l.withdraw(1000);
        l.feeAssessment();
         System.out.println("balance " +l.getBalance() +" creditBalance " +l.getCreditBalance() + " monthlyFee " +l.getMonthlyFee());
         l.withdraw(1000);
        l.feeAssessment();
         System.out.println("balance " +l.getBalance() +" creditBalance " +l.getCreditBalance() + " monthlyFee " +l.getMonthlyFee());
        l.withdraw(1000);
        l.feeAssessment();
        System.out.println("balance " +l.getBalance() +" creditBalance " +l.getCreditBalance() + " monthlyFee " +l.getMonthlyFee());
         l.withdraw(1000);
        l.feeAssessment();
        System.out.println("balance " +l.getBalance() +" creditBalance " +l.getCreditBalance() + " monthlyFee " +l.getMonthlyFee());
         l.withdraw(1000);
        l.feeAssessment();
         System.out.println("balance " +l.getBalance() +" creditBalance " +l.getCreditBalance() + "monthlyFee " +l.getMonthlyFee());
        l.withdraw(1000);
        l.feeAssessment();
        System.out.println("balance " +l.getBalance() +" creditBalance " +l.getCreditBalance() + " monthlyFee " +l.getMonthlyFee());
        */
        
        /*
        Account saving      = new Account('S',1000);
        Account invest      = new Account('I',1000);
        Account creditLine  = new Account('L',500);
        
        //-------------------------perhitungan bunga saving-----------------------//
        BigDecimal savingBalance = new BigDecimal(saving.getBalance());
        BigDecimal n             = new BigDecimal(360.0);
        BigDecimal t             = new BigDecimal(1.0);
        BigDecimal r             = new BigDecimal(.03);
       
        BigDecimal f1            = r.divide(n,20,BigDecimal.ROUND_HALF_UP).add(BigDecimal.ONE);
        BigDecimal f2            = n.multiply(t); 
        BigDecimal f3            = new BigDecimal(Math.pow(f1.doubleValue(),f2.doubleValue()));
        saving.setBalance(savingBalance.multiply(f3).doubleValue());
        System.out.println("saving setelah 12 bulan\t" +saving.getBalance());
        
        //--------------------perhitungan bunga investment <6 bulan------------------//
        BigDecimal investBalance = new BigDecimal(invest.getBalance());
        r                        = BigDecimal.valueOf(.05);
        f1                       = r.divide(n,20,BigDecimal.ROUND_HALF_UP).add(BigDecimal.ONE);
        t                        = BigDecimal.valueOf(0.5);
        f2                       = n.multiply(t);
        f3                       = new BigDecimal(Math.pow(f1.doubleValue(),f2.doubleValue()));
        invest.setBalance(investBalance.multiply(f3).doubleValue());
        
        //-----------perhitungan bunga investment >6bulan-----------//
        investBalance = new BigDecimal(invest.getBalance());
        r             = BigDecimal.valueOf(.06);
        f1            = r.divide(n,20,BigDecimal.ROUND_HALF_UP).add(BigDecimal.ONE);
        t             = BigDecimal.valueOf(0.5);
        f2            = n.multiply(t);
        f3            = new BigDecimal(Math.pow(f1.doubleValue(),f2.doubleValue()));
        invest.setBalance(investBalance.multiply(f3).doubleValue());
        System.out.println("invest setelah 12 bulan\t" +invest.getBalance());
        
        //-----------------------perhitungan bunga kredit----------------//
        double     withdrawMoney = 1500;
        BigDecimal creditBalance = new BigDecimal(creditLine.getBalance());
        r                        = BigDecimal.valueOf(0.18);
        f1                       = r.divide(n,20,BigDecimal.ROUND_HALF_UP).add(BigDecimal.ONE);
        t                        = BigDecimal.ONE;
        f2                       = n.multiply(t);
        f3                       = new BigDecimal(Math.pow(f1.doubleValue(),f2.doubleValue()));
        
        if(withdrawMoney>saving.getBalance())
        {
            System.out.println("withdraw\t" +withdrawMoney);
            double  credit = withdrawMoney-saving.getBalance();
            boolean tes = creditLine.withdraw(credit);
            if(tes==true)
            {
                saving.setBalance(0);
                System.out.println("saving\t 0");
                BigDecimal creditPlusInterest = new BigDecimal(credit);
                creditPlusInterest.multiply(f3);
                System.out.println("utang total\t" +creditPlusInterest.doubleValue());
            }
            else
            {
                System.out.println("withdraw melebihi batas kredit");
            }
            
            
        }
        else
        {
            saving.withdraw(withdrawMoney);
            System.out.println("saving\t" +saving.getBalance());
        }
       
        */
       
       /////////////////////////////////////////////////////////////////////////////////////////////////////
       
        /*  setStartTime(9,0);
       setCloseTime(17,0);
       String fname,lname,telpon,indikator;
       char type;
       double balance;
       int i=0,j=0;
       Date dob;
       SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
       Scanner in = new Scanner(System.in);
       System.out.println(Bank.getHoursOfOperation());
       System.out.println("apakah ingin membuat customer ? [y/n]");
       indikator = in.nextLine(); 
      if(indikator.equals("n"))
      {
          System.out.println("bye");
          System.exit(0); 
       }
      do{
         
       System.out.println("First Name : ");
       fname = in.nextLine();
       System.out.println("Last Name : ");
       lname = in.nextLine();
       System.out.println("Year birth :");
       int year=in.nextInt();
       System.out.println("month birth :");
       int month=in.nextInt()-1;
       System.out.println("day birth :");
       int day=in.nextInt();
       Customer customer = new Customer(fname,lname,(new GregorianCalendar(year,month,day).getTime()));
       System.out.println("No Telpon :");
       telpon=in.nextLine();
       customer.setPhoneNumber(telpon);
       System.out.println("Jenis account saving? [S/O/I/L/n-tidak membuat]");
       type=in.next().trim().charAt(0);
       while(type!='S'&&type!='O'&&type!='I'&&type!='L'&&type!='n')
       {
        System.out.println("input salah");
        type=in.next().trim().charAt(0);
        }
       if(type!='n')
        {
            String id = String.valueOf(customer.getCustId()+""+type);
            Account account=new Account();
            account.setID(id);
            customer.setAccount(account);
            
            System.out.println("balance awal ?");
            balance=in.nextDouble();
            while(balance<10)
            {
                System.out.println("balance kurang, masukkan lagi");
                balance=in.nextDouble();
            }
        
            customer.getAccount().setBalance(balance);
        }
        else
        {
            customer.getAccount().setBalance(0);
        }
        
        System.out.println(customer);
        System.out.println("apakah ingin membuat customer ? [y/n]");
        indikator = in.nextLine(); 
        indikator = in.nextLine(); 
        }while(indikator.equals("y"));
       
        System.out.println("----------------------------------------");
      in.close();   
      
      */
    }
    

    public Teller()
    {
       
    }

    /**
     * @param int:hour,int:minute , waktu mulai kerja bank dalam jam dan menit
     */
    public static void setStartTime(int hour,int minute)
    {
        
       Bank.setStartTime(hour,minute);
    }
    
    /**
     * @return int:hour,int:minute , waktu mulai kerja bank dalam jam dan menit
     */
    public static Date getStartTime()
    {
        return Bank.getStartTime();
    }
    
    /**
     * @param int:hour,int:minute , waktu tutup bank dalam jam dan menit
     */
    public static void setCloseTime(int hour,int minute)
    {
        Bank.setCloseTime(hour,minute);
    }
    
    /**
     * @return int:hour,int:minute , waktu tutup bank dalam jam dan menit
     */
    public static Date getCloseTime()
    {
        return Bank.getCloseTime();
    }
    
    
}
