/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stegemoen.timetable.data;
import com.stegemoen.timetable.model.User;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Users {
    static ArrayList<User> users = new ArrayList<>();
    public ArrayList loadFromFile(){
        //ArrayList<User> userList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("users.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (ArrayList)ois.readObject();
            ois.close();
            fis.close();
        } catch(IOException ie){
           ie.printStackTrace();
        } catch(ClassNotFoundException c){
            c.printStackTrace();
        }
        return users;
    }
    
    public ArrayList<User> getItems(){
        this.loadFromFile();
        return users;
    }
    
    public void saveToFile(){
        try {
            FileOutputStream fos = new FileOutputStream("users.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users); // Throws IOException & ClassNotFoundException
            oos.close();
            fos.close();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    public void addItem(User u){
        // Code to add a user to the saved list
        users.add(u);
        saveToFile();
    }
    
    
    
    public static ArrayList<User> createTestUsers(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Default", "User", "user@timetable.no", "Password1."));
        users.add(new User("Homer", "Simpson", "homer@timetable.no", "Password1."));
        users.add(new User("Default", "Admin", "admin@timetable.no", "Password1."));
        users.add(new User("Sheldon", "Cooper", "sheldon@timetable.no", "Password1."));
        users.add(new User("Donald", "Duck", "donald@timetable.no", "Password1."));
        Users.users = users;
        return users;
    }
}
