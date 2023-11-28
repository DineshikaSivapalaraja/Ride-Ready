<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<%
    String username = (String) request.getSession().getAttribute("username");
%>

<body>
    <div class="navbar">
         <h1> Vehicle Service Reservation <br> Ride Ready</h1>
         <h3>Welcome, <%= username %></h3>
	</div>

    <div>
       <ul class="home">
           <li class="hl"><a href="user-profile.jsp">User Profile</a></li>
           <li class="hl"><a href="view-records.jsp">View Records</a></li>
           <li class="hl"><a href="add-reservation.jsp">Add Reservation</a></li>
           <li class="hl"><a href="https://api.asgardeo.io/t/dineshiorg/oidc/logout">Logout</a></li>
       </ul>
     </div>

</body>
</html>