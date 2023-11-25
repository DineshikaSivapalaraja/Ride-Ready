package com.web.database;

import java.sql.*;

public class DB_Connection {
	public static Connection getCon() {
		try {
			// Load the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Retrieve values using the DB_Config class
            String url = DB_Config.getDbURL();
            String username = DB_Config.getDbUsername();
            String password = DB_Config.getDbPassword();
            
            //  Make the Connection
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		catch(Exception e){
			System.out.print(e);
			return null;
		} 
	}
}