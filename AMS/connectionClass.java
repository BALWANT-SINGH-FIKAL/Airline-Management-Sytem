package AMS;

import java.sql.*;

public class connectionClass {
    Connection con;
    Statement stm;

    public connectionClass() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "BALWANT@07");

            // Create a statement object
            stm = con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new connectionClass();
    }
}
