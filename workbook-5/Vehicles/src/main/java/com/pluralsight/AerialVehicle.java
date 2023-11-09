package com.pluralsight;

public class AerialVehicle extends Vehicle{
    private int maxAltitude = 0;
    private boolean isHover = false;
    public AerialVehicle(){
        super();
        this.maxAltitude = maxAltitude;
        this.isHover = isHover;
    }
    public int getMaxAltitude(){
        return maxAltitude;
    }
    public void setMaxAltitude(int maxAltitude){
        this.maxAltitude = maxAltitude;
    }

    public boolean isHover() {
        return isHover;
    }

    public void setHover(boolean hover) {
        isHover = hover;
    }
}
