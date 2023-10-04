package com.pluralsight;

import java.text.*;

public class MathApp {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args){
        question1();
        question2();
        question3();
        question4();
        question5();
        question6();
        question7();
    }

    private static void question1(){
        /* Question 1:
    Create two variables to represent the salary for Bob and Gary, name them bobSalary and garySalary.
    Create a new variable named highestSalary.
    Determine whose salary is greater using math.max() and store the answer in highestSalary.
    Set the initial salary variables to any value you want.
    Print the answer (i.e "The highest salary is ...")
     */
        int bobSalary = 100000, garySalary = 80000, highestSalary = 0;
        highestSalary = Math.max(bobSalary, garySalary);
        System.out.println("The highest salary is: $" + highestSalary);
    }

    private static void question2(){
        /* Question 2:
        Find and display the smallest of two variables named carPrice and truckPrice.
        Set the variables to any values you want.
         */
        int carPrice = 30000, truckPrice = 40000;
        System.out.println("The lower price is: $" + Math.min(carPrice, truckPrice));
    }

    private static void question3(){
        /* Question 3:
        Find and display the area of a circle whose radius is 7.25.
         */
        System.out.println("The area of a circle whose radius is 7.25 is: " + df.format((Math.PI * Math.pow(7.25, 2))));
    }

    private static void question4(){
        /* Question 4:
        Find and display the square root of a variable after it is set to 5.0.
         */
        double num_to_be_square_rooted = 5.0;
        System.out.println("The square root of " + num_to_be_square_rooted + " is: " +
                df.format(Math.sqrt(num_to_be_square_rooted)));
    }

    private static void question5(){
        /* Question 5:
        Find and display the distance between the points (5,10) and (85,50).
         */
        System.out.println("The distance between points (5,10) and (85,50) is: " +
                df.format(Math.sqrt(Math.pow((85 - 5), 2) + Math.pow((50 - 10), 2))));
    }

    private static void question6(){
        /* Question 6:
        Find and display the absolute (positive) value of a variable after it is set to -3.8.
         */
        double negative_number_to_be_absoluted = -3.8;
        System.out.println("The absolute (positive) value of " + negative_number_to_be_absoluted + " is: " +
                Math.abs(negative_number_to_be_absoluted));
    }

    private static void question7(){
        /* Question 7:
        Find and display a random number between 0 and 1.
         */
        System.out.println("A random number between 0 and 1 is: " + df.format(Math.random()));
    }
}