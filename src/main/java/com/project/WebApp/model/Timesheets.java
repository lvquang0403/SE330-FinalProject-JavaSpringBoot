package com.project.WebApp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Timesheets")
public class Timesheets {
    @Id
    @Column(name="timeshID")
    private String timeshID ;
    @Column(name="staffID")
    private String staffID;
    @Column(name="day_off")
    private int day_off;
    @Column(name="day_on")
    private int day_on;
    @Column(name="mon")
    private int mon;
    @Column(name="yea")
    private int yea;

    public Timesheets() {
    }

    public Timesheets(String timeshID, String staffID, int day_off, int day_on, int mon, int yea) {
        this.timeshID = timeshID;
        this.staffID = staffID;
        this.day_off = day_off;
        this.day_on = day_on;
        this.mon = mon;
        this.yea = yea;
    }

    public String getTimeshID() {
        return timeshID;
    }

    public void setTimeshID(String timeshID) {
        this.timeshID = timeshID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public int getDay_off() {
        return day_off;
    }

    public void setDay_off(int day_off) {
        this.day_off = day_off;
    }

    public int getDay_on() {
        return day_on;
    }

    public void setDay_on(int day_on) {
        this.day_on = day_on;
    }

    public int getMon() {
        return mon;
    }

    public void setMon(int mon) {
        this.mon = mon;
    }

    public int getYea() {
        return yea;
    }

    public void setYea(int yea) {
        this.yea = yea;
    }
}

//    StaffID varchar(6) NOT NULL,
//    day_off int NOT NULL,
//            day_on int NOT NULL,
//            mon int NOT NULL,
//            yea int NOT NULL,