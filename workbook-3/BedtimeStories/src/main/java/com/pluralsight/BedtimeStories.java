package com.pluralsight;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
public class BedtimeStories {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        do{
            System.out.println("Enter (1) for \"Goldilocks\", (2) for \"Hansel and Gretel\", (3) for \"Mary had a little lamb\", (0) for Exit");
            System.out.print("Enter your choice: ");
            input =  scan.nextInt();
            switch(input){
                case 1:
                    goldilocks();
                    break;
                case 2:
                    hansel();
                    break;
                case 3:
                    mary();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please enter a valid option!");
                    break;
            }
        }
        while(input != 0);
        scan.close();
    }
    public static void goldilocks() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("goldilocks.txt");
        Scanner scan = new Scanner(fis);
        String story = "";
        int count = 1;
        while(scan.hasNextLine()){
            story = scan.nextLine();
            System.out.println("(" + count + ") " + story);
            count++;
        }
        scan.close();
    }
    public static void hansel() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("hansel_and_gretel.txt");
        Scanner scan = new Scanner(fis);
        String story = "";
        int count = 1;
        while(scan.hasNextLine()){
            story = scan.nextLine();
            System.out.println("(" + count + ") " + story);
            count++;
        }
        scan.close();
    }
    public static void mary() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("mary_had_a_little_lamb.txt");
        Scanner scan = new Scanner(fis);
        String story = "";
        int count = 1;
        while(scan.hasNextLine()){
            story = scan.nextLine();
            System.out.println("(" + count + ") " + story);
            count++;
        }
        scan.close();
    }
}
