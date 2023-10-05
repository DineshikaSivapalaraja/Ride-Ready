package com.vehicleReservation.web;

import com.vehicleReservation.model.vehicle;
import com.vehicleReservation.dao.vehicleDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(urlPatterns = "/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private vehicleDao VehicleDAO;
	
	public void init() {
		VehicleDAO = new vehicleDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<vehicle> listUser = (List<vehicle>) VehicleDAO.selectAllVehicle();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicle-reservation-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicle-reservation-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int booking_id = Integer.parseInt(request.getParameter("booking_id"));
		vehicle existingUser = VehicleDAO.selectVehicle(booking_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicle-reservation-form.jsp");
		request.setAttribute("Vehicle", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {

		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String location = request.getParameter("location");
		String vehicle_no = request.getParameter("vehicle_no");
		int mileage = Integer.parseInt(request.getParameter("mileage"));
		String message = request.getParameter("message");
		String username = request.getParameter("username");
		vehicle newUser = new vehicle(date, time, location, vehicle_no, mileage, message, username);
		VehicleDAO.insertVehicle(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int booking_id = Integer.parseInt(request.getParameter("booking_id"));
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String location = request.getParameter("location");
		String vehicle_no = request.getParameter("vehicle_no");
		int mileage = Integer.parseInt(request.getParameter("mileage"));
		String message = request.getParameter("message");
		String username = request.getParameter("username");

		vehicle book = new vehicle(booking_id, date, time, location, vehicle_no, mileage, message, username);
		VehicleDAO.updateVehicle(book);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int booking_id = Integer.parseInt(request.getParameter("booking_id"));
		VehicleDAO.deleteVehicle(booking_id);
		response.sendRedirect("list");

	}

}
