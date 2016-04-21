import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Write a description of class ATMGUI here.
 * 
 * @author steven susanto 
 * @version 7 April 2016
 */
public class ATMGUI extends JFrame implements FocusListener
{
   private JPanel topPanel;
   private JPanel bottomPanel;
   private JPanel buttonPanel;
   private JPanel JRadioButtonPanel;
   private JPanel infoPanel;
   private JPanel textPanelOne;
   private JPanel textPanelTwo;
   private JLabel     enterCustIDLabel;
   private JTextField enterCustIDTextField;
   private JLabel     enterAmountHereLabel;
   private JTextField enterAmountHereTextField;
   private ButtonGroup group;
   private JRadioButton savingsButton;
   private JRadioButton InvestmentButton;
   private JRadioButton LOCButton;
   private JRadioButton OverdraftButton;
   private JButton depositButton;
   private JButton withdrawButton;
   private JButton exitButton;
   private JButton totalButton;
   private JTextArea infoTextArea;
   private JScrollPane vScroll;
   private JScrollPane hScroll;
   private ButtonHandler buttonHandler;
   
    /**
     * Constructor for objects of class ATMGUI
     */
    public ATMGUI()
    {
       super("ATMGUI Layout");
       buildGUI();
    }

    /**
     * fungsi untuk membuat GUI
     * 
     */
    private void buildGUI()
    {
        //-------------membuat frame baru dan mengaturnya dengan ukuran sekian-------//
        
        setSize(700,300);
        setResizable(false);
        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowHandler(this) );  
        
        makeTopPanel();         //membuat panel bagian atas
        makeBottomPanel();      //membuat panel bagian bawah
      
        add(topPanel);    //memasukkan panel ke mainFrame
        add(bottomPanel);
        setVisible(true);  //menampilkan frame keseluruhan
        
    }
    
   /**
    * membuat top panel
    */
   private void makeTopPanel()
   {    
       //----------membuat tombol radio satu persatu-------------//
        JRadioButtonPanel = new JPanel(new GridLayout(4,1));
        
        savingsButton = new JRadioButton("Savings");
        savingsButton.setToolTipText("<html>--" + "Savings" + "--<br> Untuk menyimpan uang standar dengan bunga dan balance non negatif" + "</html>");
        savingsButton.setBackground(Color.WHITE);
        
        InvestmentButton = new JRadioButton("Investment");
        InvestmentButton.setToolTipText("<html>--" + "Investment" + "--<br> Untuk menyimpan uang jangka panjang, minimal 6 bulan. <br>Penarikan prematur akan terkena penalti 20% dari jumlah yang ditarik." + "</html>");
        InvestmentButton.setBackground(Color.WHITE);
        
        
        LOCButton     = new JRadioButton("Line Of Credit");
        LOCButton.setToolTipText("<html>--" + "Line Of Credit" + "--<br> Untuk menyimpan uang dengan mengijinkan balance negatif <br> selama tidak melebihi credit limit" + "</html>");
        LOCButton.setBackground(Color.WHITE);
        
        
        OverdraftButton = new JRadioButton("Overdraft");
        OverdraftButton.setToolTipText("<html>--" + "Overdraft" + "--<br> Untuk menyimpan uang dengan terhubung ke akun Saving <br> mengijinkan penarikan melebihi balance akun ini selama <br> penarikan tidak melebihi total balance pada akun <br> saving yang terhubung. <br>Penarikan melebihi balance overdraft akan kena fee sebesar 3." + "</html>");
        OverdraftButton.setBackground(Color.WHITE);
        
        
        group = new ButtonGroup();
        group.add(savingsButton);
        group.add(InvestmentButton);
        group.add(LOCButton);
        group.add(OverdraftButton);
        //------------membuat label "enter customer id"" dan textfieldnya----------//
        enterCustIDLabel      = new JLabel("Enter Customer ID");
        enterCustIDTextField  = new JTextField("",10);
        enterCustIDTextField.setToolTipText("Enter Customer ID");
        enterCustIDTextField.addFocusListener(this);
        
        //------------membuat label "enter amount"" dan textfieldnya----------//
        enterAmountHereLabel    = new JLabel("Enter amount here");
        enterAmountHereTextField = new JTextField("0",10);
        enterAmountHereTextField.setToolTipText("Enter amount here");
        
        //-------menambahkan setiap radio button ke buttonPanel------//
        JRadioButtonPanel.add(savingsButton);
        JRadioButtonPanel.add(InvestmentButton);
        JRadioButtonPanel.add(LOCButton);
        JRadioButtonPanel.add(OverdraftButton);
        
        //---------memasukkan panel dan setiap komponen ke topPanel-----------//
        topPanel = new JPanel(new FlowLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.add(enterCustIDLabel);
        topPanel.add(enterCustIDTextField);
        topPanel.add(JRadioButtonPanel);
        topPanel.add(enterAmountHereLabel);
        topPanel.add(enterAmountHereTextField);
    }
    
    /**
     * untuk membuat bottom panel, yaitu tampilan bagian stengah ke bawah
     */
   private void makeBottomPanel()
   {
        buttonHandler = new ButtonHandler(this);
       //----------membuat setiap button----------//
        depositButton = new JButton("Deposit");
        depositButton.setActionCommand("deposit");
        depositButton.addActionListener(buttonHandler);
        
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setActionCommand("withdraw");
        withdrawButton.addActionListener(buttonHandler);
        
        exitButton     = new JButton("Exit");
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(buttonHandler);
        
        totalButton     = new JButton("Total");
        totalButton.setActionCommand("total");
        totalButton.addActionListener(buttonHandler);
        
        //----------membuat buttonPanel dan memasukkan setiap button ke panel----------//
        buttonPanel   = new JPanel(new GridLayout(4,1));
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(totalButton);
        buttonPanel.add(exitButton);
        
        //-----------membuat textArea dan mengatur agar warnanya menjadi abu-abu------//
        infoTextArea = new JTextArea("Welcome");
        infoTextArea.setEditable(false);
        infoTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
        infoTextArea.setBackground(Color.GRAY);
        
        //----------membuat bottomPanel dan memasukkan panel dan komponen bagian bawah-------//
        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.GRAY);
        bottomPanel.add(infoTextArea,BorderLayout.CENTER);
        bottomPanel.add(buttonPanel,BorderLayout.LINE_END);
    
    }
  
   
   /**
    * @param String:s - untuk set teks area
    */
   public void setTextArea(String s)
   {
       infoTextArea.setText(s);
   }
   
   public void setTextAreaColor(Color c)
   {
       infoTextArea.setBackground(c);
   }
   
   public String getCustIDText()
   {
       return enterCustIDTextField.getText();
   }
   
   public String getAmountText()
   {
       return enterAmountHereTextField.getText();
    }
    
   public int getCustID() throws NumberFormatException
   {
       try{
           return Integer.parseInt( enterCustIDTextField.getText() );
       }
       catch(NumberFormatException e)
       {
           if(enterCustIDTextField.getText().equals(""))
           {
               throw new NumberFormatException("Enter Customer ID masih kosong !!");
           }
           else
           {
               throw new NumberFormatException("Enter Customer ID tidak diisi dengan angka !!\n\nIsinya : " + enterCustIDTextField.getText());
           }
       }
       
   }
   
   public Double getAmount() throws NumberFormatException
   {
       
       try{
           return Double.parseDouble( enterAmountHereTextField.getText() );
       }
       catch(NumberFormatException e)
       {
           if(enterAmountHereTextField.getText().equals(""))
           {
               throw new NumberFormatException("Enter Amount masih kosong !!");
           }
           else
           {
               throw new NumberFormatException("Enter Amount tidak diisi dengan angka !!\n\nIsinya : " + enterAmountHereTextField.getText());
           }
       }
    }
   
   /**
    * @return ButtonGroup:group - aksesor button group pada class ini
    */
   public ButtonGroup getButtonGroup()
   {
       return group;
   }
   
   public void focusGained(FocusEvent e)
   {
       
   }
   
   public void focusLost(FocusEvent e)
   {
       if(!getCustIDText().equals(""))
       {
           try{
               setTextArea("Nama customer " + Bank.getCustomer(Integer.parseInt(getCustIDText())).getCustName());
               setTextAreaColor(Color.WHITE);
            }
           catch(CustomerNotFound cnf)
           {
               setTextArea("Customer tidak ketemu");
               setTextAreaColor(Color.WHITE);
               warning("Customer tidak ketemu");
           }
       }
   }
   
   /**
    * menampilkan dialog warning dengan pesan s
    * @param String:s - passing string yang ingin ditampilkan
    */
   private void warning(String s)
   {
       JOptionPane.showMessageDialog(this,s,"Error !!",JOptionPane.ERROR_MESSAGE);
   }
   
}
