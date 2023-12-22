package com.pluralsight.daos;

import com.pluralsight.models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JDBCVehicleDAO implements VehicleDAO{
    private HashMap<Integer, Vehicle> vehicles;
    private BasicDataSource datasource;

    @Override
    public HashMap<Integer, Vehicle> getAll(){return vehicles;}

    @Override
    public HashMap<Integer, Vehicle> searchByPrice(double min, double max) {
        HashMap<Integer, Vehicle> priced = new HashMap<>();
        for(Map.Entry<Integer, Vehicle> entry: vehicles.entrySet()){
            Vehicle v = entry.getValue();
            if(v.getPrice() >= min && v.getPrice() <= max){
                priced.put(v.getVin(), v);
            }
        }
        return priced;
    }

    @Override
    public HashMap<Integer, Vehicle> searchByMake(String make) {
        HashMap<Integer, Vehicle> maked = new HashMap<>();
        for(Map.Entry<Integer, Vehicle> entry: vehicles.entrySet()){
            Vehicle v = entry.getValue();
            if(v.getMake().equalsIgnoreCase(make)){
                maked.put(v.getVin(), v);
            }
        }
        return maked;
    }

    @Override
    public HashMap<Integer, Vehicle> searchByModel(String model) {
        HashMap<Integer, Vehicle> modeled = new HashMap<>();
        for(Map.Entry<Integer, Vehicle> entry: vehicles.entrySet()){
            Vehicle v = entry.getValue();
            if(v.getModel().equalsIgnoreCase(model)){
                modeled.put(v.getVin(), v);
            }
        }
        return modeled;
    }

    @Override
    public HashMap<Integer, Vehicle> searchByYear(int minYear, int maxYear) {
        HashMap<Integer, Vehicle> yeared = new HashMap<>();
        for(Map.Entry<Integer, Vehicle> entry: vehicles.entrySet()){
            Vehicle v = entry.getValue();
            if(v.getYear() >= minYear &&v.getYear() <= maxYear){
                yeared.put(v.getVin(), v);
            }
        }
        return yeared;
    }

    @Override
    public HashMap<Integer, Vehicle> searchByColor(String color) {
        HashMap<Integer, Vehicle> colored = new HashMap<>();
        for(Map.Entry<Integer, Vehicle> entry: vehicles.entrySet()){
            Vehicle v = entry.getValue();
            if(v.getColor().equalsIgnoreCase(color)){
                colored.put(v.getVin(), v);
            }
        }
        return colored;
    }

    @Override
    public HashMap<Integer, Vehicle> searchByMileage(int min, int max) {
        HashMap<Integer, Vehicle> mileaged = new HashMap<>();
        for(Map.Entry<Integer, Vehicle> entry: vehicles.entrySet()){
            Vehicle v = entry.getValue();
            if(v.getMileage() >= min && v.getMileage() <= max){
                mileaged.put(v.getVin(), v);
            }
        }
        return mileaged;
    }

    @Override
    public HashMap<Integer, Vehicle> searchByType(String type) {
        HashMap<Integer, Vehicle> typed = new HashMap<>();
        for(Map.Entry<Integer, Vehicle> entry: vehicles.entrySet()){
            Vehicle v = entry.getValue();
            if(v.getType().equalsIgnoreCase(type)){
                typed.put(v.getVin(), v);
            }
        }
        return typed;
    }

    @Override
    public void add(Vehicle vehicle) {
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("insert into vehicles (year, make, model, type, color, mileage, price, sold) values (?, ?, ?, ?, ?, ?, ?, ?)")){
            statement.setInt(1, vehicle.getYear());
            statement.setString(2, vehicle.getMake());
            statement.setString(3, vehicle.getModel());
            statement.setString(4, vehicle.getType());
            statement.setString(5, vehicle.getColor());
            statement.setInt(6, vehicle.getMileage());
            statement.setDouble(7, vehicle.getPrice());
            statement.setBoolean(8, vehicle.isSold());
            try{
                statement.executeUpdate();
            }
            catch(SQLException e){
                System.out.println("Error in inserting vehicle");
            }
        }
        catch(SQLException e){
            System.out.println("Error in connection to Database");
        }
        try (Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("select vin from vehicles where vin = last_insert_id()")) {
            try (ResultSet results = statement.executeQuery()) {
                Vehicle vehicleToAdd = null;
                while (results.next()) {
                    vehicleToAdd = new Vehicle(results.getInt(1), vehicle.getYear(), vehicle.getMileage(), vehicle.getMake(), vehicle.getModel(), vehicle.getType(), vehicle.getColor(), vehicle.getPrice(), vehicle.isSold());
                }
                assert vehicleToAdd != null;
                vehicles.put(vehicleToAdd.getVin(), vehicleToAdd);
            } catch (SQLException e) {
                System.out.println("Error in finding vehicle");
            }
        } catch (SQLException e) {
            System.out.println("Error in finding vehicle");
        }
    }

    @Override
    public void update(int vin, Vehicle vehicle) {
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("update vehicles set year = ?, make = ?, model = ?, type = ?, color = ?, mileage = ?, price = ?, sold = ? where vin = ?")){
            statement.setInt(9, vin);
            statement.setInt(1, vehicle.getYear());
            statement.setString(2, vehicle.getMake());
            statement.setString(3, vehicle.getModel());
            statement.setString(4, vehicle.getType());
            statement.setString(5, vehicle.getColor());
            statement.setInt(6, vehicle.getMileage());
            statement.setDouble(7, vehicle.getPrice());
            statement.setBoolean(8, vehicle.isSold());
            try{
                statement.executeUpdate();
            }
            catch(SQLException e){
                System.out.println("Error in updating vehicle");
            }
            vehicles.put(vin, new Vehicle(vin, vehicle.getYear(), vehicle.getMileage(), vehicle.getMake(), vehicle.getModel(), vehicle.getType(), vehicle.getColor(), vehicle.getPrice(), vehicle.isSold()));
        }
        catch(SQLException e){
            System.out.println("Error in connection to Database");
        }
    }

    @Override
    public void delete(int vin) {
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("delete from vehicles where vin = ?")){
            statement.setInt(1, vin);
            try{
                statement.executeUpdate();
            }
            catch(SQLException e){
                System.out.println("Error in deleting vehicle");
            }
            vehicles.remove(vin);
        }
        catch(SQLException e){
            System.out.println("Error in connection to Database");
        }
    }

    public JDBCVehicleDAO(BasicDataSource datasource){
        this.vehicles = new HashMap<>();
        this.datasource = datasource;
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("select * from vehicles")){
            try(ResultSet results = statement.executeQuery()){
                while(results.next()){
                    vehicles.put(results.getInt(1), new Vehicle(results.getInt(1), results.getInt(2), results.getInt(7), results.getString(3), results.getString(4), results.getString(5), results.getString(6), results.getDouble(8), results.getBoolean(9)));
                }
            }
            catch(SQLException e){
                System.out.println("Error in connection to Database");
            }
        }
        catch(SQLException e){
            System.out.println("Error in connection to Database");
        }
    }

}
