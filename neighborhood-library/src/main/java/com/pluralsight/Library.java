package com.pluralsight;
import java.util.*;
public class Library {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        int homeScreen = 0;

        Book[] book = new Book[20];
        book[0] = new Book(1, "192-56-1234", "Lord of the Necklaces", "", false);
        book[1] = new Book(2, "312-43-4321", "Hairy Potter", "Alex", true);
        book[2] = new Book(3, "180-23-6547", "Dialon: Legacy of Life", "Jake", true);
        book[3] = new Book(4, "349-87-7592", "Biography of Zarc Muckerburg", "", false);
        book[4] = new Book(5, "654-43-3210", "Wohn Jayne's Thanksgiving", "Joshua", true);
        book[5] = new Book(6, "541-67-8901", "The Legend of Tom Petty", "", false);
        book[6] = new Book(7, "164-678-9045", "The Journal", "Andi", true);
        book[7] = new Book(8, "145-67-8963", "Revolutions: A Study by Dr. Dave Jeremy", "Jake", true);
        book[8] = new Book(9, "653-86-9876", "Turtles: A Life Story", "Clancy", true);
        book[9] = new Book(10, "236-78-4376", "HAMMER", "Tank Tolman", true);
        book[10] = new Book(11, "739-13-4567", "The Bee Book", "", false);
        book[11] = new Book(12, "541-65-8357", "Blitzing Ballroom", "", false);
        book[12] = new Book(13, "363-63-6363", "Blue's Cross Road", "Ivan", true);
        book[13] = new Book(14, "156-97-4346", "The Legendary Lizard-Man", "Joshua", true);
        book[14] = new Book(15, "647-82-2037", "Flying Lords", "", false);
        book[15] = new Book(16, "453-79-9047", "Autobiography of Frankie Ben", "", false);
        book[16] = new Book(17, "920-73-9324", "Codewars: A Novice's Journey", "Chris", true);
        book[17] = new Book(18, "498-93-7295", "IntelliJentalmen: The Gentlemen Programmers", "Chris", true);
        book[18] = new Book(19, "439-93-2398", "I Like Turtles: A Romance Story", "", false);
        book[19] = new Book(20, "230-39-3584", "There Is No Book", "Rickey", true);

        do {
            System.out.print("Welcome to your neighborhood library!\n1 - Show Available Books\n2 - Show" +
                    " Checked Out Books\n0 - Exit\nPlease enter the number associated with your choice: ");
            homeScreen = scan.nextInt();
            switch(homeScreen){
                case 1:
                    AvailableBooks(book);
                    break;
                case 2:
                    CheckedOutBooks(book);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("ERROR - input 1, 2, or 0 please");
                    homeScreen = 0;
            }
        }
        while(homeScreen >= 0 && homeScreen <= 2);
    }

    public static void AvailableBooks(Book[] book){
        int option = 1, id = 0;
        String name = "";
        do {
            System.out.println("Currently available books: ");
            for (int i = 0; i < book.length; i++) {
                if (book[i].getIsCheckedOut() == false) {
                    System.out.println(book[i].toStringAvailable());
                }
            }
            System.out.print("What would you like to do?\n1 - Check out a book\n0 - Return to Home Screen\nEnter your choice: ");
            option = scan.nextInt();
            scan.nextLine();
            switch(option){
                case 1:
                    System.out.print("Enter the name of the person checking out the book: ");
                    name = scan.nextLine();
                    System.out.print("Enter the ID of the book getting checked out: ");
                    id = scan.nextInt();
                    for(int i = 0; i < book.length; i++){
                        if(book[i].getId() == id){
                            book[i].checkOut(name);
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("ERROR - input 1 or 0 please");
                    option = 1;
            }
        }
        while(option != 0);
    }
    public static void CheckedOutBooks(Book[] book){
        int option = 1, id = 0;
        do{
            System.out.println("Currently checked out books: ");
            for (int i = 0; i < book.length; i++) {
                if (book[i].getIsCheckedOut() == true) {
                    System.out.println(book[i].toStringAvailable());
                }
            }
            System.out.print("What would you like to do?\n1 - Check in a book\n0 - Return to Home Screen\nEnter your choice: ");
            option = scan.nextInt();
            scan.nextLine();
            switch(option){
                case 1:
                    System.out.print("Enter the ID of the book getting checked in: ");
                    id = scan.nextInt();
                    for(int i = 0; i < book.length; i++){
                        if(book[i].getId() == id){
                            book[i].checkIn();
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("ERROR - input 1 or 0 please");
                    option = 1;
            }
        }
        while(option != 0);
    }
}
