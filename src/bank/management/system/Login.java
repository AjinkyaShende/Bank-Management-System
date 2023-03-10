package bank.management.system;

//import com.mysql.cj.PingTarget;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField paintTextField;

    Login() {

        setTitle("AUTOMATED TELLER MACHINE (ATM)");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(20, 20, 250, 100);
        add(label);

        JLabel text = new JLabel("Welcome to SBI ");
        text.setFont(new Font("Raleway", Font.BOLD, 40));
        text.setBounds(300, 50, 400, 40);
        text.setForeground(Color.darkGray);
        add(text);

        JLabel cardno = new JLabel("Card No :- ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 25));
        cardno.setBounds(100, 180, 150, 40);
        add(cardno);
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 180, 250, 40);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 18));
        add(cardTextField);

        JLabel pin = new JLabel("PIN :- ");
        pin.setFont(new Font("Osward", Font.BOLD, 25));
        pin.setBounds(100, 250, 400, 40);
        add(pin);
        paintTextField = new JPasswordField();
        paintTextField.setBounds(300, 250, 250, 40);
        paintTextField.setFont(new Font("Arial", Font.BOLD, 18));
        add(paintTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300, 320, 100, 30);
        login.setBackground(Color.darkGray);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(450, 320, 100, 30);
        clear.setBackground(Color.darkGray);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGNUP");
        signup.setBounds(300, 380, 250, 30);
        signup.setBackground(Color.darkGray);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);

        setSize(800, 500);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == clear) {
            cardTextField.setText("");
            paintTextField.setText("");

        } else if (ae.getSource() == login) {
            
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = paintTextField.getText();
            String query = "select * from login where cardnumber = '"+ cardnumber + "' and pin = '"+ pinnumber + "' ";
            
            try {
                ResultSet rs = conn.s.executeQuery(query);
                
                if(rs.next()) {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number Or Pin.");
                }
                    
                
            } catch(Exception e) {
                
            }
            
            

        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }

    }

    public static void main(String args[]) {
        new Login();
    }
}
