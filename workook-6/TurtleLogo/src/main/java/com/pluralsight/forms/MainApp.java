package com.pluralsight.forms;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.awt.*;
import java.util.List;

public class MainApp
{
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        World world = new World(200, 200);
        Turtle turtle = new Turtle(world,-100, -100);
        turtle.penUp();
        System.out.println("Welcome to Turtle Paint!");
        int option = 0;
        List<Shape> list = new ArrayList<>();
        do{
            System.out.println("What would you like to do?");
            System.out.println("1) Add Image");
            System.out.println("2) Save Image");
            System.out.println("0) Exit");
            System.out.print("Your choice: ");
            option = scan.nextInt();
            switch(option){
                case 0:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                case 1:
                    list.add(addImage(turtle));
                    break;
                case 2:
                    saveImage(list);
                    break;
                default:
                    System.out.println("ERROR: Please choose a valid option");
                    break;
            }
        }while (option != 0);
    }

    public static Shape addImage(Turtle turtle){
        int option = 0;
        do{
            System.out.println("Which shape would you like to add?");
            System.out.println("1) Rectangle");
            System.out.println("2) Triangle");
            System.out.println("3) Hexagon");
            System.out.print("Your choice: ");
            option = scan.nextInt();
            scan.nextLine();
            switch(option){
                case 1:
                    return addRectangle(turtle);
                case 2:
                    return addTriangle(turtle);
                case 3:
                    return addHexagon(turtle);
                default:
                    System.out.println("ERROR: Please choose a valid option");
                    break;
            }
        }while(true);
    }
    public static Rectangle addRectangle(Turtle turtle){
        System.out.print("What is the location of the Rectangle (x,y)? ");
        String[] inputs = scan.nextLine().replace("(", "").replace(")", "").split(",");
        inputs[0] = inputs[0].trim();
        inputs[1] = inputs[1].trim();
        int option = -1;
        int color = 0;
        do{
            System.out.println("Please choose a color!");
            System.out.println("1) Black");
            System.out.println("2) Red");
            System.out.println("3) Blue");
            System.out.println("4) Magenta");
            System.out.println("5) Cyan");
            System.out.print("Your choice: ");
            option = scan.nextInt();
            switch(option){
                case 1:
                    color = 1;
                    option = -1;
                    break;
                case 2:
                    color = 2;
                    option = -1;
                    break;
                case 3:
                    color = 3;
                    option = -1;
                    break;
                case 4:
                    color = 4;
                    option = -1;
                    break;
                case 5:
                    color = 5;
                    option = -1;
                    break;
                default:
                    System.out.println("ERROR: Please choose a valid option");
                    option = 0;
                    break;
            }
        }while (option != -1);
        System.out.print("Enter the border width (thickness of the lines: ");
        int width = scan.nextInt();
        System.out.print("Enter the length of the Rectangle: ");
        double length = scan.nextDouble();
        System.out.print("Enter the height of the Rectangle: ");
        double height = scan.nextDouble();
        Rectangle rectangle = new Rectangle(turtle, Double.parseDouble(inputs[0]), Double.parseDouble(inputs[1]), color, width, length, height);
        rectangle.paint();
        return rectangle;
    }
    public static Triangle addTriangle(Turtle turtle){
        System.out.print("What is the location of the Triangle (x,y)? ");
        String[] inputs = scan.nextLine().replace("(", "").replace(")", "").split(",");
        inputs[0] = inputs[0].trim();
        inputs[1] = inputs[1].trim();
        int option = -1;
        int color = 0;
        do{
            System.out.println("Please choose a color!");
            System.out.println("1) Black");
            System.out.println("2) Red");
            System.out.println("3) Blue");
            System.out.println("4) Magenta");
            System.out.println("5) Cyan");
            System.out.print("Your choice: ");
            option = scan.nextInt();
            switch(option){
                case 1:
                    color = 1;
                    option = -1;
                    break;
                case 2:
                    color = 2;
                    option = -1;
                    break;
                case 3:
                    color = 3;
                    option = -1;
                    break;
                case 4:
                    color = 4;
                    option = -1;
                    break;
                case 5:
                    color = 5;
                    option = -1;
                    break;
                default:
                    System.out.println("ERROR: Please choose a valid option");
                    option = 0;
                    break;
            }
        }while (option != -1);
        System.out.print("Enter the border width (thickness of the lines: ");
        int width = scan.nextInt();
        System.out.print("Enter the length of the Triangle: ");
        double length = scan.nextDouble();
        System.out.print("Enter the height of the Triangle: ");
        double height = scan.nextDouble();
        System.out.print("Enter the first angle: ");
        double one = scan.nextDouble();
        System.out.print("Enter the second angle (note, the third angle will be auto-calculated): ");
        double two = scan.nextDouble();
        Triangle triangle = new Triangle(turtle, Double.parseDouble(inputs[0]), Double.parseDouble(inputs[1]), color, width, length, height, one, two);
        triangle.paint();
        return triangle;
    }
    public static Hexagon addHexagon(Turtle turtle) {
        System.out.print("What is the location of the Hexagon (x,y)? ");
        String[] inputs = scan.nextLine().replace("(", "").replace(")", "").split(",");
        inputs[0] = inputs[0].trim();
        inputs[1] = inputs[1].trim();
        int option = -1;
        int color = 0;
        do {
            System.out.println("Please choose a color!");
            System.out.println("1) Black");
            System.out.println("2) Red");
            System.out.println("3) Blue");
            System.out.println("4) Magenta");
            System.out.println("5) Cyan");
            System.out.print("Your choice: ");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    color = 1;
                    option = -1;
                    break;
                case 2:
                    color = 2;
                    option = -1;
                    break;
                case 3:
                    color = 3;
                    option = -1;
                    break;
                case 4:
                    color = 4;
                    option = -1;
                    break;
                case 5:
                    color = 5;
                    option = -1;
                    break;
                default:
                    System.out.println("ERROR: Please choose a valid option");
                    option = 0;
                    break;
            }
        } while (option != -1);
        System.out.print("Enter the border width (thickness of the lines: ");
        int width = scan.nextInt();
        System.out.print("Enter the length of the sides of the Hexagon: ");
        double height = scan.nextDouble();
        Hexagon hexagon = new Hexagon(turtle, Double.parseDouble(inputs[0]), Double.parseDouble(inputs[1]), color, width, height);
        hexagon.paint();
        return hexagon;
    }
    public static void saveImage(List<Shape> list) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Shapes.csv", true));
        for(Shape s: list){
            writer.write(s.toString());
            writer.newLine();
        }
        writer.close();
    }
}
