package com.project.WebApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Salary")
public class Salary {
    @Id
    @Column(name = "salaryID")
    private String salaryID;
    private String staffID;
    private Double basicSalary;
    private Date applicableDate;

    public Salary(String salaryID, String staffID, Double basicSalary, Date applicableDate) {
        this.salaryID = salaryID;
        this.staffID = staffID;
        this.basicSalary = basicSalary;
        this.applicableDate = applicableDate;
    }

    public Salary() {
    }

    public Date getApplicableDate() {
        return applicableDate;
    }

    public void setApplicableDate(Date applicableDate) {
        this.applicableDate = applicableDate;
    }

    public String getSalaryID() {
        return salaryID;
    }

    public void setSalaryID(String salaryID) {
        this.salaryID = salaryID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }
}
