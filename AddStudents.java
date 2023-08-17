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




  class AddStudent extends JFrame implements ActionListener {

    JTextField tfname,tffname,tfaddress,tfphone,tfemail,tfdob;
    JLabel labelrollno;
    JComboBox cbstd,cbbranch;
    JButton submit,cancel; 

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong()% 9000L) + 1000L);   
   AddStudent() 
   {
    setSize(900,700);
    setLocation(350,50);

    setLayout(null);
   
    JLabel heading=new JLabel("New Student Details");
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

     JLabel lblrollno = new JLabel("Roll Number");
     lblrollno.setBounds(50,220,200,30);
     lblrollno.setFont(new Font("serif",Font.BOLD,20));
     add(lblrollno);
   
     labelrollno = new JLabel("1533"+ first4);
     labelrollno.setBounds(200,220,200,30);
     labelrollno.setFont(new Font("serif",Font.BOLD,20));
     add(labelrollno);

     JLabel lbldob = new JLabel("Date Of Brith");
     lbldob.setBounds(400,220,200,30);
     lbldob.setFont(new Font("serif",Font.BOLD,20));
     add(lbldob);

     tfdob=new JTextField("Date of Brith");
     add(tfdob);
     tfdob.setBounds(600,220,150,30);

     JLabel lbladdress= new JLabel("Address");
     lbladdress.setBounds(50,320,200,30);
     lbladdress.setFont(new Font("serif",Font.BOLD,20));
     add(lbladdress);
    
     tfaddress = new JTextField();
     tfaddress.setBounds(200,320,150,30);
     add (tfaddress);

     JLabel lblphone= new JLabel("Phone");
     lblphone.setBounds(400,320,200,30);
     lblphone.setFont(new Font("serif",Font.BOLD,20));
     add(lblphone);
    
     tfphone = new JTextField();
     tfphone.setBounds(600,320,150,30);
     add (tfphone);

     JLabel lblemail = new JLabel("Email ID");
     lblemail.setBounds(50,420,200,30);
     lblemail.setFont(new Font("serif",Font.BOLD,20));
     add(lblemail);
    
     tfemail = new JTextField();
     tfemail.setBounds(200,420,150,30);
     add (tfemail);

    
     JLabel lblstd = new JLabel("Std");
     lblstd.setBounds(50,520,200,30);
     lblstd.setFont(new Font("serif",Font.BOLD,20));
     add(lblstd);

     String std[] = {"Std 1","Std 2","Std 3","Std 4","Std 5","Std 6","Std 7","Std 8","Std 9","Std 10","Std 11","Std 12"};
     cbstd = new JComboBox(std);
     cbstd.setBounds(200,520,150,30);
     cbstd.setBackground(Color.WHITE);
     add(cbstd);
    
     JLabel lblbranch = new JLabel("Branch");
     lblbranch.setBounds(400,420,200,30);
     lblbranch.setFont(new Font("serif",Font.BOLD,20));
     add(lblbranch);

     String branch[] = {"Science","Commerce"};
     cbbranch= new JComboBox(branch);
     cbbranch.setBounds(600,420,150,30);
     cbbranch.setBackground(Color.WHITE);
     add(cbbranch);
     
     submit = new JButton("Submit");
     submit.setBounds(250,580,120,30);
     submit.setBackground(Color.BLACK);
     submit.setForeground(Color.WHITE);
     submit.addActionListener(this);
     submit.setFont(new Font("Tahoma",Font.BOLD,15));
     add(submit);

     cancel = new JButton("Cancel");
     cancel.setBounds(450,580,120,30);
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
         String rollno = labelrollno.getText();
         String dob = tfdob.getText();
         String address = tfaddress.getText();
         String phone = tfphone.getText();
         String email =tfemail.getText();
         String std = (String) cbstd.getSelectedItem();
         String branch = (String) cbbranch.getSelectedItem();

         try
         {
             String query = "insert into student values('"+name+"', '"+fname+"', '"+rollno+"','"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+std+"', '"+branch+"')";

             Conn con = new Conn();
             con.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
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
    new AddStudent();
   }
}