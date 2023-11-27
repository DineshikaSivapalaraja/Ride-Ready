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
              <li class="nl"><a href="view-records.jsp">Logout</a></li>
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
	        <div >
				<label for="username">Username</label>
				<input type="text" name="username" value="<%= username %>" readonly>
            </div>
			<div >
				<label for="date">Date of Service Reservation</label>
				<input type="date" name="date" required>
			</div>
			<div>
				 <label for="time">Preferred Time</label>
				 <select name="time" required>
					<option value="10:00:00">10:00 A.M.</option>
					<option value="11:00:00">11:00 A.M.</option>
					<option value="12:00:00">12:00 P.M.</option>
				 </select>
			</div>
			<div>
				<label for="location">Preferred Location</label>
				<select name="location" required>
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
                </select>
			</div>  
			<div >
				<label for="vehicle_no">Vehicle Number</label>
				<input type="text" name="vehicle_no" required>
			</div>
			<div>
			    <label for="mileage">Current Mileage</label>
				<input type="text" name="mileage" required>
			</div>          	
			<div>
				<label for="message">Message</label>
				<textarea name="message"></textarea><br>
			</div>
			<div class="center">
                 <button class="button" type="submit">Submit</button>
             </div>
</form>	 
</body>
</html>



    