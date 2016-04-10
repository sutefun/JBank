import javax.swing.*;
import javax.swing.event.*;
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
   private JFrame mainFrame;
   private Panel topPanel;
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
   private List accTypeList;
   
    /**
     * Constructor for objects of class CustomerGUI
     */
    public CustomerGUI()
    {
       buildGUI();
    }

    private void buildGUI()
    {
        mainFrame = new JFrame("Customer GUi");
        mainFrame.setLayout(new GridLayout(4,1));
        mainFrame.setSize(700,400);
        mainFrame.setResizable(false);
        mainFrame.addWindowListener(new WindowHandler() {
         public void windowClosing(WindowEvent windowEvent){
            try{
             WindowHandler.showExit();                             //akan memanggil method showExit yang throws InterruptedException, harus di catch
            }
            catch(InterruptedException e)
            {
             
            }
            System.exit(0);     //keluar dari program
        }        
        });  
        
        makeFirstPanel();
        makeSecondPanel();
        makeThirdPanel();
        makeFourthPanel();
        
        topPanel = new Panel(new GridLayout(3,1));
        topPanel.add(firstPanel);
        topPanel.add(secondPanel);
        topPanel.add(thirdPanel);
        mainFrame.add(topPanel);
        mainFrame.add(fourthPanel);
        mainFrame.setVisible(true);
    }
    
    private void makeFirstPanel()
    {
        firstPanel = new Panel(new FlowLayout());
        cancel = new Button("Cancel");
        saveAndReturn = new Button("Save & Return");
        custIDField = new TextField(""+Bank.getNextID());
        custIDField.setEditable(false);
        lastNameField = new TextField("Last Name");
        lastNameField.setColumns(20);
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
        secondPanel = new Panel(new FlowLayout());
        firstNameField = new TextField("First Name");
        firstNameField.setColumns(20);
        firstNameField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            firstNameField.setText("");
            }
            public void focusLost(FocusEvent e){}
        
         });
         
        addressField = new TextField("Address");
        addressField.setColumns(30);
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
    
        thirdPanel = new Panel(new FlowLayout());
        cityField = new TextField("City");
        cityField.setColumns(30);
        cityField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            cityField.setText("");
            }
            public void focusLost(FocusEvent e){}
        
         });
         
        stateField = new TextField("State");
        stateField.setColumns(10);
        stateField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            stateField.setText("");
            }
            public void focusLost(FocusEvent e){}
        
         });
         
        zipField = new TextField("Zip Code");
        zipField.setColumns(15);
        zipField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            zipField.setText("");
            }
            public void focusLost(FocusEvent e){}
        
         }); 
        
        phoneField = new TextField("Phone");
        phoneField.setColumns(25);
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
        fourthPanel = new Panel(new FlowLayout());
        emailField = new TextField("Email Address");
        emailField.setColumns(25);
        emailField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            emailField.setText("");
            }
            public void focusLost(FocusEvent e){}
        
         });
         
        dobField = new TextField("DOB");
        dobField.setColumns(20);
        dobField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            dobField.setText("");
            }
            public void focusLost(FocusEvent e){}
        
         });
         
        accTypeList = new List(5,false);
        accTypeList.add("Checking/Overdraft");
        accTypeList.add("Line Of Credit");
        accTypeList.add("Savings");
        accTypeList.add("Investment");
        accTypeList.add("Other");
        
        fourthPanel.add(emailField);
        fourthPanel.add(dobField);
        fourthPanel.add(accTypeList);
    }
}
