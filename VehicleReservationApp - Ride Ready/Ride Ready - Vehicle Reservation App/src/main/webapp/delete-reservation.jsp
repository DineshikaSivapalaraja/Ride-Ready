<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.web.database.DBConnection"%>
<%@ page import="java.sql.*"%>

<%


String bookingId = request.getParameter("id");

    try {
        Connection con = DBConnection.getCon();
        PreparedStatement ps = con.prepareStatement("DELETE FROM vehicle_service WHERE booking_id = ?");
        ps.setString(1, bookingId);

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

        ps.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("view-records.jsp?msg=exception"); // Redirect with an exception message
    }
%>
