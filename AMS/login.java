package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {   
    JLabel l1, l2, l3, l4;
    JButton bt1, bt2;
    JPasswordField pf;
    JTextField tf;
    JFrame f;

    Login() {
        f = new JFrame("Login Account");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 580, 350);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AMS/icon/1.jpg"));
        Image i1 = img.getImage().getScaledInstance(580, 350, Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(i1);
        l1.setIcon(img2);
        f.add(l1);

        l2 = new JLabel("Username:");
        l2.setBounds(120, 120, 150, 30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l1.add(l2);

        l3 = new JLabel("Login Account");
        l3.setBounds(190, 30, 500, 50);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Arial", Font.BOLD, 30));
        l1.add(l3);

        l4 = new JLabel("Password:");
        l4.setBounds(120, 170, 150, 30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l1.add(l4);

        tf = new JTextField();
        tf.setBounds(320, 120, 150, 30);
        l1.add(tf);

        pf = new JPasswordField();
        pf.setBounds(320, 170, 150, 30);
        l1.add(pf);

        bt1 = new JButton("Login");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(120, 220, 150, 40);
        l1.add(bt1);

        bt2 = new JButton("Sign Up");
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        bt2.setBounds(320, 220, 150, 40);
        l1.add(bt2);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        f.setVisible(true);
        f.setSize(580, 350);
        f.setLocation(300, 100);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            String username = tf.getText();
            String pass = pf.getText();

            try {
                connectionClass obj = new connectionClass();
                String q = "SELECT * FROM signUp WHERE username = '" + username + "' AND password = '" + pass + "'";
                ResultSet rs = obj.stm.executeQuery(q);

                if (rs.next()) {
                    new HomePage().setVisible(true);
                    f.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "You Have Entered Wrong username And Password!");
                    f.setVisible(false);
                    f.setVisible(true);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == bt2) {
            this.f.setVisible(false);
            new SignUpMessage(); // Open the SignUpMessage frame
        }
    }

    public static void main(String[] agrs) {
        new Login();
    }
}

// New SignUpMessage Class
class SignUpMessage extends JFrame implements ActionListener {
    JFrame frame;
    JButton exitButton;
    JLabel messageLabel;

    SignUpMessage() {
        frame = new JFrame("About Signup");
        frame.setLayout(null);
        
        messageLabel = new JLabel("<html><h1>ABOUT SIGNUP</h1>You cannot sign up yourself in this project.<br>" +
                                  "You have to raise a query to Admin for creating username and password.</html>");
        messageLabel.setBounds(30, 20, 400, 100);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(messageLabel);
        
        exitButton = new JButton("Exit");
        exitButton.setBounds(150, 150, 100, 40);
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(this);
        frame.add(exitButton);

        frame.setSize(400, 250);
        frame.setLocation(500, 300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            frame.dispose(); // Close the frame
        }
    }
}
