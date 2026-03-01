package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tfname, taddress, tphone, temail, tsalary, teducation, tdesignation;
    JLabel tname, tdob, taadhar, tempid;

    JButton update, back;
    String empId;

    UpdateEmployee(String empId) {

        this.empId = empId;

        setLayout(null);
        getContentPane().setBackground(Color.CYAN);

        JLabel heading = new JLabel("UPDATE EMPLOYEE DETAILS");
        heading.setBounds(250, 20, 500, 40);
        heading.setFont(new Font("SERIF", Font.BOLD, 26));
        add(heading);

        // ===== LEFT COLUMN =====

        addLabel("NAME", 50, 100);
        tname = addValueLabel(200, 100);

        addLabel("DOB", 50, 150);
        tdob = addValueLabel(200, 150);

        addLabel("ADDRESS", 50, 200);
        taddress = addTextField(200, 200);

        addLabel("EMAIL", 50, 250);
        temail = addTextField(200, 250);

        addLabel("DESIGNATION", 50, 300);
        tdesignation = addTextField(200, 300);

        // ===== RIGHT COLUMN =====

        addLabel("FATHER NAME", 450, 100);
        tfname = addTextField(650, 100);

        addLabel("SALARY", 450, 150);
        tsalary = addTextField(650, 150);

        addLabel("PHONE", 450, 200);
        tphone = addTextField(650, 200);

        addLabel("EDUCATION", 450, 250);
        teducation = addTextField(650, 250);

        addLabel("AADHAR", 450, 300);
        taadhar = addValueLabel(650, 300);

        // EMP ID
        addLabel("EMP ID", 50, 350);
        tempid = addValueLabel(200, 350);
        tempid.setForeground(Color.RED);

        // Buttons
        update = new JButton("UPDATE");
        update.setBounds(250, 420, 150, 40);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setBounds(450, 420, 150, 40);
        back.addActionListener(this);
        add(back);

        loadEmployeeData();

        setSize(900, 550);
        setLocation(300, 100);
        setVisible(true);
    }

    // ===== Helper Methods =====

    private void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text + " :");
        label.setBounds(x, y, 150, 30);
        label.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        add(label);
    }

    private JTextField addTextField(int x, int y) {
        JTextField tf = new JTextField();
        tf.setBounds(x, y, 180, 30);
        add(tf);
        return tf;
    }

    private JLabel addValueLabel(int x, int y) {
        JLabel lbl = new JLabel();
        lbl.setBounds(x, y, 180, 30);
        lbl.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(lbl);
        return lbl;
    }

    // ===== Load Data =====

    private void loadEmployeeData() {
        try {
            conn c = new conn();
            String query = "select * from employee where empID='" + empId + "'";
            ResultSet rs = c.statement.executeQuery(query);

            if (rs.next()) {
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                tdob.setText(rs.getString("dob"));
                taddress.setText(rs.getString("address"));
                tsalary.setText(rs.getString("salary"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                teducation.setText(rs.getString("education"));
                tdesignation.setText(rs.getString("designation"));
                taadhar.setText(rs.getString("aadhar"));
                tempid.setText(rs.getString("empID"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == update) {
            String fname=tfname.getText();
            String salary=tsalary.getText();
            String address=taddress.getText();
            String phone=tphone.getText();
            String email=temail.getText();
            String education=teducation.getText();
            String designation=tdesignation.getText();

            try {
                conn c=new conn();
                String query="update employee set fname ='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where empID ='"+empId+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated successfully");
                setVisible(false);
                new Main_class();

            }catch (Exception E)
            {
                E.printStackTrace();
            }

        } else {
            setVisible(false);
            new ViewEmployee();
        }

    }

    public static void main(String[] args) {
        new UpdateEmployee("101");
    }
}