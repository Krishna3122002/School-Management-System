import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

 class UpdateTeacher extends JFrame implements ActionListener{
    
    JTextField tfname, tffname, tfempId, tfaddress, tfphone,tfemail, tfdob, tfx, tfxii,tfcourse, tfbranch;
    JLabel labelempId;
    JComboBox cbCourse,cbsubject;
    JButton submit, cancel;
    Choice cempId;
    
    UpdateTeacher() {
        
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);
        
        JLabel lblemployeeId = new JLabel("Select Employee Id");
        lblemployeeId.setBounds(50, 100, 200, 20);
        lblemployeeId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblemployeeId);
        
        cempId = new Choice();
        cempId.setBounds(250, 100, 200, 20);
        add(cempId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()) {
                cempId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

         tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200, 150, 150, 30);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(600, 150, 150, 30);
        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelfname);
        
        JLabel lblrollno = new JLabel("Employee Id");
        lblrollno.setBounds(50, 210, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);
        
        labelempId = new JLabel();
        labelempId.setBounds(200, 210, 200, 30);
        labelempId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelempId);

        tfempId = new JTextField();
        tfempId.setBounds(200, 210, 150, 30);
        add(tfempId);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 210, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        JLabel labeldob = new JLabel();
        labeldob.setBounds(600, 210, 150, 30);
        labeldob.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labeldob);

        tfdob = new JTextField();
        tfdob.setBounds(600, 210, 150, 30);
        add(tfdob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 270, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 270, 150, 30);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 270, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 270, 150, 30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 330, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);
        
        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400, 330, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);

         tfx = new JTextField();
        tfx.setBounds(600, 330, 150, 30);
        add(tfx);
        
        JLabel labelx = new JLabel();
        labelx.setBounds(600, 330, 150, 30);
        labelx.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelx);
        
        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50, 390, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);

         tfxii = new JTextField();
        tfxii.setBounds(200, 390, 150, 30);
        add(tfxii);
        
        JLabel labelxii = new JLabel();
        labelxii.setBounds(200, 390, 150, 30);
        labelxii.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelxii);
        
       
        JLabel lblcourse = new JLabel("Qualification");
        lblcourse.setBounds(400, 390, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);
 
        
        String course[] = {"B.Tech","BBA","Bsc","Msc","MBA","MCA","MCom","MA","BA"};
     cbCourse = new JComboBox(course);
     cbCourse.setBounds(600,390,150,30);
     cbCourse.setBackground(Color.WHITE);
     add(cbCourse);
        
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(50, 450, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);
        
	  
     String Subject[] = {"Science","Gujarati","English","Computer","Maths","S.S."};
     cbsubject= new JComboBox(Subject);
     cbsubject.setBounds(200,450,150,30);
     cbsubject.setBackground(Color.WHITE);
     add(cbsubject);

       
        try {
            Conn c = new Conn();
            String query = "select * from teacher where empID='"+cempId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                tfname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                tfdob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfx.setText(rs.getString("class_x"));
                tfxii.setText(rs.getString("class_xii"));
                tfempId.setText(rs.getString("empId"));
                tfcourse.setText(rs.getString("Qualification"));
                tfbranch.setText(rs.getString("department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cempId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from teacher where empId='"+cempId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        tfname.setText(rs.getString("name"));
                        tffname.setText(rs.getString("fname"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelx.setText(rs.getString("class_x"));
                        labelxii.setText(rs.getString("class_xii"));
                        labelempId.setText(rs.getString("empId"));
                        cbCourse.setSelectedItem(rs.getString("course"));
                        cbsubject.setSelectedItem(rs.getString("branch"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        submit = new JButton("Update");
        submit.setBounds(250, 540, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 540, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String fname = tfname.getText();
	      String ffname = tffname.getText();
		String dob = tfdob.getText();
            //String empId = tfempId.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
		String x = tfx.getText();
		String xii = tfxii.getText();
           // String course = cbCourse.getSelectedItem();
            //String branch = cbsubject.getSelectedItem();
            
            try {
                String query = ("update Teacher set name='"+fname+"',fname='"+ffname+"',address='"+address+"', phone='"+phone+"', email='"+email+"',dob='"+dob+"',class_x='"+x+"',class_xii='"+xii+"', course='"+cbCourse.getSelectedItem()+"', branch='"+cbsubject.getSelectedItem()+"' where empID='"+cempId.getSelectedItem()+"'");
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Teacher Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new UpdateTeacher();
    }
}