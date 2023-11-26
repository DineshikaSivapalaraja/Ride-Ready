package com.web.database;

//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getCon() {
		try {
			// Load the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Retrieve values using the DB_Config class
            String url = DBConfig.getDbURL();
            String username = DBConfig.getDbUsername();
            String password = DBConfig.getDbPassword();
            
            //  Make the Connection
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		catch(Exception e){
//			System.out.print(e);
			e.printStackTrace();
			return null;
		} 
	}
}