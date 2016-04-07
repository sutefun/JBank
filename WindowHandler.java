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
    
    /**
     * Constructor for objects of class WindowHandler
     */
    public WindowHandler()
    {
        
    }

    public static void showExit() throws InterruptedException
    {
         
          Button okButton = new Button("OK");
    
          final Frame aboutFrame = new Frame();
          aboutFrame.setSize(300,200);;
          aboutFrame.setTitle("ATMGUI");
          aboutFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent){
                   aboutFrame.dispose();
             }        
          });    
          Label msgLabel = new Label("You're exitting, goodbye!!");
          msgLabel.setAlignment(Label.CENTER);
          msgLabel.setSize(100,100);
          aboutFrame.add(msgLabel);
          aboutFrame.setVisible(true);
          Thread.sleep(10000);
    }
}
