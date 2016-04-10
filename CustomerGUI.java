import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

/**
 * Write a description of class CustomerGUI here.
 * 
 * @author steven susanto
 * @version 10 April 2016
 */
public class CustomerGUI implements ActionListener
{
   private JFrame mainFrame;
   private Panel topPanel;
   private Panel bottomPanel;
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
   private DateFormat format = new SimpleDateFormat("yyyy/mm/dd");
   private JFormattedTextField dobField;
   private java.awt.List accTypeList;
   private String[] acc = {"Checking/Overdraft","Line of Credit","Savings","Investment","Other"};
   
    /**
     * Constructor for objects of class CustomerGUI
     */
    public CustomerGUI()
    {
       buildGUI();
    }

    /**
     * membangun tampilan GUI
     */
    private void buildGUI()
    {
        mainFrame = new JFrame("Customer GUi");
        mainFrame.setLayout(new GridLayout(2,1));
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
        
       
        
        makeTopPanel();
        makeBottomPanel();
        mainFrame.setVisible(true);
    }
    
    private void makeTopPanel()
    {
        makeFirstPanel();
        makeSecondPanel();
        makeThirdPanel();
        topPanel = new Panel(new GridLayout(3,1));
        topPanel.add(firstPanel);
        topPanel.add(secondPanel);
        topPanel.add(thirdPanel);
        mainFrame.add(topPanel,BorderLayout.PAGE_START);
    }
    
    private void makeBottomPanel()
    {
        bottomPanel = new Panel(new BorderLayout());
        makeFourthPanel();
        bottomPanel.add(fourthPanel);
        accTypeList = new java.awt.List(5,false);
        for (int i=0; i <acc.length; i++) 
        {
        accTypeList.add(acc[i]);
        }
        
        bottomPanel.add(accTypeList,BorderLayout.LINE_END);
        mainFrame.add(bottomPanel);
    }
    /**
     * membuat panel pertama
     */
    private void makeFirstPanel()
    {
        firstPanel = new Panel(new FlowLayout());
        cancel = new Button("Cancel");
        cancel.setActionCommand("cancel");
        cancel.addActionListener(this);
        
        saveAndReturn = new Button("Save & Return");
        saveAndReturn.setActionCommand("save");
        saveAndReturn.addActionListener(this);
        
        custIDField = new TextField("");
        
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
    
    /**
     * membuat panel kedua
     */
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
    
    /**
     * membuat panel ketiga
     */
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
    
    /**
     * membuat panel keempat
     */
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
         
        
        dobField = new JFormattedTextField(format);
        dobField.setText("DOB - yyyy/mm/dd");
        dobField.setColumns(20);
        dobField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            dobField.setText("");
            }
            public void focusLost(FocusEvent e){}
        
         });
        
        fourthPanel.add(emailField);
        fourthPanel.add(dobField);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        Date date = new Date();
        if(command.equals("cancel"))
        {
            exitting();
            System.exit(0);
        }
        else
        {
          try{
          date = format.parse(dobField.getText());
          }
          catch(ParseException pe)
          {
              
          }
          Customer c = new Customer(firstNameField.getText(),lastNameField.getText(),date);
          System.out.println(acc[accTypeList.getSelectedIndex()]);
          Bank.addCustomer(c);
        }
    }
    
   private void exitting()
   {
       JOptionPane.showMessageDialog(mainFrame, "You're exitting, goodbye !!","goodbye",JOptionPane.WARNING_MESSAGE);
   }
}
