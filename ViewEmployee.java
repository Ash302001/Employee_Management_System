package Employee.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {

    JTable table;
    Choice choiceEMP;
    JButton searchBt, print, update, back;

    ViewEmployee() {

        // Frame basic setup
        setLayout(null);
        getContentPane().setBackground(Color.ORANGE);

        // Search label
        JLabel search = new JLabel("SEARCH BY EMPLOYEE ID");
        search.setFont(new Font("Arial", Font.BOLD, 16));
        search.setBounds(60, 30, 360, 30);
        add(search);

        // Choice dropdown
        choiceEMP = new Choice();
        choiceEMP.setFont(new Font("Arial", Font.PLAIN, 15));
        choiceEMP.setBounds(420, 30, 250, 30);
        add(choiceEMP);

        // Load emp IDs
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select empID from employee");

            while (rs.next()) {
                choiceEMP.add(rs.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Buttons
        searchBt = new JButton("SEARCH");
        searchBt.setBounds(40, 80, 100, 30);
        searchBt.addActionListener(this);
        add(searchBt);

        print = new JButton("PRINT");
        print.setBounds(160, 80, 100, 30);
        print.addActionListener(this);
        add(print);

        update = new JButton("UPDATE");
        update.setBounds(280, 80, 100, 30);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setBounds(400, 80, 100, 30);
        back.addActionListener(this);
        add(back);

        // Table
        table = new JTable();
        loadAllEmployees();

        JScrollPane sp = new JScrollPane(
                table,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
        );
        sp.setBounds(0, 130, 900, 520);
        add(sp);

        // Frame final settings
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Load all employees into table
    private void loadAllEmployees() {
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            setColumnWidth();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Set column widths manually (important)
    private void setColumnWidth() {

        table.getColumnModel().getColumn(0).setPreferredWidth(120); // name
        table.getColumnModel().getColumn(1).setPreferredWidth(120); // fname
        table.getColumnModel().getColumn(2).setPreferredWidth(100); // dob
        table.getColumnModel().getColumn(3).setPreferredWidth(100); // salary
        table.getColumnModel().getColumn(4).setPreferredWidth(180); // address
        table.getColumnModel().getColumn(5).setPreferredWidth(120); // phone
        table.getColumnModel().getColumn(6).setPreferredWidth(180); // email
        table.getColumnModel().getColumn(7).setPreferredWidth(120); // education
        table.getColumnModel().getColumn(8).setPreferredWidth(120); // designation
        table.getColumnModel().getColumn(9).setPreferredWidth(160); // aadhar
        table.getColumnModel().getColumn(10).setPreferredWidth(100); // empID
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == searchBt) {

            String empId = choiceEMP.getSelectedItem();
            String query = "select * from employee where empID='" + empId + "'";

            try {
                conn c = new conn();
                ResultSet rs = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                setColumnWidth();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == print) {

            try {
                table.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == update) {

            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem());

        } else if (e.getSource() == back) {

            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}