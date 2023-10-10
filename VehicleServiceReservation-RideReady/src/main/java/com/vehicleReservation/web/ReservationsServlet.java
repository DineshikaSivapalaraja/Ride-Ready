//package com.vehicleReservation.web;
//
//import com.vehicleReservation.model.Reservation;
//import com.vehicleReservation.dao.ReservationDAO;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//
//@WebServlet(urlPatterns = "/")
//public class ReservationsServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private ReservationDAO reservationDAO;
//
//	public void init() {
//		reservationDAO = new ReservationDAO();
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String action = request.getServletPath();
//
//		try {
//			switch (action) {
//			case "/new":
//				showNewForm(request, response);
//				break;
//			case "/insert":
//				insertUser(request, response);
//				break;
//			case "/delete":
//				deleteUser(request, response);
//				break;
//			case "/edit":
//				showEditForm(request, response);
//				break;
//			case "/update":
//				updateUser(request, response);
//				break;
//			default:
//				listUser(request, response);
//				break;
//			}
//		} catch (SQLException ex) {
//			throw new ServletException(ex);
//		}
//	}
//
//	private void listUser(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException, ServletException {
//		List<Reservation> listUser = (List<Reservation>) reservationDAO.selectAllVehicle();
//		request.setAttribute("listUser", listUser);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicle-reservation-list.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicle-reservation-form.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, ServletException, IOException {
//		int booking_id = Integer.parseInt(request.getParameter("booking_id"));
//		Reservation existingUser = reservationDAO.selectVehicle(booking_id);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicle-reservation-form.jsp");
//		request.setAttribute("Vehicle", existingUser);
//		dispatcher.forward(request, response);
//
//	}
//
//	private void insertUser(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException {
//
//		String date = request.getParameter("date");
//		String time = request.getParameter("time");
//		String location = request.getParameter("location");
//		String vehicle_no = request.getParameter("vehicle_no");
//		int mileage = Integer.parseInt(request.getParameter("mileage"));
//		String message = request.getParameter("message");
//		String username = request.getParameter("username");
//		Reservation newUser = new Reservation(date, time, location, vehicle_no, mileage, message, username);
//		reservationDAO.insertVehicle(newUser);
//		response.sendRedirect("list");
//	}
//
//	private void updateUser(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException {
//		int booking_id = Integer.parseInt(request.getParameter("booking_id"));
//		String date = request.getParameter("date");
//		String time = request.getParameter("time");
//		String location = request.getParameter("location");
//		String vehicle_no = request.getParameter("vehicle_no");
//		int mileage = Integer.parseInt(request.getParameter("mileage"));
//		String message = request.getParameter("message");
//		String username = request.getParameter("username");
//
//		Reservation book = new Reservation(booking_id, date, time, location, vehicle_no, mileage, message, username);
//		reservationDAO.updateVehicle(book);
//		response.sendRedirect("list");
//	}
//
//	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException {
//		int booking_id = Integer.parseInt(request.getParameter("booking_id"));
//		reservationDAO.deleteVehicle(booking_id);
//		response.sendRedirect("list");
//
//	}
//
//}

//package com.vehicleReservation.web;
//
//import com.vehicleReservation.model.Reservation;
//import com.vehicleReservation.dao.ReservationDAO;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//@WebServlet(urlPatterns = {"/reservations", "/new", "/insert", "/delete"})
//public class ReservationsServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private ReservationDAO reservationDAO;
//
//	public void init() {
//		reservationDAO = new ReservationDAO();
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String action = request.getServletPath();
//
//		try {
//			switch (action) {
//				case "/new":
//					showNewForm(request, response);
//					break;
//				case "/insert":
//					insertReservation(request, response);
//					break;
//				case "/delete":
//					deleteReservation(request, response);
//					break;
//				case "/reservations":
//				default:
//					listReservations(request, response);
//					break;
//			}
//		} catch (SQLException ex) {
//			throw new ServletException(ex);
//		}
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//	private void listReservations(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException, ServletException {
//		List<Reservation> reservations = reservationDAO.selectAllReservations();
//		request.setAttribute("reservations", reservations);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("reservation-list.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("reservation-form.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	private void insertReservation(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException {
//		String date = request.getParameter("date");
//		String time = request.getParameter("time");
//		String location = request.getParameter("location");
//		String vehicleNo = request.getParameter("vehicle_no");
//		int mileage = Integer.parseInt(request.getParameter("mileage"));
//		String message = request.getParameter("message");
//		String username = request.getParameter("username");
//
//		Reservation newReservation = new Reservation(date, time, location, vehicleNo, mileage, message, username);
//		reservationDAO.insertReservation(newReservation);
//		response.sendRedirect("reservations");
//	}
//
//	private void deleteReservation(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException {
//		int bookingId = Integer.parseInt(request.getParameter("booking_id"));
//		reservationDAO.deleteReservation(bookingId);
//		response.sendRedirect("reservations");
//	}
//}


//new
//package com.vehicleReservation.web;
//
//import com.vehicleReservation.model.Reservation;
//import com.vehicleReservation.dao.ReservationDAO;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//@WebServlet(urlPatterns = {"/reservations", "/new", "/insert", "/delete"})
//public class ReservationsServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private ReservationDAO reservationDAO;
//
//	public void init() {
//		reservationDAO = new ReservationDAO();
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String action = request.getServletPath();
//
//		try {
//			switch (action) {
//				case "/new":
//					showAddForm(request, response);
//					break;
//				case "/insert":
//					insertReservation(request, response);
//					break;
//				case "/delete":
//					deleteReservation(request, response);
//					break;
//				default:
//					listReservations(request, response);
//					break;
//			}
//		} catch (SQLException e) {
//			throw new ServletException(e);
//		}
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//	private void listReservations(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException, ServletException {
//		List<Reservation> reservationList = reservationDAO.selectAllReservations();
//		request.setAttribute("reservationList", reservationList);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("view-records.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	private void showAddForm(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("add-reservation.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	private void insertReservation(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException {
//		String date = request.getParameter("date");
//		String time = request.getParameter("time");
//		String location = request.getParameter("location");
//		String vehicleNo = request.getParameter("vehicle_no");
//		int mileage = Integer.parseInt(request.getParameter("mileage"));
//		String message = request.getParameter("message");
//		String username = request.getParameter("username");
//
//		Reservation newReservation = new Reservation(date, time, location, vehicleNo, mileage, message, username);
//		reservationDAO.insertReservation(newReservation);
//
//		response.sendRedirect("reservations");
//	}
//
//	private void deleteReservation(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException {
//		int bookingId = Integer.parseInt(request.getParameter("id"));
//		reservationDAO.deleteReservation(bookingId);
//		response.sendRedirect("reservations");
//	}
//}

//package com.vehicleReservation.web;
//
//import com.vehicleReservation.model.Reservation;
//import com.vehicleReservation.dao.ReservationDAO;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//@WebServlet(urlPatterns = {"/reservations", "/new", "/insert", "/delete"})
//public class ReservationsServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private ReservationDAO reservationDAO;
//
//	public void init() {
//		reservationDAO = new ReservationDAO();
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String action = request.getServletPath();
//
//		try {
//			switch (action) {
//				case "/new":
//					showAddForm(request, response);
//					break;
//				case "/insert":
//					insertReservation(request, response);
//					break;
//				case "/delete":
//					deleteReservation(request, response);
//					break;
//				default:
//					listReservations(request, response);
//					break;
//			}
//		} catch (SQLException e) {
//			throw new ServletException(e);
//		}
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//	private void listReservations(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException, ServletException {
//		List<Reservation> reservationList = reservationDAO.selectAllReservations();
//		request.setAttribute("reservationList", reservationList);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("view-records.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	private void showAddForm(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("add-reservation.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	private void insertReservation(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException {
//		String date = request.getParameter("date");
//		String time = request.getParameter("time");
//		String location = request.getParameter("location");
//		String vehicleNo = request.getParameter("vehicle_no");
//		int mileage = Integer.parseInt(request.getParameter("mileage"));
//		String message = request.getParameter("message");
//		String username = request.getParameter("username");
//
//		Reservation newReservation = new Reservation(date, time, location, vehicleNo, mileage, message, username);
//
//		// Insert the reservation into the database
//		try {
//			reservationDAO.insertReservation(newReservation);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			// Handle any exceptions here
//		}
//
//		response.sendRedirect("reservations");
//	}
//
//	private void deleteReservation(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException {
//		int bookingId = Integer.parseInt(request.getParameter("id"));
//		reservationDAO.deleteReservation(bookingId);
//		response.sendRedirect("reservations");
//	}
//}

package com.vehicleReservation.web;

import com.vehicleReservation.model.Reservation;
import com.vehicleReservation.dao.ReservationDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/reservations", "/new", "/insert", "/delete"})
public class ReservationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationDAO reservationDAO;

	public void init() {
		reservationDAO = new ReservationDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
				case "/new":
					showAddForm(request, response);
					break;
				case "/insert":
					insertReservation(request, response);
					break;
				case "/delete":
					deleteReservation(request, response);
					break;
				default:
					listReservations(request, response);
					break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listReservations(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Reservation> reservationList = reservationDAO.selectAllReservations();
		request.setAttribute("reservationList", reservationList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view-records.jsp");
		dispatcher.forward(request, response);
	}

	private void showAddForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("add-reservation.jsp");
		dispatcher.forward(request, response);
	}

	private void insertReservation(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String location = request.getParameter("location");
		String vehicleNo = request.getParameter("vehicle_no");
		int mileage = Integer.parseInt(request.getParameter("mileage"));
		String message = request.getParameter("message");
		String username = request.getParameter("username");

		Reservation newReservation = new Reservation(date, time, location, vehicleNo, mileage, message, username);
		reservationDAO.insertReservation(newReservation);

		response.sendRedirect("reservations");
	}

	private void deleteReservation(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int bookingId = Integer.parseInt(request.getParameter("id"));
		reservationDAO.deleteReservation(bookingId);
		response.sendRedirect("reservations");
	}
}