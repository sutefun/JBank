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

    public CustomFocusListener(JTextField txt, String s)
    {
        txtField = txt;
        string     = s;
    }
    
    public CustomFocusListener(JFormattedTextField txt, String s)
    {
        fmtField = txt;
        string     = s;
        
    }
    
    public CustomFocusListener(JFrame fr,JTextField txt, String s)
    {
        txtField = txt;
        string   = s;
        frame    = fr;
    }

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

    public void focusLost(FocusEvent e)
    {
        if(fmtField == null){
            if(txtField.getText().equals(""))
            {
                txtField.setText(string);
            }
            else if(txtField.getName().equals("Email Address"))
            {
                if( !CustomerGUI.emailValidator(txtField.getText()) )
                {
                    CustomerGUI.warning("format email salah !!");
                    txtField.setText(string);
                }
            }
        }
        else
        {
            if(fmtField.getText().equals(""))
            {
                fmtField.setText(getToday());
            }
        }
    }
    
    private String getToday()
    {
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        Date now = new Date();
        return date.format(now);
    }

    
}