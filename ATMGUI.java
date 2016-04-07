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
public class ATMGUI extends JPanel implements ActionListener
{
   private Frame mainFrame;
   private Panel topPanel;
   private Panel bottomPanel;
   private Panel buttonPanel;
   private Panel checkboxPanel;
   private Panel infoPanel;
   private Panel textPanelOne;
   private Panel textPanelTwo;
   private int  count;
   private Label     enterCustIDLabel;
   private TextField enterCustIDTextField;
   private Label     enterAmountHereLabel;
   private TextField enterAmountHereTextField;
   private CheckboxGroup group1;
   private Checkbox savingsButton;
   private Checkbox InvestmentButton;
   private Checkbox LOCButton;
   private Checkbox OverdraftButton;
   private Button depositButton;
   private Button withdrawButton;
   private Button exitButton;
   private TextArea welcomeTextArea;
   private ScrollPane vScroll;
   private ScrollPane hScroll;
   
    /**
     * Constructor for objects of class ATMGUI
     */
    public ATMGUI()
    {
       buildGUI();
    }

    private void buildGUI()
    {
        
        mainFrame = new JFrame("ATMGUI Layout");
        mainFrame.setSize(700,300);
        mainFrame.setResizable(false);
        mainFrame.setLayout(new GridLayout(2,1));
        mainFrame.addWindowListener(new WindowHandler() {
         public void windowClosing(WindowEvent windowEvent){
            try{
             WindowHandler.showExit();
            }
            catch(InterruptedException e)
            {
             
            }
            System.exit(0);
        }        
        });  
        
        
        checkboxPanel = new Panel(new GridLayout(4,1));
        savingsButton = new Checkbox("Savings");
        InvestmentButton = new Checkbox("Investment");
        LOCButton     = new Checkbox("Line Of Credit");
        OverdraftButton = new Checkbox("Overdraft");
        
        enterCustIDLabel      = new Label("Enter Customer ID");
        enterCustIDTextField  = new TextField("",20);
        enterAmountHereLabel    = new Label("Enter amount here");
        enterAmountHereTextField = new TextField("",20);
        
        checkboxPanel.add(savingsButton);
        checkboxPanel.add(InvestmentButton);
        checkboxPanel.add(LOCButton);
        checkboxPanel.add(OverdraftButton);
        
        topPanel = new Panel(new FlowLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.add(enterCustIDLabel);
        topPanel.add(enterCustIDTextField);
        topPanel.add(checkboxPanel);
        topPanel.add(enterAmountHereLabel);
        topPanel.add(enterAmountHereTextField);
        
        depositButton = new Button("Deposit");
        withdrawButton = new Button("Withdraw");
        exitButton     = new Button("Exit");
        
        buttonPanel   = new Panel(new GridLayout(3,1));
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(exitButton);
        
        welcomeTextArea = new TextArea("Welcome");
        welcomeTextArea.setBackground(Color.GRAY);
        bottomPanel = new Panel(new BorderLayout());
        bottomPanel.setBackground(Color.GRAY);
        bottomPanel.add(welcomeTextArea,BorderLayout.CENTER);
        bottomPanel.add(buttonPanel,BorderLayout.LINE_END);
   
      
        mainFrame.add(topPanel);
        mainFrame.add(bottomPanel);
        mainFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        count = 0;
    }
}
