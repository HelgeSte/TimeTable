/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stegemoen.timetable.data;
import com.stegemoen.timetable.model.Customer;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Customers{
    static ArrayList<Customer> customers = new ArrayList<>();
    
    public ArrayList<Customer> loadFromFile(){
        try {
            FileInputStream fis = new FileInputStream("customers.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            customers = (ArrayList)ois.readObject();
            ois.close();
            fis.close();
        } catch(IOException ie){
           ie.printStackTrace();
        } catch(ClassNotFoundException c){
            c.printStackTrace();
        }
        return customers;
    }

    public void saveToFile() {
        try {
            FileOutputStream fos = new FileOutputStream("customers.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customers);
            oos.close();
            fos.close();
        } catch(IOException ie){
            ie.printStackTrace();
        }
    }

    public void addItem(Customer c) {
        customers.add(c);
        saveToFile();
    }
    
    public ArrayList<Customer> getItems(){
        this.loadFromFile();
        return customers;
    }
    
    public void createTestCustomers(){
        Customer marsPioneers = new Customer(
                "Mars Pioneering Enterprise", "MarsPioneers", 
                "Elon Musk", "elon@elonmusk.gov", "+55 550 95 001"
        );
        Customer theRepublic = new Customer(
                "Galactic Republic", "Republic", 
                "Sheev Palpatine", "palpy@thegalaxy.rep", "555"
        );
        Customer disney = new Customer(
                "The Walt Disney Company", "Disney", 
                "Mickey Mouse", "mickey@disney.com", "+55 500 55 777"
        );
        Customer theNuclearDrunk = new Customer(
                "The Nuclear Drunk Club", "NuclearDrunk",
                "Homer Simpson", "homer@thenucleardrunk.com", "+55 539 000"
        );
        Customer angerManagement = new Customer(
                "Duckburg Anger Management Group", "DuckburgAngryMgt", 
                "Donald Duck", "donald@theangrygroup.db", "+55 500 55 313"
        );
        ArrayList<Customer> al = new ArrayList<>();
        al.add(marsPioneers);
        al.add(theRepublic);
        al.add(disney);
        al.add(theNuclearDrunk);
        al.add(angerManagement);
        customers = al;
    }
}
