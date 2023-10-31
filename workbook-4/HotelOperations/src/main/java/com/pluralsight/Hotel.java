package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfSuites, numberOfRooms, bookedSuites, bookedRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms){
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedRooms = 0;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedRooms){
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedRooms = bookedRooms;
    }

    public String getName(){
        return name;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedRooms() {
        return bookedRooms;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite){
        if(isSuite){
            if(numberOfRooms <= getAvailableSuites()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if(numberOfRooms <= getAvailableRooms()){
                return true;
            }
            else{
                return false;
            }
        }
    }
    public int getAvailableSuites(){
        return 0;
    }

    public int getAvailableRooms(){
        return 0;
    }
}
