package com.packages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayReservationsServlet")
public class DisplayReservationsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<VehicleReservation> reservations = new ArrayList<>();

        try {
            Connection connection = DatabaseConnection.getConnection();
            if (connection != null) {
                String sql = "SELECT * FROM vehicle_service";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    VehicleReservation reservation = new VehicleReservation();
                    reservation.setBookingId(resultSet.getInt("booking_id"));
                    reservation.setDate(resultSet.getDate("date"));
                    reservation.setTime(resultSet.getTime("time"));
                    reservation.setLocation(resultSet.getString("location"));
                    reservation.setVehicleNumber(resultSet.getString("vehicle_no"));
                    reservation.setMileage(resultSet.getInt("mileage"));
                    reservation.setMessage(resultSet.getString("message"));
                    reservation.setUsername(resultSet.getString("username"));

                    reservations.add(reservation);
                }

                resultSet.close();
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("reservations", reservations);
        request.getRequestDispatcher("/displayReservations.jsp").forward(request, response);
    }
}
