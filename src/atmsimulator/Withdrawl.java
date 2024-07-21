

package atmsimulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JButton withdraw,back;
    JTextField amount;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(150,230,400,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,22));
        amount.setBounds(150,280,300,25);
        image.add(amount);
        
         withdraw = new JButton("Withdraw");
        withdraw.setBounds(350,400,100,20);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
         back = new JButton("Back");
        back.setBounds(150,400,100,20);
        back.addActionListener(this);
        image.add(back);
        
        setSize(850,800);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
            }else{
                try{
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+"withdraw Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                 }catch (Exception e){
                            System.out.println(e);
                 }
            }
        } else if(ae.getSource() == back){
         setVisible(false);
         new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Withdrawl("");
    }
}
