package AMS;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Random;

public class BookFlight extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JButton bt1, bt2;
    JPanel p1, p2, p3;
    JTextField tf1, tf2, tf3, tf4, tf5;
    Font f, f1;
    Choice ch1, ch2, ch3, ch4, ch5, ch6;

    BookFlight() {
        super("Book Airlines India Flight");
        setLocation(50, 10);
        setSize(1100, 650);

        f = new Font("Arial", Font.BOLD, 25);
        f1 = new Font("Arial", Font.BOLD, 18);

        ch1 = new Choice();
        ch2 = new Choice();
        ch3 = new Choice();
        ch4 = new Choice();
        ch5 = new Choice();
        ch6 = new Choice();

        // Populate 'Source' choices
        try {
            connectionClass obj = new connectionClass();
            String q = "SELECT DISTINCT source FROM flight";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                ch1.add(rest.getString("source"));
            }
            rest.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Populate 'Username' choices
        try {
            connectionClass obj = new connectionClass();
            String q = "SELECT username FROM passenger";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                ch2.add(rest.getString("username"));
            }
            rest.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Initialize labels and text fields
        l1 = new JLabel("Book Airlines India Flight");
        l2 = new JLabel("Ticket Id");
        l3 = new JLabel("Source");
        l4 = new JLabel("Destination");
        l5 = new JLabel("Class");
        l6 = new JLabel("Price");
        l7 = new JLabel("Flight Code");
        l8 = new JLabel("Flight Name");
        l9 = new JLabel("Journey Date");
        l10 = new JLabel("Journey Time");
        l11 = new JLabel("Username");
        l12 = new JLabel("Name");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();

        tf1.setEditable(false);
        tf2.setEditable(false);
        tf5.setEditable(false);

        Random r = new Random();
        tf1.setText("" + Math.abs(r.nextInt() % 100000));
        tf1.setForeground(Color.red);

        // Buttons
        bt1 = new JButton("Book Flight");
        bt2 = new JButton("Back");

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        // Styles
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(new java.awt.Color(232, 2, 125));
        l1.setFont(f);

        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        l12.setFont(f1);

        ch1.setFont(f1);
        ch2.setFont(f1);
        ch3.setFont(f1);
        ch4.setFont(f1);
        ch5.setFont(f1);
        ch6.setFont(f1);

        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);

        bt1.setFont(f1);
        bt2.setFont(f1);

        bt1.setBackground(new java.awt.Color(232, 2, 125));
        bt2.setBackground(Color.BLACK);

        bt1.setForeground(Color.WHITE);
        bt2.setForeground(new java.awt.Color(232, 2, 125));

        // Panels
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(12, 2, 10, 10));

        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(ch1);
        p2.add(l4);
        p2.add(ch6);
        p2.add(l5);
        p2.add(ch3);
        p2.add(l6);
        p2.add(ch4);
        p2.add(l7);
        p2.add(ch5);
        p2.add(l8);
        p2.add(tf2);
        p2.add(l9);
        p2.add(tf3);
        p2.add(l10);
        p2.add(tf4);
        p2.add(l11);
        p2.add(ch2);
        p2.add(l12);
        p2.add(tf5);
        p2.add(bt1);
        p2.add(bt2);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 1, 10, 10));

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AMS/icon/bookf.png"));
        Image img1 = img.getImage().getScaledInstance(620, 570, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img1);
        JLabel imgLabel = new JLabel(ic1);
        p3.add(imgLabel);

        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "Center");
        add(p3, "West");

        
        
// For passenger name based on username
ch2.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent arg0) {
        try {
            connectionClass obj = new connectionClass();
            String username = ch2.getSelectedItem(); // Username selected from dropdown
            
            // Correct query to fetch passenger name
            String q1 = "SELECT name FROM passenger WHERE username = '" + username + "'";
            
            // Debugging query
            System.out.println(q1);
            
            // Execute the query
            ResultSet rest1 = obj.stm.executeQuery(q1);
            if (rest1.next()) {
                tf5.setText(rest1.getString("name")); // Set the passenger name in tf5
            } else {
                tf5.setText("Not Found"); // Handle case where no result is found
            }
            rest1.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
});


  // For destination
        ch1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                ch6.removeAll();
                try {
                    connectionClass obj = new connectionClass();
                    String source = ch1.getSelectedItem();
                    String q1 = "SELECT DISTINCT destination FROM flight WHERE source = '" + source + "'";
                    ResultSet rest1 = obj.stm.executeQuery(q1);
                    while (rest1.next()) {
                        ch6.add(rest1.getString("destination"));
                    }
                    rest1.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
// For class
 ch6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                ch3.removeAll();
                try {
                    connectionClass obj = new connectionClass();
                    String source = ch1.getSelectedItem();
                    String destination = ch6.getSelectedItem();
                    String q1 = "SELECT DISTINCT class_name FROM flight WHERE source = '" + source + "' AND destination = '" + destination + "'";
                    ResultSet rest1 = obj.stm.executeQuery(q1);
                    while (rest1.next()) {
                        ch3.add(rest1.getString("class_name"));
                    }
                    rest1.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

 
 // For price
ch3.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent arg0) {
        ch4.removeAll();
        try {
            connectionClass obj = new connectionClass();
            String source = ch1.getSelectedItem();
            String destination = ch6.getSelectedItem();
            String className = ch3.getSelectedItem();
            String q1 = "SELECT DISTINCT price FROM flight WHERE source = '" + source + "' AND destination = '" + destination + "' AND class_name = '" + className + "'";
            ResultSet rest1 = obj.stm.executeQuery(q1);
            while (rest1.next()) {
                ch4.add(rest1.getString("price"));
            }
            rest1.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
});
// For flight code
ch4.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent arg0) {
        ch5.removeAll();
        try {
            connectionClass obj = new connectionClass();
            String source = ch1.getSelectedItem(); // Source
            String destination = ch6.getSelectedItem(); // Destination
            String className = ch3.getSelectedItem(); // Class Name
            String price = ch4.getSelectedItem(); // Price

            // Corrected query
            String q1 = "SELECT DISTINCT f_code FROM flight " +
                        "WHERE source = '" + source + "' " +
                        "AND destination = '" + destination + "' " +
                        "AND class_name = '" + className + "' " +
                        "AND price = '" + price + "'";
            
            // Debugging query
            System.out.println(q1);

            // Execute the query
            ResultSet rest1 = obj.stm.executeQuery(q1);
            while (rest1.next()) {
                ch5.add(rest1.getString("f_code"));
            }
            rest1.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
});

// For flight name
ch5.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent arg0) {
        try {
            connectionClass obj = new connectionClass();
            String source = ch1.getSelectedItem(); // Source
            String destination = ch6.getSelectedItem(); // Destination
            String className = ch3.getSelectedItem(); // Class Name
            String price = ch4.getSelectedItem(); // Price
            String fcode = ch5.getSelectedItem(); // Flight Code

            // Corrected query to fetch f_name
            String q1 = "SELECT f_name FROM flight " +
                        "WHERE source = '" + source + "' " +
                        "AND destination = '" + destination + "' " +
                        "AND class_name = '" + className + "' " +
                        "AND price = '" + price + "' " +
                        "AND f_code = '" + fcode + "'";

            // Debugging query
            System.out.println(q1);

            // Execute the query
            ResultSet rest1 = obj.stm.executeQuery(q1);
            if (rest1.next()) {
                tf2.setText(rest1.getString("f_name")); // Set the flight name in tf2
            } else {
                tf2.setText("Not Found"); // Handle case where no result is found
            }
            rest1.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
});




        setVisible(true);
    }

public void actionPerformed(ActionEvent e) {
     
    if (e.getSource() == bt1) { // Assuming bt1 is the "Book Flight" button
        String tid = tf1.getText(); // Ticket ID
        String source = ch1.getSelectedItem(); // Source
        String destination = ch6.getSelectedItem(); // Corrected: Now destination from ch6
        String className = ch3.getSelectedItem(); // Class
        String price = ch4.getSelectedItem(); // Price
        String fcode = ch5.getSelectedItem(); // Flight Code
        String fname = tf2.getText(); // Flight Name
        String jdate = tf3.getText(); // Journey Date
        String jtime = tf4.getText(); // Journey Time
        String username = ch2.getSelectedItem(); // Corrected: Now username from ch2
        String name = tf5.getText(); // Name
        String status = "Success"; // Status

        try {
            // Create a connection to the database
            connectionClass obj3 = new connectionClass();

            // Construct the SQL query for inserting the booking
            String q1 = "INSERT INTO bookedFlight (tid, source, destination, class_name, price, fcode, fname, journey_date, journey_time, username, name, status) " +
            "VALUES ('" + tid + "', '" + source + "', '" + destination + "', '" + className + "', '" + price + "', '" + fcode + "', '" + fname + "', '" + jdate + "', '" + jtime + "', '" + username + "', '" + name + "', '" + status + "')";

            // Execute the query
            int aa = obj3.stm.executeUpdate(q1);

            // Check if the update was successful
            if (aa == 1) {
                JOptionPane.showMessageDialog(null, "Your flight has been successfully booked!");
                this.setVisible(false); // Close the booking window
            } else {
                JOptionPane.showMessageDialog(null, "Failed to book the flight. Please try again.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    if (e.getSource() == bt2) { // Assuming bt2 is the "Back" button
        JOptionPane.showMessageDialog(null,"Are you sure");
        this.setVisible(false); // Close the current window
    }
}



    public static void main(String[] args) {
        new BookFlight();
    }
}
