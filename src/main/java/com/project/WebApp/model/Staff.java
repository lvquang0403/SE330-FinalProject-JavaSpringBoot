package com.project.WebApp.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
@Entity
@Table(name = "Staff")
public class Staff {
    @Id
    @Column(name ="staffID")
    private String staffID;
    @Column(name ="full_name")
    private String full_name;
    @Column(name ="gender")
    private boolean gender;
    @Column(name ="bod")
    private Date bod;
    @Column(name ="experience")
    private int experience;
    @Column(name ="adr")
    private String adr;
    @Column(name ="phone")
    private String phone;
    @Column(name ="posID")
    private String posID;
    @Column(name ="roomID")
    private String roomID;

    public Staff(String staffID, String full_name, boolean gender, Date bod, int experience, String adr, String phone, String posID, String roomID) {
        this.staffID = staffID;
        this.full_name = full_name;
        this.gender = gender;
        this.bod = bod;
        this.experience = experience;
        this.adr = adr;
        this.phone = phone;
        this.posID = posID;
        this.roomID = roomID;
    }

    public Staff() {
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBod() {
        return bod;
    }

    public void setBod(Date bod) {
        this.bod = bod;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosID() {
        return posID;
    }

    public void setPosID(String posID) {
        this.posID = posID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }
}
//    SELECT TOP (1000) [staffID]
//        ,[full_name]
//        ,[gender]
//        ,[bod]
//        ,[experience]
//        ,[adr]
//        ,[phone]
//        ,[posID]
//        ,[roomID]