package com.Controller;

import java.io.IOException;

import com.Dao.LoginDAO;
import com.Model.LoginModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String username = request.getParameter("adm_username");
         String password = request.getParameter("adm_password");
         String whologin = request.getParameter("login");

         LoginModel lm = new LoginModel();
         lm.setUsername(username);
         lm.setPassword(password);
         lm.setLogin(whologin);


         LoginDAO ld = new LoginDAO();
         String status = ld.fetchData(lm);



         if(status.equals("SUCCESS")) {
        	 if(whologin.equals("Admin")) {

        		 HttpSession  session = request.getSession();
        		 session.setAttribute("username", username);
 	        RequestDispatcher rd1 = request.getRequestDispatcher("./admin.jsp");
 	        rd1.include(request, response);
        	 }
        	 else if(whologin.equals("Faculty")) {
        		 RequestDispatcher rd1 = request.getRequestDispatcher("./facultyHome.html");
      	        rd1.include(request, response);
        	 }
        	 else {
        		 RequestDispatcher rd1 = request.getRequestDispatcher("./studentHome.html");
      	        rd1.include(request, response);
        	 }
 		}
 		else{
 			 
 		     request.setAttribute("msg", "Invalid Credentials");
 			 RequestDispatcher rd1 = request.getRequestDispatcher("./index.jsp");
   	        rd1.include(request, response);

 		}

	}

}
