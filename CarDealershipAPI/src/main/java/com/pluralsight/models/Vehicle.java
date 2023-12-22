package com.pluralsight.models;

public class Vehicle {
    private int vin, year, mileage;
    private String make, model, type, color;
    private double price;
    private boolean sold;

    public Vehicle(int vin, int year, int mileage, String make, String model, String type, String color, double price, boolean sold) {
        this.vin = vin;
        this.year = year;
        this.mileage = mileage;
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.price = price;
        this.sold = sold;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
}
