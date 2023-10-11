package com.pluralsight;
import java.util.*;
public class VehicleInventory {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        int input = 0;
        ArrayList<Vehicle> car = new ArrayList<Vehicle>();
        car.add(new Vehicle());
        car.get(0).setPrice(13500);
        car.get(0).setVehicleID(101121);
        car.get(0).setMakeModel("Ford Explorer");
        car.get(0).setColor("Red");
        car.get(0).setOdometerReading(45000);

        car.add(new Vehicle());
        car.get(1).setPrice(11000);
        car.get(1).setVehicleID(101122);
        car.get(1).setMakeModel("Toyota Camry");
        car.get(1).setColor("Blue");
        car.get(1).setOdometerReading(60000);

        car.add(new Vehicle());
        car.get(2).setPrice(9700);
        car.get(2).setVehicleID(101123);
        car.get(2).setMakeModel("Chevrolet Malibu");
        car.get(2).setColor("Black");
        car.get(2).setOdometerReading(50000);

        car.add(new Vehicle());
        car.get(3).setPrice(7500);
        car.get(3).setVehicleID(101124);
        car.get(3).setMakeModel("Honda Civic");
        car.get(3).setColor("White");
        car.get(3).setOdometerReading(70000);

        car.add(new Vehicle());
        car.get(4).setPrice(14500);
        car.get(4).setVehicleID(101125);
        car.get(4).setMakeModel("Subaru Outback");
        car.get(4).setColor("Green");
        car.get(4).setOdometerReading(55000);

        car.add(new Vehicle());
        car.get(5).setPrice(16000);
        car.get(5).setVehicleID(101126);
        car.get(5).setMakeModel("Jeep Wrangler");
        car.get(5).setColor("Yellow");
        car.get(5).setOdometerReading(30000);

        do {
            System.out.println("What do you want to do?\n\n1 - List all vehicles\n2 - Search by make/model" +
                    "\n3 - Search by price range\n4 - Search by color\n5 - Add a vehicle\n6 - Quit");
            System.out.println();
            System.out.print("Enter your command: ");
            input = scan.nextInt();

            switch(input){
                case 1:
                    List(car);
                    break;
                case 2:
                    SearchByMakeModel(car);
                    break;
                case 3:
                    SearchByPrice(car);
                    break;
                case 4:
                    SearchByColor(car);
                    break;
                case 5:
                    car.add(new Vehicle());
                    System.out.print("Enter the vehicle ID: ");
                    car.get(car.size() - 1).setVehicleID(scan.nextLong());
                    scan.nextLine();
                    System.out.print("Enter the make and model of the vehicle: ");
                    car.get(car.size() - 1).setMakeModel(scan.nextLine());
                    System.out.print("Enter the color of the vehicle: ");
                    car.get(car.size() - 1).setColor(scan.nextLine());
                    System.out.print("Enter the odometer's reading of the vehicle: ");
                    car.get(car.size() - 1).setOdometerReading(scan.nextInt());
                    System.out.print("Enter the price of the vehicle: ");
                    car.get(car.size() - 1).setPrice(scan.nextFloat());
                    break;
                case 6:
                    System.exit(0);
            }
        }
        while(input != 6);
    }

    public static void List(ArrayList<Vehicle> car){
        for(int i = 0; i < car.size(); i++){
            if (car.get(i) != null){
                System.out.println(car.get(i).getVehicleID() + ": " + car.get(i).getColor() + " " + car.get(i).getMakeModel() +
                        " with only " + car.get(i).getOdometerReading() + " miles for $" + car.get(i).getPrice());
            }
        }
    }

    public static void SearchByMakeModel(ArrayList<Vehicle> car){
        Collections.sort(car, Vehicle.CarMakeModel);
        for(int i = 0; i < car.size(); i++){
            if (car.get(i) != null){
                System.out.println(car.get(i).getVehicleID() + ": " + car.get(i).getColor() + " " + car.get(i).getMakeModel() +
                        " with only " + car.get(i).getOdometerReading() + " miles for $" + car.get(i).getPrice());
            }
        }
    }
    public static void SearchByPrice(ArrayList<Vehicle> car){
        Collections.sort(car, Vehicle.CarPrice);
        for(int i = 0; i < car.size(); i++){
            if (car.get(i) != null){
                System.out.println(car.get(i).getVehicleID() + ": " + car.get(i).getColor() + " " + car.get(i).getMakeModel() +
                        " with only " + car.get(i).getOdometerReading() + " miles for $" + car.get(i).getPrice());
            }
        }
    }
    public static void SearchByColor(ArrayList<Vehicle> car){
        Collections.sort(car, Vehicle.CarColor);
        for(int i = 0; i < car.size(); i++){
            if (car.get(i) != null){
                System.out.println(car.get(i).getVehicleID() + ": " + car.get(i).getColor() + " " + car.get(i).getMakeModel() +
                        " with only " + car.get(i).getOdometerReading() + " miles for $" + car.get(i).getPrice());
            }
        }
    }
}
