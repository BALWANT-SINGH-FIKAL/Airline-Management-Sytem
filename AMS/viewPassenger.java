
package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class viewPassenger extends JFrame
{    
    JTable t;
    String x[]={"Username","Name","Age","Date of Birth","Address","Phone no","Email","Nationality","Gender","PassPort Number "};
    String y[][]=new String[30][20];
      int i=0,j=0;
      Font f;
    viewPassenger()
    {
       super("All Passenger Details");
       setSize(1300,400);
       setLocation(0,10);
       f=new Font("Arial",Font.BOLD,16);
       
       try
       {
         connectionClass obj=new connectionClass();
         String q="Select *from passenger";
         ResultSet rest=obj.stm.executeQuery(q);
         while(rest.next())
         {
          y[i][j++]=rest.getString("username");
           y[i][j++]=rest.getString("name");
            y[i][j++]=rest.getString("age");
             y[i][j++]=rest.getString("dob");
              y[i][j++]=rest.getString("address");
               y[i][j++]=rest.getString("phone");
                y[i][j++]=rest.getString("Email");
                 y[i][j++]=rest.getString("nationality");
                  y[i][j++]=rest.getString("gender");
                   y[i][j++]=rest.getString("passport");
          i++;
          j=0;
         }
       t= new JTable(y,x);
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       
       }
       t.setFont(f);
       t.setBackground(Color.BLACK);
       t.setForeground(Color.WHITE);
       
       JScrollPane js= new JScrollPane(t);
       
        add(js);   
    }
    public static void main(String[] args)
    {
       new viewPassenger().setVisible(true);
    
     }
            
    
    
    
    
}
