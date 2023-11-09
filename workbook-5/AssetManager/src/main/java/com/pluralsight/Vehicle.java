package com.pluralsight;

public class Vehicle extends Asset{
    private String makeModel;
    private int year, odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
    public double getValue(){
        double result = 0.0;
        if(year >= 0 && year <= 3){
            result = getOriginalCost() * (1 - (0.03 * year));
        }
        else if(year >= 4 && year <= 6){
            result = getOriginalCost() * (1 - (0.06 * year));
        }
        else if(year >= 7 && year <= 10){
            result = getOriginalCost() * (1 - (0.08 * year));
        }
        else{
            result = 1000.00;
        }
        if(odometer > 100000 && !makeModel.contains("Honda") && !makeModel.contains("Toyota")){
            result *= 0.75;
        }
        return result;
    }
}
