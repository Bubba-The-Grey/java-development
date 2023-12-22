package com.pluralsight.daos;

import com.pluralsight.models.Category;
import com.pluralsight.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Component
public class JDBCProductDAO implements ProductDAO{
    private HashMap<Integer, Product> products;
    private BasicDataSource datasource;

    @Override
    public HashMap<Integer, Product> getAll() {
        return products;
    }
    public JDBCProductDAO(BasicDataSource datasource){
        this.products = new HashMap<>();
        this.datasource = datasource;
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("select productid, productname, categoryid, unitprice from products")){
            try(ResultSet results = statement.executeQuery()){
                while(results.next()){
                    products.put(results.getInt(1), new Product(results.getInt(1), results.getString(2), results.getInt(3), results.getDouble(4)));
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

    @Override
    public Product getByID(int id) {
        try{
            return products.get(id);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: ID does not exist");
            return null;
        }
    }

    @Override
    public Product insert(Product product){
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("insert into products (productname, categoryid, unitprice) values (?, ?, ?)")){
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getCategoryID());
            statement.setDouble(3, product.getUnitPrice());
            try{
                statement.executeUpdate();
            }
            catch(SQLException e){
                System.out.println("Error in inserting product");
            }
        }
        catch(SQLException e){
            System.out.println("Error in connection to Database");
        }
        try (Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("select productid from products where productname = ?")) {
            statement.setString(1, product.getProductName());
            try (ResultSet results = statement.executeQuery()) {
                Product productToAdd = null;
                while (results.next()) {
                    productToAdd = new Product(results.getInt(1), product.getProductName(), product.getCategoryID(), product.getUnitPrice());
                }
                assert productToAdd != null;
                products.put(productToAdd.getCategoryID(), productToAdd);
                return productToAdd;
            } catch (SQLException e) {
                System.out.println("Error in finding product");
            }
        } catch (SQLException e) {
            System.out.println("Error in finding product");
        }
        return null;
    }

    @Override
    public void update(int id, Product product){
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("update products set productname = ?, categoryid = ?, unitprice = ? where productid = ?")){
            statement.setInt(4, id);
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getCategoryID());
            statement.setDouble(3, product.getUnitPrice());
            try{
                statement.executeUpdate();
            }
            catch(SQLException e){
                System.out.println("Error in updating product");
            }
            products.put(id, new Product(id, product.getProductName(), product.getCategoryID(), product.getUnitPrice()));
        }
        catch(SQLException e){
            System.out.println("Error in connection to Database");
        }
    }

    @Override
    public void delete(int id){
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("delete from products where productid = ?")){
            statement.setInt(1, id);
            try{
                statement.executeUpdate();
            }
            catch(SQLException e){
                System.out.println("Error in deleting product");
            }
            products.remove(id);
        }
        catch(SQLException e){
            System.out.println("Error in connection to Database");
        }
    }
}
