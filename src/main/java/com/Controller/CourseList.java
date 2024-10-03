package com.Controller;

import java.io.IOException;
import java.util.List;

import com.Dao.CourseDAO;
import com.Model.CourseModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

 @WebServlet("/CourseList")
public class CourseList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		 CourseDAO cd = new CourseDAO();

		 List<CourseModel> clist = cd.fetchAllCourse();

		 request.setAttribute("courselist",clist );

		   RequestDispatcher rd1 = request.getRequestDispatcher("./courseList.jsp");
		        rd1.include(request, response);

	}

}
