package com.pluralsight.daos;

import com.pluralsight.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public interface VehicleDAO {
    @Autowired
    VehicleDAO vehicleDAO = null;

    HashMap<Integer, Vehicle> getAll();

    HashMap<Integer, Vehicle> searchByPrice(double min, double max);

    HashMap<Integer, Vehicle> searchByMake(String make);
    HashMap<Integer, Vehicle> searchByModel(String model);

    HashMap<Integer, Vehicle> searchByYear(int minYear, int maxYear);

    HashMap<Integer, Vehicle> searchByColor(String color);

    HashMap<Integer, Vehicle> searchByMileage(int min, int max);

    HashMap<Integer, Vehicle> searchByType(String type);

    void add(Vehicle vehicle);
    void update(int vin, Vehicle vehicle);
    void delete(int vin);
}
