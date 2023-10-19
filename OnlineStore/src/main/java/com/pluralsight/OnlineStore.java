package com.pluralsight;
import java.io.*;
import java.time.*;
import java.util.*;
import java.text.*;
public class OnlineStore {
    public static Scanner scan = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");
    public static HashMap<String, Product> items = new HashMap<>();
    public static HashMap<Integer, ProductCount> purchased = new HashMap<>();
    public static int itemsPurchased = 0;
    public static void main(String[] args) throws IOException {
        items = getItems();
        int option = 0;
        char condition = ' ';
        String search = "";
        do{
            System.out.println("What do you want to do?");
            System.out.println("\t1-Display Products");
            System.out.println("\t2-Display Cart");
            System.out.println("\t3-Quit the Application");
            System.out.print("Your Choice: ");
            option = scan.nextInt();
            scan.nextLine();
            switch(option) {
                case 1:
                    DisplayProducts();
                    break;
                case 2:
                    DisplayCart();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Error: Invalid Input");
                    break;
            }
        }
        while(option != 3);
    }

    public static HashMap<String, Product> getItems() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("products.csv"));
        String input = "";
        String productID = "";
        String productName = "";
        String productDepartment = "";
        double productPrice;
        HashMap<String, Product> tempMap = new HashMap<>();
        while((input = reader.readLine()) != null){
            String[] temp = input.split("\\|");
            if(!temp[0].contains("SKU")) {
                productName = temp[1].toUpperCase();
                productPrice = Double.parseDouble(temp[2]);
                productID = temp[0];
                productDepartment = temp[3];
                tempMap.put(productName, (new Product(productID, productName, productPrice, productDepartment)));
            }
        }
        reader.close();
        return tempMap;
    }
    public static HashMap<String, Product> SortByName(HashMap<String, Product> items){
        List<Map.Entry<String, Product>> list = new LinkedList<>(items.entrySet());
        Collections.sort(list, new Comparator<>() {
            public int compare(Map.Entry<String, Product> o1,
                               Map.Entry<String, Product> o2) {
                return o1.getValue().getName().compareToIgnoreCase(o2.getValue().getName());
            }
        });
        HashMap<String, Product> temp = new LinkedHashMap<String, Product>();
        for(Map.Entry<String, Product> aa : list){
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static HashMap<String, Product> SortByPrice(HashMap<String, Product> items){
        List<Map.Entry<String, Product>> list = new LinkedList<>(items.entrySet());
        Collections.sort(list, new Comparator<>() {
            public int compare(Map.Entry<String, Product> o1,
                               Map.Entry<String, Product> o2) {
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
        String productName = "";
        do{
            System.out.print("Enter a valid product name: ");
            productName = scan.nextLine().toUpperCase();
        }
        while(!items.containsKey(productName));
        System.out.print("Enter the quantity: ");
        int count = scan.nextInt();
        purchased.put(itemsPurchased, new ProductCount(items.get(productName).getId(), items.get(productName).getName(), items.get(productName).getPrice(), items.get(productName).getDepartment(), count));
        itemsPurchased++;
    }
    public static void removeProduct() throws IOException{
        String productName = "";
        boolean exist = false;
        int remove = 0;
        do{
            System.out.print("Enter a valid product name: ");
            productName = scan.nextLine();
            for(Map.Entry<Integer, ProductCount> aa : purchased.entrySet()){
                if(aa.getValue().getName().equalsIgnoreCase(productName)) {
                    exist = true;
                    remove = aa.getKey();
                }
            }
            if(!exist){
                System.out.println("Error: Product is not in your purchase list");
            }
        }
        while(!exist);
        purchased.remove(remove);
    }
    public static void DisplayProducts() throws IOException {
        items = SortByName(items);
        int option = 0;
        do {
            System.out.println("What do you want to do?");
            System.out.println("\t1-Search/filter for a product");
            System.out.println("\t2-Add a product to cart");
            System.out.println("\t3-Return to Home Screen");
            System.out.print("Your Choice: ");
            option = scan.nextInt();
            scan.nextLine();
            switch(option){
                case 1:
                    ProductSearch();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Error: Invalid Input");
                    break;
            }
        }
        while(option != 3);
    }
    public static void ProductSearch(){
        int subOption = 0;
        String productName = "";
        String department = "";
        do {
            System.out.println("How would you like to search/filter?");
            System.out.println("\t1-Product name");
            System.out.println("\t2-Product price");
            System.out.println("\t3-Product department");
            System.out.println("\t4-Quit Search");
            System.out.print("Your Choice: ");
            subOption = scan.nextInt();
            switch (subOption) {
                case 1:
                    scan.nextLine();
                    do {
                        System.out.print("Enter the name of the product you are looking for: ");
                        productName = scan.nextLine().toUpperCase();
                        if (!items.containsKey(productName)) {
                            System.out.println("Error: Product does not exist");
                        }
                    }
                    while (!items.containsKey(productName));
                    System.out.println(items.get(productName).getId() + " Item: " + items.get(productName).getName() + ", Price: $" + items.get(productName).getPrice() + ", Department: " + items.get(productName).getDepartment());
                    break;
                case 2:
                    items = SortByPrice(items);
                    System.out.print("Enter the lower price point: $");
                    double lowpoint = scan.nextDouble();
                    System.out.print("Enter the upper price point: $");
                    double highpoint = scan.nextDouble();
                    for (Map.Entry<String, Product> entry : items.entrySet()) {
                        if (entry.getValue().getPrice() <= highpoint && entry.getValue().getPrice() >= lowpoint) {
                            System.out.println(entry.getValue().getId() + " Item: " + entry.getValue().getName() + ", Price: $" + entry.getValue().getPrice() + ", Department: " + entry.getValue().getDepartment());
                        }
                    }
                    break;
                case 3:
                    do {
                        System.out.println("Which department would you like to filter from?");
                        System.out.println("\tAudio Video");
                        System.out.println("\tComputers");
                        System.out.println("\tGames");
                        System.out.println("\tElectronics");
                        System.out.print("Department: ");
                        department = scan.nextLine();
                        if (!department.equalsIgnoreCase("Audio Video") && !department.equalsIgnoreCase("Computers") && !department.equalsIgnoreCase("Games") && !department.equalsIgnoreCase("Electronics")) {
                            System.out.println("Error: Invalid Input");
                        }
                    }
                    while (!department.equalsIgnoreCase("Audio Video") && !department.equalsIgnoreCase("Computers") && !department.equalsIgnoreCase("Games") && !department.equalsIgnoreCase("Electronics"));
                    for (Map.Entry<String, Product> entry : items.entrySet()) {
                        if (entry.getValue().getDepartment().equalsIgnoreCase(department)) {
                            System.out.println(entry.getValue().getId() + " Item: " + entry.getValue().getName() + ", Price: $" + entry.getValue().getPrice() + ", Department: " + entry.getValue().getDepartment());
                        }
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Error: Invalid Input");
                    break;
            }
        }
        while(subOption != 4);
    }
    public static void DisplayCart() throws IOException {
        int option = 0;
        do {
            for (Map.Entry<Integer, ProductCount> aa : purchased.entrySet()) {
                System.out.println(aa.getValue().toString());
            }
            System.out.println("How would you like to do");
            System.out.println("\t1-Check Out");
            System.out.println("\t2-Remove Product from Cart");
            System.out.println("\t3-Return to Home Screen");
            System.out.print("Your Choice: ");
            option = scan.nextInt();
            switch(option){
                case 1:
                    CheckOut();
                    break;
                case 2:
                    scan.nextLine();
                    removeProduct();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Error: Invalid Input");
            }
        }
        while(option != 3 && option != 1);
    }
    public static void CheckOut() throws IOException {
        double sum = 0.0, changeDue = 0.0, tendered = 0.0;
        for(Map.Entry<Integer, ProductCount> aa : purchased.entrySet()){
            sum += aa.getValue().getPrice() * aa.getValue().getCount();
        }
        sum = Double.parseDouble(df.format(sum));
        System.out.println("Total due: $" + df.format(sum));
        System.out.print("Enter the amount tendered: $");
        tendered = scan.nextDouble();
        if(tendered >= sum){
            LocalDateTime now = LocalDateTime.now();
            BufferedWriter writer = new BufferedWriter(new FileWriter(now.getYear() + "" + now.getMonth() + "" + now.getDayOfMonth() + "" + now.getHour() + "" + now.getMinute() + ".txt"));
            changeDue = tendered - sum;
            System.out.println("Change Owed: $" + df.format(changeDue));
            System.out.println("Receipt:");
            writer.write("Change Owed: $" + df.format(changeDue) + "\nReceipt: \n");
            System.out.println(now);
            Collection<ProductCount> list = purchased.values();
            for(Iterator<ProductCount> itr = list.iterator(); itr.hasNext();){
                if(Collections.frequency(list, itr.next()) > 1){
                    itr.remove();
                }
            }
            for(Map.Entry<Integer, ProductCount> aa : purchased.entrySet()){
                System.out.println(aa.getValue().getId() + " Item: " + aa.getValue().getName() + ", Price: $" + aa.getValue().getPrice() + ", Quantity: " + aa.getValue().getCount());
                writer.write(aa.getValue().getId() + " Item: " + aa.getValue().getName() + ", Price: $" + aa.getValue().getPrice() + ", Quantity: " + aa.getValue().getCount());
                writer.newLine();
            }
            writer.close();
            purchased.clear();
        }
        else{
            System.out.println("Error: Invalid Amount Tendered");
        }
    }
}