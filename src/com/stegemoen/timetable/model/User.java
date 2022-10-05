package com.stegemoen.timetable.model;
import java.io.*;
public class User implements Serializable {
    private static int userIdCounter;
    public int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User(){
        userIdCounter++;
    }

    public User(String firstName, String lastName, String email, String password) {
        this();
        this.userId = userIdCounter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    
    @Override
    public String toString(){
        return this.userId + ": " + this.email + ": " + this.firstName + " " + this.lastName;
    }

    // Getters / setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
