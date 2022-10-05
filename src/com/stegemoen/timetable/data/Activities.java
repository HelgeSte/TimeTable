/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stegemoen.timetable.data;
import com.stegemoen.timetable.model.Activity;
import com.stegemoen.timetable.model.Customer;
import com.stegemoen.timetable.model.User;
import com.stegemoen.timetable.model.Project;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author hsteg
 */
public class Activities {
    static ArrayList<Activity> activities = new ArrayList<>();
    
    public void loadFromFile(){
        try {
            FileInputStream fis = new FileInputStream("activities.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            activities = (ArrayList) ois.readObject();
        } catch(IOException ie){
            ie.printStackTrace();
        } catch(ClassNotFoundException c){
            c.printStackTrace();
        }
    }
    
    public void saveToFile(){
        try {
            FileOutputStream fos = new FileOutputStream("activities.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(activities);
            oos.close();
            fos.close();
        } catch(IOException ie){
            ie.printStackTrace();
        }
    }
    
    public void addItem(Activity a){
        activities.add(a);
        saveToFile();
    }
    
    public ArrayList<Activity> getActivities(){
        return activities;
    }
    
    public void createTestActivities() {
        User dolly = new User("Dolly", "Duck", "dolly@duckburg.dis", "secret");
        User minney = new User("Minney", "Mouse", "minney@duckburg.dis", "secret");
        Customer duckburg = new Customer(
                "Duckburg Women Organization", "Duckies", 
                "Madam Mim", "madam@duckies.dis", "+55 500 55 777");
        Project madam = new Project("Madams Mim's Duckburg Festival", duckburg);
        new Projects().addItem(madam);
        Calendar today = Calendar.getInstance();
        new Activities().addItem(new Activity("Creating a banner", madam, dolly, today, 5.0 ));

    }
}
