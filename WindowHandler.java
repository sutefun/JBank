import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class WindowHandler here.
 * 
 * @author steven susanto
 * @version 7 April 2016
 */
public class WindowHandler extends  WindowAdapter

{
    private JFrame frame;
    
    /**
     * Constructor for objects of class WindowHandler
     * @param JFrame - untuk mengaitkan dialog dengan frame
     */
    public WindowHandler(JFrame fr)
    {
        frame = fr;
    }
    
    /**
     * untuk menampilkan dialog konfirmasi mau exit
     * @param WindowEvent
     */
    public void windowClosing(WindowEvent windowEvent){
           
          int result = JOptionPane.showConfirmDialog(frame, "Anda mau keluar ?", "alert", JOptionPane.OK_CANCEL_OPTION);
          if(result == JOptionPane.OK_OPTION)
          {
             //Bank.exportCustomer();
             frame.dispose();
          }
    }
}
