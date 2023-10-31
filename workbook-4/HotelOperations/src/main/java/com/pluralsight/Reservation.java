package com.pluralsight;

public class Reservation {
    private String roomType;
    private double price;
    private int nights;
    private boolean weekend;

    public Reservation(String roomType, double price, int nights, boolean weekend) {
        this.roomType = roomType;
        this.price = price;
        this.nights = nights;
        this.weekend = weekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public int getNights() {
        return nights;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public double getReservationTotal(){
        if(isWeekend()){
            return (price * nights) * 1.10;
        }
        else{
            return price * nights;
        }
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "roomType='" + roomType + '\'' +
                ", price=" + price +
                ", nights=" + nights +
                ", weekend=" + weekend +
                '}';
    }
}
