package com.pluralsight.NorthwindTradersSpringBoot.model;
import java.io.Serializable;
import java.text.DecimalFormat;

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
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("0.00");
        return "Product ID: " + productID +
                "\nName: " + name +
                "\nCategory: " + category +
                "\nPrice: " + df.format(price);
    }
}
