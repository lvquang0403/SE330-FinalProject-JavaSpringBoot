package com.project.WebApp.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SalaryPayment")
public class SalaryPayment {
    @Id
    @Column(name = "salaryPayID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long salaryPayID;
    private String staffID;
    private String salaryID;
    private String timeshID;
    private int mon;
    private int yea;
    private Double insurance;
    private Double bonus;
    private Double actReceived;
    //calculation SalaryPayment from timesheet and salary
    public static final SalaryPayment calSalaryPayment(Timesheets timesheets, Salary salary) {
        Double bonus = 0.0;
        Double insurance = salary.getBasicSalary()*0.05;
        if (timesheets.getDay_off()==0){
            bonus = 2000000.0;
        }
        return new SalaryPayment(salary.getStaffID(),
                salary.getSalaryID(),
                timesheets.getTimeshID(),
                timesheets.getMon(),
                timesheets.getYea(),
                insurance,
                bonus,
                salary.getBasicSalary() - insurance + bonus
        );
    }

    // format actually
//    public static final formatActually
    public SalaryPayment(String staffID, String salaryID, String timeshID, int mon, int yea, Double insurance, Double bonus, Double actReceived) {
        this.staffID = staffID;
        this.salaryID = salaryID;
        this.timeshID = timeshID;
        this.mon = mon;
        this.yea = yea;
        this.insurance = insurance;
        this.bonus = bonus;
        this.actReceived = actReceived;
    }

    public SalaryPayment() {
    }

    public Long getSalaryPayID() {
        return salaryPayID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getSalaryID() {
        return salaryID;
    }

    public void setSalaryID(String salaryID) {
        this.salaryID = salaryID;
    }

    public String getTimeshID() {
        return timeshID;
    }

    public void setTimeshID(String timeshID) {
        this.timeshID = timeshID;
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

    public Double getInsurance() {
        return insurance;
    }

    public void setInsurance(Double insurance) {
        this.insurance = insurance;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getActReceived() {
        return actReceived;
    }

    public void setActReceived(Double actReceived) {
        this.actReceived = actReceived;
    }
}
//    salaryPayID varchar(6) primary key not null ,
//        staffID varchar(6),
//        salaryID varchar(6),
//        timeshID varchar(6),
//        mon int,
//        yea int,
//        insurance float(2),
//        bonus float(2),
//        actReceived float(2)