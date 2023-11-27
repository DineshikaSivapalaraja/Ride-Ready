<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.web.database.DBConnection" %>
<%@ page import="java.sql.*" %>
<%@page import="org.owasp.encoder.Encode"%>

<!DOCTYPE html>
<html>
  <head>
      <title>View Records</title>
      <link rel="stylesheet" type="text/css" href="css/styles.css">
  </head>
  <body>

    <div class="navbar">
         <h1> Vehicle Service Reservation <br> Ride Ready</h1>
         <ul class="nav">
              <li class="nl"><a href="home.jsp">Home</a></li>
              <li class="nl"><a href="user-profile.jsp">Profile</a></li>
              <li class="nl"><a href="add-reservation.jsp">Add</a></li>
              <li class="nl"><a href="https://api.asgardeo.io/t/dineshiorg/oidc/logout">Logout</a></li>
         </ul>
    </div>
    
  <%
// Check for success message attribute
String successMessage = (String) request.getAttribute("successMessage");

if (successMessage != null && !successMessage.isEmpty()) {
%>
    <div class="success-message" style="color: red; font-size: 30px; text-align: center;">
        <%= successMessage %>
    </div>
<%
}
%>
    
<%
    String username = (String) request.getSession().getAttribute("username");

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        // Fetch reservation records from the database
        con = DBConnection.getCon();

        if (con != null) {
        	 // Mitigate SQL Injection by using prepared statements
            ps = con.prepareStatement("select * from vehicle_service where username = ?");
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {

%>

    <!-- Display the user's vehicle service reservation -->
    <h2 class="record">Reservation Records</h2>
    <table>
    <thead>
        <tr>
            <th>Booking ID</th>
            <th>Date</th>
            <th>Time</th>
            <th>Location</th>
            <th>Vehicle Number</th>
            <th>Mileage</th>
            <th>Message</th>
            <th>Username</th>
            <th>Action</th>
        </tr>    
    </thead>
    <tbody>
        <%
            do {
        %>     
			<tr>
			   <td><%= Encode.forHtml(rs.getString("booking_id")) %></td>
			   <td><%= Encode.forHtml(rs.getString("date")) %></td>
			   <td><%= Encode.forHtml(rs.getString("time")) %></td>
			   <td><%= Encode.forHtml(rs.getString("location")) %></td>
			   <td><%= Encode.forHtml(rs.getString("vehicle_no")) %></td>
			   <td><%= Encode.forHtml(rs.getString("mileage")) %></td>
			   <td><%= Encode.forHtml(rs.getString("message")) %></td>
			   <td><%= Encode.forHtml(rs.getString("username")) %></td>
			   <td><a href="delete-reservation.jsp?id=<%= rs.getString("booking_id") %>">Delete</a></td>
			</tr>
            
        <%
            } while (rs.next());
        %>
     </tbody>
     </table>
<%
            } else {
%>
    <p style="color: red; font-size: 30px; text-align: center;">No reservations!</p>
<%
            }
        } else {
%>
    <p style="color: red; font-size: 30px; text-align: center;">Database connection is null.</p>
<%
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close resources in a finally block
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
%>
</body>
</html>
