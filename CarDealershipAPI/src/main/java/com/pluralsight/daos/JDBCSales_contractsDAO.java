package com.pluralsight.daos;

import com.pluralsight.models.Dealership;
import com.pluralsight.models.Sales_contracts;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
@Component
public class JDBCSales_contractsDAO implements Sales_contractsDAO{
    private HashMap<Integer, Sales_contracts> sales;
    private BasicDataSource datasource;
    @Override
    public HashMap<Integer, Sales_contracts> getAll() {
        return sales;
    }

    @Override
    public void addSale(Sales_contracts sales_contract) {
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("insert into sales_contracts (date, customer, customer_email, vin) values (?, ?, ?, ?)")){
            statement.setInt(1, sales_contract.getDate());
            statement.setString(2, sales_contract.getCustomer());
            statement.setString(3, sales_contract.getEmail());
            statement.setInt(4, sales_contract.getVin());
            try{
                statement.executeUpdate();
            }
            catch(SQLException e){
                System.out.println("Error in adding contract");
            }
        }
        catch(SQLException e){
            System.out.println("Error in connection to Database");
        }
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("select id from sales_contracts where vin = ?")){
            statement.setInt(1, sales_contract.getVin());
            try(ResultSet results = statement.executeQuery()){
                sales.put(results.getInt(1), new Sales_contracts(results.getInt(1), sales_contract.getDate(), sales_contract.getVin(), sales_contract.getCustomer(), sales_contract.getEmail()));
            }
            catch(SQLException e){
                System.out.println("Error in query");
            }
        }
        catch(SQLException e){
            System.out.println("Error in connection to Database");
        }
    }

    public JDBCSales_contractsDAO(BasicDataSource datasource){
        this.sales = new HashMap<>();
        this.datasource = datasource;
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("select * from sales_contracts")){
            try(ResultSet results = statement.executeQuery()){
                while(results.next()){
                    sales.put(results.getInt(5), new Sales_contracts(results.getInt(1), results.getInt(2), results.getInt(5), results.getString(3), results.getString(4)));
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
