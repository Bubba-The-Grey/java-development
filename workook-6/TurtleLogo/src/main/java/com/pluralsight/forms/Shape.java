package com.pluralsight.forms;

public abstract class Shape implements Painter{
    private Turtle turtle;
    private double x, y;
    private int color, borderWidth;

    public Shape(Turtle turtle, double x, double y, int color, int borderWidth) {
        this.turtle = turtle;
        this.x = x;
        this.y = y;
        this.color = color;
        this.borderWidth = borderWidth;
    }
    public void paint(){};

    public Turtle getTurtle() {
        return turtle;
    }

    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }
}
