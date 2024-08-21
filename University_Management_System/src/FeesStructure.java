import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FeesStructure extends JFrame implements ActionListener {

    JTable table;
    JButton cancel;
    public FeesStructure(){
        setLayout(null);

        JLabel feeslabl= new JLabel("Fees Structure");
        feeslabl.setBounds(30,30,500,50);
        feeslabl.setFont(new Font("Times New Roman",Font.BOLD,30));
        add(feeslabl);

        table= new JTable();

        try {
            Conn conn= new Conn();
            ResultSet rs= conn.s.executeQuery("select * from fees");
            while (rs.next()){
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp= new JScrollPane(table);
        jsp.setBounds(0,80,800,700);
        add(jsp);


        setSize(800,700);
        setLocation(550,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

    }

    public static void main(String[] args) {
        new FeesStructure();
    }
}
