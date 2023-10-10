package com.pluralsight;

import java.util.*;
public class AddressBuilder {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        StringBuilder address = new StringBuilder();

        System.out.print("Please provide the following information:\nFull name: ");
        address.append(scan.nextLine());
        System.out.println();

        address.append("\n\nBilling Address:\n");
        System.out.print("Billing Street: ");
        address.append(scan.nextLine() + "\n");
        System.out.print("Billing City: ");
        address.append(scan.nextLine() + ", ");
        System.out.print("Billing State: ");
        address.append(scan.nextLine() + " ");
        System.out.print("Billing Zipcode: ");
        address.append(scan.nextLine());
        System.out.println();

        address.append("\n\nShipping Address:\n");
        System.out.print("Shipping Street: ");
        address.append(scan.nextLine() + "\n");
        System.out.print("Shipping City: ");
        address.append(scan.nextLine() + ", ");
        System.out.print("Shipping State: ");
        address.append(scan.nextLine() + " ");
        System.out.print("Shipping Zipcode: ");
        address.append(scan.nextLine());
        System.out.println();

        String fullAddress = address.toString();
        System.out.println(fullAddress);
    }
}
