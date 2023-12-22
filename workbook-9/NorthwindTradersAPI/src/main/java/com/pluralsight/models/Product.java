package com.pluralsight.models;

import java.text.DecimalFormat;

public class Product {
    private int productID, categoryID;
    private String productName;
    private double unitPrice;

    public Product(int productID, String productName, int categoryID, double unitPrice) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.unitPrice = unitPrice;
    }

    public int getProductID() {
        return productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Product ID: " + productID +
                "\nName: " + productName +
                "\nCategory: " + categoryID +
                "\nPrice: " + df.format(unitPrice);
    }
}
