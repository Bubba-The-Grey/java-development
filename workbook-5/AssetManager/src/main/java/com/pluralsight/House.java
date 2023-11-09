package com.pluralsight;

public class House extends Asset{
    private String address;
    private int condition, squareFoot, lotSize;

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
    public double getValue(){
        return switch (condition) {
            case 1 -> (180.00 * squareFoot) + (0.25 * lotSize);
            case 2 -> (130.00 * squareFoot) + (0.25 * lotSize);
            case 3 -> (90.00 * squareFoot) + (0.25 * lotSize);
            case 4 -> (80.00 * squareFoot) + (0.25 * lotSize);
            default -> 0;
        };
    }
}
