package com.pluralsight;

import java.util.Comparator;

public class Product {
    private int id = 0;
    private String name = "";
    private double price = 0.0;
    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public static Comparator<Product> ProductName = new Comparator<Product>() {
        @Override
            public int compare(Product p1, Product p2){
                String ProductName1 = p1.getName();
                String ProductName2 = p2.getName();
                return ProductName1.compareToIgnoreCase(ProductName2);
            }

    };
    public static Comparator<Product> ProductID = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2){
            int ProductID1 = p1.getId();
            int ProductID2 = p2.getId();
            return ProductID1 - ProductID2;
        }

    };
    public static Comparator<Product> ProductPrice = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2){
            double ProductPrice1 = p1.getPrice();
            double ProductPrice2 = p2.getPrice();
            return (int) (ProductPrice1 - ProductPrice2);
        }

    };
}