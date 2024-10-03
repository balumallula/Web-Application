package com.Controller;

import java.io.IOException;

import com.Dao.BatchDAO;
import com.Model.BatchModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

 @WebServlet("/BatchUpdate")
public class BUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int	bid = Integer.parseInt(request.getParameter("bid"));
		String	bname =request.getParameter("bname");
		String	date =request.getParameter("date");
		int course =Integer.parseInt(request.getParameter("course"));

		 BatchModel bm = new BatchModel();
         bm.setBid(bid);
         bm.setBatchname(bname);
         bm.setDate(date);
         bm.setCourse(course);


		BatchDAO bd = new BatchDAO();
		String status = bd.update(bm);

		if(status=="SUCCESS") {
			 response.sendRedirect("BatchList");

		}
		else{
 	        RequestDispatcher rd1 = request.getRequestDispatcher("./batchUpdate.jsp");
	        rd1.include(request, response);
		}


	}

}
