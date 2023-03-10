package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JButton next;
    JTextField panno, aadharno;
    JRadioButton seniorCitizenYes, seniorCitizenNo, exisitingAccountYes, exisitingAccountNo;
    JComboBox religions, categorys, incomes, educationalQualification, occupations;
    String formno;

    SignupTwo(String formno) {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(20, 20, 250, 100);
        add(label);

        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        
        JLabel l11 = new JLabel("Form No :- ");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        l11.setBounds(650,10,150,30);
        add(l11);
        
        JLabel l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(740,10,150,30);
        add(l12);
        
        
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 30));
        additionalDetails.setBounds(290, 50, 400, 40);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion :- ");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 150, 30);
        add(religion);

        String valReligion[] = {"Select", "Hindu", "Muslim", "Buddhist", "Jain", "Sikh", "Christian", "Others"};
        religions = new JComboBox(valReligion);
        religions.setFont(new Font("Raleway", Font.BOLD, 16));
        religions.setBounds(300, 140, 400, 30);
        religions.setBackground(Color.white);
        add(religions);

        JLabel category = new JLabel("Category :- ");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String valcategory[] = {"Select", "General", "OBC", "SC", "ST", "Other"};
        categorys = new JComboBox(valcategory);
        categorys.setFont(new Font("Raleway", Font.BOLD, 16));
        categorys.setBounds(300, 190, 400, 30);
        categorys.setBackground(Color.white);
        add(categorys);

        JLabel income = new JLabel("Income :- ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String incomecategory[] = {"Select", "Null", "< 1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "> 10,00,000"};
        incomes = new JComboBox(incomecategory);
        incomes.setFont(new Font("Raleway", Font.BOLD, 16));
        incomes.setBounds(300, 240, 400, 30);
        incomes.setBackground(Color.white);
        add(incomes);

        JLabel Education = new JLabel("Educational  ");
        Education.setFont(new Font("Raleway", Font.BOLD, 20));
        Education.setBounds(100, 290, 200, 30);
        add(Education);

        JLabel qualifiacation = new JLabel("Qualifiacation :- ");
        qualifiacation.setFont(new Font("Raleway", Font.BOLD, 20));
        qualifiacation.setBounds(100, 315, 200, 30);
        add(qualifiacation);

        String educationvalue[] = {"Select", "Matriculation", "UnderGraduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        educationalQualification = new JComboBox(educationvalue);
        educationalQualification.setFont(new Font("Raleway", Font.BOLD, 16));
        educationalQualification.setBounds(300, 315, 400, 30);
        educationalQualification.setBackground(Color.white);
        add(educationalQualification);

        JLabel occupation = new JLabel("Occupation :- ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 380, 200, 30);
        add(occupation);

        String occupationvalue[] = {"Select", "Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others"};
        occupations = new JComboBox(occupationvalue);
        occupations.setFont(new Font("Raleway", Font.BOLD, 16));
        occupations.setBounds(300, 380, 400, 30);
        occupations.setBackground(Color.white);
        add(occupations);

        JLabel Pan = new JLabel("Pancard Number :- ");
        Pan.setFont(new Font("Raleway", Font.BOLD, 20));
        Pan.setBounds(100, 440, 200, 30);
        add(Pan);

        panno = new JTextField();
        panno.setFont(new Font("Raleway", Font.BOLD, 16));
        panno.setBounds(300, 440, 400, 30);
        add(panno);

        JLabel aadhar = new JLabel("Aadhar Number :- ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 200, 30);
        add(aadhar);

        aadharno = new JTextField();
        aadharno.setFont(new Font("Raleway", Font.BOLD, 16));
        aadharno.setBounds(300, 490, 400, 30);
        add(aadharno);

        JLabel senior = new JLabel("Senior Citizen :- ");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 540, 200, 30);
        add(senior);

        seniorCitizenYes = new JRadioButton("Yes");
        seniorCitizenYes.setBounds(320, 540, 100, 30);
        seniorCitizenYes.setBackground(Color.white);
        add(seniorCitizenYes);

        seniorCitizenNo = new JRadioButton("No");
        seniorCitizenNo.setBounds(470, 540, 120, 30);
        seniorCitizenNo.setBackground(Color.white);
        add(seniorCitizenNo);

        ButtonGroup citizenGroup = new ButtonGroup();
        citizenGroup.add(seniorCitizenYes);
        citizenGroup.add(seniorCitizenNo);

        JLabel exisitingAcc = new JLabel("Exisiting Account :- ");
        exisitingAcc.setFont(new Font("Raleway", Font.BOLD, 20));
        exisitingAcc.setBounds(100, 590, 200, 30);
        add(exisitingAcc);

        exisitingAccountYes = new JRadioButton("Yes");
        exisitingAccountYes.setBounds(320, 590, 100, 30);
        exisitingAccountYes.setBackground(Color.white);
        add(exisitingAccountYes);

        exisitingAccountNo = new JRadioButton("No");
        exisitingAccountNo.setBounds(470, 590, 120, 30);
        exisitingAccountNo.setBackground(Color.white);
        add(exisitingAccountNo);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(exisitingAccountYes);
        existingGroup.add(exisitingAccountNo);

        JButton next = new JButton("Next");
        next.setBackground(Color.darkGray);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 35);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String sreligions = (String) religions.getSelectedItem(); // setText
        String scategorys = (String) categorys.getSelectedItem();
        String sincomes = (String) incomes.getSelectedItem();
        String seducationalQualification = (String) educationalQualification.getSelectedItem();
        String soccupations = (String) occupations.getSelectedItem();

        String seniorCitizens = null;
        if (seniorCitizenYes.isSelected()) {
            seniorCitizens = "Yes";
        } else if (seniorCitizenNo.isSelected()) {
            seniorCitizens = "No";
        }

        String exisitingAccounts = null;
        if (exisitingAccountYes.isSelected()) {
            exisitingAccounts = "Yes";
        } else if (exisitingAccountNo.isSelected()) {
            exisitingAccounts = "No";
        }

        String span = panno.getText();
        String saadhar = aadharno.getText();

        try {

            if (sreligions.equals("Select")) {
                JOptionPane.showMessageDialog(null, "Religion is Required......");
            } else if (scategorys.equals("Select")) {
                JOptionPane.showMessageDialog(null, "Category is Required....");
            } else if (sincomes.equals("Select")) {
                JOptionPane.showMessageDialog(null, "Income is Required....");
            } else if (seducationalQualification.equals("Select")) {
                JOptionPane.showMessageDialog(null, "Educational Qualification is Required....");
            } else if (soccupations.equals("Select")) {
                JOptionPane.showMessageDialog(null, "Occupations is Required....");
            } else if (span.equals("")) {
                JOptionPane.showMessageDialog(null, "Pancard Number is Required....");
            } else if (saadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Aadhar Number is Required....");
            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno + "', '" + sreligions + "', '" + scategorys + "', '" + sincomes + "', '" + seducationalQualification + "', '" + soccupations + "', '" + span + "', '" + saadhar + "', '" + seniorCitizens + "', '" + exisitingAccounts + "')";
                c.s.executeUpdate(query);

                // Signup 3 Object
                new SignupThree(formno).setVisible(true);
                setVisible(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
