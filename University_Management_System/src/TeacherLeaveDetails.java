import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class TeacherLeaveDetails extends JFrame implements ActionListener {

    JTable table;
    JButton search,cancel,print;
    Choice cempId;

    public TeacherLeaveDetails(){
        setTitle("Student Leave Details");
        setLayout(null);

        JLabel srollNumber= new JLabel("Search EmployeeID ");
        srollNumber.setBounds(30,30,200,30);
        srollNumber.setFont(new Font("Times New Roman",Font.BOLD,22));
        add(srollNumber);

        cempId= new Choice();
        cempId.setBounds(260,30,250,20);
        cempId.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(cempId);

        try {
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("select * from teacherLeave");
            while (rs.next()){
                cempId.add(rs.getString("employeeId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table= new JTable();


        try {
            Conn conn= new Conn();
            ResultSet rs= conn.s.executeQuery("select * from teacherLeave");
            while (rs.next()){
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp= new JScrollPane(table);
        jsp.setBounds(0,100,900,700);
        add(jsp);

        search= new JButton("Search");
        search.setBounds(30,70,80,20);
        search.addActionListener(this);
        add(search);

        print= new JButton("print");
        print.setBounds(130,70,80,20);
        print.addActionListener(this);
        add(print);

        cancel= new JButton("cancel");
        cancel.setBounds(230,70,80,20);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900,700);
        setLocation(500,70);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== search){
            String query = "select * from teacherLeave where employeeId = '"+cempId.getSelectedItem()+"'";
            try{
                Conn conn= new Conn();
                ResultSet rs= conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                System.out.println(e);
            }

        }else if (ae.getSource()== print){
            try {
                table.print();
            }catch (Exception e){e.printStackTrace();}
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new TeacherLeaveDetails();

    }


}
