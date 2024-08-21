import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login,cancel;
    JTextField user;
    JPasswordField pass;
    Login(){
        setTitle("Login");
        setLayout(null);

        JLabel username=new JLabel("UserName: ");
        username.setFont(new Font("Times New Roman",Font.BOLD,24));
        username.setBounds(30,60,140,30);
        add(username);

        user=new JTextField();
        user.setFont(new Font("Times New Roman",Font.BOLD,24));
        user.setBounds(160,60,230,30);
        add(user);

        JLabel password=new JLabel("PassWord: ");
        password.setFont(new Font("Times New Roman",Font.BOLD,24));
        password.setBounds(30,130,200,30);
        add(password);

        pass=new JPasswordField();
        pass.setFont(new Font("Times New Roman",Font.BOLD,24));
        pass.setBounds(160,130,230,30);
        add(pass);

        login= new JButton("LOGIN");
        login.setFont(new Font("Times New Roman",Font.BOLD,20));
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.setBounds(50,210,120,30);
        login.addActionListener(this);
        add(login);

        cancel= new JButton("CANCEL");
        cancel.setFont(new Font("Times New Roman",Font.BOLD,20));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(190,210,120,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,25,250,250);
        add(image);

        setSize(700,400);
        getContentPane().setBackground(Color.WHITE);
        setLocation(600,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==cancel){
            System.exit(0);
        }else if (ae.getSource()== login){
            String username = user.getText();
            String password = pass.getText();

            String query= "select * from login where username = '"+username+"' and password = '"+password+"'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()){
                    setVisible(false);
                    new Project().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalide Username Or PassWord");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
