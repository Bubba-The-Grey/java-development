package com.pluralsight;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();
        assets.add(new House("House", "9/11/2001", 150000, "123 Twin Tower Street",
                1, 30000, 43560));
        assets.add(new House("Vacation House", "9/12/2001", 180000, "124 Twin Tower Street",
                4, 25000, 43560));
        assets.add(new Vehicle("Main Vehicle", "9/11/2001", 20000, "Honda Civic", 2, 120000));
        assets.add(new Vehicle("Toy Vehicle", "9/12/2001", 30000, "Shelby Mustang", 7, 50000));
        for (Asset asset : assets) {
            System.out.print(asset.getDescription() + " ");
            if (asset instanceof House house) {
                System.out.println("House at " + house.getValue());
            } else if (asset instanceof Vehicle vehicle) {
                System.out.println(vehicle.getYear() + " " + vehicle.getValue());
            }
        }
    }
}
