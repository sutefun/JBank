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
   static private JFrame mainFrame;
   static private JPanel topPanel;
   static private JPanel bottomPanel;
   static private JPanel firstPanel;
   static private JButton cancel;
   static private JButton saveAndReturn;
   static private JTextField custIDField;
   static private JTextField lastNameField;
   
   static private JPanel secondPanel;
   static private JTextField firstNameField;
   static private JTextField addressField;
   
   static private JPanel thirdPanel;
   static private JTextField cityField;
   static private JTextField stateField;
   static private JTextField zipField;
   static private JTextField phoneField;
   
   static private JPanel fourthPanel;
   static private JTextField emailField;
   static private DateFormat format = new SimpleDateFormat("yyyy/mm/dd");
   static private JFormattedTextField dobField;
   static private JList accTypeList;
   
   static private String[] acc = {"Checking/Overdraft","Line of Credit","Savings","Investment","Other"};
   
   static private String cek = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
   static private java.util.regex.Pattern p = java.util.regex.Pattern.compile(cek);
    
    
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
        mainFrame = new JFrame("Customer GUI");
        mainFrame.setLayout(new GridLayout(2,1));
        mainFrame.setSize(700,400);
        mainFrame.setResizable(false);
        mainFrame.addWindowListener(new WindowHandler() {
         public void windowClosing(WindowEvent windowEvent){
           
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
        topPanel = new JPanel(new GridLayout(3,1));
        topPanel.add(firstPanel);
        topPanel.add(secondPanel);
        topPanel.add(thirdPanel);
        mainFrame.add(topPanel,BorderLayout.PAGE_START);
    }
    
    private void makeBottomPanel()
    {
        bottomPanel = new JPanel(new BorderLayout());
        makeFourthPanel();
        bottomPanel.add(fourthPanel);
        accTypeList = new JList(acc);
        accTypeList.setSelectedIndex(4);
        accTypeList.addMouseMotionListener(new MouseMotionAdapter() {
       
                public void mouseMoved(MouseEvent e)
                {
                    JList l = (JList)e.getSource();
                    ListModel m = l.getModel();
                    int index = l.locationToIndex(e.getPoint());
                    if( index>-1 ) {
                        l.setToolTipText(m.getElementAt(index).toString());
                        switch(index)   
                        {
                            case 0: l.setToolTipText("<html>--" + m.getElementAt(index).toString() + "--<br> Untuk menyimpan uang dengan terhubung ke akun Saving <br> mengijinkan penarikan melebihi balance akun ini selama <br> penarikan tidak melebihi total balance pada akun <br> saving yang terhubung. <br>Penarikan melebihi balance overdraft akan kena fee sebesar 3." + "</html>");
                                    break;
                            case 1: l.setToolTipText("<html>--" + m.getElementAt(index).toString() + "--<br> Untuk menyimpan uang dengan mengijinkan balance negatif <br> selama tidak melebihi credit limit" + "</html>");
                                    break;
                            case 2: l.setToolTipText("<html>--" + m.getElementAt(index).toString() + "--<br> Untuk menyimpan uang standar dengan bunga dan balance non negatif" + "</html>");
                                    break;
                            case 3: l.setToolTipText("<html>--" + m.getElementAt(index).toString() + "--<br> Untuk menyimpan uang jangka panjang, minimal 6 bulan. <br>Penarikan prematur akan terkena penalti 20% dari jumlah yang ditarik." + "</html>");
                                    break;
                            case 4: l.setToolTipText("<html>--" + m.getElementAt(index).toString() + "--<br> Tidak buat akun" + "</html>");
                                    break;
                        }
                    }
                }
        });
        bottomPanel.add(accTypeList,BorderLayout.LINE_END);
        mainFrame.add(bottomPanel);
    }
    /**
     * membuat panel pertama
     */
    private void makeFirstPanel()
    {
        firstPanel = new JPanel(new FlowLayout());
        cancel = new JButton("Cancel");
        cancel.setActionCommand("cancel");
        cancel.addActionListener(this);
        
        saveAndReturn = new JButton("Save & Return");
        saveAndReturn.setActionCommand("save");
        saveAndReturn.addActionListener(this);
        
        custIDField = new JTextField("Cust ID");
        custIDField.setName("Cust ID"); 
        custIDField.setToolTipText("<html>" + "Cust ID - masukkan ID untuk update data" + "<br>" + "DEFAULT untuk buat customer baru" + "</html>");
        custIDField.setColumns(10);
        custIDField.addFocusListener(new CustomFocusListener(custIDField,"Cust ID") );
        
        
        lastNameField = new JTextField("Last Name");
        lastNameField.setName("Last Name");
        lastNameField.setToolTipText("Last Name");
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
        secondPanel = new JPanel(new FlowLayout());
        firstNameField = new JTextField("First Name");
        firstNameField.setName("First Name");
        firstNameField.setToolTipText("First Name");
        firstNameField.setColumns(20);
        firstNameField.addFocusListener(new CustomFocusListener(firstNameField,"First Name") );
         
        addressField = new JTextField("Address");
        addressField.setName("Address");
        addressField.setToolTipText("Address");
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
    
        thirdPanel = new JPanel(new FlowLayout());
        
        cityField = new JTextField("City");
        cityField.setName("City");
        cityField.setToolTipText("City");
        cityField.setColumns(30);
        cityField.addFocusListener(new CustomFocusListener(cityField , "City") );
         
        stateField = new JTextField("State");
        stateField.setName("State");
        stateField.setToolTipText("State");
        stateField.setColumns(10);
        stateField.addFocusListener(new CustomFocusListener(stateField , "State") );
         
        zipField = new JTextField("Zip Code");
        zipField.setName("Zip Code");
        zipField.setToolTipText("Zip Code");
        zipField.setColumns(15);
        zipField.addFocusListener(new CustomFocusListener(zipField, "Zip Code") );
        
        phoneField = new JTextField("Phone");
        phoneField.setName("Phone");
        phoneField.setToolTipText("Phone");
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
        fourthPanel = new JPanel(new FlowLayout());
        emailField = new JTextField("Email Address");
        emailField.setName("Email Address");
        emailField.setToolTipText("example@example.com");
        emailField.setActionCommand("email");
        emailField.addActionListener(this);
        
        emailField.setColumns(25);
        emailField.addFocusListener(new CustomFocusListener(emailField, "Email Address") );
        
        dobField = new JFormattedTextField(format);
        dobField.setText("DOB - yyyy/mm/dd");
        dobField.setName("DOB");
        dobField.setToolTipText("DOB - yyyy/mm/dd");
        dobField.setColumns(20);
        dobField.addFocusListener(new CustomFocusListener(dobField,"DOB - yyyy/mm/dd") );
        
        fourthPanel.add(emailField);
        fourthPanel.add(dobField);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        Date date = new Date();
        System.out.println("selected index "+accTypeList.getSelectedIndex());
        if(command.equals("cancel"))
        {
            resetField();
        }
        else if(command.equals("email"))
        {
            if(!emailValidator(emailField.getText()))
            {
                warning("format email salah !");
            }
        
        }
        else if(command.equals("save"))
        {
          if(cekDefaultField())
          {
              try{
              date = format.parse(dobField.getText());
              }
              catch(ParseException pe){
                warning("format tanggal salah");
              }
              
              try{
                  int custID =  Integer.parseInt(custIDField.getText() ) ;
                  Customer c = Bank.getCustomer(custID);
                  c.setName(firstNameField.getText(),lastNameField.getText());
                  c.setAddress(addressField.getText(),cityField.getText(),stateField.getText(),zipField.getText());
                  c.setPhoneNumber(phoneField.getText());
                  c.setEmail(emailField.getText());
                  c.setDateOfBirthInString(dobField.getText());
                  info("Customer sudah diupdate datanya !");
              }
              catch(Exception cnf )
              {
                  Customer c = new Customer(firstNameField.getText(),lastNameField.getText(),date);
                  c.setPhoneNumber(phoneField.getText());
                  c.setAddress(addressField.getText(),cityField.getText(),stateField.getText(), zipField.getText());
                  c.setEmail(emailField.getText());
                  try{
                      Bank.addCustomer(c);
                      info("Sudah membuat customer baru !!");
                  }
                  catch(MaxCustReached mcr)
                  {
                      System.out.println("!!!!! max cust reached !!!!!");
                      warning( mcr.getMessage() );
                  }
              }
              
         }
         else
         {
             warning("data belum keisi semua !");
         }
        }
    }
    
   private void exitting()
   {
       JOptionPane.showMessageDialog(mainFrame, "You're exitting, goodbye !!","goodbye",JOptionPane.WARNING_MESSAGE);
   }
   
   private boolean cekDefaultField()
   {
       if(lastNameField.getText().equals("Last Name") || firstNameField.getText().equals("First Name") || addressField.getText().equals("Address") || cityField.getText().equals("City") || stateField.getText().equals("State") || zipField.getText().equals("Zip Code") || phoneField.getText().equals("Phone") || emailField.getText().equals("Email Address") || dobField.getText().equals("DOB - yyyy/mm/dd") )
       {
          return false;
       }
       return true;
   }
   
   static public boolean emailValidator(String email)
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
   
   static public void warning(String s)
   {
       JOptionPane.showMessageDialog(mainFrame, s,"Error",JOptionPane.ERROR_MESSAGE);
    }
    
   static public void info(String s)
   {
       JOptionPane.showMessageDialog(mainFrame, s);
    } 
    
   static public void fetchedCustData(Customer c)
   {
       lastNameField.setText( c.getLastName() );
       firstNameField.setText( c.getFirstName() );
       addressField.setText( c.getAddress() );
       cityField.setText( c.getCity() );
       stateField.setText( c.getState() );
       zipField.setText( c.getZip() );
       phoneField.setText( c.getPhoneNumber() );
       emailField.setText( c.getEmail() );
       dobField.setText( c.getDateOfBirthInString() );
       
   }
   
   static public void resetField()
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
   
}
