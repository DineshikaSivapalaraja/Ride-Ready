<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.web.database.DBConnection" %>
<%@ page import="com.web.database.DBConfig" %>
<%@ page import="java.sql.*" %>

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
              <li class="nl"><a href="add-reservation.jsp">Add</a></li>
          </ul>
      </div>
       
<%
       String username =  (String)request.getSession().getAttribute("username");
           try {
               
               // For testing purposes, set manual username
               //String username = "testuser";

               // Fetch reservation records from the database
               Connection con = DBConnection.getCon();
               PreparedStatement ps = con.prepareStatement("select * from vehicle_service where username = ?");
               ps.setString(1, username);
               ResultSet rs = ps.executeQuery();

               if (rs.next()) {
       %>

    <div class="navbar">
         <h1> Vehicle Service Reservation <br> Ride Ready</h1>
         <ul class="nav">
              <li class="nl"><a href="home.jsp">Home</a></li>
              <li class="nl"><a href="user-profile.jsp">Profile</a></li>
              <li class="nl"><a href="add-reservation.jsp">Add</a></li>
         </ul>
    </div>

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
             <td><%= rs.getString("booking_id") %></td>
             <td><%= rs.getString("date") %></td>
             <td><%= rs.getString("time") %></td>
             <td><%= rs.getString("location") %></td>
             <td><%= rs.getString("vehicle_no") %></td>
             <td><%= rs.getString("mileage") %></td>
             <td><%= rs.getString("message") %></td>
             <td><%= rs.getString("username") %></td>
             <td><a href="delete-reservation.jsp?id=<%= rs.getString("booking_id") %>">Delete</a></td><!--  fix  -->
         </tr>
         <%
             } while (rs.next());
         %>
     </tbody>
     </table>
    
<%
     } else {
%>
     <p style="color: red; font-size: 30px;">No reservations.</p>
<%
      }
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>

</body>
</html>

