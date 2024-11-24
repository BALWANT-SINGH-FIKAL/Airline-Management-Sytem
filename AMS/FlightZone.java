package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightZone extends JFrame {
    private JTable t;
    private Choice ch1;

    public static void main(String[] args) {
        new FlightZone().setVisible(true);
    }

    FlightZone() {
        // Frame properties
        setTitle("Flight Zone");
        getContentPane().setBackground(new Color(77, 157, 227));
        setSize(900, 650);
        setLocation(100, 50);
        setLayout(null);

        // Set default close operation to DO_NOTHING_ON_CLOSE
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Add window listener to handle window closing
//        addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent we) {
//                // You can show a custom confirmation dialog if needed
//                int option = JOptionPane.showConfirmDialog(FlightZone.this,
//                        "Are you sure you want to close the application?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
//                if (option == JOptionPane.YES_OPTION) {
//                    // Make sure HomePage is open and visible
//                    HomePage homePage = new HomePage();  // Create a new instance of HomePage
//                    homePage.setVisible(true);  // Make the HomePage visible
//                    FlightZone.this.setVisible(false);  // Hide the current FlightZone window
//                      // Close the application after confirmation
//                }
//            }
//        });

        // Title Label
        JLabel flightDetails = new JLabel("Air India Flight Details");
        flightDetails.setFont(new Font("Arial", Font.BOLD, 33));
        flightDetails.setForeground(new Color(15, 11, 1));
        flightDetails.setBounds(250, 20, 570, 35);
        add(flightDetails);

        // Flight Code Label and Choice
        JLabel flightCode = new JLabel("Flight Code");
        flightCode.setFont(new Font("Arial", Font.BOLD, 18));
        flightCode.setForeground(new Color(15, 11, 1));
        flightCode.setBounds(150, 100, 120, 30);
        add(flightCode);

        ch1 = new Choice();
        ch1.setBounds(290, 100, 200, 30);
        ch1.setFont(new Font("Arial", Font.BOLD, 18));
        try {
            connectionClass con = new connectionClass();
            String q = "select distinct f_code from flight";
            ResultSet rs = con.stm.executeQuery(q);
            while (rs.next()) {
                ch1.add(rs.getString("f_code"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        add(ch1);

        // Show Details Button
        JButton bt = new JButton("Show Details");
        bt.setFont(new Font("Arial", Font.BOLD, 20));
        bt.setBounds(560, 100, 220, 30);
        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    connectionClass con = new connectionClass();
                    String code = ch1.getSelectedItem();
                    String query = "SELECT * FROM flight WHERE f_code = '" + code + "'";
                    ResultSet rs = con.stm.executeQuery(query);
                    t.setModel(DbUtils.resultSetToTableModel(rs)); // Dynamically sets headers and data
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(bt);

        // JTable for Flight Details
        t = new JTable();
        t.setBackground(Color.WHITE);
        t.setFont(new Font("Arial", Font.PLAIN, 15));
        t.setBounds(20, 170, 850, 450); // Adjusted position to remove redundant labels
        add(t);

        // Flight Detail Labels (Only for display above the table)
        String[] labels = { "Flight Code", "Flight Name", "Source", "Destination", "Capacity", "Class Name", "Price" };
        int x = 30;
        for (String label : labels) {
            JLabel l = new JLabel(label);
            l.setFont(new Font("Arial", Font.BOLD, 14));
            l.setForeground(new Color(15, 11, 1));
            l.setBounds(x, 150, 120, 16); // Position the static labels above the table
            add(l);
            x += 125; // Adjust spacing between labels
        }
    }
}
