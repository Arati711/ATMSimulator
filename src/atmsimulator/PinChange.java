

package atmsimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.*;

public class PinChange extends JFrame implements ActionListener{
    
    JButton change,back;
   JPasswordField repin,pin;
   String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);
        
        JLabel text = new JLabel("Change your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(230,230,400,20);
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD,16));
        pintext.setBounds(150,260,400,20);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD,25));
        pin.setBounds(300,260,150,20);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD,16));
        repintext.setBounds(150,300,400,20);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD,25));
        repin.setBounds(300,300,150,20);
        image.add(repin);
        
        change = new JButton("Change");
        change.setBounds(350,400,100,20);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(150,400,100,20);
        back.addActionListener(this);
        image.add(back);
        
        setSize(850,800);
        setLocation(350,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == change){
        try{
            String npin = pin.getText();
            String rpin = repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered pin does not match");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter new pin");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Re-enter new pin");
                return;
            }
            Conn conn = new Conn();
            String query1 = "update bank set pinnumber = '"+rpin+"' where pinnumber='"+pinnumber+"' ";
            String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber='"+pinnumber+"' ";
            String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber='"+pinnumber+"' ";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "Pin changed successfully");
            setVisible(false);
            new Transactions(rpin).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
}
    
    public static void main(String[] args){
        new PinChange("").setVisible(true);
}
}
