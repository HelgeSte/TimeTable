/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.stegemoen.timetable;
import com.stegemoen.timetable.gui.*;
import com.stegemoen.timetable.model.*;
import com.stegemoen.timetable.data.*;

import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Customers c = new Customers();
        c.loadFromFile();
        // Testing Activities, Customers, Projects and Users:
        //new Activities().createTestActivities();
        //new Activities().saveToFile();
        ArrayList<Activity> activities = new Activities().getActivities();
        for(Activity a : activities){
            System.out.println(a.toString());
            System.out.println("Email: " + a.m_User.getEmail());
        }
        
        /* Check if these are serializable, since they include other objects.
           If not, consider using objectId's to identify objects of different
           types.
        */
        //Projects.loadProjectList();
        //Activities.loadActivityList();
       
        
        // Start the GUI
        /*SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                //new UserList(Users.getUserList());
                new AddUser().setVisible(true); // Needed for form created by
                                                // using NetBean's GUI designer
                //new AddCustomer();
            }
        });*/
        
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                //new AddCustomer().setVisible(true);
                new AddCustomer().setVisible(true);
                //new CustomerList().setVisible(true);
                //new _AddUser().setVisible(true);
                //new AddCustomer().setVisible(true);
            }
        });
        
        
    }
    
}
