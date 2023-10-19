package com.pluralsight;
public class Product {
    private String id = "", name = "", department = "";
    private double price = 0.0;
    public Product(String id, String name, double price, String department){
        this.id = id;
        this.name = name;
        this.price = price;
        this.department = department;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return this.department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getId() + "|" + this.getName() + "|" + this.getPrice() + "|" + this.getDepartment();
    }
}
