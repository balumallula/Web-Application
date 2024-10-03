 package com.Controller;

import java.io.IOException;

import com.Dao.CourseDAO;
import com.Model.CourseModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/NewCourse")
public class Course extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String	cname =request.getParameter("coursename");
		int	cfee =Integer.parseInt(request.getParameter("coursefees"));
		String	duration =request.getParameter("duration");

		CourseModel cm = new CourseModel();
		cm.setCoursename(cname);
		cm.setCoursefees(cfee);
		cm.setDuration(duration);

		CourseDAO cd = new CourseDAO();
		String status = cd.insertData(cm);

		if(status.equals("SUCCESS")) {
	        RequestDispatcher rd1 = request.getRequestDispatcher("./admin.jsp");
	        rd1.include(request, response);
		}
		else{
			request.setAttribute("error", "This course already exist");
	        RequestDispatcher rd1 = request.getRequestDispatcher("./addCourse.jsp");
	        rd1.include(request, response);
		}
 	}

}
