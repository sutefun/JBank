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
   
   public ButtonHandler(ATMGUI a)
   {
       atmgui = a;
   }
    
   public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        String custID  = atmgui.getCustIDTextField().getText();
        double amount  = Double.parseDouble(atmgui.getAmountTextField().getText());
        Customer cust  = Bank.getCustomer(Integer.parseInt(custID));
        String custName = cust.getCustName();
        char accType = getSelectedButtonText(atmgui.getButtonGroup());
        if(cust != null)
        {
            if(command.equals("deposit"))
            {
                atmgui.getTextArea().setBackground(Color.WHITE);
                deposit(cust,accType,amount);
                atmgui.getTextArea().setText(custName +" " +custID +" saves an amount of money " +amount);
            }
            if(command.equals("withdraw"))
            {
                atmgui.getTextArea().setBackground(Color.WHITE);
                if(withdraw(cust,accType,amount))
                {
                atmgui.getTextArea().setText(custName +" " +custID +" withdraws an amount of money " +amount);
                }
                else
                {
                 atmgui.getTextArea().setText(custName +" " +custID +" withdraws exceed balance " + accType);
                 
                     warning();
                    
                     
                }
            }
            if(command.equals("exit"))
            {
                atmgui.getTextArea().setBackground(Color.WHITE);
                atmgui.getTextArea().setText("sudah exit "  + accType);
            }   
            if(command.equals("total"))
            {
                double balance=0;
                Account account;
                atmgui.getTextArea().setBackground(Color.WHITE);
                account = cust.getAccount('S');
                if(account !=null){balance += account.getBalance();}
                account = cust.getAccount('I');
                if(account !=null){balance += account.getBalance();}
                account = cust.getAccount('L');
                if(account !=null){balance += account.getBalance();}
                account = cust.getAccount('O');
                if(account !=null){balance += account.getBalance();}
                atmgui.getTextArea().setText(custName +" " +"Total balance customer "  + balance);
            }  
        }
    }
    
   private void deposit(Customer cust, char accType, double amount)
   {
       cust.getAccount(accType).deposit(amount);
   }
   
   private boolean withdraw(Customer cust, char accType, double amount)
   {
       return cust.getAccount(accType).withdraw(amount);
   }
   
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
    
   private void warning()
   {
       Frame warningFrame = new Frame();
       warningFrame.setSize(300,100);
       warningFrame.setTitle("Melebihi saldo balance atau limit");
       Label msgLabel = new Label("Melebihi saldo balance atau limit!!");
       msgLabel.setAlignment(Label.CENTER);
       msgLabel.setSize(100,100);
       warningFrame.add(msgLabel);
        warningFrame.addWindowListener(new WindowHandler() {
         public void windowClosing(WindowEvent windowEvent){
            
            System.exit(0);     //keluar dari program
        }        
        });  
       warningFrame.setVisible(true);
   }
}
