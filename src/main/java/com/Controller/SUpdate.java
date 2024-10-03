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

@WebServlet("/StudUpdate")
public class SUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int	sid = Integer.parseInt(request.getParameter("sid"));
		String	fullname =request.getParameter("fullname");
		long	mobile = Long.parseLong(request.getParameter("mobile"));
 		String	email =request.getParameter("email");
		String	gender =request.getParameter("gender");
		String	branch =request.getParameter("branch");
		String	year =request.getParameter("year");
		String	fathername =request.getParameter("fathername");
		 long	fmobile =Long.parseLong(request.getParameter("fmobile"));
		 int batch =Integer.parseInt(request.getParameter("batch"));

		 StudentModel sm = new StudentModel();

		sm.setFirstname(fullname);
		sm.setMobile(fmobile);
		sm.setEmail(email);
		sm.setGender(gender);
		sm.setBranch(branch);
		sm.setYear(year);
		sm.setFathername(fathername);
		sm.setFmobile(fmobile);
		sm.setBatch(batch);
		sm.setSid(sid);

		StudentDAO sd = new StudentDAO();
		String status = sd.update(sm);

		if(status=="SUCCESS") {
			 response.sendRedirect("StudList");

		}
		else{
 	        RequestDispatcher rd1 = request.getRequestDispatcher("/studentUpdate.jsp");
	        rd1.include(request, response);
		}



	}
}
