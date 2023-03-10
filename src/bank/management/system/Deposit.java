package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pinnumber;

    Deposit(String pinnumber) {

        ImageIcon sbitoplogo = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image sbi2toplogo = sbitoplogo.getImage().getScaledInstance(90, 30, Image.SCALE_DEFAULT);
        ImageIcon sbi3toplogo = new ImageIcon(sbi2toplogo);
        JLabel sbitoplabel = new JLabel(sbi3toplogo);
        sbitoplabel.setBounds(360, 5, 90, 30);
        add(sbitoplabel);

        ImageIcon sbi = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image sbi2 = sbi.getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT);
        ImageIcon sbi3 = new ImageIcon(sbi2);
        JLabel sbilabel = new JLabel(sbi3);
        sbilabel.setBounds(375, 448, 100, 50);
        add(sbilabel);

        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(10, 0, 800, 800);
        add(l3);

        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 18));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(215, 100, 600, 30);
        l3.add(l1);

        t1.setBounds(215, 140, 370, 30);
        l3.add(t1);

        b1.setBounds(425, 255, 150, 35);
        l3.add(b1);

        b2.setBounds(425, 300, 150, 35);
        l3.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(820, 1050);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = t1.getText();
            Date date = new Date();
            if (ae.getSource() == b1) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                } else {
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('" + pinnumber + "', '" + date + "', 'Deposit', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully....");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
            } else if (ae.getSource() == b2) {
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }
}
