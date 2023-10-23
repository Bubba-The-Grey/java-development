package com.pluralsight;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.time.*;
import java.time.format.*;
public class AccountingLedger {

    // Creating a HashMap of Transactions as well as a universal formats
    public static HashMap<Integer, Transaction> transactions = new HashMap<>();
    public static int count = 0;
    public static Scanner scan = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");
    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    public static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm:ss");


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
                transactions.put(count, new Transaction(date, time, description, vendor, amount));
                count++;
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
            scan.nextLine();


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



    // Make a Deposit method
    public static void addDeposit() throws  IOException{
        System.out.println("Enter the date of deposit (use format MM/DD/YYYY or leave blank for system date): ");
        String date = scan.nextLine();
        System.out.println("Enter the time of deposit (use format HH:MM:SS or leave blank for system time): ");
        String time = scan.nextLine();
        System.out.println("Enter the description of the deposit: ");
        String description = scan.nextLine();
        System.out.println("Enter the vendor of the deposit: ");
        String vendor = scan.nextLine();
        System.out.println("Enter the amount deposited: $");
        double amount = Double.parseDouble(df.format(scan.nextLine()));
        boolean sure = false;
        if(amount > 0){
            sure = true;
        }
        while (!sure){
            System.out.print("Are you sure you want to enter a negative value? Deposits are usually positive (Y/N): ");
            String positive = scan.nextLine().substring(0, 1).toUpperCase();
            if(positive.equals("Y")){
                sure = true;
            }
            else{
                System.out.println("Enter the amount deposited: $");
                amount = Double.parseDouble(df.format(scan.nextLine()));
                if(amount > 0){
                    sure = true;
                }
            }
        }
        transactions.put(count, new Transaction(LocalDate.parse(date, dateFormatter), LocalTime.parse(time, timeFormatter), description, vendor, amount));
        BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv", true));
        writer.write(transactions.get(count).toString());
        writer.close();
        count++;
    }
    public static void addPayment() throws IOException{
        System.out.println("Enter the date of payment (use format MM/DD/YYYY or leave blank for system date): ");
        String date = scan.nextLine();
        System.out.println("Enter the time of payment (use format HH:MM:SS or leave blank for system time): ");
        String time = scan.nextLine();
        System.out.println("Enter the description of the payment: ");
        String description = scan.nextLine();
        System.out.println("Enter the vendor of the payment: ");
        String vendor = scan.nextLine();
        System.out.println("Enter the amount payment: $");
        double amount = Double.parseDouble(df.format(scan.nextLine()));
        boolean sure = false;
        if(amount < 0){
            sure = true;
        }
        while (!sure){
            System.out.print("Are you sure you want to enter a positive value? Payments are usually negative (Y/N): ");
            String positive = scan.nextLine().trim().substring(0, 1).toUpperCase();
            if(positive.equals("Y")){
                sure = true;
            }
            else{
                System.out.println("Enter the amount deposited: $");
                amount = Double.parseDouble(df.format(scan.nextLine()));
                if(amount < 0){
                    sure = true;
                }
            }
        }
        transactions.put(count, new Transaction(LocalDate.parse(date, dateFormatter), LocalTime.parse(time, timeFormatter), description, vendor, amount));
        BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv", true));
        writer.write(transactions.get(count).toString());
        writer.close();
        count++;
    }

}
