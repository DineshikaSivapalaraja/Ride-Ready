//package com.vehicleReservation.dao;
//
//import com.vehicleReservation.model.vehicle;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
////dao class provides crud database operations for the table  in the database
//public class vehicleDao {
//
//    private String jdbcURL ="jdbc:mysql://51.132.137.223:3306/isec_assessment2";
//    private String jdbcUsername="isec";
//    private String jdbcPassword="EUHHaYAmtzbv";
//
//
//
//    //    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES "
//    private static final String INSERT_Vehicle_SQL = "INSERT INTO vehicle_service" + "  (booking_id, date, time, location, vehicle_no, mileage, message, username) VALUES "
//            + " (?, ?, ?, ?, ?, ?, ?, ?);";
//
//    private static final String SELECT_Vehicle_BY_ID = "select booking_id, date, time, location, vehicle_no, mileage, message, username from  vehicle_service where booking_id =?";
//    private static final String SELECT_ALL_Vehicle = "select * from  vehicle_service";
//    private static final String DELETE_Vehicle_SQL = "delete from  vehicle_service where booking_id = ?;";
//    private static final String UPDATE_Vehicle_SQL = "update  vehicle_service set date = ?,time= ?, location =? vehicle_no = ?,mileage= ?, message=?  username=? where booking_id = ?";
//
//
//    protected Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            try {
//                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//    //create/insert vehicle reservation
//    public void insertVehicle(vehicle Vehicle) throws SQLException {
//        //System.out.println(INSERT_vehicle_SQL);
//        // try-with-resource statement will auto close the connection.
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Vehicle_SQL)) {
//            // booking_id, date, time, location, vehicle_no, mileage, message, username
//            preparedStatement.setString(1, Vehicle.getDate());
//            preparedStatement.setString(2, Vehicle.getTime());
//            preparedStatement.setString(3, Vehicle.getLocation());
//            preparedStatement.setString(4, Vehicle.getVehicle_no());
//            preparedStatement.setInt(5, Vehicle.getMileage());
//            preparedStatement.setString(6, Vehicle.getMessage());
//            preparedStatement.setString(7, Vehicle.getUsername());
//            //System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//        }
////        catch (SQLException e) {
////            printSQLException(e);
////        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    //update reservation
//    public boolean updateVehicle(vehicle Vehicle) throws SQLException {
//        //System.out.println(INSERT_vehicle_SQL);
//        boolean rowUpdated;
//        // try-with-resource statement will auto close the connection.
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Vehicle_SQL)) {
//            PreparedStatement statement = null;
//            statement.setString(1, Vehicle.getDate());
//            statement.setString(2, Vehicle.getTime());
//            statement.setString(3, Vehicle.getLocation());
//            statement.setString(4, Vehicle.getVehicle_no());
//            statement.setInt(5, Vehicle.getMileage());
//            statement.setString(6, Vehicle.getMessage());
//            statement.setString(7, Vehicle.getUsername());
//            //System.out.println(preparedStatement);
//            rowUpdated = statement.executeUpdate() > 0;
//
//        }
//        return rowUpdated;
//    }
//
//    //select vehicle reservation  by id
//    public vehicle selectVehicle (int booking_id){
//        vehicle Vehicle = null;
//        // Step 1: Establishing a Connection
//        try (Connection connection = getConnection();
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Vehicle_BY_ID);) {
//            preparedStatement.setInt(1, booking_id);
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//
//                String date = rs.getString("date");
//                String time = rs.getString("time");
//                String location = rs.getString("location");
//                String vehicle_no = rs.getString("vehicle_no");
//                int mileage = rs.getInt("mileage");
//                String message = rs.getString("message");
//                String username = rs.getString("username");
//                Vehicle = new vehicle(booking_id, date, time, location, vehicle_no, mileage, message, username);
//            }
//        } catch (SQLException e) {
////            printSQLException(e);
//            e.printStackTrace();
//        }
//        return Vehicle;
//    }
//    //select all vehicles
//    public vehicle selectAllVehicle (){
//        List<vehicle> Vehicle = new ArrayList<>();
//        // Step 1: Establishing a Connection
//        try (Connection connection = getConnection();
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Vehicle_BY_ID);) {
//
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                int booking_id = rs.getInt("booking_id");
//                String date = rs.getString("date");
//                String time = rs.getString("time");
//                String location = rs.getString("location");
//                String vehicle_no = rs.getString("vehicle_no");
//                int mileage = rs.getInt("mileage");
//                String message = rs.getString("message");
//                String username = rs.getString("username");
//                Vehicle = (List<vehicle>) new vehicle(booking_id, date, time, location, vehicle_no, mileage, message, username);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return (vehicle) Vehicle;
//    }
//
//    //delete vehicle reservation
//    public boolean deleteVehicle(int booking_id) throws SQLException {
//        boolean rowDeleted;
//        try (Connection connection = getConnection();
//             PreparedStatement statement = connection.prepareStatement(DELETE_Vehicle_SQL);) {
//            statement.setInt(1,booking_id);
//            rowDeleted = statement.executeUpdate() > 0;
//        }
//        return rowDeleted;
//    }
//}


package com.vehicleReservation.dao;

import com.vehicleReservation.model.vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class vehicleDao {

    private String jdbcURL = "jdbc:mysql://51.132.137.223:3306/isec_assessment2";
    private String jdbcUsername = "isec";
    private String jdbcPassword = "EUHHaYAmtzbv";

    private static final String INSERT_Vehicle_SQL = "INSERT INTO vehicle_service (date, time, location, vehicle_no, mileage, message, username) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_Vehicle_BY_ID = "SELECT booking_id, date, time, location, vehicle_no, mileage, message, username FROM vehicle_service WHERE booking_id = ?;";
//    private static final String SELECT_ALL_Vehicle = "SELECT * FROM vehicle_service;";
    private static final String DELETE_Vehicle_SQL = "DELETE FROM vehicle_service WHERE booking_id = ?;";
   // private static final String UPDATE_Vehicle_SQL = "UPDATE vehicle_service SET date = ?, time = ?, location = ?, vehicle_no = ?, mileage = ?, message = ?, username = ? WHERE booking_id = ?;";

    // ... (rest of the code remains the same)


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    //create/insert vehicle reservation
    public void insertVehicle(vehicle Vehicle) throws SQLException {
        //System.out.println(INSERT_vehicle_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Vehicle_SQL)) {
            // booking_id, date, time, location, vehicle_no, mileage, message, username
            preparedStatement.setString(1, Vehicle.getDate());
            preparedStatement.setString(2, Vehicle.getTime());
            preparedStatement.setString(3, Vehicle.getLocation());
            preparedStatement.setString(4, Vehicle.getVehicle_no());
            preparedStatement.setInt(5, Vehicle.getMileage());
            preparedStatement.setString(6, Vehicle.getMessage());
            preparedStatement.setString(7, Vehicle.getUsername());
            //System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
//        catch (SQLException e) {
//            printSQLException(e);
//        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //update reservation
    public boolean updateVehicle(vehicle Vehicle) throws SQLException {
        //System.out.println(INSERT_vehicle_SQL);
        boolean rowUpdated;
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Vehicle_SQL)) {
            PreparedStatement statement = null;
            statement.setString(1, Vehicle.getDate());
            statement.setString(2, Vehicle.getTime());
            statement.setString(3, Vehicle.getLocation());
            statement.setString(4, Vehicle.getVehicle_no());
            statement.setInt(5, Vehicle.getMileage());
            statement.setString(6, Vehicle.getMessage());
            statement.setString(7, Vehicle.getUsername());
            //System.out.println(preparedStatement);
            rowUpdated = statement.executeUpdate() > 0;

        }
        return rowUpdated;
    }

    //select vehicle reservation  by id
    public vehicle selectVehicle (int booking_id){
        vehicle Vehicle = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Vehicle_BY_ID);) {
            preparedStatement.setInt(1, booking_id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {

                String date = rs.getString("date");
                String time = rs.getString("time");
                String location = rs.getString("location");
                String vehicle_no = rs.getString("vehicle_no");
                int mileage = rs.getInt("mileage");
                String message = rs.getString("message");
                String username = rs.getString("username");
                Vehicle = new vehicle(booking_id, date, time, location, vehicle_no, mileage, message, username);
            }
        } catch (SQLException e) {
//            printSQLException(e);
            e.printStackTrace();
        }
        return Vehicle;
    }
    //select all vehicles
    public vehicle selectAllVehicle (){
        List<vehicle> Vehicle = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Vehicle_BY_ID);) {

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int booking_id = rs.getInt("booking_id");
                String date = rs.getString("date");
                String time = rs.getString("time");
                String location = rs.getString("location");
                String vehicle_no = rs.getString("vehicle_no");
                int mileage = rs.getInt("mileage");
                String message = rs.getString("message");
                String username = rs.getString("username");
                Vehicle = (List<vehicle>) new vehicle(booking_id, date, time, location, vehicle_no, mileage, message, username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (vehicle) Vehicle;
    }

    //delete vehicle reservation
    public boolean deleteVehicle(int booking_id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_Vehicle_SQL);) {
            statement.setInt(1,booking_id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

}
