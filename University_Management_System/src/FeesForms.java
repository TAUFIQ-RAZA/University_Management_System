import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class FeesForms extends JFrame implements ActionListener {

    JLabel name,fname;
    Choice crollno;
    JComboBox branch,semester;
    JButton cancel,submit,pay;
    JLabel total;
    public FeesForms(){
        setLayout(null);

        JLabel heading = new JLabel("Fees Form");
        heading.setBounds(120,20,400,30);
        heading.setFont(new Font("Times New Roman",Font.BOLD,24));
        add(heading);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,400,400);
        add(image);

        JLabel srollNumber= new JLabel("Roll Number");
        srollNumber.setBounds(20,70,120,20);
        srollNumber.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(srollNumber);

        crollno= new Choice();
        crollno.setBounds(150,70,200,20);
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

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(20,120,80,20);
        lblname.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lblname);

        name = new JLabel();
        name.setBounds(150,120,400,20);
        name.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(name);

        JLabel lblfname = new JLabel("FatherName");
        lblfname.setBounds(20,170,120,30);
        lblfname.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lblfname);

        fname = new JLabel();
        fname.setBounds(150,170,400,30);
        fname.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(fname);

        try{
            Conn c = new Conn();
            ResultSet rs= c.s.executeQuery("select * from student where rollno = '"+crollno.getSelectedItem()+"'");
            while (rs.next()){
                name.setText(rs.getString("stdName"));
                fname.setText(rs.getString("fatherName"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent it) {
                try{
                    Conn c = new Conn();
                    ResultSet rs= c.s.executeQuery("select * from student where rollno = '"+crollno.getSelectedItem()+"'");
                    while (rs.next()){
                        name.setText(rs.getString("stdName"));
                        fname.setText(rs.getString("fatherName"));
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(20,220,120,30);
        lblbranch.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lblbranch);

        String branches[]= {"BTech","ISE","ECE","MECH","CIVIL","CSE"};
        branch= new JComboBox(branches);
        branch.setFont(new Font("Times New Roman",Font.BOLD,20));
        branch.setBounds(150,220,200,30);
        branch.setBackground(Color.WHITE);
        add(branch);

        JLabel lblsem = new JLabel("Semester");
        lblsem.setBounds(20,280,120,30);
        lblsem.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lblsem);

        String sem[]= {"sem1","sem2","sem3","sem4","sem5","sem6","sem7","sem8"};
        semester= new JComboBox(sem);
        semester.setFont(new Font("Times New Roman",Font.BOLD,20));
        semester.setBounds(150,280,200,30);
        semester.setBackground(Color.WHITE);
        add(semester);

        JLabel lbltotal = new JLabel("Total Pay");
        lbltotal.setBounds(20,340,120,30);
        lbltotal.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lbltotal);

        total = new JLabel();
        total.setBounds(150,340,120,30);
        total.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(total);


        submit= new JButton("Update");
        submit.setFont(new Font("Times New Roman",Font.BOLD,20));
        submit.setBounds(20,400,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        pay= new JButton("Pay");
        pay.setFont(new Font("Times New Roman",Font.BOLD,20));
        pay.setBounds(150,400,100,30);
        pay.setBackground(Color.black);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        add(pay);

        cancel= new JButton("Cancel");
        cancel.setFont(new Font("Times New Roman",Font.BOLD,20));
        cancel.setBounds(280,400,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(800,600);
        setLocation(600,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== submit){

            String bran= " "+branch.getSelectedItem();
            String scsem = ""+semester.getSelectedItem();

            try {
                Conn c= new Conn();
                ResultSet rs= c.s.executeQuery("select * from fees where course = '"+bran+"'");
                while (rs.next()){
                    total.setText(rs.getString(scsem));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource()== pay){
            JOptionPane.showMessageDialog(null,"Fees Is Paid");
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new FeesForms();
    }
}
