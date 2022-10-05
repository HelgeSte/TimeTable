package com.stegemoen.timetable.gui;
import com.stegemoen.timetable.model.*;
import java.util.ArrayList;
import com.stegemoen.timetable.data.Users;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddUser  extends JFrame implements ActionListener {
    ArrayList<User> users = new ArrayList<>();
    JFrame frame;
    JLabel lb_FirstName;
    JLabel lb_LastName;
    JLabel lb_Email;
    JLabel lb_Pwd;
    JLabel lb_ConfirmPwd;
    JTextField jtf_FirstName;
    JTextField jtf_LastName;
    JTextField jtf_Email;
    JTextField jtf_Pwd;
    JTextField jtf_ConfirmPwd;
    JButton btn_Submit;
    JButton btn_List;
    
    public AddUser(){
        initComponents();
    }
    
    private void initComponents() {
        lb_FirstName = new JLabel();
        lb_LastName = new JLabel();
        lb_Email = new JLabel();
        lb_Pwd = new JLabel();
        lb_ConfirmPwd = new JLabel();
        jtf_FirstName = new JTextField();
        jtf_LastName = new JTextField();
        jtf_Email = new JTextField();
        jtf_Pwd = new JTextField();
        jtf_ConfirmPwd = new JTextField();
        btn_Submit = new JButton();
        btn_List = new JButton();
        
        //frame = new JFrame("Add Customers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 340);
        setPreferredSize(new Dimension(250, 340));
        setLayout(new FlowLayout());
        
        lb_FirstName.setText("First Name: ");
        lb_FirstName.setPreferredSize(new Dimension(100, 16));
        lb_LastName.setText("Last Name: ");
        lb_LastName.setPreferredSize(new Dimension(100, 16));
        lb_Email.setText("E-mail: ");
        lb_Email.setPreferredSize(new Dimension(100, 16));
        lb_Pwd.setText("Password: ");
        lb_Pwd.setPreferredSize(new Dimension(100, 16));
        lb_ConfirmPwd.setText("Confirm: ");
        lb_ConfirmPwd.setPreferredSize(new Dimension(100, 16));
        
        jtf_FirstName.setPreferredSize(new Dimension(100, 16));
        jtf_LastName.setPreferredSize(new Dimension(100, 16));
        jtf_Email.setPreferredSize(new Dimension(100, 16));
        jtf_Pwd.setPreferredSize(new Dimension(100, 16));
        jtf_ConfirmPwd.setPreferredSize(new Dimension(100, 16));
        
        btn_Submit.setText("Submit");
        btn_Submit.setPreferredSize(new Dimension(100, 16));
        btn_Submit.addActionListener(this);
        btn_List.setText("List");
        btn_List.setPreferredSize(new Dimension(100, 16));
        btn_List.addActionListener(this);
        
        add(lb_FirstName);
        add(jtf_FirstName);
        add(lb_LastName);
        add(jtf_LastName);
        add(lb_Email);
        add(jtf_Email);
        add(lb_Pwd);
        add(jtf_Pwd);
        add(lb_ConfirmPwd);
        add(jtf_ConfirmPwd);
        
        add(btn_List);
        add(btn_Submit);
        
        //setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Submit")){
            String firstName = jtf_FirstName.getText();
            String lastName = jtf_LastName.getText();
            String eMail = jtf_Email.getText();
            String pwd = jtf_Pwd.getText(); 
            String confirmPwd = jtf_ConfirmPwd.getText();
            if(pwd.equals(confirmPwd)){
                User u = new User(firstName, lastName, eMail,
                pwd);
                new Users().addItem(u);
            } else {
                User u = new User(firstName, lastName, eMail, "nopass");
                // Show error message instead
                new Users().addItem(u);
            }
                
        } else if(ae.getActionCommand().equals("List")){
            dispose();
           new UserList().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new AddUser().setVisible(true);
            }
        });
    }
}
