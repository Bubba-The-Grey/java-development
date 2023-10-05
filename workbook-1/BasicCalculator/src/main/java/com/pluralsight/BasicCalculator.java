package com.pluralsight;

import java.util.*;

public class BasicCalculator {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        float first_num, second_num;
        char operation;

        System.out.print("Enter the first number: ");
        first_num = getNum();
        System.out.print("Enter the second number: ");
        second_num = getNum();
        scan.nextLine();

        System.out.println("Possible calculations: \n (A)dd \n (S)ubtract \n (M)ultiply \n (D)ivide");
        System.out.print("Please select an option: ");
        operation = getOperation();
        switch (operation){
            case 'A':
                System.out.println(first_num + " + " + second_num + " = " + (first_num + second_num));
                break;
            case 'S':
                System.out.println(first_num + " - " + second_num + " = " + (first_num - second_num));
                break;
            case 'M':
                System.out.println(first_num + " * " + second_num + " = " + (first_num * second_num));
                break;
            case 'D':
                System.out.println(first_num + " / " + second_num + " = " + (first_num / second_num));
                break;
        }
    }

    public static float getNum(){
        float num;
        num = scan.nextFloat();
        return num;
    }

    public static char getOperation(){
        char operation = ' ';
        do {
            System.out.print("Please select an option: ");
            operation = Character.toUpperCase(scan.nextLine().charAt(0));
        }
        while (operation != 'A' && operation != 'S' && operation != 'M' && operation != 'D');
        return operation;
    }
}
