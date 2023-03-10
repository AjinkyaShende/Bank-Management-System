package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JTextField t1;
    String pinnumber;

    FastCash(String pinnumber) {

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

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 20));

        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(245, 100, 600, 35);
        l3.add(l1);

        b1.setBounds(230, 155, 150, 35);
        l3.add(b1);

        b2.setBounds(230, 205, 150, 35);
        l3.add(b2);

        b3.setBounds(230, 253, 150, 35);
        l3.add(b3);

        b4.setBounds(425, 155, 150, 35);
        l3.add(b4);

        b5.setBounds(425, 205, 150, 35);
        l3.add(b5);

        b6.setBounds(425, 255, 150, 35);
        l3.add(b6);

        b7.setBounds(230, 300, 345, 35);
        l3.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(820, 1050);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton) ae.getSource()).getText().substring(3); //k
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            String num = "17";
            if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == b7) {
                this.setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } else {
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('" + pinnumber + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully...");

                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
