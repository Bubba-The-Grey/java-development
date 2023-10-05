package com.pluralsight;

import java.text.*;
import java.util.*;
public class PayrollCalculator {

    public static Scanner scan = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args){

        String name;
        float hours_worked, pay_rate;

        System.out.print("Enter your name: ");
        name = getName();
        System.out.print("Enter your hours worked: ");
        hours_worked = getHours();
        System.out.print("Enter your hourly pay rate: $");
        pay_rate = getPayRate();

        if (hours_worked > 40.00){
            System.out.println("Employee: " + name + "\nGross pay: $" +
                    df.format((40 * pay_rate) + ((hours_worked - 40) * (pay_rate * 1.5))));
        }
        else{
            System.out.println("Employee: " + name + "\nGross pay: $" + df.format(pay_rate * hours_worked));
        }
    }

    public static String getName(){
        String name = scan.nextLine();
        return name;
    }

    public static float getHours(){
        float hours = scan.nextFloat();
        return hours;
    }

    public static float getPayRate(){
        float pay_rate = scan.nextFloat();
        return pay_rate;
    }
}
