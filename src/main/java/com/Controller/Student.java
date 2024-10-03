 package com.Controller;

import java.io.IOException;

import com.Dao.StudentDAO;
import com.Model.StudentModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

 @WebServlet("/StudRegister")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String	fname =request.getParameter("firstname");
		String	uname =request.getParameter("username");
		String	pass =request.getParameter("password");
		String	email =request.getParameter("email");
		long	mobile = Long.parseLong(request.getParameter("mobile"));
		String	gender =request.getParameter("gender");
		String	branch =request.getParameter("branch");
		int	batch =Integer.parseInt(request.getParameter("batch"));
		String	year =request.getParameter("year");
		String	fathername =request.getParameter("fathername");
		 long	fmobile =Long.parseLong(request.getParameter("fmobile"));




		StudentModel sm = new StudentModel();

		 sm.setFirstname(fname);
		 sm.setUsername(uname);
		 sm.setPassword(pass);
		 sm.setEmail(email);
		 sm.setMobile(mobile);
		 sm.setGender(gender);
		 sm.setBranch(branch);
		 sm.setBatch(batch);
		 sm.setYear(year);
		 sm.setFathername(fathername);
		 sm.setFmobile(fmobile);


		StudentDAO sd = new StudentDAO();
		String status = sd.insertData(sm);

		if(status.equals("SUCCESS")) {
	        RequestDispatcher rd1 = request.getRequestDispatcher("/admin.jsp");
	        rd1.include(request, response);
		}
		else{
			request.setAttribute("invalid", "This User name already exist");
	        RequestDispatcher rd1 = request.getRequestDispatcher("/studentRegistration.jsp");
	        rd1.include(request, response);
		}
	}

}
