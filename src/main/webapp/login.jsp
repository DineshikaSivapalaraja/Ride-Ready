<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.web.database.DBConnection" %>
<%@ page import="java.sql.*" %>

<%
try {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        con = DBConnection.getCon();

        // Use a prepared statement to prevent SQL injection
        ps = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
        ps.setString(1, username);
        ps.setString(2, password);

        rs = ps.executeQuery();

        if (rs.next()) {
            // User authentication successful
            // Set the username in the session to indicate that the user is logged in
            request.getSession().setAttribute("username", username);

            // Redirect to the home page or another appropriate destination
            response.sendRedirect("home.jsp");
        } else {
            // Authentication failed
            // You may want to redirect to a login page with an error message
            response.sendRedirect("login.jsp?msg=Invalid");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Redirect to login page with an exception message
        response.sendRedirect("login.jsp?msg=exception");
    } finally {
        // Close resources in a finally block
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
} catch (Exception e) {
    e.printStackTrace();
    // Redirect to login page with an exception message
    response.sendRedirect("login.jsp?msg=exception");
}
%>
