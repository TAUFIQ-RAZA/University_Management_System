import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Runtime;

public class Project extends JFrame implements ActionListener {

    public Project(){
        setTitle("University Management System");

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1600,850,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1600,850);
        add(image);

        JMenuBar mb= new JMenuBar();
        setJMenuBar(mb);

        //New Information
        JMenu newInformation= new JMenu("Information");
        newInformation.setForeground(Color.BLUE);
        newInformation.setFont(new Font("Times New Roman",Font.BOLD,18));
        mb.add(newInformation);

        JMenuItem faculty= new JMenuItem("Add Faculty");
        faculty.setBackground(Color.WHITE);
        faculty.setFont(new Font("Times New Roman",Font.BOLD,18));
        faculty.addActionListener(this);
        newInformation.add(faculty);

        JMenuItem student= new JMenuItem("Add Student");
        student.setBackground(Color.WHITE);
        student.setFont(new Font("Times New Roman",Font.BOLD,18));
        student.addActionListener(this);
        newInformation.add(student);

        //View Details
        JMenu viewDetails= new JMenu("View Details");
        viewDetails.setForeground(Color.RED);
        viewDetails.setFont(new Font("Times New Roman",Font.BOLD,18));
        mb.add(viewDetails);

        JMenuItem facultyDetails= new JMenuItem("Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.setFont(new Font("Times New Roman",Font.BOLD,18));
        facultyDetails.addActionListener(this);
        viewDetails.add(facultyDetails);

        JMenuItem studentDetails= new JMenuItem("Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.setFont(new Font("Times New Roman",Font.BOLD,18));
        studentDetails.addActionListener(this);
        viewDetails.add(studentDetails);

        //Apply Leave
        JMenu leave= new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        leave.setFont(new Font("Times New Roman",Font.BOLD,18));
        mb.add(leave);

        JMenuItem facultyLeave= new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.setFont(new Font("Times New Roman",Font.BOLD,18));
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave= new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.setFont(new Font("Times New Roman",Font.BOLD,18));
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        //Leave Details
        JMenu leaveDetails= new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
        leaveDetails.setFont(new Font("Times New Roman",Font.BOLD,18));
        mb.add(leaveDetails);

        JMenuItem facultyleaveDetails= new JMenuItem("Faculty Leave Details");
        facultyleaveDetails.setBackground(Color.WHITE);
        facultyleaveDetails.setFont(new Font("Times New Roman",Font.BOLD,18));
        facultyleaveDetails.addActionListener(this);
        leaveDetails.add(facultyleaveDetails);

        JMenuItem studentLeaveDetails= new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.WHITE);
        studentLeaveDetails.setFont(new Font("Times New Roman",Font.BOLD,18));
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        //Examination
        JMenu examination= new JMenu("Examination");
        examination.setForeground(Color.BLUE);
        examination.setFont(new Font("Times New Roman",Font.BOLD,18));
        mb.add(examination);

        JMenuItem examResult= new JMenuItem("Exam Result");
        examResult.setBackground(Color.WHITE);
        examResult.setFont(new Font("Times New Roman",Font.BOLD,18));
        examResult.addActionListener(this);
        examination.add(examResult);

        JMenuItem marks= new JMenuItem("Enter Student Marks");
        marks.setBackground(Color.WHITE);
        marks.setFont(new Font("Times New Roman",Font.BOLD,18));
        marks.addActionListener(this);
        examination.add(marks);

        //Updated Details
        JMenu update= new JMenu("Update Details");
        update.setForeground(Color.RED);
        update.setFont(new Font("Times New Roman",Font.BOLD,18));
        mb.add(update);

        JMenuItem facultyUpdatd= new JMenuItem("Faculty Details Update");
        facultyUpdatd.setBackground(Color.WHITE);
        facultyUpdatd.setFont(new Font("Times New Roman",Font.BOLD,18));
        facultyUpdatd.addActionListener(this);
        update.add(facultyUpdatd);

        JMenuItem studentUpadate= new JMenuItem("Student Details Update");
        studentUpadate.setBackground(Color.WHITE);
        studentUpadate.setFont(new Font("Times New Roman",Font.BOLD,18));
        studentUpadate.addActionListener(this);
        update.add(studentUpadate);

        //Fees
        JMenu fee= new JMenu("Fees");
        fee.setForeground(Color.BLUE);
        fee.setFont(new Font("Times New Roman",Font.BOLD,18));
        mb.add(fee);

        JMenuItem feeStructure= new JMenuItem("Fees Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.setFont(new Font("Times New Roman",Font.BOLD,18));
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeForm= new JMenuItem("Fees Form");
        feeForm.setBackground(Color.WHITE);
        feeForm.setFont(new Font("Times New Roman",Font.BOLD,18));
        feeForm.addActionListener(this);
        fee.add(feeForm);

        //Utility
        JMenu utility= new JMenu("Utility");
        utility.setForeground(Color.RED);
        utility.setFont(new Font("Times New Roman",Font.BOLD,18));
        mb.add(utility);

        JMenuItem calculator= new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.setFont(new Font("Times New Roman",Font.BOLD,18));
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenuItem notepade= new JMenuItem("Notepad");
        notepade.setBackground(Color.WHITE);
        notepade.setFont(new Font("Times New Roman",Font.BOLD,18));
        notepade.addActionListener(this);
        utility.add(notepade);

        //exit
        JMenu exit= new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        exit.setFont(new Font("Times New Roman",Font.BOLD,18));
        mb.add(exit);

        JMenuItem exitSystem= new JMenuItem("Exit");
        exitSystem.setBackground(Color.WHITE);
        exitSystem.setFont(new Font("Times New Roman",Font.BOLD,18));
        exitSystem.addActionListener(this);
        exit.add(exitSystem);



        setSize(1640,950);
        setLocation(100,20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String msg= ae.getActionCommand();

        if (msg.equals("Exit")){
            System.exit(0);
        }else if (msg.equals("Calculator")){
            try {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception e){}
        }else if (msg.equals("Notepad")){
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e){}
        } else if (msg.equals("Add Student")) {
            new AddStudent().setVisible(true);
        } else if (msg.equals("Add Faculty")) {
            new AddFaculty().setVisible(true);
        }else if (msg.equals("Faculty Details")){
            new ViewFacultyDetails().setVisible(true);
        } else if (msg.equals("Student Details")) {
            new ViewStudentDetails().setVisible(true);
        } else if (msg.equals("Faculty Leave")) {
            new TeacherLeave().setVisible(true);
        }else if (msg.equals("Student Leave")){
            new StudentLeave().setVisible(true);
        }else if (msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails().setVisible(true);
        }
        else if (msg.equals("Student Leave Details")){
            new StudentLeaveDetails().setVisible(true);
        }else if (msg.equals("Faculty Details Update")){
            new UpdateTeacher();
        }else if (msg.equals("Student Details Update")){
            new UpdateStudent();
        }else if (msg.equals("Enter Student Marks")){
            new EnterMarks();
        }else if (msg.equals("Exam Result")){
            new Examination();
        }else if (msg.equals("Fees Structure")){
            new FeesStructure();
        }
        else if (msg.equals("Fees Form")){
            //new FeesForm();
        }

    }
    public static void main(String[] args) {
        new Project();
    }
}
