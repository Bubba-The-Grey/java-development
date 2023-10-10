package com.pluralsight;

public class Dice {
    private int min = 1, max = 6;
    public Dice(){
        this.min = min;
        this.max = max;
    }
    public int roll(){
        return this.min + (int)(Math.random() * this.max);
    }
}
