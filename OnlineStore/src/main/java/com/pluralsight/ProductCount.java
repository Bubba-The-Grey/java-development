package com.pluralsight;

public class ProductCount {
    private String id = "", name = "", department = "";
    private double price = 0.0;
    private int count = 0;
    public ProductCount(String id, String name, double price, String department, int count){
        this.id = id;
        this.name = name;
        this.price = price;
        this.department = department;
        this.count = count;
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
    public int getCount() {
        return this.count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString() {
        return this.getId() + "|" + this.getName() + "|" + this.getPrice() + "|" + this.getDepartment() + "|" + this.getCount();
    }
}
