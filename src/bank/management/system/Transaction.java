package bank.management.system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transaction extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinnumber;
    Transaction(String pinnumber){
        
        
        ImageIcon sbi = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image sbi2 = sbi.getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT);
        ImageIcon sbi3 = new ImageIcon(sbi2);
        JLabel sbilabel = new JLabel(sbi3);
        sbilabel.setBounds(375, 448, 100, 50);
        add(sbilabel);
        
        
        ImageIcon sbitoplogo = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image sbi2toplogo = sbitoplogo.getImage().getScaledInstance(90, 30, Image.SCALE_DEFAULT);
        ImageIcon sbi3toplogo = new ImageIcon(sbi2toplogo);
        JLabel sbitoplabel = new JLabel(sbi3toplogo);
        sbitoplabel.setBounds(360, 5, 90, 30);
        add(sbitoplabel);
        
        
        
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(10, 0, 800, 800);
        add(l2);
        
        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.white);
        l1.setFont(new Font("System", Font.BOLD, 25));
        
       
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("EXIT");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("PIN CHANGE");
        
        setLayout(null);
        
        l1.setBounds(220,100,700,35);
        l2.add(l1);
        
        b1.setBounds(230,155,150,35);
        l2.add(b1);
        
        b2.setBounds(230,205,150,35);
        l2.add(b2);
        
        b3.setBounds(230,253,150,35);
        l2.add(b3);
        
        b4.setBounds(425,155,150,35);
        l2.add(b4);
        
        b5.setBounds(230,300,345,35);
        l2.add(b5);
        
        b6.setBounds(425,205,150,35);
        l2.add(b6);
        
        b7.setBounds(425,255,150,35);
        l2.add(b7);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        
        setSize(820,1050);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){ 
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==b2){ 
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==b3){ 
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==b4){ 
            new MiniStatement(pinnumber).setVisible(true);
        }else if(ae.getSource()==b7){ 
            setVisible(false);
            new Pin(pinnumber).setVisible(true);
        }else if(ae.getSource()==b6){ 
            this.setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==b5){ 
            System.exit(0);
            
            
        }
    }
    
    public static void main(String[] args){
        new Transaction("").setVisible(true);
    }
}
