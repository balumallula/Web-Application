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

@WebServlet("/Newpass")
public class Newpass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pass = request.getParameter("password");
 		HttpSession session = request.getSession();
	    String login = (String) session.getAttribute("login");
	    String username = (String) session.getAttribute("user");

		 System.out.println(login);

		ForgotModel fm = new ForgotModel();
		fm.setPass(pass);
 		fm.setLogin(login);
 		fm.setUsername(username);


		ForgotDAO fd = new ForgotDAO();
		String status = fd.updateData(fm);

		if (status.equals("SUCCESS")) {
			RequestDispatcher rd1 = request.getRequestDispatcher("./index.jsp");
			rd1.include(request, response);
		} else {

			RequestDispatcher rd1 = request.getRequestDispatcher("./forgotPass.jsp");
			rd1.include(request, response);

		}
	}

}
