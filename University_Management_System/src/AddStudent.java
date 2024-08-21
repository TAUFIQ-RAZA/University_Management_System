import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;


public class AddStudent extends JFrame implements ActionListener {

    JTextField name,fname,address,phone,email,classx,classxii,adhar;
    JComboBox branch;
    JDateChooser dob;
    JLabel rollno;
    JButton submit,cancel;
    Random random= new Random();

    public AddStudent(){
        int rollnumber= Math.abs((random.nextInt() % 9000)+1000);
        setLayout(null);

        JLabel stduentInformation= new JLabel("New Student Details");
        stduentInformation.setFont(new Font("Times New Roman",Font.BOLD,30));
        stduentInformation.setBounds(300,20,400,30);
        add(stduentInformation);

        JLabel sname= new JLabel("Name");
        sname.setFont(new Font("Times New Roman",Font.BOLD,22));
        sname.setBounds(60,150,100,30);
        add(sname);

        name= new JTextField();
        name.setFont(new Font("Times New Roman",Font.BOLD,20));
        name.setBounds(180,150,200,30);
        add(name);

        JLabel sfname= new JLabel("Father Name");
        sfname.setFont(new Font("Times New Roman",Font.BOLD,22));
        sfname.setBounds(410,150,200,30);
        add(sfname);

        fname= new JTextField();
        fname.setFont(new Font("Times New Roman",Font.BOLD,20));
        fname.setBounds(600,150,200,30);
        add(fname);

        JLabel srollno= new JLabel("Roll No");
        srollno.setFont(new Font("Times New Roman",Font.BOLD,22));
        srollno.setBounds(60,220,100,30);
        add(srollno);

        rollno= new JLabel("2024"+rollnumber);
        rollno.setFont(new Font("Times New Roman",Font.BOLD,22));
        rollno.setBounds(180,220,200,30);
        add(rollno);

        JLabel dateofbirth= new JLabel("Date of Birth");
        dateofbirth.setFont(new Font("Times New Roman",Font.BOLD,22));
        dateofbirth.setBounds(410,220,200,30);
        add(dateofbirth);

        dob= new JDateChooser();
        dob.setFont(new Font("Times New Roman",Font.BOLD,20));
        dob.setBounds(600,220,200,30);
        add(dob);

        JLabel saddress= new JLabel("Address");
        saddress.setFont(new Font("Times New Roman",Font.BOLD,22));
        saddress.setBounds(60,280,100,30);
        add(saddress);

        address= new JTextField();
        address.setFont(new Font("Times New Roman",Font.BOLD,20));
        address.setBounds(180,280,200,30);
        add(address);

        JLabel sphone= new JLabel("Phone");
        sphone.setFont(new Font("Times New Roman",Font.BOLD,22));
        sphone.setBounds(410,280,200,30);
        add(sphone);

        phone= new JTextField();
        phone.setFont(new Font("Times New Roman",Font.BOLD,20));
        phone.setBounds(600,280,200,30);
        add(phone);

        JLabel semail= new JLabel("Email ID");
        semail.setFont(new Font("Times New Roman",Font.BOLD,22));
        semail.setBounds(60,340,100,30);
        add(semail);

        email= new JTextField();
        email.setFont(new Font("Times New Roman",Font.BOLD,20));
        email.setBounds(180,340,200,30);
        add(email);

        JLabel sadhar= new JLabel("Adhar Card");
        sadhar.setFont(new Font("Times New Roman",Font.BOLD,22));
        sadhar.setBounds(410,340,200,30);
        add(sadhar);

        adhar= new JTextField();
        adhar.setFont(new Font("Times New Roman",Font.BOLD,20));
        adhar.setBounds(600,340,200,30);
        add(adhar);

        JLabel sx= new JLabel("Class X(%)");
        sx.setFont(new Font("Times New Roman",Font.BOLD,22));
        sx.setBounds(60,400,100,30);
        add(sx);

        classx= new JTextField();
        classx.setFont(new Font("Times New Roman",Font.BOLD,20));
        classx.setBounds(180,400,200,30);
        add(classx);

        JLabel sxii= new JLabel("Class XII(%)");
        sxii.setFont(new Font("Times New Roman",Font.BOLD,22));
        sxii.setBounds(410,400,200,30);
        add(sxii);

        classxii= new JTextField();
        classxii.setFont(new Font("Times New Roman",Font.BOLD,20));
        classxii.setBounds(600,400,200,30);
        add(classxii);

        JLabel sbranch= new JLabel("Branch");
        sbranch.setFont(new Font("Times New Roman",Font.BOLD,22));
        sbranch.setBounds(60,460,100,30);
        add(sbranch);

        String branches[]= {"CSE","ISE","CIVIL","ECE","MECH"};
        branch= new JComboBox(branches);
        branch.setFont(new Font("Times New Roman",Font.BOLD,20));
        branch.setBounds(180,460,200,30);
        branch.setBackground(Color.WHITE);
        add(branch);

        submit= new JButton("Submit");
        submit.setFont(new Font("Times New Roman",Font.BOLD,20));
        submit.setBounds(280,540,150,35);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel= new JButton("Cancel");
        cancel.setFont(new Font("Times New Roman",Font.BOLD,20));
        cancel.setBounds(480,540,150,35);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(500,70);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== cancel){
            setVisible(false);
        } else if (ae.getSource()== submit) {
            String sname = name.getText();
            String father= fname.getText();
            String rollNo = rollno.getText();
            String dcdate=((JTextField)dob.getDateEditor().getUiComponent()).getText();
            String add = address.getText();
            String phno= phone.getText();
            String mail = email.getText();
            String adharNumber = adhar.getText();
            String tenth= classx.getText();
            String twelve= classxii.getText();
            String sbrach= (String) branch.getSelectedItem();

            try {
                String query = "insert into student values('"+sname+"','"+father+"','"+rollNo+"','"+dcdate+"','"+add+"','"+phno+"','"+mail+"','"+adharNumber+"','"+tenth+"','"+twelve+"','"+sbrach+"')";

                Conn conn = new Conn();
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details are Added");
                setVisible(false);

            }catch (Exception e){
                System.out.println(e);
            }
        }

    }
    public static void main(String[] args) {
        new AddStudent();
    }
}
