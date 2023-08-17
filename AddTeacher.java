import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.Random;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;




  class AddTeacher extends JFrame implements ActionListener {

    JTextField tfname, tffname, tfempID, tfaddress, tfphone, tfemail, tfdob, tfx, tfxii;
    JLabel lblempId;
    JComboBox cbCourse,cbsubject;
    JButton submit,cancel; 

   
   AddTeacher() 
   {
    setSize(900,700);
    setLocation(350,50);

    setLayout(null);
   
    JLabel heading=new JLabel("New Teacher Details");
    heading.setBounds(310,30,500,50);
    heading.setFont(new Font("serif",Font.BOLD,30));
    add(heading);
	
	
     JLabel lblname = new JLabel("Name");
     lblname.setBounds(50,120,100,30);
     lblname.setFont(new Font("serif",Font.BOLD,20));
     add(lblname);

    tfname = new JTextField();
    tfname.setBounds(200,120,150,30);
    add(tfname);

     JLabel lblfname = new JLabel("Father's Name");
     lblfname.setBounds(400,120,200,30);
     lblfname.setFont(new Font("serif",Font.BOLD,20));
     add(lblfname);

    tffname = new JTextField();
    tffname.setBounds(600,120,150,30);
    add(tffname);

     JLabel lblempId = new JLabel("Employee ID");
     lblempId.setBounds(50,190,200,30);
     lblempId.setFont(new Font("serif",Font.BOLD,20));
     add(lblempId);

     tfempID = new JTextField();
    tfempID.setBounds(200,190,150,30);
    add(tfempID);
   
     lblempId = new JLabel("101");
     lblempId.setBounds(200,190,200,30);
     lblempId.setFont(new Font("serif",Font.BOLD,20));
     add(lblempId);

     JLabel lbldob = new JLabel("Date Of Brith");
     lbldob.setBounds(400,190,200,30);
     lbldob.setFont(new Font("serif",Font.BOLD,20));
     add(lbldob);
     tfdob=new JTextField(" ");
     tfdob.setBounds(600,190,150,30);
     add(tfdob);

     JLabel lbladdress= new JLabel("Address");
     lbladdress.setBounds(50,260,200,30);
     lbladdress.setFont(new Font("serif",Font.BOLD,20));
     add(lbladdress);
    
     tfaddress = new JTextField();
     tfaddress.setBounds(200,260,150,30);
     add (tfaddress);

     JLabel lblphone= new JLabel("Phone");
     lblphone.setBounds(400,260,200,30);
     lblphone.setFont(new Font("serif",Font.BOLD,20));
     add(lblphone);
    
     tfphone = new JTextField();
     tfphone.setBounds(600,260,150,30);
     add (tfphone);

     JLabel lblemail = new JLabel("Email ID");
     lblemail.setBounds(50,330,200,30);
     lblemail.setFont(new Font("serif",Font.BOLD,20));
     add(lblemail);

     tfemail = new JTextField();
     tfemail.setBounds(200,330,150,30);
     tfemail.setFont(new Font("serif",Font.BOLD,20));
     add( tfemail);
    
    
      JLabel lblx= new JLabel("Class X (%)");
     lblx.setBounds(400,330,200,30);
     lblx.setFont(new Font("serif",Font.BOLD,20));
     add(lblx);
    
     tfx = new JTextField();
     tfx.setBounds(600,330,150,30);
     add (tfx);

     JLabel lblxii = new JLabel("Class Xii (%)");
     lblxii.setBounds(50,400,200,30);
     lblxii.setFont(new Font("serif",Font.BOLD,20));
     add(lblxii);
    
     tfxii = new JTextField();
     tfxii.setBounds(200,400,150,30);
     add (tfxii);

     JLabel lblcourse = new JLabel("Qualification");
     lblcourse.setBounds(400,400,200,30);
     lblcourse.setFont(new Font("serif",Font.BOLD,20));
     add(lblcourse);

     String course[] = {"B.Tech","BBA","Bsc","Msc","MBA","MCA","MCom","MA","BA"};
     cbCourse = new JComboBox(course);
     cbCourse.setBounds(600,400,150,30);
     cbCourse.setBackground(Color.WHITE);
     add(cbCourse);
    
     JLabel lblSubject = new JLabel("Department");
     lblSubject.setBounds(50,470,200,30);
     lblSubject.setFont(new Font("serif",Font.BOLD,20));
     add(lblSubject);

     String subject[] = {"Science","Gujarati","English","Computer","Maths","S.S."};
     cbsubject= new JComboBox(subject);
     cbsubject.setBounds(200,470,150,30);
     cbsubject.setBackground(Color.WHITE);
     add(cbsubject);

    
     submit = new JButton("Submit");
     submit.setBounds(250,540,120,30);
     submit.setBackground(Color.BLACK);
     submit.setForeground(Color.WHITE);
     submit.addActionListener(this);
     submit.setFont(new Font("Tahoma",Font.BOLD,15));
     add(submit);

     cancel = new JButton("Cancel");
     cancel.setBounds(450,540,120,30);
     cancel.setBackground(Color.BLACK);
     cancel.setForeground(Color.WHITE);
     cancel.addActionListener(this);
     submit.setFont(new Font("Tahoma",Font.BOLD,15));
     add(cancel);

    setVisible(true);   
   }
    public void actionPerformed(ActionEvent ae)
    {
      if (ae.getSource() == submit)
      { 
         String name = tfname.getText();
         String fname = tffname.getText();
         String empId = tfempID.getText();
         String dob =  tfdob.getText();
         String address = tfaddress.getText();
         String phone = tfphone.getText();
         String email =tfemail.getText();
         String X = tfx.getText();
         String Xii = tfxii.getText();
         String Course = (String) cbCourse.getSelectedItem();
         String Subject = (String) cbsubject.getSelectedItem();

         try
         {
             String query = "insert into Teacher values('"+name+"', '"+fname+"', '"+empId+"','"+dob+"',' "+address+"', '"+phone+"','"+email+"','"+X+"','"+Xii+"','"+Course+"','"+Subject+"')";

             Conn con = new Conn();
             con.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "teacher Details Inserted successfully");
             setVisible(false);
         }

         catch (Exception e)
         {
           e.printStackTrace();
         }
      }
       else 
      {
      
           setVisible(false);
      }
    }
    

    public static void main(String [] args)
   {
    new AddTeacher();
   }
}