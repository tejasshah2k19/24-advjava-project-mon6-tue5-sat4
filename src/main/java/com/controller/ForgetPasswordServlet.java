package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MailerService;

@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");

		// check email is present in database or not ?

		String otp = "";
		for (int i = 1; i <= 6; i++) {
			otp = otp + (int) (Math.random() * 10) + "";
		}	

		// if present
		// send mail
		MailerService.sendOtpForForgetPassword(email, "Demo", otp);

		// if not
		// send error

	}
}
