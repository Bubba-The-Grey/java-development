package com.pluralsight;

public class Room {
    private int numBeds;
    private double price;
    private boolean available, dirty, occupied;

    public Room(int numBeds, double price, boolean available, boolean dirty, boolean occupied) {
        this.numBeds = numBeds;
        this.price = price;
        this.available = available;
        this.dirty = dirty;
        this.occupied = occupied;
    }

    public int getNumBeds() {
        return numBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void checkIn(){
        if(available) {
            setAvailable(false);
            setOccupied(true);
            setDirty(true);
        }
        else{
            System.out.println("Sorry, room is not available yet. Here is why:");
            if(occupied){
                System.out.println("Room is currently occupied.");
            }
            else{
                System.out.println("Room is dirty.");
            }
        }
    }

    public void checkOut(){
        setOccupied(false);
    }

    public void cleanRoom(){
        if(!occupied) {
            setDirty(false);
            setAvailable(true);
        }
        else{
            System.out.println("Room is occupied. Make sure to check-out before cleaning.");
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "numBeds=" + numBeds +
                ", price=" + price +
                ", available=" + available +
                ", dirty=" + dirty +
                ", occupied=" + occupied +
                '}';
    }
}