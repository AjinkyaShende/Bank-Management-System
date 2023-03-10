package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    
    JButton b1, b2;

    MiniStatement(String pinnumber) {
       
        
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(500, 800);
        setLocation(20, 20);
        
        
        ImageIcon sbi = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image sbi2 = sbi.getImage().getScaledInstance(100, 40, Image.SCALE_DEFAULT);
        ImageIcon sbi3 = new ImageIcon(sbi2);
        JLabel sbilabel = new JLabel(sbi3);
        sbilabel.setBounds(10, 10, 100, 40);
        add(sbilabel);
        
        

        JLabel mini = new JLabel();
        add(mini);

        JLabel l2 = new JLabel("State Bank Of India");
        l2.setForeground(Color.blue);
        l2.setBounds(150, 10, 400, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(40, 70, 500, 20);
        l3.setFont(new Font("Arial", Font.BOLD, 18));
        add(l3);

        JLabel l4 = new JLabel();
        add(l4);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
            while (rs.next()) {
                l3.setText("Card Number :    " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
        }

        try {
            int balance = 0;
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pinnumber + "' order by date desc");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            mini.setBounds(20, 120, 500, 800);
            mini.setFont(new Font("Raleway", Font.BOLD, 12));
            
            
            l4.setText("Your total Balance is Rs. " + balance);
            l4.setFont(new Font("Raleway", Font.BOLD, 18));
            l4.setBounds(50, 100, 500, 30);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(null);
        b1 = new JButton("Exit");
        b1.setFont(new Font("Arial", Font.BOLD, 18));
        add(b1);

        b1.addActionListener(this);

        b1.setBounds(20, 720, 450, 25);
    }

    
    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }

}
