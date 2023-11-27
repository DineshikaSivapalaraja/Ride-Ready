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
          <h2> Welcome to Ride Ready Vehicle reservation Application </h2>
          <br>
          <h2> Login to the page to Enjoy the privileges </h2>
          <br>
          <div class="center" id="boX">
              <button class="login" style="text-align: center" >
                  <a id="ind1" href="https://api.asgardeo.io/t/dineshiorg/oauth2/authorize?scope=openid name email phone country profile&response_type=code&redirect_uri=http://localhost:8080/Ride_Ready_-_Vehicle_Reservation_App/oauthorize.jsp&client_id=gYaBx1rA9Ss91g4xFww1bbmT394a">Login</a>
              </button>
              
              <p class="register" >No account?<br>Register today!</p>
              <a href="https://console.asgardeo.io/" style="text-align: center" id="ind2"><b>Register</b></a> 
              
          </div>
     </div> 
</body>
</html>



