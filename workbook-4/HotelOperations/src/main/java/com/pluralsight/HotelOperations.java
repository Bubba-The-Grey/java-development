package com.pluralsight;

public class HotelOperations {
    public static void main(String[] args) {
        Room firstRoom = new Room(2, 124.00, true, false, false);
        Reservation firstReservation = new Reservation("double", 124.00, 2, true);
        Employee firstEmployee = new Employee(1, "Guest Services", "Enrico Suave", 7.25, 60);
        System.out.println(firstEmployee);
        System.out.println(firstReservation);
        System.out.println(firstRoom);
    }
}
