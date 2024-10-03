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

@WebServlet("/studDelete")
public class SDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int	sid = Integer.parseInt(request.getParameter("sid"));

		 StudentModel dm = new StudentModel();

			dm.setSid(sid);

			StudentDAO sd = new StudentDAO();
			String status = sd.delete(dm);

			if(status=="SUCCESS") {
				response.sendRedirect("BatchListForStud");

			}
			else{
	 	        RequestDispatcher rd1 = request.getRequestDispatcher("/studentDelete.jsp");
		        rd1.include(request, response);
			}
	}

}
