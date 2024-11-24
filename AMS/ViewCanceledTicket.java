package AMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCanceledTicket extends JFrame implements ActionListener {
    JLabel l1;
    JTable t1;
    JButton bt1;
    String[] columnNames = {"TID", "Source", "Destination", "Class", "Price", "Username", "Name", "Reason", "Journey Date", "Journey Time"};
    String[][] data = new String[20][10];
    int i = 0, j = 0;

    ViewCanceledTicket() {
        super("View Canceled Tickets");

        // Set up JFrame properties
        setSize(1200, 600);
        setLocation(100, 100);

        // Fetch canceled tickets from the database
        try {
            connectionClass obj = new connectionClass();
            String query = "SELECT * FROM cancelFlight";
            ResultSet rs = obj.stm.executeQuery(query);
            while (rs.next()) {
                data[i][j++] = rs.getString("tid");
                data[i][j++] = rs.getString("source");
                data[i][j++] = rs.getString("destination");
                data[i][j++] = rs.getString("class_name");
                data[i][j++] = rs.getString("price");
                data[i][j++] = rs.getString("username");
                data[i][j++] = rs.getString("name");
                data[i][j++] = rs.getString("reason");
                data[i][j++] = rs.getString("journey_date");
                data[i][j++] = rs.getString("journey_time");
                i++;
                j = 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Table to display data
        t1 = new JTable(data, columnNames);
        t1.setForeground(Color.WHITE); // Set text color to white
        t1.setBackground(Color.BLACK); // Set table background color to black
        t1.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font
        t1.setRowHeight(25); // Increase row height for better readability

        JScrollPane sp = new JScrollPane(t1);

        // Back Button
        bt1 = new JButton("Back");
        bt1.setFont(new Font("Arial", Font.BOLD, 16));
        bt1.setForeground(Color.WHITE);
        bt1.setBackground(Color.BLACK);
        bt1.setFocusable(false);  // Make button non-focusable to avoid a visual focus border
        bt1.addActionListener(this);

        // Layout settings
        setLayout(new BorderLayout());
        add(sp, "Center");
        add(bt1, "South");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewCanceledTicket().setVisible(true);
    }
}
