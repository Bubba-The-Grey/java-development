package com.pluralsight;

import java.util.*;
import java.text.*;

public class MortgageCalculator {

    public static Scanner scan = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args){

        double principal, interest_rate, monthly_payment, total_interest, interest_rate_decimal;
        int loan_length;

        System.out.print("Enter the principal: $");
        principal = getPrincipal();
        System.out.print("Enter the interest rate: ");
        interest_rate = getInterest();
        interest_rate_decimal = (interest_rate / 100);
        System.out.print("Enter the length of the loan in years: ");
        loan_length = getYears();

        monthly_payment = getPayment(principal, interest_rate_decimal, loan_length);
        total_interest = getInterestTotal(monthly_payment, principal, loan_length);


        System.out.println("A $" + principal + " loan at " + interest_rate + "% interest for " +
                loan_length + " years would have a $" + df.format(monthly_payment) + " / month payment with " +
                "a total interest of $" + df.format(total_interest));
    }

    public static double getPrincipal(){
        return scan.nextDouble();
    }

    public static double getInterest(){
        return scan.nextDouble();
    }

    public static int getYears(){
        return scan.nextInt();
    }

    public static double getPayment(double principal, double interest_rate_decimal, int loan_length){;

        double payment = 0.0;
        interest_rate_decimal /= 12;

        // M = P * (i / (1 - (1 + i)^-L
        payment = principal * interest_rate_decimal / (1 -
                Math.pow((1 + interest_rate_decimal), (-1 * (loan_length * 12))));

        return payment;
    }

    public static double getInterestTotal(double monthly_payment, double principal, int loan_length){

        double total_interest = 0.0;
        total_interest = (monthly_payment * (loan_length * 12)) - principal;

        return total_interest;
    }
}
