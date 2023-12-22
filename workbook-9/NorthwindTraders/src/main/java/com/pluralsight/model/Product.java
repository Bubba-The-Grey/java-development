package com.pluralsight.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int productID;
    private String name, category;
    private double price;

    public Product() {}
    public Product(int productID, String name, String category, double price) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
