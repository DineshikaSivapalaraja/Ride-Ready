<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Ride Ready</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Vehicle Service Reservation - Ride Ready</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Vehicle Reservations</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Vehicle Reservation</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Vehicle Reservation</a>
			</div>
			<br>

			<table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Booking_ID</th>
                        <th>Username</th>
                        <th>Reservation Date</th>
                        <th>Preferred Time</th>
                        <th>Preferred Location</th>
                        <th>Vehicle Registration Number</th>
                        <th>Current Mileage</th>
                        <th>Message</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Loop through the vehicle service reservations -->
                    <c:forEach var="reservation" items="${reservationList}">
                        <tr>
                            <td><c:out value="${reservation.booking_id}" /></td>
                            <td><c:out value="${reservation.username}" /></td>
                            <td><c:out value="${reservation.reservationDate}" /></td>
                            <td><c:out value="${reservation.preferredTime}" /></td>
                            <td><c:out value="${reservation.preferredLocation}" /></td>
                            <td><c:out value="${reservation.vehicleRegistrationNumber}" /></td>
                            <td><c:out value="${reservation.currentMileage}" /></td>
                            <td><c:out value="${reservation.message}" /></td>
                            <td>
                                <!-- Provide links for actions -->
                                <a href="edit-reservation?booking_id=<c:out value='${reservation.booking_id}' />">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="delete-reservation?booking_id=<c:out value='${reservation.booking_id}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

		</div>
	</div>
</body>
</html>
