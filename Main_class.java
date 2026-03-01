package Employee.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {
    Main_class() {

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.png"));
        Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);

        JLabel heading = new JLabel("DASHBOARD");
        heading.setBounds(450, 120, 600, 150);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setBackground(Color.BLACK);
        heading.setForeground(Color.BLACK);
        img.add(heading);


        JButton add=new JButton("ADD Employee");
        add.setBounds(335,270,150,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.RED);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ADDEmployee();
                setVisible(false);
            }
        });
        img.add(add);

        JButton view=new JButton("VIEW Employee");
        view.setBounds(565,270,150,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.GREEN);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new ViewEmployee();
                setVisible(false);
            }
        });
        img.add(view);

        JButton remove=new JButton("REMOVE Employee");
        remove.setBounds(440,370,150,40);
        remove.setForeground(Color.WHITE);
        remove.setBackground(Color.BLUE);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();
            }
        });
        img.add(remove);

        setTitle("Employee Management System - Dashboard");
        setSize(1120, 630);
        setLocation(250, 100);
        setLayout(null);


        setVisible(true);
    }
    public static void main(String[] args) {
        new Main_class();
    }
}