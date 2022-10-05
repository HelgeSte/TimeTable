package com.stegemoen.timetable.gui;
import com.stegemoen.timetable.model.User;
import com.stegemoen.timetable.data.Users;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author hsteg
 */
public class UserList extends JFrame implements ActionListener, ListSelectionListener {
    JFrame frame;
    JButton jbtn_AddUser;
    JList<String> jl_Users;
    JScrollPane jScrollPane;
    
    public UserList(){
        initComponents();
    }
    
    private void initComponents(){
        ArrayList<User> u = new Users().getItems();
        String users[] = new String[u.size()];
        for(int i=0; i<u.size(); i++){
            users[i] = u.get(i).toString();
        }
        setLayout(new FlowLayout());
        setSize(300, 340);
        jl_Users = new JList<String>(users);
        jl_Users.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane = new JScrollPane(jl_Users);
        jScrollPane.setPreferredSize(new Dimension(260, 90));
        add(jScrollPane);
        
        jbtn_AddUser = new JButton("NewUser");
        jbtn_AddUser.addActionListener(this);
        add(jbtn_AddUser);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("NewUser")){
            dispose();
            new AddUser().setVisible(true);
        }
    }
    
    public void valueChanged(ListSelectionEvent le){
        
    }
    
    /*public static void main(String[] args){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Default", "User", "user@timetable.no", "Password1."));
        users.add(new User("Homer", "Simpson", "homer@timetable.no", "Password1."));
        users.add(new User("Default", "Admin", "admin@timetable.no", "Password1."));
        users.add(new User("Sheldon", "Cooper", "sheldon@timetable.no", "Password1."));
        users.add(new User("Donald", "Duck", "donald@timetable.no", "Password1."));
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new UserList();
            }
        });
    }*/
}
