
/**
 *
 * @author feebisharma1
 */
// Assignment 3 - G5
// Alex Jirovsky
// Safwan Hasan
// Tyler M. Johnson
// Haroon Saeed 
//
// We (G18) were assigned the parts 5, 6, 7, and 7b which were completed following the completion of the base question
// which assigned us to create three different classes and incorporate GUI components to write a program that would
// allow a user to perform certain actions on bank accounts. We were meant to utilize four radio buttons, three text
// fields and one push button GUI components. We were meant to create the GUI and implement methods that would allow the
// user to do multiple things including: search for a balance by entering the name of the customer(5), adding interest
// to a customer's account by entering their name(6), displaying all of the customer's info by entering their name(7),
// and allowing the user to exit by choice(7b). All of the assigned GUI components were used to achieve this.
/*Question::
Provide four radio Buttons (title same as operations in the question), three labels(Name, Name, and AccountType), three text fields (to input ‘max’ or ‘min’, to input Amount, and to input AccType) and a “submit” push Button for the following four operations
 (5) Provide a method searchBalancebyName(….) of an account holder and display the result by JOptionPane. Note initially the “text box to input Name” is disabled. But if we select this radio button then the “text box” is enabled. searchBalanceByName(SavingAccount[]   ……, String   name)
(6) Add interest to the account holder’s balance by Name. addInterest method should call deposit(…).Note initially the “text boxes for inputting Name”and rate are disabled. But if we select this radio button then the “text boxes” are enabled. Provide a method:addInterestByName(SavingAccount[ ], String name, double rate)
(7) Display all information about account holders by accountType using JOptionPane. Provide a method: displayAllByAccountType(SavingAccount[ ], accountType); 
(7b) Exit
(Note initially the “text boxes for inputting Name, Name and interest rate , and accountType” are disabled. But if we select this radio button then the “text boxes” are enabled.). */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Account {
    
    private int id;
    private char accountType;
    private double balance;
    private Customer customer;

    Account(){
        id = 0;
        accountType = ' ';
        balance = 0.0;
        customer = null;
    }

    Account (Customer customer, int id, char accountType, double balance) {
        this.id = id;
        this.accountType = accountType;
        this.balance = balance;
        this.customer = customer;
    }

    String getName() {
        return customer.getFirst() + " " + customer.getLast();
    }

    void setName( String first, String last) {
        this.customer = new Customer(first,last);
    }

    int getid() {
        return id;
    }

    void setid(int ID) {
        this.id = ID;
    }

    char getaccountType() {
        return accountType;
    }

    void setaccountType(char type) {
        this.accountType = type;
    }

    double getbalance() {
        return this.balance;
    }

    void setbalance(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) {
        if (getbalance() >= amount) {
            setbalance(getbalance() - amount);
        }
    }

    void deposit(double amount) {
        setbalance(this.balance + amount);
    }

    void displayBalance() {
        
        //System.out.println("Your Balance is: " +getbalance());

    }

    void displayAll() {
        /*
        System.out.println(" Name: " + getstrName());
        System.out.println("Id: " +getid());
        System.out.println("Account Type: " +getaccountType());
        System.out.println("Total Balnce: " +getbalance());
        */
        
        String display;
        
        display = " Name: "+ customer.getFirst()+" "+customer.getLast();
        display += "\nId: " + id;
        display += "\nAccount Type: "+ accountType;
        display += "\nTotal Balance: " + balance;
        
        JOptionPane.showMessageDialog ( null, display , "Displaying all information (Account)", JOptionPane.PLAIN_MESSAGE);
    }
}

class SavingAccount extends Account {
    private double rate;

    SavingAccount(){
        super();
        rate = 0.0;
    }

    SavingAccount( Customer customer, int id, char accountType, double balance, double rate) {
        super(customer, id, accountType, balance);
        this.rate = rate;
    }

    public void addInterst() {
        double interestAmount = (rate/12) * getbalance();
        deposit(interestAmount);
    }

    public void deductLoan(SavingAccount[] loan, char accountType, double amount) {
        double loanDeducted = getbalance() - amount;
    }
    
    void displayAll() {
        /*
        System.out.println(" Name: " + getstrName());
        System.out.println("Id: " +getid());
        System.out.println("Account Type: " +getaccountType());
        System.out.println("Total Balnce: " +getbalance());
        */
        
        String display;
        
        display = " Name: "+ getName();
        display += "\nId: " + getid();
        display += "\nAccount Type: "+ getaccountType();
        display += "\nTotal Balance: " + getbalance();
        display += "\nRate: " + rate;
        
        JOptionPane.showMessageDialog ( null, display , "Displaying all information (Saving Account)", JOptionPane.PLAIN_MESSAGE);
    }
    
}

class Customer {
    private String firstName;
    private String lastName;
    
    Customer(String first, String last){
        firstName = first;
        lastName = last;
    }
    
    void setFirst(String name){
        firstName = name;
    }
    
    void setLast(String name){
        lastName = name;
    }
    
    String getFirst(){
        return firstName;
    }
    
    String getLast(){
        return lastName;
    }
}

public class UseSavingBankAccount extends javax.swing.JFrame {
    boolean bRb1 = false;
    boolean bRb2 = false;
    boolean bRb3 = false;
    boolean bRb4 = false;
    
    private double placeHolder;
    private double balance;

    public SavingAccount[] objAcc = new SavingAccount[50];
    /**
     * Creates new form UseSavingBankAccount
     */
    public UseSavingBankAccount() {
        
        objAcc = this.generateObjectArray();
        
        initComponents();
        
        ButtonGroup group = new ButtonGroup();
        group.add(Rb1);
        group.add(Rb2);
        group.add(Rb3);
        group.add(Rb4);

        Tf1.setEnabled(false);
        Tf2.setEnabled(false);
        Tf3.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        Rb1 = new javax.swing.JRadioButton();
        Rb2 = new javax.swing.JRadioButton();
        Rb3 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Rb4 = new javax.swing.JRadioButton();
        Tf1 = new javax.swing.JTextField();
        Tf2 = new javax.swing.JTextField();
        Tf3 = new javax.swing.JTextField();
        Submit = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        operationsMenu = new javax.swing.JMenu();
        operationsSearchBalance = new javax.swing.JMenuItem();
        operationsAddInterest = new javax.swing.JMenuItem();
        operationsDisplayAccountInfo = new javax.swing.JMenuItem();
        operationsExitWindow = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Rb1.setText("Search Balance By Name");
        Rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rb1ActionPerformed(evt);
            }
        });

        Rb2.setText("Add Interest To Account Holder BY Name");
        Rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rb2ActionPerformed(evt);
            }
        });

        Rb3.setText("Display All Using Account Type");
        Rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rb3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter Name");

        jLabel2.setText("Enter Name");

        jLabel3.setText("Enter A/C Type");

        Rb4.setText("Exit");
        Rb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rb4ActionPerformed(evt);
            }
        });

        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        operationsMenu.setText("Operations");
        operationsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationsMenuActionPerformed(evt);
            }
        });

        operationsSearchBalance.setText("Search Balance by Name");
        operationsSearchBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationsSearchBalanceActionPerformed(evt);
            }
        });
        operationsMenu.add(operationsSearchBalance);

        operationsAddInterest.setText("Add Interest To Account Holder By Name");
        operationsAddInterest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationsAddInterestActionPerformed(evt);
            }
        });
        operationsMenu.add(operationsAddInterest);

        operationsDisplayAccountInfo.setText("Display All Accounts By Type");
        operationsDisplayAccountInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationsDisplayAccountInfoActionPerformed(evt);
            }
        });
        operationsMenu.add(operationsDisplayAccountInfo);

        operationsExitWindow.setText("Exit");
        operationsExitWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationsExitWindowActionPerformed(evt);
            }
        });
        operationsMenu.add(operationsExitWindow);

        jMenuBar1.add(operationsMenu);

        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        exitMenu.add(exitMenuItem);

        jMenuBar1.add(exitMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(Rb4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Rb3)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tf3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Submit))
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Rb1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Rb2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addComponent(Tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rb1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rb2)
                    .addComponent(jLabel2)
                    .addComponent(Tf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rb3)
                    .addComponent(jLabel3)
                    .addComponent(Tf3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rb4)
                    .addComponent(Submit))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rb1ActionPerformed
        // TODO add your handling code here:
        bRb1 = true;
        bRb2 = false;
        bRb3 = false;
        bRb4 = false;
        Tf1.setEnabled(true);
        Tf2.setEnabled(false);
        Tf3.setEnabled(false);
    }//GEN-LAST:event_Rb1ActionPerformed

    private void Rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rb2ActionPerformed
        // TODO add your handling code here:
        bRb1 = false;
        bRb2 = true;
        bRb3 = false;
        bRb4 = false;

        Tf1.setEnabled(false);
        Tf2.setEnabled(true);
        Tf3.setEnabled(false);

    }//GEN-LAST:event_Rb2ActionPerformed

    private void Rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rb3ActionPerformed
        // TODO add your handling code here:
        bRb1 = false;
        bRb2 = false;
        bRb3 = true;

        Tf1.setEnabled(false);
        Tf2.setEnabled(false);
        Tf3.setEnabled(true);
    }//GEN-LAST:event_Rb3ActionPerformed

    private void Rb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rb4ActionPerformed
        // TODO add your handling code here:
        bRb1 = false;
        bRb2 = false;
        bRb3 = false;
        bRb4 = true;

        Tf1.setEnabled(false);
        Tf2.setEnabled(false);
        Tf3.setEnabled(false);
    }//GEN-LAST:event_Rb4ActionPerformed

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        // TODO add your handling code here:
        String textfield1 = Tf1.getText();
        String textfield2 = Tf2.getText();
        String textfield3 = Tf3.getText();

        // System.out.println(textfield);
        if (bRb1){
            searchBalanceByName(objAcc,textfield1);
        }
        else if (bRb2){
            addInterestByName(objAcc, textfield2, 0.03);
        }
        else if (bRb3){
            char textfield = textfield3.charAt(0);
            displayAllByAccountType(objAcc, textfield);
        }
        else
            System.exit(0);
    }//GEN-LAST:event_SubmitActionPerformed

    private void operationsSearchBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operationsSearchBalanceActionPerformed
        // TODO add your handling code here:
        
        //create object for the UseSavingBankAccount class
        UseSavingBankAccount obj = new UseSavingBankAccount();
        
        //create object for the dialog box class
        dlgBoxSearchBalanceByName dBox = new dlgBoxSearchBalanceByName(obj, "Search Balance by Name");
        
        //make the dialog box visible
        dBox.setVisible(true);
        
    }//GEN-LAST:event_operationsSearchBalanceActionPerformed

    private void operationsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operationsMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_operationsMenuActionPerformed

    private void operationsAddInterestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operationsAddInterestActionPerformed
        UseSavingBankAccount obj = new UseSavingBankAccount();
        
        //create object for the dialog box class
        dlgBoxAddInterestByName dBox = new dlgBoxAddInterestByName(obj, "Add Interest By Name");
        
        //make the dialog box visible
        dBox.setVisible(true);
    }//GEN-LAST:event_operationsAddInterestActionPerformed

    private void operationsDisplayAccountInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operationsDisplayAccountInfoActionPerformed
        // TODO add your handling code here:
        UseSavingBankAccount obj = new UseSavingBankAccount();
        
        //create object for the dialog box class
        dlgBoxDisplayAccsByType dBox = new dlgBoxDisplayAccsByType(obj, "Display By Type");
        
        //make the dialog box visible
        dBox.setVisible(true);
    }//GEN-LAST:event_operationsDisplayAccountInfoActionPerformed

    private void operationsExitWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operationsExitWindowActionPerformed
        // TODO add your handling code here:
        
        System.exit(0);
    }//GEN-LAST:event_operationsExitWindowActionPerformed

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitMenuActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        // TODO add your handling code here:
        UseSavingBankAccount obj = new UseSavingBankAccount();
        
        //create object for the dialog box class
        dlgBoxExitProgram dBox = new dlgBoxExitProgram(obj, "Exit Program");
        
        //make the dialog box visible
        dBox.setVisible(true);
    }//GEN-LAST:event_exitMenuItemActionPerformed
    void searchBalanceByName(SavingAccount[] account, String name) {
        Customer[] customers = new Customer[50];
        String fullName;
        for( int i = 0; i < 50; i++) {
            customers[i] = new Customer("Test",(char)(65+i)+"");
            fullName = customers[i].getFirst() + " " + customers[i].getLast();
            if (name.equals(fullName)){
                //placeHolder = account[i].getbalance() + balance;
                JOptionPane.showMessageDialog(null,"<html>" + "Name: " +  fullName  + "<br>" +"Type: " + account[i].getaccountType() + "<br> " +"Balance: " + account[i].getbalance());
                break;
            }
        }
    }

    void addInterestByName(SavingAccount[] account, String name, double rate) {
        Customer[] customers = new Customer[50];
        String fullName;
        for(int i = 0; i < 50; i++){
            customers[i] = new Customer("Test",(char)(65+i)+"");
            fullName = customers[i].getFirst() + " " + customers[i].getLast();
            if ( name.equals(fullName)){
                
                balance = account[i].getbalance() * rate;
                account[i].deposit(balance);
                JOptionPane.showMessageDialog(null,"<html>" + "Name: " +  fullName  + "<br>" +"Type: " + account[i].getaccountType() + "<br> " +"Balance: " + account[i].getbalance());
                break;
            }
        }
    }

    void displayAllByAccountType(SavingAccount[] account, char Type) {
        String finaloutput = " ";
        String fullName;
        Customer[] customers = new Customer[50];
        for(int i = 0; i < 50; i++) {
            customers[i] = new Customer("Test",(char)(65+i)+"");
            if (account[i].getaccountType() == Type) {
                customers[i] = new Customer("Test",(char)(65+i)+"");
                fullName = customers[i].getFirst() + " " + customers[i].getLast();
                finaloutput += ( "Name: " +  fullName  + "  " +"Type: " + account[i].getaccountType() + "   " +"Balance: " + account[i].getbalance() + "\n");
                //JOptionPane.showMessageDialog(null,"<html>" + "Name: " +  account[i].getstrName() + "<br>" +"Type: " + account[i].getaccountType() + "<br> " +"Balance: " + account[i].getbalance());
            }
        }
        JOptionPane.showMessageDialog(null,finaloutput);
    }
    
    public SavingAccount[] generateObjectArray(){
        SavingAccount[] objectArray = new SavingAccount[50];
        
        int id = 100;
        char atype = 'C';
        Customer[] customers = new Customer[50];
        for (int i = 0; i < 50; i++) {
            customers[i] = new Customer("Test",(char)(65+i)+ "");
            objectArray[i] = new SavingAccount(customers[i], id + i, atype , (1000*i), 0.03);
            if (i > 20){
                atype = 'S';
            }
        }
        
        return objectArray;
    } 
     /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UseSavingBankAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UseSavingBankAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UseSavingBankAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UseSavingBankAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UseSavingBankAccount().setVisible(true);
            }
        });
    }

class dlgBoxSearchBalanceByName extends JDialog implements ActionListener{
    JTextField nameTextField = new JTextField(10);
    SavingAccount[] objArray;
    
    dlgBoxSearchBalanceByName(JFrame parent, String title){
        super(parent, title, false);
        
        //sets the layout where it sequentially adds elements to the Dialog Box
        setLayout(new FlowLayout());
        
        //set the size to 300px*200px
        setSize(300, 200);
        
        //create a label that says "Enter a Name"
        JLabel label = new JLabel("Enter a name");
        
        //create a button that says "Enter" and initiates the operation
        JButton enterButton = new JButton("Enter");
        
        //add the GUI elements to the Dialog Box window
        add(label);
        add(nameTextField);
        add(enterButton);
        
        //make the enter button responsive
        enterButton.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        
        String buttonPressed = e.getActionCommand();
        String name;
        
        if(buttonPressed.equals("Enter")){
            //put the string from the text field into name
            name = nameTextField.getText();
            
            //create a UseSavingBankAccount object so a new SavingAccount
            //object array is created upon the constructor being envoked
            UseSavingBankAccount obj = new UseSavingBankAccount();
            
            //call searchBalanceByName in the UseSavingBankAccount class
            //creates a JOptionPane displaying the name and corresponding balance
            obj.searchBalanceByName(objAcc, name);
        }
    }
}

class dlgBoxExitProgram extends JDialog implements ActionListener{
    JTextField nameTextField = new JTextField(10);
    SavingAccount[] objArray;
    
    dlgBoxExitProgram(JFrame parent, String title){
        super(parent, title, false);
        
        //sets the layout where it sequentially adds elements to the Dialog Box
        setLayout(new FlowLayout());
        
        //set the size to 300px*200px
        setSize(300, 200);
        
        //create a button that says "Enter" and initiates the operation
        JButton exitButton = new JButton("Exit");
       
        add(exitButton);
        
        //make the enter button responsive
        exitButton.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        
        String buttonPressed = e.getActionCommand();
        
        if(buttonPressed.equals("Exit")){
            System.exit(0);
        }
    }
}

class dlgBoxAddInterestByName extends JDialog implements ActionListener{
    JTextField nameTextField = new JTextField(10);
    JTextField rateTextField = new JTextField(10);
    SavingAccount[] objArray;
    
    dlgBoxAddInterestByName(JFrame parent, String title){
        super(parent, title, false);
        
        //sets the layout where it sequentially adds elements to the Dialog Box
        setLayout(new FlowLayout());
        
        //set the size to 300px*200px
        setSize(300, 200);
        
        //create a label that says "Enter a Name"
        JLabel nameLabel = new JLabel("Enter a name");
        JLabel rateLabel = new JLabel("Enter a rate");
        
        //create a button that says "Enter" and initiates the operation
        JButton enterButton = new JButton("Enter");
        
        //add the GUI elements to the Dialog Box window
        add(nameLabel);
        add(nameTextField);
        add(rateLabel);
        add(rateTextField);
        add(enterButton);
        
        //make the enter button responsive
        enterButton.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        
        String buttonPressed = e.getActionCommand();
        String name;
        double rate = 0;
        
        if(buttonPressed.equals("Enter")){
            //put the string from the text field into name
            name = nameTextField.getText();
            try
            {
                rate = Double.parseDouble(rateTextField.getText());
            }
            catch (Exception exc)
            {
                JOptionPane.showMessageDialog(null, "Error: Couldn't parse rate to double.");
            } 
            
            //create a UseSavingBankAccount object so a new SavingAccount
            //object array is created upon the constructor being envoked
            UseSavingBankAccount obj = new UseSavingBankAccount();
            
            //call searchBalanceByName in the UseSavingBankAccount class
            //creates a JOptionPane displaying the name and corresponding balance
            obj.addInterestByName(objAcc, name, rate);
        }
    }
}

class dlgBoxDisplayAccsByType extends JDialog implements ActionListener{
    JTextField typeTextField = new JTextField(10);
    SavingAccount[] objArray;
    
    dlgBoxDisplayAccsByType(JFrame parent, String title){
        super(parent, title, false);
        
        //sets the layout where it sequentially adds elements to the Dialog Box
        setLayout(new FlowLayout());
        
        //set the size to 300px*200px
        setSize(300, 200);
        
        //create a label that says "Enter a Name"
        JLabel typeLabel = new JLabel("Enter a type of account (C/S) ");
        
        //create a button that says "Enter" and initiates the operation
        JButton enterButton = new JButton("Enter");
        
        //add the GUI elements to the Dialog Box window
        add(typeLabel);
        add(typeTextField);
        add(enterButton);
        
        //make the enter button responsive
        enterButton.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        
        String buttonPressed = e.getActionCommand();
        String type;
        char typeChar;
        
        if(buttonPressed.equals("Enter")){
            //put the string from the text field into name
            type = typeTextField.getText();
            typeChar = type.charAt(0);
            //create a UseSavingBankAccount object so a new SavingAccount
            //object array is created upon the constructor being envoked
            UseSavingBankAccount obj = new UseSavingBankAccount();
            
            //call searchBalanceByName in the UseSavingBankAccount class
            //creates a JOptionPane displaying the name and corresponding balance
            obj.displayAllByAccountType(objAcc, typeChar);
        }
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Rb1;
    private javax.swing.JRadioButton Rb2;
    private javax.swing.JRadioButton Rb3;
    private javax.swing.JRadioButton Rb4;
    private javax.swing.JButton Submit;
    private javax.swing.JTextField Tf1;
    private javax.swing.JTextField Tf2;
    private javax.swing.JTextField Tf3;
    private javax.swing.JMenu exitMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem operationsAddInterest;
    private javax.swing.JMenuItem operationsDisplayAccountInfo;
    private javax.swing.JMenuItem operationsExitWindow;
    private javax.swing.JMenu operationsMenu;
    private javax.swing.JMenuItem operationsSearchBalance;
    // End of variables declaration//GEN-END:variables
}
