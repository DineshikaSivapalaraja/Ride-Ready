<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.web.database.DB_Connection"%>
<%@ page import="java.sql.*"%>

<%
    String bookingId = request.getParameter("id");

    try {
        Connection con = DB_Connection.getCon();
        PreparedStatement ps = con.prepareStatement("DELETE FROM vehicle_service WHERE booking_id = ?");
        ps.setString(1, bookingId);

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            response.sendRedirect("view-records.jsp"); // Redirect to view-records.jsp after successful deletion
        } else {
            response.sendRedirect("view-records.jsp?msg=Invalid"); // Redirect with an error message
        }

        ps.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("view-records.jsp?msg=exception"); // Redirect with an exception message
    }
%>
