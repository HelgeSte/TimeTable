package com.stegemoen.timetable.model;
import java.util.Calendar;
import java.io.*;
/**
 *
 * @author hsteg
 */
public class Project implements Serializable {
    private Calendar startDate;
    private int projectId;
    private String projectName;
    public Customer m_Customer;
    private String info;

    public Project(){
        projectId++;
        info = "Project-info";
    }
    
    public Project(String projectName, 
            Customer m_Customer) {
        this();
        this.projectName = projectName;
        this.m_Customer = m_Customer;
    }
    
    public Project(String projectName, 
            Customer m_Customer, String info) {
        this();
        this.projectName = projectName;
        this.m_Customer = m_Customer;
        this.info = info;
    }
    
    @Override
    public String toString(){
        return this.projectName + "\t" + this.m_Customer.getCompanyName()
                + "\t" + this.info;
    }
  
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Calendar getPeriodLength() {
        return startDate;
    }

    public void setPeriodLength(Calendar startDate) {
        this.startDate = startDate;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Customer getM_Customer() {
        return m_Customer;
    }

    public void setM_Customer(Customer m_Customer) {
        this.m_Customer = m_Customer;
    }
}
