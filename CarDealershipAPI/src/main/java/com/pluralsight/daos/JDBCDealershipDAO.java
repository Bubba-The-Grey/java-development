package com.pluralsight.daos;

import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
@Component
public class JDBCDealershipDAO implements DealershipDAO{
    private HashMap<Integer, Dealership> dealerships;
    private BasicDataSource datasource;
    @Override
    public HashMap<Integer, Dealership> getAll() {
        return dealerships;
    }

    @Override
    public HashMap<Integer, Vehicle> getAllFromID(int id) {
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("select v.* from vehicles v left join inventory i on v.vin = i.vin left join dealerships d on i.dealership_id = d.dealership_id where d.dealership_id = ?")){
            statement.setInt(1, id);
            HashMap<Integer, Vehicle> vehicles = new HashMap<>();
            try(ResultSet results = statement.executeQuery()){
                while(results.next()){
                    vehicles.put(results.getInt(1), new Vehicle(results.getInt(1), results.getInt(2), results.getInt(7), results.getString(3), results.getString(4), results.getString(5), results.getString(6), results.getDouble(8), results.getBoolean(9)));
                }
            }
            catch(SQLException e){
                System.out.println("Error in query");
            }
            return vehicles;
        }
        catch(SQLException e){
            System.out.println("Error in connection to Database");
        }
        return null;
    }

    public JDBCDealershipDAO(BasicDataSource datasource){
        this.dealerships = new HashMap<>();
        this.datasource = datasource;
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("select * from dealerships")){
            try(ResultSet results = statement.executeQuery()){
                while(results.next()){
                    dealerships.put(results.getInt(1), new Dealership(results.getInt(1), results.getString(2), results.getString(3), results.getString(4)));
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
