import java.awt.*;
import java.awt.event.*;

/**
 * Write a description of class CustomerGUI here.
 * 
 * @author steven susanto
 * @version 10 April 2016
 */
public class CustomerGUI
{
   private Panel firstPanel;
   private Button cancel;
   private Button saveAndReturn;
   private TextField custIDField;
   private TextField lastNameField;
   
   private Panel secondPanel;
   private TextField firstNameField;
   private TextField addressField;
   
   private Panel thirdPanel;
   private TextField cityField;
   private TextField stateField;
   private TextField zipField;
   private TextField phoneField;
   
   private Panel fourthPanel;
   private TextField emailField;
   private TextField dobField;
   private TextArea accTypeField;
   
    /**
     * Constructor for objects of class CustomerGUI
     */
    public CustomerGUI()
    {
       buildGUI();
    }

    private void buildGUI()
    {
    
    }
    
    private void makeFirstPanel()
    {
        firstPanel = new Panel();
        cancel = new Button("Cancel");
        saveAndReturn = new Button("Save & Return");
        custIDField = new TextField(Bank.getNextID());
        custIDField.setEditable(false);
        lastNameField = new TextField("Last Name");
        lastNameField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            lastNameField.setText("");
            }
            public void focusLost(FocusEvent e){}
        
         });
         
        firstPanel.add(cancel);
        firstPanel.add(saveAndReturn);
        firstPanel.add(custIDField);
        firstPanel.add(lastNameField);
        
    }
    
     private void makeSecondPanel()
    {
        secondPanel = new Panel();
        firstNameField = new TextField("First Name");
        firstNameField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            firstNameField.setText("");
            }
            public void focusLost(FocusEvent e){}
        
         });
         
        addressField = new TextField("Address");
        addressField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            addressField.setText("");
            }
            public void focusLost(FocusEvent e){}
        
         });
         
         secondPanel.add(firstNameField);
         secondPanel.add(addressField);
    }
    
     private void makeThirdPanel()
    {
    
        thirdPanel = new Panel();
        cityField = new TextField("City");
        cityField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            cityField.setText("");
            }
            public void focusLost(FocusEvent e){}
        
         });
         
        stateField = new TextField("State");
        stateField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            stateField.setText("");
            }
            public void focusLost(FocusEvent e){}
        
         });
         
        zipField = new TextField("Zip Code");
        zipField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            zipField.setText("");
            }
            public void focusLost(FocusEvent e){}
        
         }); 
        
        phoneField = new TextField("Phone");
        phoneField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            phoneField.setText("");
            }
            public void focusLost(FocusEvent e){}
        
         });
         
        thirdPanel.add(cityField);
        thirdPanel.add(stateField);
        thirdPanel.add(zipField);
        thirdPanel.add(phoneField);
        
    }
    
     private void makeFourthPanel()
    {
        fourthPanel = new Panel();
        
        
        
    }
}
