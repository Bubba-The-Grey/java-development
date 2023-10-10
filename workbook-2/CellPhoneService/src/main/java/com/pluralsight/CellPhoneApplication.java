package com.pluralsight;
import com.pluralsight.Cellphone;
import java.util.*;
public class CellPhoneApplication {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){

        Cellphone cellphone1 = new Cellphone();

        System.out.print("What is the serial number (1000000 - 9999999)? ");
        cellphone1.setSerialNumber(scan.nextInt());
        scan.nextLine();
        System.out.print("What model is the phone? ");
        cellphone1.setModel(scan.nextLine());
        System.out.print("Who is the carrier? ");
        cellphone1.setCarrier(scan.nextLine());
        System.out.print("What is the phone number? ");
        cellphone1.setPhoneNumber(scan.nextLine());
        System.out.print("Who is the owner of the phone? ");
        cellphone1.setOwner(scan.nextLine());
        System.out.println();

        Cellphone cellphone2 = new Cellphone();
        System.out.print("What is the serial number (1000000 - 9999999)? ");
        cellphone2.setSerialNumber(scan.nextInt());
        scan.nextLine();
        System.out.print("What model is the phone? ");
        cellphone2.setModel(scan.nextLine());
        System.out.print("Who is the carrier? ");
        cellphone2.setCarrier(scan.nextLine());
        System.out.print("What is the phone number? ");
        cellphone2.setPhoneNumber(scan.nextLine());
        System.out.print("Who is the owner of the phone? ");
        cellphone2.setOwner(scan.nextLine());
        System.out.println();

        Cellphone cellphone3 = new Cellphone(3213213, "iPhone 15 Max", "Boost",
                "321-123-3213", "LEEROY JENKINS");

        display(cellphone1);
        display(cellphone2);
        display(cellphone3);

        cellphone1.dial(cellphone2.getPhoneNumber());
        cellphone2.dial(cellphone1.getPhoneNumber());
        cellphone3.dial(cellphone1);
    }

    public static void display(Cellphone cellphone){
        System.out.println("Owner: " + cellphone.getOwner());
        System.out.println("Phone Number: " + cellphone.getPhoneNumber());
        System.out.println("Model: " + cellphone.getModel());
        System.out.println("Serial Number: " + cellphone.getSerialNumber());
        System.out.println("Carrier: " + cellphone.getCarrier());
    }

}
