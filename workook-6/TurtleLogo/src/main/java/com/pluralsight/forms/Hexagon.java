package com.pluralsight.forms;

import java.awt.*;

public class Hexagon extends Shape implements Painter{
    private double length;

    public Hexagon(Turtle turtle, double x, double y, int color, int borderWidth, double length) {
        super(turtle, x, y, color, borderWidth);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public void paint(){
        Turtle turtle = this.getTurtle();
        switch(this.getColor()){
            case 1:
                turtle.setColor(Color.BLACK);
                break;
            case 2:
                turtle.setColor(Color.RED);
                break;
            case 3:
                turtle.setColor(Color.BLUE);
                break;
            case 4:
                turtle.setColor(Color.MAGENTA);
                break;
            case 5:
                turtle.setColor(Color.CYAN);
                break;
        }
        turtle.setPenWidth(getBorderWidth());
        turtle.goTo(this.getX(), this.getY());
        turtle.penDown();
        for(int i = 0; i < 6; i++){
            turtle.forward(length);
            turtle.turnLeft(60);
        }
        turtle.penUp();
        turtle.turnRight(60);
    }

    @Override
    public String toString() {
        return "Hexagon|" + this.getX() + "|" + this.getY() + "|" + this.getColor() + "|" + this.getBorderWidth() + "|" + this.getLength();
    }
}
