package com.pluralsight;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
public class NorthwindDataManager {
    private DataSource datasource;
    public NorthwindDataManager(DataSource datasource) {
        this.datasource = datasource;
    }
    public void addShipper(String name, String number){
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("insert into shippers " +
                "(companyname, phone) values (?, ?)")){
            statement.setString(1, name);
            statement.setString(2, number);
            try{
                statement.executeUpdate();
            }
            catch(SQLException e){
                System.out.println("Error in adding shipper");
            }
        }
        catch(SQLException e){
            System.out.println("Error in adding shipper");
        }
    }
    public void updateShipper(String id, String name, String number){
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("update shippers " +
                "set companyname = ?, " +
                "set phone = ? " +
                "where shipperid = ?")){
            statement.setString(1, name);
            statement.setString(2, number);
            statement.setInt(3, Integer.parseInt(id));
            try{
                statement.executeUpdate();
            }
            catch(SQLException e){
                System.out.println("Error in updating shipper");
            }
        }
        catch(SQLException e){
            System.out.println("Error in updating shipper");
        }
    }
    public void deleteShipper(String id){
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("delete from shippers " +
                "where shipperid = ?")){
            statement.setInt(1, Integer.parseInt(id));
            try{
                statement.executeUpdate();
            }
            catch(SQLException e){
                System.out.println("Error in deleting shipper");
            }
        }
        catch(SQLException e){
            System.out.println("Error in deleting shipper");
        }
    }
    public List<Shipper> viewShippers(){
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("select * from shippers")){
            List<Shipper> s = new ArrayList<>();
            try(ResultSet results = statement.executeQuery()){
                while(results.next()){
                    s.add(new Shipper(results.getInt(1), results.getString(2), results.getString(3)));
                }
            }
            catch(SQLException e){
                System.out.println("Error in searching");
            }
            return s;
        }
        catch(SQLException e){
            System.out.println("Error in searching");
        }
        return null;
    }
}