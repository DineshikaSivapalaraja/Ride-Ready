package com.web.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DB_Config {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = DB_Config.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Method to retrieve the values for url,username,password of the DB
    public static String getDbURL() {
        return properties.getProperty("db_url");
    }

    public static String getDbUsername() {
        return properties.getProperty("db_username");
    }

    public static String getDbPassword() {
        return properties.getProperty("db_password");
    }
    
    public static String getDbDriver() {
        return properties.getProperty("db_driver");
    }
}