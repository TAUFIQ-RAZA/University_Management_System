import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Marks extends JFrame implements ActionListener {
    String rollno;
    JLabel croll,sem,sub1,sub2,sub3,sub4,sub5;
    JButton cancel;
    public Marks(String rollno){
        this.rollno=rollno;

        setTitle("Result");
        setLayout(null);

        JLabel heading = new JLabel("Karnataka University");
        heading.setBounds(100,20,400,30);
        heading.setFont(new Font("Times New Roman",Font.BOLD,26));
        add(heading);

        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(40,80,200,30);
        lblrollno.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lblrollno);

        croll = new JLabel();
        croll.setBounds(280,80,500,30);
        croll.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(croll);

        JLabel lblsem = new JLabel("Semester");
        lblsem.setBounds(40,130,200,30);
        lblsem.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lblsem);

        sem = new JLabel();
        sem.setBounds(280,130,500,30);
        sem.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(sem);

        sub1 = new JLabel();
        sub1.setBounds(100,200,500,20);
        sub1.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(sub1);

        sub2 = new JLabel();
        sub2.setBounds(100,230,500,20);
        sub2.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(sub2);

        sub3 = new JLabel();
        sub3.setBounds(100,260,500,20);
        sub3.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(sub3);

        sub4 = new JLabel();
        sub4.setBounds(100,290,500,20);
        sub4.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(sub4);

        sub5 = new JLabel();
        sub5.setBounds(100,320,500,20);
        sub5.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(sub5);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from subjects where rollno = '"+rollno+"'");
            while (rs.next()){
                croll.setText(rs.getString("rollno"));
                sub1.setText(rs.getString("subject1"));
                sub2.setText(rs.getString("subject2"));
                sub3.setText(rs.getString("subject3"));
                sub4.setText(rs.getString("subject4"));
                sub5.setText(rs.getString("subject5"));
            }

            ResultSet rs2 = c.s.executeQuery("Select * from marks where rollno = '"+rollno+"'");
            while (rs2.next()){
                sub1.setText(sub1.getText()+"-----------"+rs2.getString("marks1"));
                sub2.setText(sub2.getText()+"-----------"+rs2.getString("marks2"));
                sub3.setText(sub3.getText()+"-----------"+rs2.getString("marks3"));
                sub4.setText(sub4.getText()+"-----------"+rs2.getString("marks4"));
                sub5.setText(sub5.getText()+"-----------"+rs2.getString("marks5"));
                sem.setText(rs2.getString("semester"));
            }


        }catch (Exception e){
            e.printStackTrace();
        }


        cancel= new JButton("Back");
        cancel.setFont(new Font("Times New Roman",Font.BOLD,18));
        cancel.setBounds(380,500,80,20);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(500,600);
        setLocation(600,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==cancel){
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new Marks("");
    }
}
