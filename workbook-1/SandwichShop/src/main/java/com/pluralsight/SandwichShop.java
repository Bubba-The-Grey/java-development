package com.pluralsight;

import java.util.*;

public class SandwichShop {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){

        double regular_price = 5.45, large_price = 8.95;
        double student_rate = 0.9, senior_rate = 0.8;
        double regular_loaded = 1.00, large_loaded = 1.75;
        double price;
        int age;
        String size, loaded;

        System.out.print("Enter the size of the sandwich (Regular or Large): ");
        size = getSize().toUpperCase();
        System.out.print("Enter your age: ");
        age = getAge();
        scan.nextLine();
        System.out.print("Will the sandwich be loaded? ");
        loaded = getLoad().toUpperCase();

        if(size.equals("LARGE")){

            if(loaded.equals("YES")) {

                if (age <= 17) {
                    price = (large_price + large_loaded) * student_rate;
                    System.out.printf("The cost of the sandwich is: $%.2f", price);
                } else if (age >= 65) {
                    price = (large_price + large_loaded) * senior_rate;
                    System.out.printf("The cost of the sandwich is: $%.2f", price);
                } else {
                    price = large_price + large_loaded;
                    System.out.printf("The cost of the sandwich is $%.2f", price);
                }
            }
            else {
                if (age <= 17) {
                    price = large_price * student_rate;
                    System.out.printf("The cost of the sandwich is: $%.2f", price);
                } else if (age >= 65) {
                    price = large_price * senior_rate;
                    System.out.printf("The cost of the sandwich is: $%.2f", price);
                } else {
                    price = large_price;
                    System.out.printf("The cost of the sandwich is $%.2f", price);
                }
            }
        }
        else if (size.equals("REGULAR")){

            if(loaded.equals("YES")) {

                if (age <= 17) {
                    price = (regular_price + regular_loaded) * student_rate;
                    System.out.printf("The cost of the sandwich is: $%.2f", price);
                } else if (age >= 65) {
                    price = (regular_price + regular_loaded) * senior_rate;
                    System.out.printf("The cost of the sandwich is: $%.2f", price);
                } else {
                    price = regular_price + regular_loaded;
                    System.out.printf("The cost of the sandwich is $%.2f", price);
                }
            }
            else {
                if (age <= 17) {
                    price = regular_price * student_rate;
                    System.out.printf("The cost of the sandwich is: $%.2f", price);
                } else if (age >= 65) {
                    price = regular_price * senior_rate;
                    System.out.printf("The cost of the sandwich is: $%.2f", price);
                } else {
                    price = regular_price;
                    System.out.printf("The cost of the sandwich is $%.2f", price);
                }
            }
        }

    }

    public static String getSize(){
        return scan.nextLine();
    }

    public static int getAge(){
        return scan.nextInt();
    }

    public static String getLoad() {
        return scan.nextLine();
    }
}
