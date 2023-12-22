package com.pluralsight.models;

public class Dealership {
    private int dealership_id;
    private String name, address, phone;

    public Dealership(int dealership_id, String name, String address, String phone) {
        this.dealership_id = dealership_id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getDealership_id() {
        return dealership_id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
