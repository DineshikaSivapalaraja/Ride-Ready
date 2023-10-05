%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Ride Ready</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	cross-origin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Vehicle Reservation Application - Ride Ready</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Reservations</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit Record
            		</c:if>
						<c:if test="${user == null}">
            			Add New Record
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="booking_id" value="<c:out value='${user.booking_id}' />" />
				</c:if>

				<form action="insert-reservation" method="post">
                    <field-set class="form-group">
                        <label>Username</label>
                        <input type="text" value="<c:out value='${user.username}' />" class="form-control" name="username" required="required">
                    </field-set>

                    <field-set class="form-group">
                        <label>Date of Service Reservation</label>
                        <input type="date" min="<%= LocalDate.now().plusDays(1) %>" class="form-control" name="reservationDate" required="required">
                    </field-set>

                    <field-set class="form-group">
                        <label>Preferred Time</label>
                        <select class="form-control" name="preferredTime">
                            <option value="10 AM">10 AM</option>
                            <option value="11 AM">11 AM</option>
                            <option value="12 PM">12 PM</option>
                        </select>
                    </field-set>

                    <field-set class="form-group">
                        <label>Preferred Location</label>
                        <select class="form-control" name="preferredLocation">
                            <option value="District 1">Colombo</option>
                            <option value="District 2">Gampaha</option>
                            <option value="District 3">Jaffna</option>
                            <option value="District 4">Kaluthura</option>
                            <option value="District 5">Galle</option>
                            <option value="District 6">Kandy</option>
                            <option value="District 7">Hatton</option>
                            <option value="District 8">Trincomalee</option>
                            <option value="District 9">Ampara</option>
                            <option value="District 10">Vavuniya</option>
                        </select>
                    </field-set>

                    <field-set class="form-group">
                        <label>Vehicle Registration Number</label>
                        <input type="text" class="form-control" name="vehicleRegistrationNumber" required="required">
                    </field-set>

                    <field-set class="form-group">
                        <label>Current Mileage</label>
                        <input type="number" class="form-control" name="currentMileage" required="required">
                    </field-set>

                    <field-set class="form-group">
                        <label>Message</label>
                        <textarea class="form-control" name="message"></textarea>
                    </field-set>

                    <button type="submit" class="btn btn-success">Submit</button>
                </form>

				</form>
			</div>
		</div>
	</div>
</body>
</html>

