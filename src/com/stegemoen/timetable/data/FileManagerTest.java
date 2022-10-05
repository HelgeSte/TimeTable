/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stegemoen.timetable.data;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Serializable;
class Car implements Serializable {
    String brand;
    String model;
    
   
    
    Car(String brand, String model){
        this.brand = brand;
        this.model = model;
    }
    
    public String getBrand(){
        return brand;
    }
    
    public String getModel(){
        return model;
    }
    
    public void setBrand(String brand){
        this.brand = brand;
    }
    
    public void setModel(String model){
        this.model = model;
    }
}

class FileManagerTest<T> {
    public void writeFile(ArrayList<T> t){
        String className = t.get(0).getClass().getName();
       
        System.out.println(className);
        try {
            FileOutputStream fos = new FileOutputStream(className + "s.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t);
            oos.close();
            fos.close();
        } catch(IOException ie){
            ie.printStackTrace();
        }
        System.out.println("Finished writing objects to a file");
    }
    
    public void readFromFile(){
        String className = this.getClass().getName();
        ArrayList<Car> cars;
        try {
            FileInputStream fis = new FileInputStream(className + ".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            cars = (ArrayList) ois.readObject();
            for(Car c : cars){
            System.out.println(c.getBrand() + " " + c.getModel());
        }
        }catch(IOException ie){
            ie.printStackTrace();
        } catch(ClassNotFoundException c){
            c.printStackTrace();
        }
        
    }
}

class Program {
    public static void main(String[] args){
        FileManagerTest manager = new FileManagerTest();
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Opel", "Manta"));
        cars.add(new Car("Honda", "Accord"));
        cars.add(new Car("Toyota", "Corolla"));
        manager.writeFile(cars);
        //manager.readFromFile();
    }
}
