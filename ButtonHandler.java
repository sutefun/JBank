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
        Customer cust = null;
        if(command.equals("exit"))
            {
                atmgui.getTextArea().setBackground(Color.WHITE);
                atmgui.getTextArea().setText("exit ");
                exitting();
                System.exit(0);
            } 
        
        int custID      = Integer.parseInt( atmgui.getCustIDText() );
        double amount   = Double.parseDouble(0 + atmgui.getAmountText());
        try{
            cust   = Bank.getCustomer(custID);
        }
        catch(CustomerNotFound cnf)
        {
           warning(cnf.getMessage());
        }
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
                        double bl = cust.getAccount(accType).getBalance();
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
                             LineOfCredit l = (LineOfCredit)cust.getAccount(accType);
                             double cr      = l.getBalance();
                             double cl      = l.getCreditLeft();
                             atmgui.getTextArea().setText(custName +" " +custID +" withdraws an amount of money " +amount +"\nbalance left " + cr + "\ncredit allowable left " + cl);
                        
                        }
                        else
                        {
                            atmgui.getTextArea().setText(custName +" " +custID +" withdraws an amount of money " +amount +"\nbalance left " + cust.getAccount(accType).getBalance());
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
                
                double balance=0, bl=0;
                Account account=null;
                atmgui.getTextArea().setBackground(Color.WHITE);
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
                    atmgui.getTextArea().setText( s2 + s );
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
