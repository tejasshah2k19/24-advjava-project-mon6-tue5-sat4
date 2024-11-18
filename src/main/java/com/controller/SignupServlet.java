package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MailerService;
import com.util.DbConnection;

import java.util.regex.Pattern;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get parameters from request
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = "STUDENT";
		String city = request.getParameter("city");

		// Basic validation
		String errorMessage = validateInputs(firstname, lastname, email, password, role, city);

		if (errorMessage != null) {
			// If there's an error, redirect back to signup with error message
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("Signup.jsp").forward(request, response);
		} else {
			// If validation passes, you can proceed with storing the data in the database
			// (Database connection and insertion code here, skipped for simplicity)

			try {
				Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"insert into users (firstName,lastName,role,email,password,city) values (?,?,?,?,?,?)");
				pstmt.setString(1, firstname);
				pstmt.setString(2, lastname);
				pstmt.setString(3, role);
				pstmt.setString(4, email);
				pstmt.setString(5, password);
				pstmt.setString(6, city);

				pstmt.executeUpdate();//insert update delete 
				
				MailerService.sendWelcomeMail(email, firstname);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Redirect to success page or login page
			response.sendRedirect("Login.jsp");
		}
	}

	private String validateInputs(String firstname, String lastname, String email, String password, String role,
			String city) {

		if (isEmpty(firstname) || isEmpty(lastname) || isEmpty(email) || isEmpty(password) || isEmpty(role)
				|| isEmpty(city)) {
			return "All fields are required.";
		}

		if (!isValidEmail(email)) {
			return "Invalid email format.";
		}

		if (password.length() < 6) {
			return "Password must be at least 6 characters long.";
		}

		return null; // No validation errors
	}

	private boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}

	private boolean isValidEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern pattern = Pattern.compile(emailRegex);
		return pattern.matcher(email).matches();
	}
}
