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
	</div>

    <div>
    <li class="nl"><a href="add-reservation.jsp">Add</a></li>
    <li class="nl"><a href="view-records.jsp">View</a></li>
          <h2> Welcome to Ride Ready Vehicle reservation Application </h2>
          <br>
          <h2> Login to the page to Enjoy the privileges </h2>
          <br>
          <div class="center">
              <button class="login" style="text-align: center">
                  <a href="https://api.asgardeo.io/t/dineshiorg/oauth2/authorize?scope=openid address country email phone profile&response_type=code&redirect_uri=http://localhost:8080/Ride_Ready_-_Vehicle_Reservation_App/oauthorize.jsp&client_id=bG3EtUSLDKifx3Hk3msCIAMIdH0a">
                        Login
                  </a>
              </button>
              
          </div>
     </div> 
</body>
</html>



