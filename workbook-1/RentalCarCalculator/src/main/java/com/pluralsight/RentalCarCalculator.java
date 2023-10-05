package com.pluralsight;

import java.util.*;
import java.text.*;
public class RentalCarCalculator {

    public static Scanner scan = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args){

        String pickup_date, electronic_toll_tag, GPS, roadside_assistance;
        int days_of_rental, age;
        double total_rental;
        double ETT_rental = 3.95, GPS_rental = 2.95, RA_rental = 3.95, underage_surcharge = 0.30, car_rental = 29.99;

        System.out.print("Enter the pickup date: ");
        pickup_date = getDate();

        System.out.print("Do you want an Electronic Toll Tag ($3.95/day)? ");
        electronic_toll_tag = getTag().toUpperCase();

        System.out.print("Do you want GPS ($2.95/day)? ");
        GPS = getGPS().toUpperCase();

        System.out.print("Do you want Roadside Assistance ($3.95/day)? ");
        roadside_assistance = getRA().toUpperCase();

        System.out.print("Enter the days for the rental: ");
        days_of_rental = getDays();

        System.out.print("Enter your age: ");
        age = getAge();

        String output = "Your results:\nBasic Rental ($29.99/day): " + (car_rental * days_of_rental);
        total_rental = car_rental * days_of_rental;

        if(electronic_toll_tag.equals("YES")){
            total_rental += (ETT_rental * days_of_rental);
            output += ("\nElectronic Toll Tag ($3.95/day): $" + (ETT_rental * days_of_rental));
        }
        if(GPS.equals("YES")){
            total_rental += (GPS_rental * days_of_rental);
            output += ("\nGPS ($2.95/day): $" + (GPS_rental * days_of_rental));
        }
        if(roadside_assistance.equals("YES")){
            total_rental += (RA_rental * days_of_rental);
            output += ("\nRoadside Assistance ($3.95/day): $" + (RA_rental * days_of_rental));
        }
        if(age < 25){
            output += ("\nUnderage Surcharge (30%): $" + df.format(total_rental * underage_surcharge));
            total_rental *= (1 + underage_surcharge);
        }
        output += ("\nTotal cost for rental: $" + df.format(total_rental));

        System.out.println(output);

    }

    public static String getDate(){
        return scan.nextLine();
    }

    public static String getTag(){
        return scan.nextLine();
    }

    public static String getGPS(){
        return scan.nextLine();
    }

    public static String getRA(){
        return scan.nextLine();
    }

    public static int getDays(){
        return scan.nextInt();
    }

    public static int getAge(){
        return scan.nextInt();
    }
}
