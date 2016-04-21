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
public class CustomerGUI extends JFrame implements ActionListener,MouseMotionListener,ListSelectionListener
{
   private JPanel topPanel;
   private JPanel bottomPanel;
   private JPanel firstPanel;
   private JButton cancel;
   private JButton saveAndReturn;
   private JTextField custIDField;
   private JTextField lastNameField;
   
   private JPanel secondPanel;
   private JTextField firstNameField;
   private JTextField addressField;
   
   private JPanel thirdPanel;
   private JTextField cityField;
   private JTextField stateField;
   private JTextField zipField;
   private JTextField phoneField;
   
   private JPanel fourthPanel;
   private JTextField emailField;
   private JTextField amountField;
   private JTextField termField;
   private JTextField creditLimitField;
   private JPanel     accountPanel;
   private DateFormat format = new SimpleDateFormat("yyyy/mm/dd");
   private JFormattedTextField dobField;
   private JList accTypeList;
   
   static private String[] acc = {"Checking/Overdraft","Line of Credit","Savings","Investment","Other"};
   
   static private String cek = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
   static private java.util.regex.Pattern p = java.util.regex.Pattern.compile(cek);
    
    
    /**
     * Constructor for objects of class CustomerGUI
     */
    public CustomerGUI()
    {
       super("Customer GUI");
       buildGUI();
    }

    /**
     * membangun tampilan GUI
     */
    private void buildGUI()
    {
        setLayout(new GridLayout(2,1));
        setSize(700,400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowHandler(this) );  
        
        makeTopPanel();
        makeBottomPanel();
        setVisible(true);
        
     /* mainFrame = new JFrame("Customer GUI");
        mainFrame.setLayout(new GridLayout(2,1));
        mainFrame.setSize(700,400);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainFrame.addWindowListener(new WindowHandler(mainFrame) );  
        
        makeTopPanel();
        makeBottomPanel();
        mainFrame.setVisible(true);
     */
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
        add(topPanel,BorderLayout.PAGE_START);
    }
    
    private void makeBottomPanel()
    {
        bottomPanel = new JPanel(new BorderLayout());
        makeFourthPanel();
        bottomPanel.add(fourthPanel);
        accTypeList = new JList(acc);
        accTypeList.setSelectedIndex(4);
        accTypeList.addMouseMotionListener(this);
        
        accTypeList.addListSelectionListener(this);
        
        makeAccountPanel();
        bottomPanel.add(accountPanel,BorderLayout.SOUTH);
        bottomPanel.add(accTypeList,BorderLayout.LINE_END);
        add(bottomPanel);
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
        custIDField.addFocusListener(new CustomFocusListener(custIDField,"Cust ID",this) );
        
        
        lastNameField = new JTextField("Last Name");
        lastNameField.setName("Last Name");
        lastNameField.setToolTipText("Last Name");
        lastNameField.setColumns(20);
        lastNameField.addFocusListener(new CustomFocusListener(lastNameField,"Last Name",this) );
         
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
        firstNameField.addFocusListener(new CustomFocusListener(firstNameField,"First Name",this) );
         
        addressField = new JTextField("Address");
        addressField.setName("Address");
        addressField.setToolTipText("Address");
        addressField.setColumns(30);
        addressField.addFocusListener(new CustomFocusListener(addressField , "Address",this) );
         
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
        cityField.addFocusListener(new CustomFocusListener(cityField , "City",this) );
         
        stateField = new JTextField("State");
        stateField.setName("State");
        stateField.setToolTipText("State");
        stateField.setColumns(10);
        stateField.addFocusListener(new CustomFocusListener(stateField , "State",this) );
         
        zipField = new JTextField("Zip Code");
        zipField.setName("Zip Code");
        zipField.setToolTipText("Zip Code");
        zipField.setColumns(15);
        zipField.addFocusListener(new CustomFocusListener(zipField, "Zip Code",this) );
        
        phoneField = new JTextField("Phone");
        phoneField.setName("Phone");
        phoneField.setToolTipText("Phone");
        phoneField.setColumns(25);
        phoneField.addFocusListener(new CustomFocusListener(phoneField , "Phone",this) );
         
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
        emailField.addFocusListener(new CustomFocusListener(emailField, "Email Address",this) );
        
        dobField = new JFormattedTextField(format);
        dobField.setText("DOB - yyyy/mm/dd");
        dobField.setName("DOB");
        dobField.setToolTipText("DOB - yyyy/mm/dd");
        dobField.setColumns(20);
        dobField.addFocusListener(new CustomFocusListener(dobField,"DOB - yyyy/mm/dd",this) );
        
        fourthPanel.add(emailField);
        fourthPanel.add(dobField);
        
    }
    
    /**
     * membuat tempat isi informasi jenis akun untuk customer yang akan dibuat
     */
    private void makeAccountPanel()
    {
        amountField = new JTextField();
        amountField.setColumns(10);
        amountField.setText("Enter Amount");
        amountField.setName("Enter Amount");
        amountField.addFocusListener(new CustomFocusListener(amountField,"Enter Amount",this));
        
        termField   = new JTextField();
        termField.setColumns(10);
        termField.setText("Invest Term");
        termField.setName("Invest Term");
        termField.addFocusListener(new CustomFocusListener(termField,"Invest Term",this));
        
        creditLimitField = new JTextField();
        creditLimitField.setColumns(10);
        creditLimitField.setText("Credit Limit");
        creditLimitField.setName("Credit Limit");
        creditLimitField.addFocusListener(new CustomFocusListener(creditLimitField,"Credit Limit",this));
        
        accountPanel = new JPanel(new FlowLayout());
        
        accountPanel.add(amountField);
        accountPanel.add(termField);
        accountPanel.add(creditLimitField);
        amountField.setVisible(false);
        termField.setVisible(false);
        creditLimitField.setVisible(false);
    
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        Customer c;
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
                  c = updateDataCustomer();
                  
              }
              catch( CustomerNotFound cnf )
              {
                  System.out.println("coba buat cust baru");
                  c = buatCustomerBaru();
                  
              }
              
         }
         else
         {
             warning("data belum keisi semua !");
         }
        }
    }
  
   private void buatAccount(Customer c) throws AccountTypeAlreadyExistsException,NumberFormatException,AccountTypeNotFoundException
   {
       double amount = 0;
       double creditLimit = 0;
       int term = 0;
       
       
       switch( accTypeList.getSelectedIndex() )
       {
           case 0 : amount = getAmount();
                    c.addAccount(amount, 'O' );
                    info("Berhasil menambah tipe Account baru");
                    break;
                    
           case 1 : amount = getAmount();
                    creditLimit = getCreditLimit();
                    c.addAccount(amount, 'L' );
                    try{
                       LineOfCredit l = (LineOfCredit)c.getAccount('L');
                       l.setCreditLimit( creditLimit );
                       info("Berhasil menambah tipe Account baru");
                    }
                    catch(Exception e){}
                    break;
                    
           case 2 : amount = getAmount();
                    c.addAccount(amount, 'S' );
                    info("Berhasil menambah tipe Account baru");
                    break;
                    
           case 3 : amount = getAmount();
                    term = getTerm();
                    c.addAccount(amount, 'I' );
                    try{
                       Investment i = (Investment)c.getAccount('I');
                       i.setTerm( term );
                       info("Berhasil menambah tipe Account baru");
                    }
                    catch(Exception e){}
                    break;
                    
           default: break;
       }
       
   }
    
   private Customer updateDataCustomer() throws CustomerNotFound
   {
       int custID =  0;
       try{
           custID = Integer.parseInt(custIDField.getText() ) ;
       }
       catch(NumberFormatException e)
       {
           System.out.println("update customer - number format exception - Cust ID");
       }
       Customer c = Bank.getCustomer(custID);
       c.setName(firstNameField.getText(),lastNameField.getText());
       c.setAddress(addressField.getText(),cityField.getText(),stateField.getText(),zipField.getText());
       c.setPhoneNumber(phoneField.getText());
       c.setEmail(emailField.getText());
       c.setDateOfBirthInString(dobField.getText());
       info("Customer sudah diupdate datanya !");
       try{
                      System.out.println("cust lama - - - tambah akun");
                      buatAccount(c);
                      
                  }
                  catch(AccountTypeNotFoundException e)
                  {
                      warning( e.getMessage() );
                  }
                  catch(NumberFormatException e)
                  {
                      warning("<html>" + "Tidak membuat account baru <br>" + e.getMessage() + "</html>");
                  }
                  catch(AccountTypeAlreadyExistsException ae){
                      warning( ae.getMessage() );
                  }
       return c;
   }
   
   private Customer buatCustomerBaru()
   {
       Customer c = new Customer(firstNameField.getText(),lastNameField.getText(),dobField.getText());
       c.setPhoneNumber(phoneField.getText());
       c.setAddress(addressField.getText(),cityField.getText(),stateField.getText(), zipField.getText());
       c.setEmail(emailField.getText());
       try{
           Bank.addCustomer(c);
           info("Sudah membuat customer baru !!");
           try{
                      buatAccount(c);
                  }
                  catch(AccountTypeNotFoundException e)
                  {
                      warning( e.getMessage() );
                  }
                  catch(NumberFormatException e)
                  {
                      warning("<html>" + "Tidak membuat account baru <br>" + e.getMessage() + "</html>");
                  }
                  catch(AccountTypeAlreadyExistsException ae){
                      warning( ae.getMessage() );
                  }
           return c;
       }
       catch(MaxCustReached mcr)
       {
           warning( mcr.getMessage() );
       }    
       return null;
   }
    
   private void exitting()
   {
       JOptionPane.showMessageDialog(this, "You're exitting, goodbye !!","goodbye",JOptionPane.WARNING_MESSAGE);
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
   
   public void warning(String s)
   {
       JOptionPane.showMessageDialog(this, s,"Error",JOptionPane.ERROR_MESSAGE);
    }
    
   public void info(String s)
   {
       JOptionPane.showMessageDialog(this, s);
    } 
    
   public void fetchedCustData(Customer c)
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
   
   public void resetField()
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
       accTypeList.setSelectedIndex(4);
   }
   
   private double getAmount() throws NumberFormatException
   {
     try{
        return Double.parseDouble( amountField.getText() );
     }
     catch(NumberFormatException nfe)
     {
        if(amountField.getText().equals(""))
        {
            throw new NumberFormatException("Amount Field masih kosong !!");
        }
        else
        {
            throw new NumberFormatException("Amount Field tidak diisi dengan angka !!");
        }
     }
   }
   
   private int getTerm() throws NumberFormatException
   {
     try{
        return Integer.parseInt( termField.getText() );
     }
     catch(NumberFormatException nfe)
     {
        if(termField.getText().equals(""))
        {
            throw new NumberFormatException("Term Field masih kosong !!");
        }
        else
        {
            throw new NumberFormatException("Term Field tidak diisi dengan angka !!");
        }
     }
   }
   
   private double getCreditLimit() throws NumberFormatException
   {
    try{
        return Double.parseDouble( creditLimitField.getText() );
     }
     catch(NumberFormatException nfe)
     {
        if(creditLimitField.getText().equals(""))
        {
            throw new NumberFormatException("Credit Limit Field masih kosong !!");
        }
        else
        {
            throw new NumberFormatException("Credit Limit Field tidak diisi dengan angka !!");
        }
     }
   
   }
   
   
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
   
   public void mouseDragged(MouseEvent e)
   {}
   
   public void valueChanged(ListSelectionEvent e)
   {
      JList jl = (JList)e.getSource();
      int  i   = jl.getSelectedIndex();
      JTextField jtf1,jtf2,jtf3;
      
      jtf1 = amountField; // get amountField
      jtf1.setText("Enter Amount");
      
      jtf2 = termField; // get invest term field
      jtf2.setText("Invest Term");
      
      jtf3 = creditLimitField; // get credit limit field
      jtf3.setText("Credit Limit");
                    
                    switch(i)
                    {
                        case 0 : jtf1.setVisible(true);
                                 jtf2.setVisible(false);
                                 jtf3.setVisible(false);
                                 break;
                        case 1 : jtf1.setVisible(true);
                                 jtf2.setVisible(false);
                                 jtf3.setVisible(true);
                                 break;
                        case 2 : jtf1.setVisible(true);
                                 jtf2.setVisible(false);
                                 jtf3.setVisible(false);
                                 break;
                        case 3 : jtf1.setVisible(true);
                                 jtf2.setVisible(true);
                                 jtf3.setVisible(false);
                                 break;
                        case 4 : jtf1.setVisible(false);
                                 jtf2.setVisible(false);
                                 jtf3.setVisible(false);
                                 break;
                        default : jtf1.setVisible(false);
                                  jtf2.setVisible(false);
                                  jtf3.setVisible(false);
                    }
                    
                    this.invalidate();
                    this.validate();
   }
   
}

