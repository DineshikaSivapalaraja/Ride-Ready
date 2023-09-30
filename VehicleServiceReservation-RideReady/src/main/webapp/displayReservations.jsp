<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOC TYPE html>
<html>
<head>
    <title>Vehicle Service Reservations</title>
</head>
<body>
    <h1>Vehicle Service Reservations</h1>

    <table border="1">
        <thread>
            <tr>
                <th>Booking ID</th>
                <th>Date</th>
                <th>Time</th>
                <th>Location</th>
                <th>Vehicle Number</th>
                <th>Mileage</th>
                <th>Message</th>
                <th>Username</th>
            </tr>
        </thread>
        <body>
            <c:forEach var="reservation" items="${reservations}">
                <tr>
                    <td>${reservation.bookingId}</td>
                    <td>${reservation.date}</td>
                    <td>${reservation.time}</td>
                    <td>${reservation.location}</td>
                    <td>${reservation.vehicleNumber}</td>
                    <td>${reservation.mileage}</td>
                    <td>${reservation.message}</td>
                    <td>${reservation.username}</td>
                </tr>
            </c:forEach>
        </body>
    </table>
</body>
</html>
