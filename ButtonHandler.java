import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

/**
 * Write a description of class ButtonHandler here.
 * 
 * @author steven susanto
 * @version 10 April 2016
 */
public class ButtonHandler implements ActionListener
{
   private ATMGUI atmgui;
   
   /**
    * @param ATMGUI - konstruktor buttonhandler yang menerima ATMGUI
    */
   public ButtonHandler(ATMGUI a)
   {
       atmgui = a;
   }
    
   /**
    * action listener bila ada button yang dipencet
    */
   public void actionPerformed(ActionEvent e)
   {
        String command = e.getActionCommand();
        Customer cust  = null;
        int custID     = 0;
        double amount  = 0;
        String custName;
        char accType;
        
        if(command.equals("exit"))
            {
                atmgui.setTextAreaColor(Color.RED);
                atmgui.setTextArea("exit ");
                Bank.exportCustomer();
                exitting();
                System.exit(0);
            } 
        else
        {
            try{
                custID      = atmgui.getCustID();  
                cust        = Bank.getCustomer(custID);
                amount      = atmgui.getAmount(); 
                
                custName    = cust.getCustName();
                accType     = getSelectedButtonText(atmgui.getButtonGroup());
           
            
                if(accType != '\0')
                {
                    if(command.equals("deposit"))
                    {
                        atmgui.setTextAreaColor(Color.GREEN);
                        
                        try{
                            deposit(cust,accType,amount);
                            double bl = cust.getAccount(accType).getBalance();
                            atmgui.setTextArea(custName +" " +custID +" saves an amount of money " +amount + "\nbalance " + bl );
                        }
                        catch(AccountTypeNotFoundException ee)
                        {
                            atmgui.setTextArea(custName +" " +custID +" does not have " + accType);
                            warning(ee.getMessage());
                        }
                        
                    }
                  
                    if(command.equals("withdraw"))
                    {
                        atmgui.setTextAreaColor(Color.YELLOW);
                        
                        try{
                        withdraw(cust,accType,amount);
                            if(accType == 'L')
                            {
                                 LineOfCredit l = (LineOfCredit)cust.getAccount(accType);
                                 double cr      = l.getBalance();
                                 double cl      = l.getCreditLeft();
                                 atmgui.setTextArea(custName +" " +custID +" withdraws an amount of money " +amount +"\nbalance left " + cr + "\ncredit allowable left " + cl);
                            
                            }
                            else
                            {
                                atmgui.setTextArea(custName +" " +custID +" withdraws an amount of money " +amount +"\nbalance left " + cust.getAccount(accType).getBalance());
                            }
                        }
                        catch(AmountOverDrawnException ee)
                        {
                         atmgui.setTextArea(custName +" " +custID +" withdraws exceed balance " + accType);
                         
                             warning(ee.getMessage());
                        }
                        catch(AccountTypeNotFoundException ae)
                        {
                            atmgui.setTextArea(custName +" " +custID +" does not have " + accType);
                         
                            warning(ae.getMessage());
                        }
                          
                    }
                }
                  
                if(command.equals("total"))
                {
                    
                    double balance=0, bl=0;
                    Account account=null;
                    atmgui.setTextAreaColor(Color.WHITE);
                    String s = "" , s2;
                   
                    try{
                        
                        bl = cust.getAccount('S').getBalance();
                        balance += bl;
                        s = "\n-balance Savings " + "\t"+ bl;
                        
                    }catch(Exception ee){}
                    
                    try{
                        
                        bl = cust.getAccount('I').getBalance();
                        balance += bl;
                        s += "\n-balance Investment " + "\t"+ bl;
                        
                    }catch(Exception ee){}
                    
                    try{
                        
                        bl = cust.getAccount('L').getBalance();
                        LineOfCredit l = (LineOfCredit)Bank.getCustomer(custID).getAccount('L');
                        double cl = l.getCreditLeft();
                        balance += bl;
                        s += "\n-balance Line Of Credit " +"\t"+ bl + "\t-|- credit allowable left " + cl;
                        
                    }catch(Exception ee){}
                    
                    try{
                        
                        bl = cust.getAccount('O').getBalance();
                        balance += bl;
                        s += "\n-balance Overdraft " +"\t"+ bl;
                        
                    }catch(Exception ee){}
                    
                    finally
                    {
                        s2 = custName +" " +"Total balance customer "  + balance;
                        atmgui.setTextArea( s2 + s );
                    }
                }
                
            }
            catch(NumberFormatException | CustomerNotFound npe)
            {
                warning( npe.getMessage() );
            }
            
        }  
    }
        
    

    
   /**
    * untuk menyimpan dana
    */
   private void deposit(Customer cust, char accType, double amount) throws AccountTypeNotFoundException
   {
       
       cust.getAccount(accType).deposit(amount);
        
   }
   
   /**
    * @return boolean - true bila withdraw tidak melebihi balance pada akun tertentu
    *
   */
   
  private void withdraw(Customer cust, char accType, double amount) throws AmountOverDrawnException , AccountTypeNotFoundException
   {
       
           cust.getAccount(accType).withdraw(amount);
        
   }
  
   /**
    * @return char:accType - melihat tombol untuk tipe akun mana yang dipilih
    */
   public char getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                if(button.getText().equals("Savings"))
                {
                    return 'S';
                }
                else if(button.getText().equals("Investment"))
                {
                    return 'I';
                }
                else if(button.getText().equals("Line Of Credit"))
                {
                    return 'L';
                }
                else if(button.getText().equals("Overdraft"))
                {
                    return 'O';
                }
                
            }
        }

        return '\0';
    }
    
   /**
    * menampilkan dialog warning dengan pesan s
    * @param String:s - passing string yang ingin ditampilkan
    */
   private void warning(String s)
   {
       JOptionPane.showMessageDialog(atmgui,s,"Error !!",JOptionPane.ERROR_MESSAGE);
   }
   
   private void exitting()
   {
       JOptionPane.showMessageDialog(atmgui, "You're exitting, goodbye !!","goodbye",JOptionPane.WARNING_MESSAGE);
   }
}
