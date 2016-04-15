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
   private JTextField custIDField;
   private JTextField lastNameField;
   
   private Panel secondPanel;
   private JTextField firstNameField;
   private JTextField addressField;
   
   private Panel thirdPanel;
   private JTextField cityField;
   private JTextField stateField;
   private JTextField zipField;
   private JTextField phoneField;
   
   private Panel fourthPanel;
   private JTextField emailField;
   private DateFormat format = new SimpleDateFormat("yyyy/mm/dd");
   private JFormattedTextField dobField;
   private java.awt.List accTypeList;
   private String[] acc = {"Checking/Overdraft","Line of Credit","Savings","Investment","Other"};
   
   
    private static String cek = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    private static java.util.regex.Pattern p = java.util.regex.Pattern.compile(cek);
    
    
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
            /*try{
             WindowHandler.showExit();                             //akan memanggil method showExit yang throws InterruptedException, harus di catch
            }
            catch(InterruptedException e)
            {
             
            }*/
            exitting();
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
        for (int i=0; i <acc.length-1; i++) 
        {
        accTypeList.add(acc[i]);
        }
        accTypeList.add(acc[acc.length-1]);
        accTypeList.select(5);
        accTypeList.addActionListener(this);
        
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
        
        custIDField = new JTextField("Cust ID");
        custIDField.setColumns(10);
        custIDField.addFocusListener(new CustomFocusListener(custIDField,"Cust ID") );
        
        
        lastNameField = new JTextField("Last Name");
        lastNameField.setColumns(20);
        lastNameField.addFocusListener(new CustomFocusListener(lastNameField,"Last Name") );
         
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
        firstNameField = new JTextField("First Name");
        firstNameField.setColumns(20);
        firstNameField.addFocusListener(new CustomFocusListener(firstNameField,"First Name") );
         
        addressField = new JTextField("Address");
        addressField.setColumns(30);
        addressField.addFocusListener(new CustomFocusListener(addressField , "Address") );
         
         secondPanel.add(firstNameField);
         secondPanel.add(addressField);
    }
    
    /**
     * membuat panel ketiga
     */
     private void makeThirdPanel()
    {
    
        thirdPanel = new Panel(new FlowLayout());
        cityField = new JTextField("City");
        cityField.setColumns(30);
        cityField.addFocusListener(new CustomFocusListener(cityField , "City") );
         
        stateField = new JTextField("State");
        stateField.setColumns(10);
        stateField.addFocusListener(new CustomFocusListener(stateField , "State") );
         
        zipField = new JTextField("Zip Code");
        zipField.setColumns(15);
        zipField.addFocusListener(new CustomFocusListener(zipField, "Zip Code") );
        
        phoneField = new JTextField("Phone");
        phoneField.setColumns(25);
        phoneField.addFocusListener(new CustomFocusListener(phoneField , "Phone") );
         
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
        emailField = new JTextField("Email Address");
        emailField.setActionCommand("email");
        emailField.addActionListener(this);
        
        emailField.setColumns(25);
        emailField.addFocusListener(new CustomFocusListener(emailField, "Email Address") );
        
        dobField = new JFormattedTextField(format);
        dobField.setText("DOB - yyyy/mm/dd");
        dobField.setColumns(20);
        dobField.addFocusListener(new CustomFocusListener(dobField,"DOB - yyyy/mm/dd") );
        
        fourthPanel.add(emailField);
        fourthPanel.add(dobField);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        Date date = new Date();
        
        if(command.equals("cancel"))
        {
            custIDField.setText("Cust ID");
            lastNameField.setText("Last Name");
            firstNameField.setText("First Name");
            addressField.setText("Address");
            cityField.setText("City");
            stateField.setText("State");
            zipField.setText("Zip Code");
            phoneField.setText("Phone");
            emailField.setText("Email Address");
            dobField.setText("DOB - yyyy/mm/dd");
        }
        else if(command.equals("email"))
        {
            if(!emailValidator(emailField.getText()))
            {
                warning("Email tidak valid!!");
            }
        
        }
        else if(command.equals("save"))
        {
          try{
          date = format.parse(dobField.getText());
          }
          catch(ParseException pe)
          {
              
          }
          Customer c = new Customer(firstNameField.getText(),lastNameField.getText(),date);
          c.setPhoneNumber(phoneField.getText());
          c.setAddress(addressField.getText(),cityField.getText(),zipField.getText());
          c.setEmail(emailField.getText());
          //System.out.println(acc[accTypeList.getSelectedIndex()]);
          Bank.addCustomer(c);
        }
    }
    
   private void exitting()
   {
       JOptionPane.showMessageDialog(mainFrame, "You're exitting, goodbye !!","goodbye",JOptionPane.WARNING_MESSAGE);
   }
   
   private boolean emailValidator(String email)
   {
       java.util.regex.Matcher m = p.matcher(email);
       
          if(m.matches())
          {
          return true;
          }
          else
          {
            return false;
            }
   }
   
   private void warning(String s)
   {
       JOptionPane.showMessageDialog(mainFrame, s,"Error",JOptionPane.ERROR_MESSAGE);
    }
    
   
}
