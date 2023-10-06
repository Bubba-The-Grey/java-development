package com.pluralsight;
//imports
import java.util.*;
import java.text.*;

public class AnnuityCalculator {
    //initialize input and format
    public static Scanner scan = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");

    //main method
    public static void main(String[] args){
        //declare variables
        double monthly_payout, interest_rate, present_value;
        int years;

        //assign variables through inputs
        System.out.print("Enter the monthly payout: $");
        monthly_payout = getPayout();
        System.out.print("Enter the expected interest rate: ");
        interest_rate = getInterest();
        System.out.print("Enter the number of years: ");
        years = getYears();

        //assign variables through methods
        present_value = getValue(monthly_payout, interest_rate, years);

        //output
        System.out.println("To fund an annuity that pays $" + monthly_payout + " monthly for " +
                years + " years and earns an expected " + interest_rate + "% interest, you " +
                "would need to invest $" + df.format(present_value) + " today.");
    }

    //methods
    public static double getPayout(){
        return scan.nextDouble();
    }

    public static double getInterest(){
        return scan.nextDouble();
    }

    public static int getYears(){
        return scan.nextInt();
    }

    public static double getValue(double payment, double interest, int years){
        //calculations done here to avoid clutter in main
        //Present Value = Payment * ((1 - (1 + interest)^-num_payments) / interest)
        double present = 0.0;

        interest /= 1200;
        present = payment * (( 1 - Math.pow((1 + interest), (-1 * (years * 12)))) / interest);
        return present;
    }
}
