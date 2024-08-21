import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class StudentLeaveDetails extends JFrame implements ActionListener {

    JTable table;
    JButton search,cancel,print;
    Choice crollno;

    public StudentLeaveDetails(){
        setTitle("Student Leave Details");
        setLayout(null);

        JLabel srollNumber= new JLabel("Search Roll Number");
        srollNumber.setBounds(30,30,200,20);
        srollNumber.setFont(new Font("Times New Roman",Font.BOLD,22));
        add(srollNumber);

        crollno= new Choice();
        crollno.setBounds(250,30,250,20);
        crollno.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(crollno);

        try {
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("select * from studentLeave");
            while (rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table= new JTable();


        try {
            Conn conn= new Conn();
            ResultSet rs= conn.s.executeQuery("select * from studentLeave");
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
            String query = "select * from studentLeave where rollno = '"+crollno.getSelectedItem()+"'";
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
        new StudentLeaveDetails();

    }


}
