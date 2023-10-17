package com.pluralsight;
import java.util.*;
import java.io.*;
public class SearchInventory {
    public static void main(String[] args) throws IOException {
        ArrayList<Product> items = new ArrayList<Product>();
        BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
        FileWriter writer = new FileWriter("inventory.csv", true);
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
        reader.close();
        Scanner scan = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("What do you want to do?");
            System.out.println("\t1-List all products");
            System.out.println("\t2-Lookup a product by its id");
            System.out.println("\t3-Find all products within a price range");
            System.out.println("\t4-Add a new product");
            System.out.println("\t5-Quit the application");
            System.out.print("Your Choice: ");
            option = scan.nextInt();
            switch(option) {
                case 1:
                    Collections.sort(items, Product.ProductName);
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println(items.get(i).getId() + " Item: " + items.get(i).getName() + ", Price: $" + items.get(i).getPrice());
                    }
                    break;
                case 2:
                    Collections.sort(items, Product.ProductID);
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println(items.get(i).getId() + " Item: " + items.get(i).getName() + ", Price: $" + items.get(i).getPrice());
                    }
                    break;
                case 3:
                    Collections.sort(items, Product.ProductPrice);
                    System.out.print("Enter the lower price point: $");
                    double lowpoint = scan.nextDouble();
                    System.out.print("Enter the upper price point: $");
                    double highpoint = scan.nextDouble();
                    for (int i = 0; i < items.size(); i++) {
                        if(items.get(i).getPrice() <= highpoint && items.get(i).getPrice() >= lowpoint) {
                            System.out.println(items.get(i).getId() + " Item: " + items.get(i).getName() + ", Price: $" + items.get(i).getPrice());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter the product ID: ");
                    productID = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter the product name: ");
                    productName = scan.nextLine();
                    System.out.print("Enter the product price: $");
                    productPrice = scan.nextDouble();
                    items.add(new Product(productID, productName, productPrice));
                    writer.write("\n" + productID + "|" + productName + "|" + productPrice);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Error: Invalid Option! Please choose a valid option!");
            }
        }
        while(option != 5);
        scan.close();
        writer.close();
    }
}
