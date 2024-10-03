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

@WebServlet("/FacultyUpdate")
public class FUpdate extends HttpServlet {
		private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int	fid = Integer.parseInt(request.getParameter("fid"));
		String	fname =request.getParameter("fullname");
		long	mobile =Long.parseLong(request.getParameter("mobile"));
		String	email =request.getParameter("email");
		String	gender =request.getParameter("gender");
		int	fexp =Integer.parseInt(request.getParameter("fexp"));
		int	cid = Integer.parseInt(request.getParameter("course"));

		FacultyModel fm = new FacultyModel();

		 fm.setFirstname(fname);
		 fm.setFid(fid);
		 fm.setEmail(email);
		 fm.setMobile(mobile);
		 fm.setGender(gender);
		 fm.setExp(fexp);
		 fm.setCourse(cid);

		 FacultyDAO fd = new FacultyDAO();
		 String status = fd.fupdate(fm);

		if(status=="SUCCESS") {
			response.sendRedirect("FacList");

		}
		else{
 	        RequestDispatcher rd1 = request.getRequestDispatcher("/facultyUpdate.jsp");
	        rd1.include(request, response);
		}

	}

}
