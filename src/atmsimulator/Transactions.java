
package atmsimulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,balance,ministatement,pinchange,exit;
    String pinnumber;
    Transactions(String pinnumber){
         
        this.pinnumber = pinnumber;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);
        
        JLabel text = new JLabel("please select your Transaction");
        text.setBounds(160, 220,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
         deposit = new JButton("Deposit");
        deposit.setBounds(140,320,120,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(300,320,150,30);
        image.add(withdrawl);
        withdrawl.addActionListener(this);
        
         balance = new JButton("Balance Enquiry");
        balance.setBounds(140,355,120,30);
        image.add(balance);
        balance.addActionListener(this);
        
         ministatement = new JButton("Mini Statement");
        ministatement.setBounds(300,355,150,30);
        image.add(ministatement);
        ministatement.addActionListener(this);
        
         pinchange = new JButton("Pin Change");
        pinchange.setBounds(140,390,120,30);
        image.add(pinchange);
        pinchange.addActionListener(this);
        
         exit = new JButton("Exit");
        exit.setBounds(300,390,150,30);
        image.add(exit);
        
        
        setSize(800,700);
        setLocation(250,0);
        //setUndecorated(true); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
    }
        
    public static void main(String[] args){
        new Transactions("");
    }
}
