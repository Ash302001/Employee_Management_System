package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Random;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice choiceEmpID;

    JButton delete,back;

    RemoveEmployee()
    {
        JLabel label=new JLabel("EMPLOYEE ID :");
        label.setBounds(50,50,150,20);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        add(label);

        choiceEmpID=new Choice();
        choiceEmpID.setBounds(200,50,150,30);
        add(choiceEmpID);


        try {
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from employee");
            while (resultSet.next())
            {
                choiceEmpID.add(resultSet.getString("empID"));
            }
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }

        //name
        JLabel labelname=new JLabel("NAME :");
        labelname.setBounds(50,100,100,20);
        labelname.setFont(new Font("Tahoma",Font.BOLD,15));
        labelname.setForeground(Color.WHITE);
        add(labelname);

        JLabel textName=new JLabel();
        textName.setBounds(200,100,100,20);
        textName.setFont(new Font("SERIF",Font.BOLD,20));
        textName.setForeground(Color.WHITE);
        add(textName);

        //phone

        JLabel labelphone=new JLabel("PHONE NO :");
        labelphone.setBounds(50,150,100,20);
        labelphone.setFont(new Font("Tahoma",Font.BOLD,15));
        labelphone.setForeground(Color.WHITE);
        add(labelphone);

        JLabel textphone=new JLabel();
        textphone.setBounds(200,150,100,20);
        textphone.setForeground(Color.WHITE);
        textphone.setFont(new Font("SERIF",Font.BOLD,20));

        add(textphone);

        //email

        JLabel labelemail=new JLabel("EMAIL :");
        labelemail.setBounds(50,200,100,20);
        labelemail.setFont(new Font("Tahoma",Font.BOLD,15));
        labelemail.setForeground(Color.WHITE);
        add(labelemail);

        JLabel textemail=new JLabel();
        textemail.setBounds(200,200,100,20);
        textemail.setForeground(Color.WHITE);
        textemail.setFont(new Font("SERIF",Font.BOLD,20));
        add(textemail);

        try
        {
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from employee where empID='"+choiceEmpID.getSelectedItem()+"'");
            while (resultSet.next())
            {
                textName.setText(resultSet.getString("name"));
                textphone.setText(resultSet.getString("phone"));
                textemail.setText(resultSet.getString("email"));

            }

        }catch (Exception E)
        {
            E.printStackTrace();
        }

        choiceEmpID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {

                    conn c=new conn();
                    ResultSet resultSet=c.statement.executeQuery("select * from employee where empID='"+choiceEmpID.getSelectedItem()+"'");
                    while (resultSet.next())
                    {
                        textName.setText(resultSet.getString("name"));
                        textphone.setText(resultSet.getString("phone"));
                        textemail.setText(resultSet.getString("email"));

                    }
                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        //delete
        delete =new JButton("DELETE");
        delete.setBounds(80,300,100,20);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        //back
        back =new JButton("BACK");
        back.setBounds(220,300,100,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);



        //img-delete

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(600,50,300,200);
        add(img);



        //rback
        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/deleteBG.png"));
        Image i22=i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel image=new JLabel(i33);
        image.setBounds(0,0,1120,630);
        add(image);


        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==delete)
        {
            try {
                conn c=new conn();
                String query="delete from employee where empID = '"+choiceEmpID.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee DELETED Successfully");
                setVisible(false);
                new Main_class();
            }catch (Exception E)
            {
                E.printStackTrace();
            }

        }
        else
        {
            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new RemoveEmployee();

    }
}
