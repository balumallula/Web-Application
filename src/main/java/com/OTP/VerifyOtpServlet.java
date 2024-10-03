package com.OTP;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/VerifyOtpServlet")
public class VerifyOtpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

         Integer sessionOtp = (Integer) session.getAttribute("otp");




         if (sessionOtp == null) {
        	 RequestDispatcher rd1 = request.getRequestDispatcher("./forgotPass.jsp?msg1=No OTP found. Please request a new OTP");
	        rd1.include(request, response);
	        return;
        }

        try {
            int userOtp = Integer.parseInt(request.getParameter("otp"));

            if (userOtp == sessionOtp) {

                 RequestDispatcher rd1 = request.getRequestDispatcher("./setNewpass.jsp");
      	        rd1.include(request, response);
            } else {
            	  RequestDispatcher rd1 = request.getRequestDispatcher("./forgotPass.jsp?msg1=Invalid OTP Please try again");
        	        rd1.include(request, response);

           }
        }
            catch (NumberFormatException e) {
             response.getWriter().write("Invalid OTP format. Please enter a numeric OTP.");
        }
    }
    }
