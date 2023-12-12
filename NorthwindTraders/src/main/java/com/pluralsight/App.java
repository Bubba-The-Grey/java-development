package com.pluralsight;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.text.DecimalFormat;

public class App {
    public static DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root",
                "");
        PreparedStatement statement = connection.prepareStatement("select * from products;");
        ResultSet results = statement.executeQuery();
        while(results.next()){
            System.out.println("ID: " + results.getString(1));
            System.out.println("Name: " + results.getString(2));
            System.out.println("Price: " + df.format(results.getFloat(6)));
            System.out.println("Stock: " + results.getString(7));
            System.out.println("__________________________________________________________");
            System.out.println();
        }
        connection.close();
    }
}
