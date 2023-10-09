<!DOCTYPE html>
<html>
<head>
    <title>Add Reservation</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">

</head>
<body>
    <div class="navbar">
        <h1> Vehicle Service Reservation <br> Ride Ready</h1>
        <ul class="nav">
              <li class="nl"><a href="home.jsp">Home</a></li>
               <li class="nl"><a href="user-profile.jsp">Profile</a></li>
             <li class="nl"><a href="view-records.jsp">Records</a></li>
        </ul>
    </div>

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
            <option value="Galle">Colombo</option>
            <option value="Kandy">Gampaha</option>
            <option value="Jaffna">Colombo</option>
            <option value="Ampara">Gampaha</option>
        </select><br>

        <label>Vehicle Number:</label>
        <input type="text" name="vehicle_no" required><br>

        <label>Current Mileage:</label>
        <input type="number" name="mileage" required><br>

        <label>Message:</label>
        <textarea name="message"></textarea><br>

        <div class="center">
           <button class="button">Submit</button>
        </div>
    </form>
</body>
</html>
