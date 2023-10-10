package com.pluralsight;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;
public class TheaterReservations {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        System.out.print("Please enter your name (firstname lastname): ");
        String name = scan.nextLine();
        name = name.trim();
        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        String date = scan.nextLine();
        date = date.trim();
        System.out.print("How many tickets would you like? ");
        int tickets = scan.nextInt();
        System.out.println();

        String[] names = name.split("\\ ");

        LocalDate reservationDate = LocalDate.parse(date, formatter);
        if(tickets > 1){
            System.out.println(tickets + " tickets reserved for " + reservationDate + " under " + names[1] +
                    ", " + names[0]);
        }
        else{
            System.out.println(tickets + " ticket reserved for " + reservationDate + " under " + names[1] +
                    ", " + names[0]);
        }
    }
}
