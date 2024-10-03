 package com.Controller;


import java.io.IOException;

import com.Dao.ForgotDAO;
import com.Model.ForgotModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
 @WebServlet("/Forgot")
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String email =  request.getParameter("email");
		String whologin = request.getParameter("login");

		ForgotModel fm = new ForgotModel();
		fm.setUsername(username);
		fm.setEmail(email);
		fm.setLogin(whologin);

		  System.out.println(fm.getLogin());

		ForgotDAO  fd = new ForgotDAO();
		String status = fd.checkData(fm);

		System.out.println(status);
		if(status.equals("SUCCESS")) {

		  HttpSession session = request.getSession();

			session.setAttribute( "login", whologin);
			session.setAttribute( "user", username);
       		 RequestDispatcher rd1 = request.getRequestDispatcher("SendOtpServlet");
     	        rd1.include(request, response);
		}
		else{
 			request.setAttribute("error","Invalid Credentials");

			 RequestDispatcher rd1 = request.getRequestDispatcher("./forgotPass.jsp");
  	        rd1.include(request, response);

		}
	}

}


