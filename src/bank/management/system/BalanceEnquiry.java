package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {

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

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(220, 120, 400, 35);
        l1.setFont(new Font("Arial", Font.BOLD, 16));
        l3.add(l1);

        b1.setBounds(425, 300, 150, 35);
        l3.add(b1);
        int balance = 0;
        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
        }

        l1.setText("Your Current Account Balance is Rs. \n" + balance);

        b1.addActionListener(this);

        setSize(820, 1050);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
