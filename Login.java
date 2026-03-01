package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    Login() {

        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/second.png"));
        Image bgImg = bgIcon.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH);



        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setBounds(0, 0, 600, 300);
        add(background);

//        ImageIcon sideIcon = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.png"));
//        Image sideImg = sideIcon.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
//        JLabel sideImage = new JLabel(new ImageIcon(sideImg));
//        sideImage.setBounds(360, 40, 220, 220);
//        background.add(sideImage);

        JLabel title = new JLabel("Employee Login");
        title.setBounds(50, 20, 250, 30);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(new Color(40, 40, 40));
        background.add(title);

        JLabel username = new JLabel("Username");
        username.setBounds(50, 80, 100, 25);
        username.setFont(new Font("Arial", Font.BOLD, 14));
        username.setForeground(new Color(60, 60, 60));
        background.add(username);

        tusername = new JTextField();
        tusername.setBounds(160, 80, 170, 28);
        tusername.setFont(new Font("Arial", Font.PLAIN, 14));
        tusername.setBorder(BorderFactory.createLineBorder(new Color(120, 120, 120)));
        background.add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(50, 120, 100, 25);
        password.setFont(new Font("Arial", Font.BOLD, 14));
        password.setForeground(new Color(60, 60, 60));
        background.add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(160, 120, 170, 28);
        tpassword.setFont(new Font("Arial", Font.PLAIN, 14));
        tpassword.setBorder(BorderFactory.createLineBorder(new Color(120, 120, 120)));
        background.add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(160, 170, 170, 30);
        login.setBackground(new Color(0, 153, 153));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Arial", Font.BOLD, 14));
        login.setFocusPainted(false);
        login.addActionListener(this);
        background.add(login);

        back = new JButton("EXIT");
        back.setBounds(160, 210, 170, 30);
        back.setBackground(new Color(220, 80, 80));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setFocusPainted(false);
        back.addActionListener(this);
        background.add(back);



        setSize(600, 300);
        setLocation(450, 200);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {
            try {
                String username = tusername.getText();
                String password = tpassword.getText();

                conn conn = new conn();
                String query = "select * from login where username='" + username + "' and password='" + password + "'";
                ResultSet rs = conn.statement.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Main_class();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == back) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}