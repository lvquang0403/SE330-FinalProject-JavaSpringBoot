package com.project.WebApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Salary")
public class Salary {
    @Id
    @Column(name = "salaryID")
    private String salaryID;
    private String staffID;
    private Double basicSalary;

    public Salary(String salaryID, String staffID, Double basicSalary) {
        this.salaryID = salaryID;
        this.staffID = staffID;
        this.basicSalary = basicSalary;
    }

    public Salary() {
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
