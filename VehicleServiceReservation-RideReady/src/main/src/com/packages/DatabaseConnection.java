//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DatabaseConnection {
//    private static final String JDBC_URL = "jdbc:mysql://51.132.137.223:3306/isec_assessment2";
//    private static final String DB_USER = "isec";
//    private static final String DB_PASSWORD = "EUHHaYAmtzbv";
//
//    public static Connection getConnection() {
//        try {
//            return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}

package com.packages;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static final Properties properties = loadProperties();

    private static Properties loadProperties() {
        try (InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream("config/application.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getConnection() {
        String jdbcUrl = properties.getProperty("db.url");
        String dbUser = properties.getProperty("db.username");
        String dbPassword = properties.getProperty("db.password");

        try {
            return DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

