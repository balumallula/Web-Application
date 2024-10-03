package com.Controller;

import java.io.IOException;
import java.util.List;

import com.Dao.FacultyDAO;
import com.Model.FacultyModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/FacList")
public class FacultyList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FacultyDAO sd = new FacultyDAO();

		List<FacultyModel> faculty = sd.fetchAllFaculty();


 		 request.setAttribute("flist",faculty );

		 RequestDispatcher rd1 = request.getRequestDispatcher("/facultyList.jsp");
	        rd1.include(request, response);
	}

}
