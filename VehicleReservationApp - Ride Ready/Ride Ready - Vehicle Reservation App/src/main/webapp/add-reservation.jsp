<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <title>Add Reservation</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>

<%@page import="java.sql.*"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="com.web.database.DBConnection"%>
<%@page import="com.web.database.DBConfig"%>

<%
   //String username = "testuser";
 String username =  (String)request.getSession().getAttribute("username"); 
%>

<body>
    <div class="navbar">
        <h1> Vehicle Service Reservation <br> Ride Ready</h1>
        <ul class="nav">
              <li class="nl"><a href="home.jsp">Home</a></li>
              <li class="nl"><a href="user-profile.jsp">Profile</a></li>
              <li class="nl"><a href="view-records.jsp">Records</a></li>
        </ul>
    </div>
    
<%
    String msg = request.getParameter("msg");
    if (msg != null && !msg.isEmpty()) {
        String alertClass = msg.equals("valid") ? "alert-success" : "alert-danger";
        String alertMessage = msg.equals("valid") ? "Reservation added successfully!" : "Failed to add reservation. Please try again.";
%>
    <div style="color: red; font-size: 30px;" class="alert <%= alertClass %>">
        <%= alertMessage %>
    </div>
<%
    }
%>

    <form action="add-reservation-process.jsp" method="post">
        <h2>Add Reservation Form</h2>
        <label>Date of Service Reservation:</label>
        <input type="date" name="date" required><br>

        <label>Preferred Time:</label>
        <select name="time">
            <option value="10 AM">10 AM</option>
            <option value="11 AM">11 AM</option>
            <option value="12 PM">12 PM</option>
        </select><br>

        <label>Preferred Location:</label>
        <select name="location">
            <option value="Colombo">Colombo</option>
            <option value="Gampaha">Gampaha</option>
            <option value="Galle">Galle</option>
            <option value="Kandy">Kandy</option>
            <option value="Jaffna">Jaffna</option>
            <option value="Ampara">Ampara</option>
            <option value="Anuradhapura">Anuradhapura</option>
            <option value="Hatton">Hatton</option>
            <option value="Kalutara">Kalutara</option>
            <option value="Vavuniya">Vavuniya</option>
            <option value="Mannar">Mannar</option>
            <option value="Matara">Matara</option>
            <option value="Polannaruwa">Polannaruwa</option>
            <option value="Trincomalee">Trincomalee</option>
        </select><br>

        <label>Vehicle Number:</label>
        <input type="text" name="vehicle_no" required><br>

        <label>Current Mileage:</label>
        <input type="number" name="mileage" required><br>

        <label>Message:</label>
        <textarea name="message"></textarea><br>

        <label>Username:</label>
        <input type="text" name="username" value="<%= username %>" readonly>

        <div class="center">
           <button class="button" type="submit">Submit</button>
        </div>
    </form>
</body>
</html>

    