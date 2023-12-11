package com.pluralsight;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root",
                "D3athL33terN00b");
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM products";
        ResultSet results = statement.executeQuery(query);
        while(results.next()){
            System.out.println(results.getString(2));
        }
        connection.close();
    }
}
