import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

 public class StudentDetails extends JFrame implements ActionListener
   {
    Choice crollno;
    JTable table;
    JButton Search, print, update, add, cancel;

    StudentDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add (heading);

        crollno = new Choice();
        crollno.setBounds(180,20,150,20);
        add(crollno);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            While(rs.next());
            {
                crollno.add(rs.getString("rollno"));

            } 

        }catch(Exception e)  {
            e.printStackTrace();
        }

        table = new JTable();

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        Search = new JButton("Search");
        Search.setBounds(20,70,80,20);
        Search.addActionListener(this);
        add(Search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);



        setSize(900,700);
        setLocation(300,100);
        setVisible(true);

    }
      public void actionperformed(ActionEvent ae){
        if(ae.getSource() == Search){
            String query = "select * form student where rollno ='"+crollno.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs)); 

            }  catch(Exception e)  {
                e.printStackTrace();
            }

         } else if (ae.getsource() == print) {
            try{
                table.print();
            }catch(Exception e) {
                e.printStackTrace();
            }
         }  else if(ae.getsource() == add) {
            setVisible(false);
            new AddStudent();

          }  else if(ae.getsource() == update) {
            setVisible(false);
          //  new UpdateStudent();
          } else  {
             setVisible(false);
          }
 
         }
      }

    public static void main(String[] args)
    {
        new StudentDetails();
    }

