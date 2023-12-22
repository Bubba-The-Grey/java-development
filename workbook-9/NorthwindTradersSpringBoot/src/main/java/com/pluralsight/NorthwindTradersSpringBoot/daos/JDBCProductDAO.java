package com.pluralsight.NorthwindTradersSpringBoot.daos;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

import java.util.*;
import java.sql.*;

@Component
public class JDBCProductDAO implements ProductDAO{
    private List<Product> products;
    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
    public JDBCProductDAO(BasicDataSource datasource){
        this.products = new ArrayList<>();
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("select p.productid, p.productname, c.categoryname, p.unitprice from products p left join categories c on p.categoryid = c.categoryid")){
            try(ResultSet results = statement.executeQuery()){
                while(results.next()){
                    products.add(new Product(results.getInt(1), results.getString(2), results.getString(3), results.getDouble(4)));
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
