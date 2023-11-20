package com.pluralsight.forms;

import java.awt.*;

public class Triangle extends Shape implements Painter{
    private double length, width, one , two;

    public Triangle(Turtle turtle, double x, double y, int color, int borderWidth, double length, double width, double one, double two) {
        super(turtle, x, y, color, borderWidth);
        this.length = length;
        this.width = width;
        this.one = one;
        this.two = two;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getOne() {
        return one;
    }

    public void setOne(double one) {
        this.one = one;
    }

    public double getTwo() {
        return two;
    }

    public void setTwo(double two) {
        this.two = two;
    }

    public void paint(){
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
        turtle.turnLeft(one);
        turtle.forward(width);
        turtle.turnLeft(two);
        turtle.goTo(this.getX(), this.getY());
        turtle.penUp();
    }

    @Override
    public String toString() {
        return "Triangle|" + this.getX() + "|" + this.getY() + "|" + this.getColor() + "|" + this.getBorderWidth() + "|" + this.getLength() + "|" + this.getWidth() + "|" + this.getOne() + "|" + this.getTwo();
    }
}
