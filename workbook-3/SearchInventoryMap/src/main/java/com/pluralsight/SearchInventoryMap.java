package com.pluralsight;

import java.io.*;
import java.util.*;

public class SearchInventoryMap {
    public static HashMap<String, Product> items = new HashMap<String, Product>();
    public static void main(String[] args) throws IOException {
        items = loadInventory();
        Scanner scan = new Scanner(System.in);
        int option = 0;
        String search = "";
        do {
            System.out.println("What do you want to do?");
            System.out.println("\t1-List all products");
            System.out.println("\t2-Lookup a product by its id");
            System.out.println("\t3-Find all products within a price range");
            System.out.println("\t4-Add a new product");
            System.out.println("\t5-Search by product name");
            System.out.println("\t6-Quit the application");
            System.out.print("Your Choice: ");
            option = scan.nextInt();
            scan.nextLine();
            char condition = ' ';
            switch(option) {
                case 1:
                    items = SortByName(items);
                    for (Map.Entry<String, Product> entry : items.entrySet()) {
                        System.out.println(entry.getValue().getId() + " Item: " + entry.getValue().getName() + ", Price: $" + entry.getValue().getPrice());
                    }
                    break;
                case 2:
                    items = SortByID(items);
                    for (Map.Entry<String, Product> entry : items.entrySet()) {
                        System.out.println(entry.getValue().getId() + " Item: " + entry.getValue().getName() + ", Price: $" + entry.getValue().getPrice());
                    }
                    break;
                case 3:
                    items = SortByPrice(items);
                    System.out.print("Enter the lower price point: $");
                    double lowpoint = scan.nextDouble();
                    System.out.print("Enter the upper price point: $");
                    double highpoint = scan.nextDouble();
                    for (Map.Entry<String, Product> entry : items.entrySet()) {
                        if(entry.getValue().getPrice() <= highpoint && entry.getValue().getPrice() >= lowpoint) {
                            System.out.println(entry.getValue().getId() + " Item: " + entry.getValue().getName() + ", Price: $" + entry.getValue().getPrice());
                        }
                    }
                    break;
                case 4:
                    addProduct();
                    break;
                case 5:
                    do{
                        System.out.print("Enter the product you are looking for: ");
                        search = scan.nextLine();
                        if(items.get(search) != null) {
                            System.out.println(items.get(search).getId() + " Item: " + items.get(search).getName() + ", Price: $" + items.get(search).getPrice());
                            System.out.print("Would you like to search for another item (Y/N)? ");
                            search = scan.nextLine();
                            condition = search.charAt(0);
                        }
                        else{
                            System.out.println("Error: Product is not in database");
                        }
                    }
                    while(condition != 'N' && condition != 'n');
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Error: Invalid Option! Please choose a valid option!");
            }
        }
        while(option != 6);
        scan.close();
    }
    public static HashMap<String, Product> loadInventory() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
        String input = "";
        int productID = 0;
        String productName = "";
        double productPrice;
        HashMap<String, Product> tempMap = new HashMap<String, Product>();
        while((input = reader.readLine()) != null){
            String[] temp = input.split("\\|");
            productName = temp[1];
            productPrice = Double.parseDouble(temp[2]);
            productID = Integer.parseInt(temp[0]);
            tempMap.put(productName, (new Product(productID, productName, productPrice)));
        }
        reader.close();
        return tempMap;
    }
    public static HashMap<String, Product> SortByName(HashMap<String, Product> items){
        List<Map.Entry<String, Product>> list = new LinkedList<Map.Entry<String, Product>>(items.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Product> >() {
            public int compare(Map.Entry<String, Product> o1,
                               Map.Entry<String, Product> o2)
            {
                return o1.getValue().getName().compareToIgnoreCase(o2.getValue().getName());
            }
        });
        HashMap<String, Product> temp = new LinkedHashMap<String, Product>();
        for(Map.Entry<String, Product> aa : list){
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static HashMap<String, Product> SortByID(HashMap<String, Product> items){
        List<Map.Entry<String, Product>> list = new LinkedList<Map.Entry<String, Product>>(items.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Product> >() {
            public int compare(Map.Entry<String, Product> o1,
                               Map.Entry<String, Product> o2)
            {
                return o1.getValue().getId() - o2.getValue().getId();
            }
        });
        HashMap<String, Product> temp = new LinkedHashMap<String, Product>();
        for(Map.Entry<String, Product> aa : list){
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static HashMap<String, Product> SortByPrice(HashMap<String, Product> items){
        List<Map.Entry<String, Product>> list = new LinkedList<Map.Entry<String, Product>>(items.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Product> >() {
            public int compare(Map.Entry<String, Product> o1,
                               Map.Entry<String, Product> o2)
            {
                return (int) (o1.getValue().getPrice() - o2.getValue().getPrice());
            }
        });
        HashMap<String, Product> temp = new LinkedHashMap<String, Product>();
        for(Map.Entry<String, Product> aa : list){
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static void addProduct() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv", true));
        Scanner newScan = new Scanner(System.in);
        System.out.print("Enter the product ID: ");
        int productID = newScan.nextInt();
        newScan.nextLine();
        System.out.print("Enter the product name: ");
        String productName = newScan.nextLine();
        System.out.print("Enter the product price: $");
        double productPrice = newScan.nextDouble();
        items.put(productName, new Product(productID, productName, productPrice));
        writer.write("\n" + productID + "|" + productName + "|" + productPrice);
        writer.close();
    }
}