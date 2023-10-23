package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.time.*;
import java.time.format.*;
public class AccountingLedger {

    // Creating an ArrayList of Transactions as well as a universal input scanner
    public static ArrayList<Transaction> transactions = new ArrayList<>();
    public static Scanner scan = new Scanner(System.in);


    // Load Ledger Method
    public static void loadTransactions() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"));
        String input = "";
        String[] inputs;
        LocalDate date;
        LocalTime time;
        String vendor, description;
        double amount;
        while((input = reader.readLine()) != null){
            inputs  = input.split("\\|");
            if(!inputs[0].equalsIgnoreCase("date")){
                date = LocalDate.parse(inputs[0]);
                time = LocalTime.parse(inputs[1]);
                description = inputs[2];
                vendor = inputs[3];
                amount = Double.parseDouble(inputs[4]);
                transactions.add(new Transaction(date, time, vendor, description, amount));
            }
        }
        reader.close();
    }

    // Main Method, also Home Screen
    public static void main(String[] args) throws IOException {

        // Loads Ledger
        loadTransactions();

        // Greetings
        System.out.println("Welcome to the Ledger!");

        // User Options for Home Screen
        int input = 0;
        do{
            System.out.println("What would you like to do?");
            System.out.println("\t1 - Add a Deposit");
            System.out.println("\t2 - Add a Payment(Debit)");
            System.out.println("\t3 - View Ledger");
            System.out.println("\t4 - Exit Program");
            System.out.print("Your Choice: ");
            input = scan.nextInt();


            // Switch Case for selecting option based on User Input
            switch (input){
                case 1:
                    addDeposit();
                    break;
                case 2:
                    addPayment();
                    break;
                case 3:
                    viewLedger();
                    break;
                case 4:
                    System.out.println("Exiting Program...");
                    break;
                default:
                    System.out.println("ERROR: Invalid Input (please enter 1, 2, 3, or 4");
            }
        } while (input != 4);
    }

}
