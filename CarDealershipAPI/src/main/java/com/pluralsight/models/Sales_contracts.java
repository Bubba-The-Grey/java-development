package com.pluralsight.models;

public class Sales_contracts {
    private int id, date, vin;
    private String customer, email;

    public Sales_contracts(int id, int date, int vin, String customer, String email) {
        this.id = id;
        this.date = date;
        this.vin = vin;
        this.customer = customer;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public int getDate() {
        return date;
    }

    public int getVin() {
        return vin;
    }

    public String getCustomer() {
        return customer;
    }

    public String getEmail() {
        return email;
    }
}
