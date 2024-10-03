package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.Dao.CourseDAO;
import com.Model.CourseModel;

@WebServlet("/DropList")
public class DropCourseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		 CourseDAO cd = new CourseDAO();

		 List<CourseModel> dclist = cd.fetchAllCourse();

		 HttpSession session = request.getSession();
			session.setAttribute("droplist",dclist );
			
			RequestDispatcher rd1 = request.getRequestDispatcher("./addBatch.jsp");
			rd1.include(request, response);

		   
	}

}
