/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stegemoen.timetable.model;
import java.io.*;

public class Customer implements Serializable {
    private String contactEmail;
    private String companyName;
    private String shortName;
    private String contactPersonName;
    private int customerId;
    private String phone;

    public Customer(){
        customerId++;
    }

    public Customer( String companyName, String shortName,
            String contactEmail, String contactPersonName, 
            String phone) {
        this();
        this.companyName = companyName;
        this.shortName = shortName;
        this.contactPersonName = contactPersonName;
        this.contactEmail = contactEmail;
        this.phone = phone;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String toString(){
        return this.companyName + "\t" + this.contactPersonName + "\t"
                + this.contactEmail + "\t" + this.phone;
    }
}