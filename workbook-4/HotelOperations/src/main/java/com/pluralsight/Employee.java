package com.pluralsight;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;

public class Employee {
    private int id;
    private String department, name;
    private double payRate, hours;
    private LocalDateTime punchIn, punchOut;

    public Employee(int id, String department, String name, double payRate, double hours) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.payRate = payRate;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getRegularHours(){
        if (hours > 40){
            return 40;
        }
        else{
            return hours;
        }
    }

    public double getOvertimeHours(){
        if (hours > 40){
            return hours - 40;
        }
        else{
            return 0;
        }
    }

    public double getTotalPay(){
        return (payRate * getOvertimeHours()) + (payRate + getRegularHours());
    }

    public void punchIn(LocalDateTime punchIn){
        this.punchIn = punchIn;
    }

    public void punchOut(LocalDateTime punchOut){
        this.punchOut = punchOut;
    }

    public void punchIn(){
        punchIn = LocalDateTime.now();
    }

    public void punchOut(){
        punchOut = LocalDateTime.now();
    }

    public void punchTimeCard(){
        Date d1 = Date.from(punchIn.toInstant(ZoneOffset.ofHours(5)));
        Date d2 = Date.from(punchOut.toInstant(ZoneOffset.ofHours(5)));
        hours += (double) (d2.getTime() - d1.getTime()) / 3600000;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", payRate=" + payRate +
                ", hours=" + hours +
                '}';
    }
}
