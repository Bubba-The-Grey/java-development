package com.pluralsight;

public class AquamarineVehicle extends Vehicle{
    private int maxDepth;
    private boolean isSubmersive;

    public AquamarineVehicle() {
        super();
        this.maxDepth = maxDepth;
        this.isSubmersive = isSubmersive;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public boolean isSubmersive() {
        return isSubmersive;
    }

    public void setSubmersive(boolean submersive) {
        isSubmersive = submersive;
    }
}
