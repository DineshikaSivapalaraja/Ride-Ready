////package com.vehicleReservation.dao;
////
////import com.vehicleReservation.model.vehicle;
////
////import java.sql.*;
////import java.util.ArrayList;
////import java.util.List;
////
//////dao class provides crud database operations for the table  in the database
////public class vehicleDao {
////
////    private String jdbcURL ="jdbc:mysql://51.132.137.223:3306/isec_assessment2";
////    private String jdbcUsername="isec";
////    private String jdbcPassword="EUHHaYAmtzbv";
////
////
////
////    //    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES "
////    private static final String INSERT_Vehicle_SQL = "INSERT INTO vehicle_service" + "  (booking_id, date, time, location, vehicle_no, mileage, message, username) VALUES "
////            + " (?, ?, ?, ?, ?, ?, ?, ?);";
////
////    private static final String SELECT_Vehicle_BY_ID = "select booking_id, date, time, location, vehicle_no, mileage, message, username from  vehicle_service where booking_id =?";
////    private static final String SELECT_ALL_Vehicle = "select * from  vehicle_service";
////    private static final String DELETE_Vehicle_SQL = "delete from  vehicle_service where booking_id = ?;";
////    private static final String UPDATE_Vehicle_SQL = "update  vehicle_service set date = ?,time= ?, location =? vehicle_no = ?,mileage= ?, message=?  username=? where booking_id = ?";
////
////
////    protected Connection getConnection() {
////        Connection connection = null;
////        try {
////            Class.forName("com.mysql.jdbc.Driver");
////            try {
////                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
////            } catch (SQLException e) {
////                throw new RuntimeException(e);
////            }
////        } catch (ClassNotFoundException e) {
////            // TODO Auto-generated catch block
////            e.printStackTrace();
////        }
////        return connection;
////    }
////
////    //create/insert vehicle reservation
////    public void insertVehicle(vehicle Vehicle) throws SQLException {
////        //System.out.println(INSERT_vehicle_SQL);
////        // try-with-resource statement will auto close the connection.
////        try (Connection connection = getConnection();
////             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Vehicle_SQL)) {
////            // booking_id, date, time, location, vehicle_no, mileage, message, username
////            preparedStatement.setString(1, Vehicle.getDate());
////            preparedStatement.setString(2, Vehicle.getTime());
////            preparedStatement.setString(3, Vehicle.getLocation());
////            preparedStatement.setString(4, Vehicle.getVehicle_no());
////            preparedStatement.setInt(5, Vehicle.getMileage());
////            preparedStatement.setString(6, Vehicle.getMessage());
////            preparedStatement.setString(7, Vehicle.getUsername());
////            //System.out.println(preparedStatement);
////            preparedStatement.executeUpdate();
////        }
//////        catch (SQLException e) {
//////            printSQLException(e);
//////        }
////        catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
////
////    //update reservation
////    public boolean updateVehicle(vehicle Vehicle) throws SQLException {
////        //System.out.println(INSERT_vehicle_SQL);
////        boolean rowUpdated;
////        // try-with-resource statement will auto close the connection.
////        try (Connection connection = getConnection();
////             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Vehicle_SQL)) {
////            PreparedStatement statement = null;
////            statement.setString(1, Vehicle.getDate());
////            statement.setString(2, Vehicle.getTime());
////            statement.setString(3, Vehicle.getLocation());
////            statement.setString(4, Vehicle.getVehicle_no());
////            statement.setInt(5, Vehicle.getMileage());
////            statement.setString(6, Vehicle.getMessage());
////            statement.setString(7, Vehicle.getUsername());
////            //System.out.println(preparedStatement);
////            rowUpdated = statement.executeUpdate() > 0;
////
////        }
////        return rowUpdated;
////    }
////
////    //select vehicle reservation  by id
////    public vehicle selectVehicle (int booking_id){
////        vehicle Vehicle = null;
////        // Step 1: Establishing a Connection
////        try (Connection connection = getConnection();
////             // Step 2:Create a statement using connection object
////             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Vehicle_BY_ID);) {
////            preparedStatement.setInt(1, booking_id);
////            System.out.println(preparedStatement);
////            // Step 3: Execute the query or update query
////            ResultSet rs = preparedStatement.executeQuery();
////
////            // Step 4: Process the ResultSet object.
////            while (rs.next()) {
////
////                String date = rs.getString("date");
////                String time = rs.getString("time");
////                String location = rs.getString("location");
////                String vehicle_no = rs.getString("vehicle_no");
////                int mileage = rs.getInt("mileage");
////                String message = rs.getString("message");
////                String username = rs.getString("username");
////                Vehicle = new vehicle(booking_id, date, time, location, vehicle_no, mileage, message, username);
////            }
////        } catch (SQLException e) {
//////            printSQLException(e);
////            e.printStackTrace();
////        }
////        return Vehicle;
////    }
////    //select all vehicles
////    public vehicle selectAllVehicle (){
////        List<vehicle> Vehicle = new ArrayList<>();
////        // Step 1: Establishing a Connection
////        try (Connection connection = getConnection();
////             // Step 2:Create a statement using connection object
////             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Vehicle_BY_ID);) {
////
////            System.out.println(preparedStatement);
////            // Step 3: Execute the query or update query
////            ResultSet rs = preparedStatement.executeQuery();
////
////            // Step 4: Process the ResultSet object.
////            while (rs.next()) {
////                int booking_id = rs.getInt("booking_id");
////                String date = rs.getString("date");
////                String time = rs.getString("time");
////                String location = rs.getString("location");
////                String vehicle_no = rs.getString("vehicle_no");
////                int mileage = rs.getInt("mileage");
////                String message = rs.getString("message");
////                String username = rs.getString("username");
////                Vehicle = (List<vehicle>) new vehicle(booking_id, date, time, location, vehicle_no, mileage, message, username);
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////        return (vehicle) Vehicle;
////    }
////
////    //delete vehicle reservation
////    public boolean deleteVehicle(int booking_id) throws SQLException {
////        boolean rowDeleted;
////        try (Connection connection = getConnection();
////             PreparedStatement statement = connection.prepareStatement(DELETE_Vehicle_SQL);) {
////            statement.setInt(1,booking_id);
////            rowDeleted = statement.executeUpdate() > 0;
////        }
////        return rowDeleted;
////    }
////}
//
//
//package com.vehicleReservation.dao;
//
//import com.vehicleReservation.model.Reservation;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ReservationDAO {
//
//    private String jdbcURL = "jdbc:mysql://51.132.137.223:3306/isec_assessment2";
//    private String jdbcUsername = "isec";
//    private String jdbcPassword = "EUHHaYAmtzbv";
//
//    private static final String INSERT_Vehicle_SQL = "INSERT INTO vehicle_service (date, time, location, vehicle_no, mileage, message, username) VALUES (?, ?, ?, ?, ?, ?, ?);";
//    private static final String SELECT_Vehicle_BY_ID = "SELECT booking_id, date, time, location, vehicle_no, mileage, message, username FROM vehicle_service WHERE booking_id = ?;";
////    private static final String SELECT_ALL_Vehicle = "SELECT * FROM vehicle_service;";
//    private static final String DELETE_Vehicle_SQL = "DELETE FROM vehicle_service WHERE booking_id = ?;";
//   // private static final String UPDATE_Vehicle_SQL = "UPDATE vehicle_service SET date = ?, time = ?, location = ?, vehicle_no = ?, mileage = ?, message = ?, username = ? WHERE booking_id = ?;";
//
//    // ... (rest of the code remains the same)
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
//    public void insertVehicle(Reservation Reservation) throws SQLException {
//        //System.out.println(INSERT_vehicle_SQL);
//        // try-with-resource statement will auto close the connection.
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Vehicle_SQL)) {
//            // booking_id, date, time, location, vehicle_no, mileage, message, username
//            preparedStatement.setString(1, Reservation.getDate());
//            preparedStatement.setString(2, Reservation.getTime());
//            preparedStatement.setString(3, Reservation.getLocation());
//            preparedStatement.setString(4, Reservation.getVehicle_no());
//            preparedStatement.setInt(5, Reservation.getMileage());
//            preparedStatement.setString(6, Reservation.getMessage());
//            preparedStatement.setString(7, Reservation.getUsername());
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
//    public boolean updateVehicle(Reservation Reservation) throws SQLException {
//        //System.out.println(INSERT_vehicle_SQL);
//        boolean rowUpdated;
//        // try-with-resource statement will auto close the connection.
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Vehicle_SQL)) {
//            PreparedStatement statement = null;
//            statement.setString(1, Reservation.getDate());
//            statement.setString(2, Reservation.getTime());
//            statement.setString(3, Reservation.getLocation());
//            statement.setString(4, Reservation.getVehicle_no());
//            statement.setInt(5, Reservation.getMileage());
//            statement.setString(6, Reservation.getMessage());
//            statement.setString(7, Reservation.getUsername());
//            //System.out.println(preparedStatement);
//            rowUpdated = statement.executeUpdate() > 0;
//
//        }
//        return rowUpdated;
//    }
//
//    //select vehicle reservation  by id
//    public Reservation selectVehicle (int booking_id){
//        Reservation Reservation = null;
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
//                Reservation = new Reservation(booking_id, date, time, location, vehicle_no, mileage, message, username);
//            }
//        } catch (SQLException e) {
////            printSQLException(e);
//            e.printStackTrace();
//        }
//        return Reservation;
//    }
//    //select all vehicles
//    public Reservation selectAllVehicle (){
//        List<Reservation> Reservation = new ArrayList<>();
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
//                Reservation = (List<Reservation>) new Reservation(booking_id, date, time, location, vehicle_no, mileage, message, username);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return (Reservation) Reservation;
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
//
//}


//new

//package com.vehicleReservation.dao;
//
//import com.vehicleReservation.model.Reservation;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ReservationDAO {
//    private String jdbcURL = "jdbc:mysql://51.132.137.223:3306/isec_assessment2";
//    private String jdbcUsername = "isec";
//    private String jdbcPassword = "EUHHaYAmtzbv";
//
//    private static final String INSERT_RESERVATION_SQL = "INSERT INTO vehicle_service (date, time, location, vehicle_no, mileage, message, username) VALUES (?, ?, ?, ?, ?, ?, ?);";
//    private static final String SELECT_RESERVATION_BY_ID = "SELECT booking_id, date, time, location, vehicle_no, mileage, message, username FROM vehicle_service WHERE booking_id = ?;";
//    private static final String SELECT_ALL_RESERVATIONS = "SELECT * FROM vehicle_service;";
//    private static final String DELETE_RESERVATION_SQL = "DELETE FROM vehicle_service WHERE booking_id = ?;";
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
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//    // Insert a reservation into the database
//    public void insertReservation(Reservation reservation) throws SQLException {
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESERVATION_SQL)) {
//            preparedStatement.setString(1, reservation.getDate());
//            preparedStatement.setString(2, reservation.getTime());
//            preparedStatement.setString(3, reservation.getLocation());
//            preparedStatement.setString(4, reservation.getVehicle_no());
//            preparedStatement.setInt(5, reservation.getMileage());
//            preparedStatement.setString(6, reservation.getMessage());
//            preparedStatement.setString(7, reservation.getUsername());
//            preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Select a reservation by its booking ID
//    public Reservation selectReservation(int booking_id) {
//        Reservation reservation = null;
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESERVATION_BY_ID)) {
//            preparedStatement.setInt(1, booking_id);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                // Extract data from the ResultSet and create a Reservation object
//                int booking_id = rs.getInt("booking_id");
//                String date = rs.getString("date");
//                String time = rs.getString("time");
//                String location = rs.getString("location");
//                String vehicle_no = rs.getString("vehicle_no");
//                int mileage = rs.getInt("mileage");
//                String message = rs.getString("message");
//                String username = rs.getString("username");
//                reservation = new Reservation(booking_id, date, time, location, vehicle_no, mileage, message, username);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return reservation;
//    }
//
//    // Select all reservations from the database
//    public List<Reservation> selectAllReservations() {
//        List<Reservation> reservations = new ArrayList<>();
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RESERVATIONS)) {
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                // Extract data from the ResultSet and create Reservation objects
//                int booking_id = rs.getInt("booking_id");
//                String date = rs.getString("date");
//                String time = rs.getString("time");
//                String location = rs.getString("location");
//                String vehicle_no = rs.getString("vehicle_no");
//                int mileage = rs.getInt("mileage");
//                String message = rs.getString("message");
//                String username = rs.getString("username");
//                Reservation reservation = new Reservation(booking_id, date, time, location, vehicle_no, mileage, message, username);
//                reservations.add(reservation);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return reservations;
//    }
//
//    // Delete a reservation from the database by its booking ID
//    public boolean deleteReservation(int booking_id) throws SQLException {
//        boolean rowDeleted;
//        try (Connection connection = getConnection();
//             PreparedStatement statement = connection.prepareStatement(DELETE_RESERVATION_SQL)) {
//            statement.setInt(1, booking_id);
//            rowDeleted = statement.executeUpdate() > 0;
//        }
//        return rowDeleted;
//    }
//}

//new
package com.vehicleReservation.dao;

import com.vehicleReservation.model.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

        private String jdbcURL = "jdbc:mysql://51.132.137.223:3306/isec_assessment2";
        private String jdbcUsername = "isec";
        private String jdbcPassword = "EUHHaYAmtzbv";
    private static final String INSERT_RESERVATION_SQL = "INSERT INTO vehicle_service (date, time, location, vehicle_no, mileage, message, username) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_RESERVATION_BY_ID = "SELECT booking_id, date, time, location, vehicle_no, mileage, message, username FROM vehicle_service WHERE booking_id = ?;";
    private static final String SELECT_ALL_RESERVATIONS = "SELECT * FROM vehicle_service;";
    private static final String DELETE_RESERVATION_SQL = "DELETE FROM vehicle_service WHERE booking_id = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.oj.jdbc.Driver");
//            String jdbcUsername = "isec";
//            String jdbcPassword = "EUHHaYAmtzbv";
//            String jdbcURL = "jdbc:mysql://51.132.137.223:3306/isec_assessment2";
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
//            catch (SQLException e) {
            catch (Exception e) {
//                throw new RuntimeException(e);
                e.printStackTrace();
            }
        return connection;

    }


//    protected Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            try {
//
//                String jdbcURL = "jdbc:mysql://51.132.137.223:3306/isec_assessment2";
//                String jdbcUsername = "isec";
//                String jdbcPassword = "EUHHaYAmtzbv";
//                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return connection;
//
//    }

    public void insertReservation(Reservation reservation) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESERVATION_SQL)) {
            preparedStatement.setString(1, reservation.getDate());
            preparedStatement.setString(2, reservation.getTime());
            preparedStatement.setString(3, reservation.getLocation());
            preparedStatement.setString(4, reservation.getVehicle_no());
            preparedStatement.setInt(5, reservation.getMileage());
            preparedStatement.setString(6, reservation.getMessage());
            preparedStatement.setString(7, reservation.getUsername());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Reservation selectReservation(int bookingId) {
        Reservation reservation = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESERVATION_BY_ID)) {
            preparedStatement.setInt(1, bookingId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("booking_id");
                String date = rs.getString("date");
                String time = rs.getString("time");
                String location = rs.getString("location");
                String vehicleNo = rs.getString("vehicle_no");
                int mileage = rs.getInt("mileage");
                String message = rs.getString("message");
                String username = rs.getString("username");
                reservation = new Reservation(date, time, location, vehicleNo, mileage, message, username);
                reservation.setBooking_id(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservation;
    }

    public List<Reservation> selectAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RESERVATIONS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("booking_id");
                String date = rs.getString("date");
                String time = rs.getString("time");
                String location = rs.getString("location");
                String vehicleNo = rs.getString("vehicle_no");
                int mileage = rs.getInt("mileage");
                String message = rs.getString("message");
                String username = rs.getString("username");
                Reservation reservation = new Reservation(date, time, location, vehicleNo, mileage, message, username);
                reservation.setBooking_id(id);
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public boolean deleteReservation(int bookingId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_RESERVATION_SQL)) {
            statement.setInt(1, bookingId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}








