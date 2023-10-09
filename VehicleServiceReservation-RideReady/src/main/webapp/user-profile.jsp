<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">

</head>
<body>
     <div class="navbar">
            <h1> Vehicle Service Reservation <br> Ride Ready</h1>
            <ul class="nav">
                 <li class="nl"><a href="home.jsp">Home</a></li>
                 <li class="nl"><a href="view-records.jsp">Records</a></li>
                 <li class="nl"><a href="add-reservation.jsp">Add</a></li>
            </ul>
     </div>

    <div class="pro">
    <h2>User Profile</h2>
         <ul>
            <li><b>Username:</b> <%= request.getRemoteUser() %></li>
            <li><b>Name:</b> John Doe</li> <!-- Replace with actual user name -->
            <li><b>Email:</b> john.doe@example.com</li> <!-- Replace with actual email -->
            <li><b>Contact Number:</b> 123-456-7890</li> <!-- Replace with actual contact number -->
            <li><b>Country:</b> USA</li> <!-- Replace with actual country -->
         </ul>
    </div>
</body>
</html>
