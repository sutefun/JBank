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
     */
    public WindowHandler(JFrame fr)
    {
        frame = fr;
    }
    
    
    /**
     * menampilkan pesan exit lalu tidur 1/2 detik
     */
    public static void showExit() throws InterruptedException
    {
         
          Frame closingMessageFrame = new Frame();
          closingMessageFrame.setSize(300,200);
          closingMessageFrame.setTitle("ATMGUI");    
          Label msgLabel = new Label("You're exitting, goodbye!!");
          msgLabel.setAlignment(Label.CENTER);
          msgLabel.setSize(100,100);
          closingMessageFrame.add(msgLabel);
          closingMessageFrame.setVisible(true);
          Thread.sleep(500);
    }
    
    public void windowClosing(WindowEvent windowEvent){
           
          int result = JOptionPane.showConfirmDialog(frame, "Anda mau keluar ?", "alert", JOptionPane.OK_CANCEL_OPTION);
          if(result == JOptionPane.OK_OPTION)
          {
             frame.dispose();
          }
    }
}
