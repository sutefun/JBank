import java.util.*;
import java.text.*;
import java.awt.*;
import javax.swing.*;

/**
 * panel yang menampilkan waktu yang diupdate selama 1 detik dengan thread sendiri
 * 
 * @author steven susanto 
 * @version 2 May 2016
 */
public class StatusBar extends JPanel implements Runnable
{
   static private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
   static private SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
   private JLabel timeLabel = new JLabel();
   private JLabel dateLabel = new JLabel();
   
   /**
    * konstruktor untuk class ini sebagai panel
    */
   public StatusBar(){
       this.setLayout(new FlowLayout());
       setSize(70,20);
       this.add(timeLabel);
       this.add(dateLabel);
       setVisible(true);
       (new Thread(this)).start();
   }
    
   /**
    * 
    * runnable yang akan selalu loop untuk mengupdate label waktu
    */
   public void run(){
       while(true){
           Date current = new Date();
           timeLabel.setText( timeFormat.format(current) );
           dateLabel.setText( dateFormat.format(current) );
           
           try{
            Thread.sleep(1000);
           }
           catch(Exception e){
            
           }
        }
   }
}
