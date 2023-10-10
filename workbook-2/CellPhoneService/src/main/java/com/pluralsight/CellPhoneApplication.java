package com.pluralsight;
import com.pluralsight.Cellphone;
import java.util.*;
public class CellPhoneApplication {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        Cellphone cellphone = new Cellphone();

        System.out.print("What is the serial number (1000000 - 9999999)? ");
        cellphone.setSerialNumber(scan.nextInt());
        scan.nextLine();
        System.out.print("What model is the phone? ");
        cellphone.setModel(scan.nextLine());
        System.out.print("Who is the carrier? ");
        cellphone.setCarrier(scan.nextLine());
        System.out.print("What is the phone number? ");
        cellphone.setPhoneNumber(scan.nextLine());
        System.out.print("Who is the owner of the phone? ");
        cellphone.setOwner(scan.nextLine());
        System.out.println();

        System.out.println("Owner: " + cellphone.getOwner());
        System.out.println("Phone Number: " + cellphone.getPhoneNumber());
        System.out.println("Model: " + cellphone.getModel());
        System.out.println("Serial Number: " + cellphone.getSerialNumber());
        System.out.println("Carrier: " + cellphone.getCarrier());
    }

}
