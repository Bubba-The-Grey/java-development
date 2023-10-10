package com.pluralsight;
import java.util.*;
public class FullNameParser {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        String name = "", firstName = "", middleName = "", lastName = "";

        System.out.print("Please enter your name (\"first last\" or \"first middle last\"): ");
        name = scan.nextLine();
        name = name.trim();
        firstName = name.substring(0, name.indexOf(" "));
        name = name.substring(name.indexOf(" ") + 1);
        if(name.contains(" ")) {
            middleName = name.substring(0, name.indexOf(" "));
            name = name.substring(name.indexOf(" ") + 1);
            lastName = name;
        }
        else{
            lastName = name;
        }
        System.out.println("First name: " + firstName + "\nMiddle name: " + middleName + "\nLast name: " + lastName);
    }
}
