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

@WebServlet("/FacultyDelete")
public class FDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int	fid = Integer.parseInt(request.getParameter("fid"));

		 FacultyModel fm = new FacultyModel();

			fm.setFid(fid);

			FacultyDAO ud = new FacultyDAO();
			String status = ud.fdelete(fm);

			if(status=="SUCCESS") {
				response.sendRedirect("FacList");

			}
			else{
	 	        RequestDispatcher rd1 = request.getRequestDispatcher("/facultyDelete.jsp");
		        rd1.include(request, response);
			}
	}

}
