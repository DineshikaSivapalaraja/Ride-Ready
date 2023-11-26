<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.web.database.DBConnection"%>
<%@page import="com.web.database.DBConfig"%>
<%@page import="java.sql.*"%>
<%@page import="java.text.SimpleDateFormat" %>

<%
    //String username = "testuser";

    // Retrieve form data 
    String username = request.getParameter("username");
    String dateStg = request.getParameter("date");
    String time = request.getParameter("time");
    String location = request.getParameter("location");
    String vehicleRegNo = request.getParameter("vehicle_no");
    String mileageStg = request.getParameter("mileage");
    String message = request.getParameter("message");

    try {
        // Convert String to Date 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = sdf.parse(dateStg);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        // Convert String to Integer 
        int mileage = Integer.parseInt(mileageStg);

        // Convert String time to java.sql.Time
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        java.util.Date parsedTime = timeFormat.parse(time);
        java.sql.Time sqlTime = new java.sql.Time(parsedTime.getTime());

        // Perform database operations (insertion) here using the retrieved data
        Connection con = DBConnection.getCon();
        PreparedStatement ps = con.prepareStatement("insert into vehicle_service (date, time, location, vehicle_no, mileage, message, username) values(?,?,?,?,?,?,?)");
        // Set parameters for the prepared statement
        ps.setDate(1, sqlDate);
        ps.setTime(2, sqlTime);
        ps.setString(3, location);
        ps.setString(4, vehicleRegNo);
        ps.setInt(5, mileage);
        ps.setString(6, message);
        ps.setString(7, username);

        // Execute the SQL query
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            // Redirect to the same page with a success message
            //response.sendRedirect("add-reservation.jsp?msg=valid");
            
        	// Debugging statement
           //System.out.println("Reservation added successfully!");
          response.sendRedirect("add-reservation.jsp?msg=valid");
        } else {
            // Redirect to the same page with an error message
           // response.sendRedirect("add-reservation.jsp?msg=Invalid");
            
         // Debugging statement
            //System.out.println("Failed to add reservation.");
            response.sendRedirect("add-reservation.jsp?msg=Invalid");
        }

        // Close the resources
        ps.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
        // Redirect to the same page with an exception message
        response.sendRedirect("add-reservation.jsp?msg=exception");
    }
%>





