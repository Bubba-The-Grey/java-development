package com.pluralsight;
//imports
import java.util.*;
import java.text.*;

public class FutureValueCalculator {
    //initialize input and format
    public static Scanner scan = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args){
        //declare variables
        double deposit, interest_rate, future_value, total_interest;
        int years;

        //assign variables from input
        System.out.print("Enter the deposit amount for the CD: $");
        deposit = getDeposit();
        System.out.print("Enter the interest rate: ");
        interest_rate = getInterestRate();
        interest_rate /= 100;
        System.out.print("Enter the number of year for it to mature: ");
        years = getYears();

        //assign variables from calculation methods
        future_value = getFuture(deposit, interest_rate, years);
        total_interest = getTotalInterest(deposit, future_value);


        //output
        System.out.println("If you deposit $" + deposit + " in a CD that earns " +
                interest_rate + "% interest and matures in " + years + "years, " +
                "your CD's ending balance will be $" + df.format(future_value) +
                " and you will have earned $" + df.format(total_interest) +
                " in interest.");
    }

    //methods
    public static double getDeposit(){
        return scan.nextDouble();
    }

    public static double getInterestRate(){
        return scan.nextDouble();
    }

    public static int getYears(){
        return scan.nextInt();
    }

    public static double getFuture(double deposit, double interest_rate, int years){
        double future = deposit;

        for(int i = 0; i < years; i++){
            future *= (1 + interest_rate);
        }
        return future;
    }

    public static double getTotalInterest(double deposit, double future_value){
        double total_interest;

        total_interest = future_value - deposit;

        return total_interest;
    }
}
