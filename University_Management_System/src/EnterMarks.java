import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox sem;
    JTextField sub1,sub2,sub3,sub4,sub5,marks1,marks2,marks3,marks4,marks5;
    JButton submit,cancel;

    public EnterMarks(){

        setTitle("ENTER MARKS");
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(520,70,400,300);
        add(image);

        JLabel srollNumber= new JLabel("Roll Number");
        srollNumber.setBounds(30,30,140,20);
        srollNumber.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(srollNumber);

        crollno= new Choice();
        crollno.setBounds(170,30,250,20);
        crollno.setFont(new Font("Times New Roman",Font.BOLD,18));
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

        JLabel semester= new JLabel("Semester");
        semester.setBounds(30,80,140,20);
        semester.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(semester);

        String[] add= {"1st Sem","2nd Sem", "3rd sem","4th Sem", "5th Sem", "6th Sem", "7th Sem", "8th Sem"};
        sem= new JComboBox(add);
        sem.setBounds(170,80,240,30);
        sem.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(sem);

        JLabel subject= new JLabel("Subject");
        subject.setBounds(70,140,140,20);
        subject.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(subject);

        JLabel marks= new JLabel("Marks");
        marks.setBounds(270,140,140,20);
        marks.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(marks);

        sub1= new JTextField();
        sub1.setBounds(20,180,200,30);
        add(sub1);

        marks1= new JTextField();
        marks1.setBounds(220,180,200,30);
        add(marks1);

        sub2= new JTextField();
        sub2.setBounds(20,210,200,30);
        add(sub2);

        marks2= new JTextField();
        marks2.setBounds(220,210,200,30);
        add(marks2);

        sub3 =new JTextField();
        sub3.setBounds(20,240,200,30);
        add(sub3);

        marks3= new JTextField();
        marks3.setBounds(220,240,200,30);
        add(marks3);

        sub4 =new JTextField();
        sub4.setBounds(20,270,200,30);
        add(sub4);

        marks4= new JTextField();
        marks4.setBounds(220,270,200,30);
        add(marks4);

        sub5 =new JTextField();
        sub5.setBounds(20,300,200,30);
        add(sub5);

        marks5= new JTextField();
        marks5.setBounds(220,300,200,30);
        add(marks5);

        submit= new JButton("Submit");
        submit.setFont(new Font("Times New Roman",Font.BOLD,20));
        submit.setBounds(50,380,150,35);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel= new JButton("Cancel");
        cancel.setFont(new Font("Times New Roman",Font.BOLD,20));
        cancel.setBounds(230,380,150,35);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        setSize(1000,600);
        setLocation(500,150);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== submit){
            try {
                Conn c = new Conn();
                String query1= "insert into subjects values('"+crollno.getSelectedItem()+"','"+sem.getSelectedItem()+"','"+sub1.getText()+"','"+sub2.getText()+"','"+sub3.getText()+"','"+sub4.getText()+"','"+sub5.getText()+"')";
                String query2= "insert into marks values('"+crollno.getSelectedItem()+"','"+sem.getSelectedItem()+"','"+marks1.getText()+"','"+marks2.getText()+"','"+marks3.getText()+"','"+marks4.getText()+"','"+marks5.getText()+"')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Student Marks is Inserted");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }


        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}
