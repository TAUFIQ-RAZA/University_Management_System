import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Examination extends JFrame implements ActionListener {

    JButton result,cancel;
    JTextField search;
    JTable table;
    public  Examination(){

        setLayout(null);

        JLabel heading = new JLabel("Search Your Number");
        heading.setBounds(20,20,400,30);
        heading.setFont(new Font("Times New Roman",Font.BOLD,22));
        add(heading);

        search = new JTextField();
        search.setBounds(20,50,200,30);
        add(search);


        result= new JButton("Result");
        result.setFont(new Font("Times New Roman",Font.BOLD,18));
        result.setBounds(240,50,100,30);
        result.setBackground(Color.black);
        result.setForeground(Color.WHITE);
        result.addActionListener(this);
        add(result);

        cancel= new JButton("Cancel");
        cancel.setFont(new Font("Times New Roman",Font.BOLD,18));
        cancel.setBounds(350,50,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        table= new JTable();
        table.setBounds(0,80,1000,600);

        try {
            Conn conn= new Conn();
            String query ="select * from student";
            ResultSet rs= conn.s.executeQuery(query);
            while (rs.next()){
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }        }catch (Exception e){
            System.out.println(e);
        }

        JScrollPane jsp= new JScrollPane(table);
        jsp.setBounds(0,100,1000,600);
        add(jsp);

        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              int row= table.getSelectedRow();
              search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });

        setSize(1000,600);
        setLocation(500,150);
        setVisible(true);
    }

    public  void actionPerformed(ActionEvent ae){
        if (ae.getSource()== result){
            new Marks(search.getText());
            setVisible(false);
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Examination();

    }
}