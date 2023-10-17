package com.pluralsight;
import java.util.*;
import java.io.*;
public class SearchInventory {
    public static void main(String[] args) throws IOException {
        ArrayList<Product> items = new ArrayList<Product>();
        BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
        String input = "";
        int productID = 0;
        String productName = "";
        double productPrice;
        while((input = reader.readLine()) != null){
            String[] temp = input.split("\\|");
                productName = temp[1];
                productPrice = Double.parseDouble(temp[2]);
                productID = Integer.parseInt(temp[0]);
                items.add(new Product(productID, productName, productPrice));
        }
        Collections.sort(items, Product.ProductName);
        for(int i = 0; i < items.size(); i++){
            System.out.println(items.get(i).getId() + " Item: " + items.get(i).getName() + ", Price: $" + items.get(i).getPrice());
        }
    }
}
