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
        String accType = getSelectedButtonText(atmgui.getButtonGroup());
        if(cust != null)
        {
            if(command.equals("deposit"))
            {
                atmgui.getTextArea().setBackground(Color.WHITE);
                deposit(cust,accType,amount);
                atmgui.getTextArea().setText(custID +" saves an amount of money " +amount + accType);
            }
            if(command.equals("withdraw"))
            {
                atmgui.getTextArea().setBackground(Color.WHITE);
                if(withdraw(cust,accType,amount))
                {
                atmgui.getTextArea().setText(custID +" withdraws an amount of money " +amount + accType);
                }
                else
                {
                 atmgui.getTextArea().setText(custID +" withdraws exceed balance + accType");
                }
            }
            if(command.equals("exit"))
            {
                atmgui.getTextArea().setBackground(Color.WHITE);
                atmgui.getTextArea().setText("sudah exit"  + accType);
            }   
        }
    }
    
   private void deposit(Customer cust, String accType, double amount)
   {
       
   }
   
   private boolean withdraw(Customer cust, String accType, double amount)
   {
       
       return false;
   }
   
   public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
}
