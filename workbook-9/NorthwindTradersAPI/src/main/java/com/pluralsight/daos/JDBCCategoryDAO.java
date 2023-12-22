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
public class JDBCCategoryDAO implements CategoryDAO {
    private HashMap<Integer, Category> categories;
    private BasicDataSource datasource;

    @Override
    public HashMap<Integer, Category> getAll() {
        return categories;
    }

    public JDBCCategoryDAO(BasicDataSource datasource) {
        this.categories = new HashMap<>();
        this.datasource = datasource;
        try (Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("select categoryid, categoryname from categories")) {
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    categories.put(results.getInt(1), new Category(results.getInt(1), results.getString(2)));
                }
            } catch (SQLException e) {
                System.out.println("Error in connection to Database");
            }
        } catch (SQLException e) {
            System.out.println("Error in connection to Database");
        }
    }

    @Override
    public Category getByID(int id) {
        try {
            return categories.get(id);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: ID does not exist");
            return null;
        }
    }

    @Override
    public Category insert(Category category) {
        try (Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("insert into categories values (null, ?, null, null)")) {
            statement.setString(1, category.getCategoryName());
            try {
                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error in inserting category");
            }
        } catch (SQLException e) {
            System.out.println("Error in connection to Database");
        }
        try (Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("select categoryid from categories where categoryname = ?")) {
            statement.setString(1, category.getCategoryName());
            try (ResultSet results = statement.executeQuery()) {
                Category categoryToAdd = null;
                while (results.next()) {
                    categoryToAdd = new Category(results.getInt(1), category.getCategoryName());
                }
                assert categoryToAdd != null;
                categories.put(categoryToAdd.getCategoryID(), categoryToAdd);
                return categoryToAdd;
            } catch (SQLException e) {
                System.out.println("Error in finding category");
            }
        } catch (SQLException e) {
            System.out.println("Error in finding category");
        }
        return null;
    }

    @Override
    public void update(int id, Category category) {
        try (Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("update categories set categoryname = ? where categoryid = ?")) {
            statement.setInt(2, id);
            statement.setString(1, category.getCategoryName());
            try {
                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error in updating category");
            }
            categories.put(id, new Category(id, category.getCategoryName()));
        } catch (SQLException e) {
            System.out.println("Error in connection to Database");
        }
    }
    public void delete(int id){
        try(Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement("delete from categories where categoryid = ?")){
            statement.setInt(1, id);
            try{
                statement.executeUpdate();
            }
            catch(SQLException e){
                System.out.println("Error in deleting category");
            }
            categories.remove(id);
        }
        catch(SQLException e){
            System.out.println("Error in connection to Database");
        }
    }
}
