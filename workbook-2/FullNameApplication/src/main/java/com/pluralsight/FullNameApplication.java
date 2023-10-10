package com.pluralsight;

import java.util.Scanner;

public class FullNameApplication {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        String firstName = "", middleName = "", lastName = "", suffix = "", fullName = "";

        System.out.print("Please enter your name\nFirst name: ");
        firstName = scan.nextLine();
        System.out.print("Middle name: ");
        middleName = scan.nextLine();
        System.out.print("Last name: ");
        lastName = scan.nextLine();
        System.out.print("Suffix: ");
        suffix = scan.nextLine();
        if(!suffix.equals("")) {
            fullName = firstName + " " + middleName + " " + lastName + ", " + suffix;
        }
        else {
            fullName = firstName + " " + middleName + " " + lastName;
        }
        while (fullName.contains("  ")) {
            fullName = fullName.replace("  ", " ");
        }
        System.out.println();
        System.out.println("Full name: " + fullName);
    }
}
