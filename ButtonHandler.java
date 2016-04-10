import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
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
        String amount  = atmgui.getAmountTextField().getText();
        
        if(command.equals("deposit"))
        {
            atmgui.getTextArea().setBackground(Color.WHITE);
            atmgui.getTextArea().setText(custID +" saves an amount of money " +amount);
        }
        if(command.equals("withdraw"))
        {
            atmgui.getTextArea().setBackground(Color.WHITE);
            atmgui.getTextArea().setText(custID +" withdraws an amount of money " +amount);
        }
        if(command.equals("exit"))
        {
            atmgui.getTextArea().setBackground(Color.WHITE);
            atmgui.getTextArea().setText("sudah exit");
        }   
    }
}
