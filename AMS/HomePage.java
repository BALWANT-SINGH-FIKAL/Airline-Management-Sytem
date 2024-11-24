
package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class HomePage extends JFrame implements ActionListener
{
    JLabel l1,l2;
     Font f,f1,f2;
    HomePage()
    {    
         super("AirIndia home Page ");
         setLocation(0,0);
         setSize(1550,800);
         
         f=new Font("Lucida Fax",Font.BOLD,20);
         f2= new Font("Gadugi",Font.BOLD,35);
         f1= new Font("Ms UI Gothic",Font.BOLD,18);
         
         ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AMS/icon/home1.jpg"));
        Image img1 = img.getImage().getScaledInstance(1550, 800, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img1);
         l1=new JLabel(ic1);
         
         JMenuBar m1=new JMenuBar();
         
         JMenu men1=new JMenu("Passenger Profile");
         JMenuItem ment1= new JMenuItem("Add Passenger Profile");
         JMenuItem ment2= new JMenuItem("View Passenger Profile");
         men1.add(ment1);
         men1.add(ment2);
         m1.add(men1);
         
         JMenu men2=new JMenu("Manage Passenger");
         JMenuItem ment3=new JMenuItem("Update Passenger Details");
          men2.add(ment3);
         m1.add(men2);
         
         JMenu men3=new JMenu("Your Flight");
         JMenuItem ment5=new JMenuItem("Book Flight");
         JMenuItem ment6=new JMenuItem("View Booked Flight");
         men3.add(ment5);
         men3.add(ment6);
         m1.add(men3);
         
         JMenu men4=new JMenu("Flight Details");
         JMenuItem ment7=new JMenuItem("Journey Details");
         JMenuItem ment8=new JMenuItem("Flight Zone");
         men4.add(ment7);
         men4.add(ment8);
         m1.add(men4);
         
         JMenu men5=new JMenu("Cancellation");
         JMenuItem ment9=new JMenuItem("Cancel Ticket");
         JMenuItem ment10=new JMenuItem("View Canceled Ticket");
         men5.add(ment9);
         men5.add(ment10);
         m1.add(men5);
         
         JMenu men6=new JMenu("Bill");
         JMenuItem ment11=new JMenuItem("Check Payment");
         men6.add(ment11);
         m1.add(men6);
         
         
         JMenu men8=new JMenu("Logout");
         JMenuItem ment14=new JMenuItem("Exit");
         men8.add(ment14);
         m1.add(men8);
        
         men1.setFont(f);
         men2.setFont(f);
         men3.setFont(f);
         men4.setFont(f);
         men5.setFont(f);
         men6.setFont(f);
         men8.setFont(f);
         
         ment1.setFont(f1);
         ment2.setFont(f1);
         ment3.setFont(f1);
         ment5.setFont(f1);
         ment6.setFont(f1);
         ment7.setFont(f1);
         ment8.setFont(f1);
         ment9.setFont(f1);
         ment10.setFont(f1);
         ment11.setFont(f1);
         ment14.setFont(f1);
         
         
         m1.setBackground(new java.awt.Color(4,1,54));
         
         men1.setForeground(Color.GRAY);
         men2.setForeground(Color.GRAY);
         men3.setForeground(Color.GRAY);
         men4.setForeground(Color.GRAY);
         men5.setForeground(Color.GRAY);
         men6.setForeground(Color.GRAY);
         men8.setForeground(Color.RED);
         
         
         
         ment1.setBackground(Color.BLACK);
         ment2.setBackground(Color.BLACK);
         ment3.setBackground(Color.BLACK);
         ment5.setBackground(Color.BLACK);
         ment6.setBackground(Color.BLACK);
         ment7.setBackground(Color.BLACK);
         ment8.setBackground(Color.BLACK);
         ment9.setBackground(Color.BLACK);
         ment10.setBackground(Color.BLACK);
         ment11.setBackground(Color.BLACK);
         ment14.setBackground(Color.BLACK);
         
         ment1.setForeground(Color.YELLOW);
         ment2.setForeground(Color.YELLOW);
         ment3.setForeground(Color.YELLOW);
         ment5.setForeground(Color.YELLOW);
         ment6.setForeground(Color.YELLOW);
         ment7.setForeground(Color.YELLOW);
         ment8.setForeground(Color.YELLOW);
         ment9.setForeground(Color.YELLOW);
         ment10.setForeground(Color.YELLOW);
         ment11.setForeground(Color.YELLOW);
         ment14.setForeground(Color.RED);
         
         
         ment1.addActionListener(this);
         ment2.addActionListener(this);
         ment3.addActionListener(this);
         ment5.addActionListener(this);
         ment6.addActionListener(this);
         ment7.addActionListener(this);
         ment8.addActionListener(this);
         ment9.addActionListener(this);
         ment10.addActionListener(this);
         ment11.addActionListener(this);   
         ment14.addActionListener(this);
         setJMenuBar(m1);
         add(l1);
    
    }
    
    public void actionPerformed(ActionEvent e)
    {
       String cmd=e.getActionCommand();
        if(cmd.equals("Add Passenger Profile"))
        {
            new AddPassengerDetails().setVisible(true);
        } 
        else if (cmd.equals("View Passenger Profile"))
        {
            new viewPassenger().setVisible(true);
        } 
        else if (cmd.equals("Update Passenger Details"))
        {
            new UpdatePassenger().setVisible(true);
        } 
        else if (cmd.equals("Book Flight")) 
        {
            new BookFlight().setVisible(true);
        }
        else if (cmd.equals("View Booked Flight")) 
        {
            new viewBookedFlight().setVisible(true);
        } 
        else if (cmd.equals("Journey Details")) 
        {
           new FlightJouney().setVisible(true);
        } 
        else if (cmd.equals("Flight Zone")) 
        {
             new FlightZone().setVisible(true);
        } 
        else if (cmd.equals("Cancel Ticket")) 
        {
            new cancelFlight().setVisible(true);
        } 
        else if (cmd.equals("View Canceled Ticket")) 
        {
             new ViewCanceledTicket().setVisible(true);        
        }
        else if (cmd.equals("Check Payment")) 
        {
            new checkPaymentDetails().setVisible(true);
        } 
        else if (cmd.equals("Exit")) 
        {
            System.exit(0);
        } 
    
    }
    public static void main(String[] args) 
    {
      new HomePage().setVisible(true);
      
    }
}
