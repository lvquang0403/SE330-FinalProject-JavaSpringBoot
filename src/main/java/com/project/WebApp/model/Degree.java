package com.project.WebApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Degree")
public class Degree {
    @Id
    @Column(name = "degreeID")
    private String degreeID;
    @Column(name ="staffID")
    private String staffID;
    @Column(name ="academic_level")
    private int name_major;
    @Column(name ="name_university")
    private String name_university;

    public Degree(String staffID, int name_major, String name_university) {
        this.staffID = staffID;
        this.name_major = name_major;
        this.name_university = name_university;
    }

    public Degree() {
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getDegreeID() {
        return degreeID;
    }

    public void setDegreeID(String degreeID) {
        this.degreeID = degreeID;
    }

    public int getName_major() {
        return name_major;
    }

    public void setName_major(int name_major) {
        this.name_major = name_major;
    }

    public String getName_university() {
        return name_university;
    }

    public void setName_university(String name_university) {
        this.name_university = name_university;
    }
}

//    staffID varchar(6) PRIMARY KEY NOT NULL,
//	academic_level int,
//            name_major varchar(100),
//            name_university varchar(100),