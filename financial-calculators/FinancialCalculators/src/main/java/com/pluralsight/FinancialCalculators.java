package com.pluralsight;
//imports
import java.util.*;
import java.text.*;
public class FinancialCalculators {
    //initialize input and format
    public static Scanner scan = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");

    //main method
    public static void main(String[] args){
        //declare variables
        int option;
        do {
            System.out.print("Enter the number of the calculator you wish to use:" +
                    "\n(1) Mortgage Calculator\n(2) Certificate of Deposit Calculator" +
                    "\n(3) Annuity Calculator\n(0) Exit Program\nChoice: ");
            option = scan.nextInt();
        }
        while (option < 0 && option > 3);
        switch (option){
            case 1:
                MortgageCalculator();
                break;
            case 2:
                CDCalculator();
                break;
            case 3:
                AnnuityCalculator();
                break;
            default:
                System.exit(0);
        }
    }

    //Mortgage Calculator method
    public static void MortgageCalculator(){
        //declare variables
        double principal, interest_rate, monthly_payment, total_interest, interest_rate_decimal;
        int loan_length;

        //assign variables from input
        System.out.print("Enter the principal: $");
        principal = getPrincipal();
        System.out.print("Enter the interest rate: ");
        interest_rate = getInterest();
        interest_rate_decimal = (interest_rate / 100);
        System.out.print("Enter the length of the loan in years: ");
        loan_length = getYears();

        //assign variables from calculations
        monthly_payment = getPayment(principal, interest_rate_decimal, loan_length);
        total_interest = getInterestTotal(monthly_payment, principal, loan_length);

        //output
        System.out.println("A $" + principal + " loan at " + interest_rate + "% interest for " +
                loan_length + " years would have a $" + df.format(monthly_payment) + " / month payment with " +
                "a total interest of $" + df.format(total_interest));
    }

    //Certificate of Deposit Calculator method
    public static void CDCalculator(){
        //declare variables
        double deposit, interest_rate, future_value, total_interest;
        int years;

        //assign variables from input
        System.out.print("Enter the deposit amount for the CD: $");
        deposit = getDeposit();
        System.out.print("Enter the interest rate: ");
        interest_rate = getInterest();
        interest_rate /= 100;
        System.out.print("Enter the number of year for it to mature: ");
        years = getYears();

        //assign variables from calculation methods
        future_value = getFuture(deposit, interest_rate, years);
        total_interest = getTotalInterest(deposit, future_value);


        //output
        System.out.println("If you deposit $" + deposit + " in a CD that earns " +
                interest_rate + "% interest and matures in " + years + " years, " +
                "your CD's ending balance will be $" + df.format(future_value) +
                " and you will have earned $" + df.format(total_interest) +
                " in interest.");
    }

    //Annuity Calculator method
    public static void AnnuityCalculator(){
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

    //methods used for calculations and inputs
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
        //monthly payment math done here to avoid clutter in main method
        double payment = 0.0;
        interest_rate_decimal /= 12;

        // M = P * (i / (1 - (1 + i)^-L
        payment = principal * interest_rate_decimal / (1 -
                Math.pow((1 + interest_rate_decimal), (-1 * (loan_length * 12))));

        return payment;
    }

    public static double getInterestTotal(double monthly_payment, double principal, int loan_length){
        //interest total math done here to avoid clutter in main method
        double total_interest = 0.0;
        total_interest = (monthly_payment * (loan_length * 12)) - principal;

        return total_interest;
    }

    public static double getDeposit(){
        return scan.nextDouble();
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

    public static double getPayout(){
        return scan.nextDouble();
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
