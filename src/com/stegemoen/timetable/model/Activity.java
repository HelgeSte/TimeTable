package com.stegemoen.timetable.model;
import java.util.Calendar;
import java.io.*;

public class Activity implements Serializable {
    private static int activityId;
    private String comment;
    private Calendar start;
    private double hours;    // hours used
    public Project m_Project;
    public User m_User;

    public Activity(){
        activityId++;
        comment = "Activity-comment";
    }

    public Activity(Project m_Project, User m_User) {
        this();
        this.m_Project = m_Project;
        this.m_User = m_User;
    }
    
    public Activity(String comment, Project m_Project, User m_User, 
            Calendar start, double hours) {
        this();
        this.comment = comment;
        this.m_Project = m_Project;
        this.m_User = m_User;
        this.start = start;
        this.hours = hours;
    }
    
    @Override
    public String toString(){
        return m_Project.getProjectName() + "\t" + m_User.getFirstName() + " "
                + m_User.getLastName() + "\t" + this.comment;
    }

    // getters / setters
    public int getAktivitetId() {
        return activityId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public Calendar getStart() {
        return start;
    }

    public void setStart(Calendar start) {
        this.start = start;
    }

    public void setTimer(double timer) {
        this.hours = timer;
    }

    public Project getM_Prosjekt() {
        return m_Project;
    }

    public void setM_Prosjekt(Project m_Prosjekt) {
        this.m_Project = m_Prosjekt;
    }

    public User getM_User() {
        return m_User;
    }

    public void setM_User(User m_User) {
        this.m_User = m_User;
    }
}
