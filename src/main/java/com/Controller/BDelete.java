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

 @WebServlet("/BatchDelete")
public class BDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 System.out.println("id got in con");
		int	bid = Integer.parseInt(request.getParameter("bid"));

		 BatchModel bm = new BatchModel();

			bm.setBid(bid);

			BatchDAO sd = new BatchDAO();
			String status = sd.delete(bm);

			if(status=="SUCCESS") {
				response.sendRedirect("BatchList");

			}
			else{
	 	        RequestDispatcher rd1 = request.getRequestDispatcher("/batchDelete.jsp");
		        rd1.include(request, response);
			}
	}

}
