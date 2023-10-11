package com.pluralsight;
import java.text.*;
import java.util.*;
public class Vehicle {
    public DecimalFormat df = new DecimalFormat("0.00");
    private float price = 0.00f;
    private int odometerReading = 0;
    private long vehicleID =0l;
    private String makeModel = "", color = "";

    public Vehicle(){
        this.price = price;
        this.color = color;
        this.vehicleID = vehicleID;
        this.odometerReading = odometerReading;
        this.makeModel = makeModel;
    }
    public void setPrice(float price){
        this.price = Float.parseFloat(df.format(price));
    }
    public void setOdometerReading(int odometerReading){
        this.odometerReading = odometerReading;
    }
    public void setVehicleID(long vehicleID){
        this.vehicleID = vehicleID;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setMakeModel(String makeModel){
        this.makeModel = makeModel;
    }

    public float getPrice(){
        return this.price;
    }
    public int getOdometerReading(){
        return this.odometerReading;
    }
    public long getVehicleID(){
        return this.vehicleID;
    }
    public String getColor(){
        return this.color;
    }
    public String getMakeModel(){
        return this.makeModel;
    }

    public static Comparator<Vehicle> CarMakeModel = new Comparator<Vehicle>() {
        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            String makeModel1 = o1.getMakeModel();
            String makeModel2 = o2.getMakeModel();
            return makeModel1.compareToIgnoreCase(makeModel2);
        }
    };
    public static Comparator<Vehicle> CarPrice = new Comparator<Vehicle>() {
        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            float price1 = o1.getPrice();
            float price2 = o2.getPrice();
            return (int) (price1 - price2);
        }
    };

    public static Comparator<Vehicle> CarColor = new Comparator<Vehicle>() {
        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            String color1 = o1.getColor();
            String color2 = o2.getColor();
            return color1.compareToIgnoreCase(color2);
        }
    };
}
