 package com.Controller;

import java.io.IOException;

import com.Dao.FacultyDAO;
import com.Model.FacultyModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FacultyRegister")
public class Faculty extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String	fname =request.getParameter("firstname");
		String	uname =request.getParameter("username");
		String	pass =request.getParameter("password");
		String	email =request.getParameter("email");
		long	mobile =Long.parseLong(request.getParameter("mobile"));
		String	gender =request.getParameter("gender");
		int	fexp = Integer.parseInt(request.getParameter("exp"));
		int	courseid =Integer.parseInt(request.getParameter("course"));

		FacultyModel fm = new FacultyModel();
		 fm.setFirstname(fname);
		 fm.setUsername(uname);
		 fm.setPassword(pass);
		 fm.setEmail(email);
		 fm.setMobile(mobile);
		 fm.setGender(gender);
		 fm.setExp(fexp);
		 fm.setCourse(courseid);

		 FacultyDAO fd = new FacultyDAO();
		 String status = fd.insertData(fm);

		if(status.equals("SUCCESS")) {
	        RequestDispatcher rd1 = request.getRequestDispatcher("/admin.jsp");
	        rd1.include(request, response);
		}
		else{
			request.setAttribute("invalid", "This User name already exist");
	        RequestDispatcher rd1 = request.getRequestDispatcher("/facultyRegistration.jsp");
	        rd1.include(request, response);
		}
	}

}
