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
         </ul>
    </div>

    <!-- Display the user's vehicle service reservations here -->
    <h2 class="record">Reservation Records</h2>
    <table>
        <!-- Table header -->
        <tr>
            <th>Date</th>
            <th>Time</th>
            <th>Location</th>
            <th>Vehicle Number</th>
            <th>Mileage</th>
            <th>Message</th>
            <th>Action</th>
        </tr>
        <!-- Loop through and display reservation records -->
        <c:forEach items="${reservationList}" var="reservation">
            <tr>
                <td>${reservation.date}</td>
                <td>${reservation.time}</td>
                <td>${reservation.location}</td>
                <td>${reservation.vehicle_no}</td>
                <td>${reservation.mileage}</td>
                <td>${reservation.message}</td>
                <td><a href="delete-reservation.jsp?id=${reservation.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
