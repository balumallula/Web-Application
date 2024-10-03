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

import com.Dao.BatchDAO;
import com.Dao.CourseDAO;
import com.Model.BatchModel;
import com.Model.CourseModel;

@WebServlet("/DropBatchList")
public class DropListOnStud extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		

		 BatchDAO cd = new BatchDAO();

		 List<BatchModel> dblist = cd.fetchAllBatch();

		 HttpSession session = request.getSession();
			session.setAttribute("dblist",dblist );
			
			RequestDispatcher rd1 = request.getRequestDispatcher("./studentRegistration.jsp");
			rd1.include(request, response);
	}

}
