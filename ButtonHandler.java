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
        
        if(command.equals("exit"))
            {
                atmgui.getTextArea().setBackground(Color.WHITE);
                atmgui.getTextArea().setText("exit ");
                exitting();
                System.exit(0);
            } 
        
        int custID      = Integer.parseInt( atmgui.getCustIDTextField().getText() );
        double amount   = Double.parseDouble(0+atmgui.getAmountTextField().getText());
        Customer cust   = Bank.getCustomer(custID);
        String custName = cust.getCustName();
        char accType    = getSelectedButtonText(atmgui.getButtonGroup());
        
        if(cust != null)
        {
            if(accType != '\0')
            {
                if(command.equals("deposit"))
                {
                    atmgui.getTextArea().setBackground(Color.WHITE);
                    try{
                        deposit(cust,accType,amount);
                        double bl = Bank.getCustomer(custID).getAccount(accType).getBalance();
                        atmgui.getTextArea().setText(custName +" " +custID +" saves an amount of money " +amount + "\nbalance " + bl );
                    }
                    catch(AccountTypeNotFoundException ee)
                    {
                        atmgui.getTextArea().setText(custName +" " +custID +" does not have " + accType);
                        warning(ee.getMessage());
                    }
                    
                }
              
                if(command.equals("withdraw"))
                {
                    atmgui.getTextArea().setBackground(Color.WHITE);
                    
                    try{
                    withdraw(cust,accType,amount);
                        if(accType == 'L')
                        {
                             LineOfCredit l = (LineOfCredit)Bank.getCustomer(custID).getAccount(accType);
                             double cr      = l.getBalance();
                             double cl      = l.getCreditLeft();
                             atmgui.getTextArea().setText(custName +" " +custID +" withdraws an amount of money " +amount +"\nbalance left " + cr + "\ncredit allowable left " + cl);
                        
                        }
                        else
                        {
                            atmgui.getTextArea().setText(custName +" " +custID +" withdraws an amount of money " +amount +"\nbalance left " + Bank.getCustomer(custID).getAccount(accType).getBalance());
                        }
                    }
                    catch(AmountOverDrawnException ee)
                    {
                     atmgui.getTextArea().setText(custName +" " +custID +" withdraws exceed balance " + accType);
                     
                         warning(ee.getMessage());
                    }
                    catch(AccountTypeNotFoundException ae)
                    {
                        atmgui.getTextArea().setText(custName +" " +custID +" does not have " + accType);
                     
                        warning(ae.getMessage());
                    }
                      
                }
            }
              
            if(command.equals("total"))
            {
                
                double balance=0;
                Account account=null;
                atmgui.getTextArea().setBackground(Color.WHITE);
               
                try{
                    
                    balance += cust.getAccount('S').getBalance();
                    
                }catch(Exception ee){}
                
                try{
                    
                    balance += cust.getAccount('I').getBalance();
                    
                }catch(Exception ee){}
                
                try{
                    
                    balance += cust.getAccount('L').getBalance();
                    
                }catch(Exception ee){}
                
                try{
                    
                    balance += cust.getAccount('O').getBalance();
                    
                }catch(Exception ee){}
                
                finally
                {
                    atmgui.getTextArea().setText(custName +" " +"Total balance customer "  + balance);
                }
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
   private boolean withdraw(Customer cust, char accType, double amount)
   {
       try
       {
           cust.getAccount(accType).withdraw(amount);
           return true;
        }
       catch(Exception e)
       {
           return false;
       }
   }
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
    * menampilkan dialog warning exceed balance
    */
   private void warning(String s)
   {
       JOptionPane.showMessageDialog(atmgui.getMainFrame(),s,"Error !!",JOptionPane.ERROR_MESSAGE);
   }
   
   private void exitting()
   {
       JOptionPane.showMessageDialog(atmgui.getMainFrame(), "You're exitting, goodbye !!","goodbye",JOptionPane.WARNING_MESSAGE);
   }
}
