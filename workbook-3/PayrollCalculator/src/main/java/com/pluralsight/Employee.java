package com.pluralsight;
import java.text.*;
public class Employee {
    private int id= 0;
    private double payRate = 0.0,hoursWorked = 0.0;
    private String name = "";
    public Employee(String id, String name, String hoursWorked, String payRate){
        this.id = Integer.parseInt(id);
        this.name = name;
        this.hoursWorked = Double.parseDouble(hoursWorked);
        this.payRate = Double.parseDouble(payRate);
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getPayRate() {
        return this.payRate;
    }
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
    public double getHoursWorked() {
        return this.hoursWorked;
    }
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getGrossPay(){
        double gross = 0.0;
        if(this.getHoursWorked() <= 40) {
            gross = this.getHoursWorked() * this.getPayRate();
        }
        else{
            gross = this.getPayRate() * 40;
            gross += ((this.getHoursWorked() - 40) * (this.getPayRate() * 1.5));
        }
        return gross;
    }
}
