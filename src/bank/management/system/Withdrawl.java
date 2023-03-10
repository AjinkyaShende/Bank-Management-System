package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3, l4;
    String pinnumber;

    Withdrawl(String pinnumber) {

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

        l1 = new JLabel("");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 18));

        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 20));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));

        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(215, 100, 600, 35);
        l3.add(l1);

        l2.setBounds(240, 120, 400, 20);
        l3.add(l2);

        t1.setBounds(240, 160, 310, 30);
        l3.add(t1);

        b1.setBounds(425, 255, 150, 35);
        l3.add(b1);

        b2.setBounds(425, 300, 150, 35);
        l3.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(820, 1050);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = t1.getText();
            Date date = new Date();
            if (ae.getSource() == b1) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                } else {
                    Conn c1 = new Conn();

                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }

                    c1.s.executeUpdate("insert into bank values('" + pinnumber + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdraw Successfully...");

                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
            } else if (ae.getSource() == b2) {
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: " + e);
        }

    }

    public static void main(String[] args) {
        new Withdrawl("").setVisible(true);
    }
}
