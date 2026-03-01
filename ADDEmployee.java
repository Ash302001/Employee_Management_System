package Employee.Management.System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ADDEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(9999);

    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation;
    JLabel tempid;
    JDateChooser tdob;
    JComboBox<String> Boxeducation;

    JButton add, back;

    ADDEmployee() {

        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        JLabel heading = new JLabel("ADD EMPLOYEE DETAIL");
        heading.setBounds(300, 30, 500, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("SERIF", Font.BOLD, 25));
        add(heading);

        // NAME
        JLabel name = new JLabel("NAME :");
        name.setBounds(50, 120, 150, 30);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 120, 150, 30);
        tname.setForeground(Color.pink);
        add(tname);

        // FATHER NAME
        JLabel fname = new JLabel("FATHER'S NAME :");
        fname.setBounds(400, 120, 200, 30);
        fname.setForeground(Color.WHITE);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 120, 150, 30);
        tfname.setForeground(Color.pink);
        add(tfname);

        // DOB
        JLabel dob = new JLabel("DOB :");
        dob.setBounds(50, 170, 150, 30);
        dob.setForeground(Color.WHITE);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(dob);

        tdob = new JDateChooser();
        tdob.setForeground(Color.pink);
        tdob.setBounds(200, 170, 150, 30);
        add(tdob);

        // SALARY
        JLabel salary = new JLabel("SALARY :");
        salary.setBounds(400, 170, 200, 30);
        salary.setForeground(Color.WHITE);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(salary);

        tsalary = new JTextField();
        tsalary.setForeground(Color.pink);
        tsalary.setBounds(600, 170, 150, 30);
        add(tsalary);

        // ADDRESS
        JLabel address = new JLabel("ADDRESS :");
        address.setBounds(50, 220, 150, 30);
        address.setForeground(Color.WHITE);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(address);

        taddress = new JTextField();
        taddress.setForeground(Color.pink);
        taddress.setBounds(200, 220, 150, 30);
        add(taddress);

        // PHONE
        JLabel phone = new JLabel("PHONE :");
        phone.setForeground(Color.WHITE);
        phone.setBounds(400, 220, 200, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(phone);

        tphone = new JTextField();
        tphone.setForeground(Color.pink);
        tphone.setBounds(600, 220, 150, 30);
        add(tphone);

        // EMAIL
        JLabel email = new JLabel("EMAIL :");
        email.setBounds(50, 270, 150, 30);
        email.setForeground(Color.WHITE);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(email);

        temail = new JTextField();
        temail.setForeground(Color.pink);
        temail.setBounds(200, 270, 150, 30);
        add(temail);

        // EDUCATION
        JLabel education = new JLabel("EDUCATION :");
        education.setForeground(Color.WHITE);
        education.setBounds(400, 270, 200, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(education);

        String items[] = {"BBA","B.Tech","BCA","BSc","BCom","MBA","MCA","MTech","MSc","PhD","Other"};
        Boxeducation = new JComboBox<>(items);
        Boxeducation.setForeground(Color.pink);
        Boxeducation.setBounds(600, 270, 150, 30);
        add(Boxeducation);

        // DESIGNATION
        JLabel designation = new JLabel("DESIGNATION :");
        designation.setBounds(50, 320, 200, 30);
        designation.setForeground(Color.WHITE);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setForeground(Color.pink);
        tdesignation.setBounds(200, 320, 150, 30);
        add(tdesignation);

        // AADHAR
        JLabel aadhar = new JLabel("AADHAR NO :");
        aadhar.setBounds(400, 320, 200, 30);
        aadhar.setForeground(Color.WHITE);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(aadhar);

        taadhar = new JTextField();
        heading.setForeground(Color.pink);
        taadhar.setBounds(600, 320, 150, 30);
        add(taadhar);

        // EMP ID
        JLabel empid = new JLabel("EMPLOYEE ID :");
        empid.setBounds(50, 370, 200, 30);
        empid.setForeground(Color.WHITE);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(empid);

        tempid = new JLabel("" + number);
        tempid.setBounds(200, 370, 150, 30);
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        tempid.setForeground(Color.yellow);
        add(tempid);

        // BUTTONS
        add = new JButton("ADD");
        add.setBounds(250, 440, 150, 40);
        add.setForeground(Color.BLACK);
        add.setBackground(Color.GREEN);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(450, 440, 150, 40);
        back.setBackground(Color.RED);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setSize(900, 550);
        setLocation(300, 100);
        setTitle("ADD EMPLOYEE");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {

            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) Boxeducation.getSelectedItem();
            String designation = tdesignation.getText();
            String aadhar = taadhar.getText();
            String empid = tempid.getText();

            try {
                conn c = new conn();
                String query =
                        "insert into employee values('" + name + "','" + fname + "','" + dob + "','" +
                                salary + "','" + address + "','" + phone + "','" + email + "','" +
                                education + "','" + designation + "','" + aadhar + "','" + empid + "')";

                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                setVisible(false);
                new Main_class();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            new Main_class();
        }

        if (e.getSource() == back) {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new ADDEmployee();
    }
}