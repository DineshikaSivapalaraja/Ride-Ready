<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>

<body>
    <div class="navbar">
         <h1> Vehicle Service Reservation <br> Ride Ready</h1>
         <h3>Welcome, <%= request.getRemoteUser() %></h3>
	</div>

    <div>
       <ul class="home">
           <li class="hl"><a href="user-profile.jsp">User Profile</a></li>
           <li class="hl"><a href="view-records.jsp">View Records</a></li>
           <li class="hl"><a href="add-reservation.jsp">Add Reservation</a></li>
       </ul>
     </div>

</body>
</html>