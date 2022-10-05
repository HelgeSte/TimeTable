/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stegemoen.timetable.data;
import com.stegemoen.timetable.model.Project;
import com.stegemoen.timetable.model.Customer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author hsteg
 */
public class Projects {
    static ArrayList<Project> projects = new ArrayList<>();
    public void loadFromFile(){
        try {
            FileInputStream fis = new FileInputStream("projects.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            projects = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
            
        } catch(IOException ie){
            ie.printStackTrace();
        } catch(ClassNotFoundException ce){
            ce.printStackTrace();
        }
    }
    
    public void saveToFile(){
        try {
            FileOutputStream fos = new FileOutputStream("projects.ser");
            ObjectOutputStream ois = new ObjectOutputStream(fos);
            ois.writeObject(projects);
            ois.close();
            fos.close();
        } catch(IOException ie){
            ie.printStackTrace();
        }
    }
    
    public void addItem(Project p){
            projects.add(p);
            saveToFile();
        }
    
    public ArrayList<Project> getProjects(){
        return projects;
    }
}
