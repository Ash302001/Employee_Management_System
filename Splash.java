package Employee.Management.System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash() {
        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
            Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
            JLabel image = new JLabel(new ImageIcon(i2));
            image.setBounds(0, 0, 1170, 650);
            add(image);
        } catch (Exception e) { System.out.println("Splash image not found."); }

        setSize(1170, 650);
        setLocation(200, 50);
        setLayout(null);
        setVisible(true);

        try {
            Thread.sleep(5000); // 5-second wait
            setVisible(false);
            new Login(); // Loads Login screen
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}