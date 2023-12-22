package com.pluralsight;

public class Shipper {
    private int id;
    private String name, number;

    public Shipper(int id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nName: " + name +
                "\nNumber: " + number +
                "\n_________________________________________________________________________________";
    }
}
