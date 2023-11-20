package com.pluralsight.forms;

import java.awt.*;

public class Rectangle extends Shape implements Painter{
    private double length, height;

    public Rectangle(Turtle turtle, double x, double y, int color, int borderWidth, double length, double height) {
        super(turtle, x, y, color, borderWidth);
        this.length = length;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void paint() {
        Turtle turtle = getTurtle();
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
        turtle.forward(length);
        turtle.turnLeft(90);
        turtle.forward(height);
        turtle.turnLeft(90);
        turtle.forward(length);
        turtle.turnLeft(90);
        turtle.forward(height);
        turtle.penUp();
    }
    @Override
    public String toString() {
        return "Rectangle|" + this.getX() + "|" + this.getY() + "|" + this.getColor() + "|" + this.getBorderWidth() + "|" + this.getLength() + "|" + this.getHeight();
    }
}
