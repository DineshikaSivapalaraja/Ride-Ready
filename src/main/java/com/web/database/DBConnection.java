package com.web.database;

//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	
//	private static final String url="jdbc:mysql://172.187.178.153:3306/isec_assessment2";
//	private static final String username="isec";
//	private static final String password="EUHHaYAmtzbv";
		
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