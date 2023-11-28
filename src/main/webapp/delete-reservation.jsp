<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.web.database.DBConnection" %>
<%@ page import="java.sql.*" %>

<%
try {
    // Ensure that the user is logged in (example: you may have a more robust authentication mechanism)
    if (request.getSession().getAttribute("username") == null) {
        response.sendRedirect("login.jsp"); // Redirect unauthorized users to the login page
        return;
    }

    String bookingId = request.getParameter("id");

    Connection con = null;
    PreparedStatement ps = null;

    try {
        con = DBConnection.getCon();
        
        // Use a prepared statement to prevent SQL injection
        ps = con.prepareStatement("DELETE FROM vehicle_service WHERE booking_id = ? AND username = ?");
        ps.setString(1, bookingId);
        ps.setString(2, (String) request.getSession().getAttribute("username"));

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            // Set success message attribute
            request.setAttribute("successMessage", "Deleted vehicle reservation successfully!");
            // Forward the request to view-records.jsp
            RequestDispatcher rd = request.getRequestDispatcher("view-records.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("view-records.jsp?msg=Invalid"); // Redirect with an error message
        }
    } catch (SQLException e) {
        e.printStackTrace();
        response.sendRedirect("view-records.jsp?msg=exception"); // Redirect with an exception message
    } finally {
        // Close resources in a finally block
        try {
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
    response.sendRedirect("view-records.jsp?msg=exception"); // Redirect with an exception message
}
%>
