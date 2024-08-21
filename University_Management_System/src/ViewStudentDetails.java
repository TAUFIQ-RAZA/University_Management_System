import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class ViewStudentDetails extends JFrame implements ActionListener {

    JTable table;
    JButton search,add,update,cancel,print;
    Choice crollno;

    public ViewStudentDetails(){
        setTitle("Student Details");
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
            ResultSet rs= c.s.executeQuery("select * from student");
            while (rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table= new JTable();


        try {
            Conn conn= new Conn();
            ResultSet rs= conn.s.executeQuery("select * from student");
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

        add= new JButton("Add");
        add.setBounds(130,70,80,20);
        add.addActionListener(this);
        add(add);

        update= new JButton("update");
        update.setBounds(230,70,80,20);
        update.addActionListener(this);
        add(update);

        print= new JButton("print");
        print.setBounds(330,70,80,20);
        print.addActionListener(this);
        add(print);

        cancel= new JButton("cancel");
        cancel.setBounds(430,70,80,20);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900,700);
        setLocation(500,70);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== search){
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
            try{
                Conn conn= new Conn();
                ResultSet rs= conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                System.out.println(e);
            }

        }else if (ae.getSource()== add){
            setVisible(false);
            new AddStudent().setVisible(true);
        }else if (ae.getSource()== update){
            setVisible(false);
            // new UpdateStudent().setVisible(true);
        }else if (ae.getSource()== print){
            try {
                table.print();
            }catch (Exception e){e.printStackTrace();}
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new ViewStudentDetails();

    }


}
