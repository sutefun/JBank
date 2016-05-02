import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.*;
/**
 * @author steven susanto 
 * @version 15 April 2016
 */


public class CustomFocusListener implements FocusListener {
    private JTextField          txtField;
    private JFormattedTextField fmtField = null;
    private String              string;
    private JFrame              frame;
    private CustomerGUI         cgui;
    
    public CustomFocusListener(JTextField txt, String s,CustomerGUI g)
    {
        txtField = txt;
        string   = s;
        cgui     = g;
    }
    
    public CustomFocusListener(JFormattedTextField txt, String s,CustomerGUI g)
    {
        fmtField = txt;
        string   = s;
        cgui     = g;
    }

    
    /**
     * focus event bila suatu field tertentu dipilih
     */
    public void focusGained(FocusEvent e)
    {
        if(fmtField == null){
            if(txtField.getText().equals(string))
            {
                txtField.setText("");
            }
        }
        else
        {
            if(fmtField.getText().equals(string))
            {
                fmtField.setText("");
            }
        }
    }
    

    /**
     * focus event bila suatu field tertentu dipilih lalu tidak dipilih
     */
    public void focusLost(FocusEvent e)
    {
        if(fmtField == null){
            if(txtField.getText().equals(""))
            {
                txtField.setText(string);
            }
            else if(txtField.getName().equals("Email Address"))
            {
                if( !cgui.emailValidator(txtField.getText()) )
                {
                    cgui.warning("Format email salah !!");
                    txtField.setText(string);
                }
            }
            else if(txtField.getName().equals("Cust ID"))
            {
                try{
                    int custID = Integer.parseInt( txtField.getText() );
                    try{
                        cgui.fetchedCustData( Bank.getCustomer(custID ) );
                    }
                    catch(CustomerNotFound ee){
                        cgui.warning("Customer dengan ID " + txtField.getText() +" tidak ada");
                        cgui.resetField();
                    }
                }
                catch(NumberFormatException nfe)
                {
                    cgui.warning("Cust ID tidak diisi dengan angka !!\nMereset ke DEFAULT");
                    cgui.resetField();
                }
               
            }
        }
        else
        {
            if(fmtField.getText().equals(""))
            {
                cgui.warning("Format tanggal salah !!\nMengisi tanggal hari ini");
                fmtField.setText(getToday());
            }
        }
    }
    
    /**
     * untuk mendapatkan waktu hari ini
     * @return String : date
     */
    private String getToday()
    {
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        Date now = new Date();
        return date.format(now);
    }

    
}