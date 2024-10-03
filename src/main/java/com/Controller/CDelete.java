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

 @WebServlet("/CourseDelete")
public class CDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int	cid = Integer.parseInt(request.getParameter("cid"));

		 CourseModel dm = new CourseModel();

			dm.setCid(cid);

			CourseDAO sd = new CourseDAO();
			String status = sd.delete(dm);

			if(status=="SUCCESS") {
				response.sendRedirect("CourseList");

			}
			else{
	 	        RequestDispatcher rd1 = request.getRequestDispatcher("/studentDelete.jsp");
		        rd1.include(request, response);
			}

	}

}
