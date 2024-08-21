import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame implements ActionListener {

    Choice cemplId,time;
    JDateChooser dcdate;
    JButton submit,cancel;
    public TeacherLeave(){

        setTitle("Teacher Leave");
        setLayout(null);

        JLabel lbl= new JLabel("Apply Teacher Leave");
        lbl.setFont(new Font("Times New Roman",Font.BOLD,22));
        lbl.setBounds(100,30,300,30);
        add(lbl);

        JLabel srollNumber= new JLabel("Search EmployeeID");
        srollNumber.setBounds(50,100,200,20);
        srollNumber.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(srollNumber);

        cemplId= new Choice();
        cemplId.setBounds(50,130,250,20);
        cemplId.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(cemplId);

        try {
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("select * from teacher");
            while (rs.next()){
                cemplId.add(rs.getString("employeeId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel leaveDate= new JLabel("Date");
        leaveDate.setBounds(50,180,200,20);
        leaveDate.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(leaveDate);

        dcdate= new JDateChooser();
        dcdate.setBounds(50,210,250,25);
        dcdate.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(dcdate);

        JLabel leaveDuration= new JLabel("Duration");
        leaveDuration.setBounds(50,260,200,20);
        leaveDuration.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(leaveDuration);

        time= new Choice();
        time.setBounds(50,290,250,20);
        time.setFont(new Font("Times New Roman",Font.BOLD,18));
        time.add("Full day");
        time.add("Half day");
        add(time);

        submit= new JButton("Submit");
        submit.setFont(new Font("Times New Roman",Font.BOLD,18));
        submit.setBounds(50,350,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel= new JButton("Cancel");
        cancel.setFont(new Font("Times New Roman",Font.BOLD,18));
        cancel.setBounds(180,350,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(500,500);
        setLocation(600,100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== submit){
            String employeeId = cemplId.getSelectedItem();
            String date= ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = time.getSelectedItem();
            String query= "insert into teacherLeave values('"+employeeId+"', '"+date+"', '"+duration+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Leave Submitted");
                setVisible(false);
            }catch (Exception e){
                System.out.println(e);
            }
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new TeacherLeave();
    }
}
