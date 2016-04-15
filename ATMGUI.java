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
public class ATMGUI extends JFrame
{
   private JFrame mainFrame;
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
       
       buildGUI();
    }

    /**
     * fungsi untuk membuat GUI
     * 
     */
    private void buildGUI()
    {
        //-------------membuat frame baru dan mengaturnya dengan ukuran sekian-------//
        mainFrame = new JFrame("ATMGUI Layout");
        mainFrame.setSize(700,300);
        mainFrame.setResizable(false);
        mainFrame.setLayout(new GridLayout(2,1));
        
        
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
        
        makeTopPanel();         //membuat panel bagian atas
        makeBottomPanel();      //membuat panel bagian bawah
      
        mainFrame.add(topPanel);    //memasukkan panel ke mainFrame
        mainFrame.add(bottomPanel);
        mainFrame.setVisible(true);  //menampilkan frame keseluruhan
    }
    
   /**
    * membuat top panel
    */
   private void makeTopPanel()
   {    
       //----------membuat tombol radio satu persatu-------------//
        JRadioButtonPanel = new JPanel(new GridLayout(4,1));
        
        savingsButton = new JRadioButton("Savings");
        savingsButton.setBackground(Color.WHITE);
        
        InvestmentButton = new JRadioButton("Investment");
        InvestmentButton.setBackground(Color.WHITE);
        
        
        LOCButton     = new JRadioButton("Line Of Credit");
        LOCButton.setBackground(Color.WHITE);
        
        
        OverdraftButton = new JRadioButton("Overdraft");
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
        enterAmountHereLabel    = new JLabel("Enter amount here");
        enterAmountHereTextField = new JTextField("",10);
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
        infoTextArea.setBackground(Color.GRAY);
        
        //----------membuat bottomPanel dan memasukkan panel dan komponen bagian bawah-------//
        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.GRAY);
        bottomPanel.add(infoTextArea,BorderLayout.CENTER);
        bottomPanel.add(buttonPanel,BorderLayout.LINE_END);
    
    }
    
   /**
    * @return TextArea - aksesor text area informasi
    */
   public JTextArea getTextArea()
   {
       return infoTextArea;
   }
   
   /**
    * @param String:s - untuk set teks area
    */
   public void setTextArea(String s)
   {
       infoTextArea.setText(s);
   }
   
   /**
    * @return TextField:custIDtextField - aksesor text field cust ID
    */
   public JTextField getCustIDTextField()
   {
       return enterCustIDTextField;
   }
   
   public String getCustIDText()
   {
       return enterCustIDTextField.getText();
   }
   
   /**
    * @return TextField:amountTextField - aksesor text field amount
    */
   public JTextField getAmountTextField()
   {
       return enterAmountHereTextField;
   }
   
   public String getAmountText()
   {
       return enterAmountHereTextField.getText();
    }
   
   /**
    * @return ButtonGroup:group - aksesor button group pada class ini
    */
   public ButtonGroup getButtonGroup()
   {
       return group;
   }
   
   /**
    * @return Frame:mainFrame - aksesor untuk mainFrame
    */
   public Frame getMainFrame()
   {
       return mainFrame;
   }
}
