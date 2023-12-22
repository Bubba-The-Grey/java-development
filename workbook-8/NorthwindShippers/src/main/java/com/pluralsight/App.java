package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.util.*;

public class App {
    public static Scanner scan = new Scanner(System.in);
    public static String userInput = "";

    public static void main(String[] args) {
        String username = System.getenv("MY_DB_USERNAME");
        String password = System.getenv("MY_DB_PASSWORD");
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/Northwind");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        NorthwindDataManager dataManager = new NorthwindDataManager(dataSource);
        System.out.println("Welcome to Northwind Shippers!");
        while (true) {
            System.out.println("""
                    What would you like to do?
                    1) Add A Shipper
                    2) View Shippers
                    3) Update A Shipper
                    4) Delete A Shipper
                    0) Exit
                    Please enter your choice with the corresponding number""");
            userInput = scan.nextLine();
            switch (userInput) {
                case "1":
                    addAShipper(dataManager);
                    break;
                case "2":
                    viewShippers(dataManager);
                    break;
                case "3":
                    updateAShipper(dataManager);
                    break;
                case "4":
                    deleteAShipper(dataManager);
                    break;
                case "0":
                    scan.close();
                    try {
                        dataSource.close();
                    } catch (SQLException e) {
                        System.out.println("Error occurred while closing the dataSource");
                    }
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("ERROR: please choose a valid input");
                    break;
            }
        }
    }

    public static void addAShipper(NorthwindDataManager dataManager) {
        System.out.println("Enter the name of the Shipper");
        String name = scan.nextLine();
        System.out.println("Enter the phone number of the Shipper (format it as ###-###-####)");
        String number = scan.nextLine();
        dataManager.addShipper(name, number);
    }
    public static void viewShippers(NorthwindDataManager dataManager){
        List<Shipper> shippers;
        shippers = dataManager.viewShippers();
        if(shippers != null) {
            for (Shipper s : shippers) {
                System.out.println(s.toString());
            }
        }
    }
    public static void updateAShipper(NorthwindDataManager dataManager){
        List<Shipper> shippers;
        shippers = dataManager.viewShippers();
        System.out.println("Enter the ID of the Shipper you want to update (enter -1 if you don't want to, it will return an error message but ignore it)");
        userInput = scan.nextLine();
        boolean exists = false;
        for(Shipper s: shippers){
            if(s.getId() == Integer.parseInt(userInput)){
                exists = true;
                break;
            }
        }
        if(exists){
            System.out.println("Enter the name you want the Shipper to be");
            String name = scan.nextLine();
            System.out.println("Enter the number you want the Shipper to have (format it as ###-###-####)");
            String number = scan.nextLine();
            dataManager.updateShipper(userInput, name, number);
        }
        else{
            System.out.println("Sorry, that Shipper does not exist");
        }
    }
    public static void deleteAShipper(NorthwindDataManager dataManager){
        List<Shipper> shippers;
        shippers = dataManager.viewShippers();
        System.out.println("Enter the ID of the Shipper you want to delete (enter -1 if you don't want to, it will return an error message but ignore it)");
        userInput = scan.nextLine();
        boolean exists = false;
        for(Shipper s: shippers){
            if(s.getId() == Integer.parseInt(userInput)){
                exists = true;
                break;
            }
        }
        if(exists){
            dataManager.deleteShipper(userInput);
        }
        else{
            System.out.println("Sorry, that Shipper does not exist");
        }
    }
}
