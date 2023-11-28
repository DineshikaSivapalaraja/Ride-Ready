<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, java.net.*, java.util.*" %>
<%@ page import="org.json.JSONObject" %>

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
              <li class="nl"><a href="https://api.asgardeo.io/t/dineshiorg/oidc/logout">Logout</a></li>
           </ul>
      </div>
<%

     // Extract the access_token, id_token from session
        String accessToken = (String) request.getSession().getAttribute("access_token");
        String idToken = (String) request.getSession().getAttribute("id_token");

    // Check access token is not null or empty
    if (accessToken != null && !accessToken.isEmpty()) {
        // Define userinfo endpoint
        String userinfoEndpoint = "https://api.asgardeo.io/t/dineshiorg/oauth2/userinfo";
        String introspectionEndpoint ="https://api.asgardeo.io/t/dineshiorg/oauth2/introspect";


        try {
            // Create a URL object for the userinfo endpoint
            URL userinfoUrl = new URL(userinfoEndpoint);

            // Open a connection to the userinfo endpoint
            HttpURLConnection userinfoConnection = (HttpURLConnection) userinfoUrl.openConnection();

            // Set the request method to GET
            userinfoConnection.setRequestMethod("GET");

            // Set the Authorization header with the access token
            userinfoConnection.setRequestProperty("Authorization", "Bearer " + accessToken);

            // Get the response code from the userinfo endpoint
            int userinfoResponseCode = userinfoConnection.getResponseCode();

            // Read the response data from the userinfo endpoint
            try (BufferedReader userinfoReader = new BufferedReader(new InputStreamReader(userinfoConnection.getInputStream()))) {
                String userinfoInputLine;
                StringBuilder userinfoResponse = new StringBuilder();

                while ((userinfoInputLine = userinfoReader.readLine()) != null) {
                    userinfoResponse.append(userinfoInputLine);
                }

                // Parse the userinfo response data as JSON
                JSONObject userinfoJson = new JSONObject(userinfoResponse.toString());

                // Extract user information
                String username = userinfoJson.optString("username");
                String firstName = userinfoJson.optString("given_name");
                String lastName = userinfoJson.optString("family_name");
                String email = userinfoJson.optString("email");
                String contactNo = userinfoJson.optString("phone_number");
             	// Extract the address object
                JSONObject addressJson = userinfoJson.optJSONObject("address");

                // Initialize country as an empty string 
                String country = "";

                // Check address is not null
                if (addressJson != null) {
                    // Retrieve the country from the address object
                    country = addressJson.optString("country");
                }

             	// Set the username as session
                request.getSession().setAttribute("username", username);

%>

      <div class="pro">
      <h2>User Profile</h2>
          <ul>
            <li><b>Username:</b><%= username %></li>
            <li><b>Name:</b><%= firstName +" "+lastName %>
            <li><b>Email:</b><%= email %></li> 
            <li><b>Contact Number:</b><%= contactNo %></li> 
            <li><b>Country:</b><%= country %></li> 
          </ul>
      </div>
</body>
</html>

<%
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        // Access token is not present
        out.println("Access token is missing.");
    }
%>





