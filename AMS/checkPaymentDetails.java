
package AMS;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class checkPaymentDetails extends JFrame
{
     JTextField textField;
     JTable table;
     JLabel sector,ticket_id,price,journey_date,label,journey_time,username,status;
    
    checkPaymentDetails()
    {
      initialize();  
    }
    
    public static void main(String[] args) {
        new checkPaymentDetails().setVisible(true);
    }
    
    private void initialize()
    {
        setTitle("Payment Details ");
    getContentPane().setBackground(Color.WHITE);
    setSize(860, 486);
    setLocationRelativeTo(null); // Center the frame on the screen
    setLayout(null);
       
       JLabel Fcode=new JLabel("Username");
       Fcode.setFont(new Font("Arial",Font.BOLD,16));
       Fcode.setBounds(190,160,150,26);
       add(Fcode);
       
        textField =new JTextField();
        textField.setBounds(300,160,150,26);
        textField.setFont(new Font("Arial",Font.BOLD,14));
        add(textField);
        
        JButton show=new JButton("Show");
        show.setFont(new Font("Arial",Font.BOLD,14));
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(500,160,150,26);
        add(show);
        
table = new JTable();
table.setBounds(117, 290, 720, 87); // Positioned below the labels and centered
add(table);


        
        
        sector=new JLabel("Check Payment Details");
        sector.setForeground(Color.BLUE);
        sector.setFont(new Font("Arial",Font.BOLD,33));
        sector.setBounds(291,17,800,39);
        add(sector);
        
        ticket_id=new JLabel("Ticket Id");
        ticket_id.setFont(new Font("Arial",Font.BOLD,14));
        ticket_id.setBounds(117,262,108,26);
        add(ticket_id);
        
        
       price=new JLabel("Price");
        price.setFont(new Font("Arial",Font.BOLD,14));
        price.setBounds(237,268,38,14);
        add(price);
        
        
        journey_date=new JLabel("Journey Date");
        journey_date.setFont(new Font("Arial",Font.BOLD,14));
        journey_date.setBounds(362,264,101,24);
        add(journey_date);
        
        
         journey_time=new JLabel("Journey Time");
        journey_time.setFont(new Font("Arial",Font.BOLD,14));
        journey_time.setBounds(485,268,114,14);
        add(journey_time);
        
        
         username=new JLabel("Username");
        username.setFont(new Font("Arial",Font.BOLD,14));
        username.setBounds(620,269,101,19);
        add(username);
        
        status=new JLabel("Status");
        status.setFont(new Font("Arial",Font.BOLD,14));
        status.setBounds(752,264,86,24);
        add(status);
        
        
        label=new JLabel();
         ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AMS/icon/status.jpeg"));
        Image img1 = img.getImage().getScaledInstance(1550, 800, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img1);
         label.setIcon(ic1);
         label.setBounds(0,0,960,590);
         add(label);
        
         
         
         show.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
        try {
            String uname = textField.getText();
            connectionClass obj = new connectionClass(); // Assuming your ConnectionClass manages DB connection
            String str = "SELECT tid, price, journey_date, journey_time, username, status FROM bookedFlight WHERE username = '" + uname + "'and status='success'";
            ResultSet rs = obj.stm.executeQuery(str);
            table.setModel(DbUtils.resultSetToTableModel(rs)); // Populates JTable with data
            table.setFont(new Font("Arial", Font.BOLD, 14));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
});
         
         setSize(960,590);
         setVisible(true);

    }
}
