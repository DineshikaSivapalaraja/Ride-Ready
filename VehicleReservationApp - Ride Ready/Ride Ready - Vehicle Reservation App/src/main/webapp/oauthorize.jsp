<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.web.IDPConfig.OIDCConfig" %>
<%@ page import="java.io.*,java.net.*,java.util.*" %>
<%@ page import="org.json.JSONObject" %>

<%
    String authorizationCode = request.getParameter("code");

    // Check authorization code is not null or empty
    if (authorizationCode != null && !authorizationCode.isEmpty()) {
    	// Use the configuration 
        String clientId = OIDCConfig.getClientId();
        String clientSecret = OIDCConfig.getClientSecret();
        String redirectUri = OIDCConfig.getRedirectUri();
        String tokenEndpoint = OIDCConfig.getTokenEndpoint();


        try {
            // Construct the request data for token exchange
            String requestData = "code=" + authorizationCode +
                    "&grant_type=authorization_code" +
                    "&client_id=" + clientId +
                    "&client_secret=" + clientSecret +
                    "&redirect_uri=" + URLEncoder.encode(redirectUri, "UTF-8");

            // Create URL for the token endpoint
            URL tokenUrl = new URL(tokenEndpoint);

            // Open a connection to the token endpoint
            HttpURLConnection tokenConnection = (HttpURLConnection) tokenUrl.openConnection();

            // Set the request method to POST
            tokenConnection.setRequestMethod("POST");

            // Enable input/output streams
            tokenConnection.setDoOutput(true);

            // Write the request data to the output stream
            try (DataOutputStream tokenOutputStream = new DataOutputStream(tokenConnection.getOutputStream())) {
                tokenOutputStream.writeBytes(requestData);
                tokenOutputStream.flush();
            }

            // Get the response code from the token endpoint
            int tokenResponseCode = tokenConnection.getResponseCode();

            // Read the response data from the token endpoint
            try (BufferedReader tokenReader = new BufferedReader(new InputStreamReader(tokenConnection.getInputStream()))) {
                String tokenInputLine;
                StringBuilder tokenResponse = new StringBuilder();

                while ((tokenInputLine = tokenReader.readLine()) != null) {
                    tokenResponse.append(tokenInputLine);
                }

             	// Handle the response data
                String responseDataStr = tokenResponse.toString();
                
                // Parse the response data as JSON
                JSONObject jsonResponse = new JSONObject(responseDataStr);

                // Extract access_token and id_token
                String access_token = jsonResponse.getString("access_token");
                String id_token = jsonResponse.getString("id_token");

                // Store tokens in session attributes
                request.getSession().setAttribute("access_token", access_token);
                request.getSession().setAttribute("id_token", id_token);
                
                response.sendRedirect("profile.jsp");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        // Authorization code is not present
        out.println("Authorization code is missing.");
    }
%>