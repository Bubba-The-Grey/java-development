package com.pluralsight;

public class LandVehicle extends Vehicle{
    private int numberOfTires = 0, numberOfDoors = 0;
    private boolean hasHitch = false;

    public LandVehicle() {
        super();
        this.numberOfTires = numberOfTires;
        this.numberOfDoors = numberOfDoors;
        this.hasHitch = hasHitch;
    }

    public int getNumberOfTires() {
        return numberOfTires;
    }

    public void setNumberOfTires(int numberOfTires) {
        this.numberOfTires = numberOfTires;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public boolean isHasHitch() {
        return hasHitch;
    }

    public void setHasHitch(boolean hasHitch) {
        this.hasHitch = hasHitch;
    }
}
