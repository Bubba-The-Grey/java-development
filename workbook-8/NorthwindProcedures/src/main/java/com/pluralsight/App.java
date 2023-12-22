package com.pluralsight;
import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        String username = System.getenv("MY_DB_USERNAME");
        String password = System.getenv("MY_DB_PASSWORD");
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/Northwind");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        NorthwindDataManager dataManager = new NorthwindDataManager(dataSource);

    }
}
