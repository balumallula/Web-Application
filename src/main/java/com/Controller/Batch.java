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

/***
 * Author: Satya
 * Date: 09/18/20124
 * Description: Batch class 
 * Version: VCUBE 1.0
 * 
 * 
 */
 @WebServlet("/NewBatch")
public class Batch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String bname = request.getParameter("batchname");
		 String date = request.getParameter("date");
		 int course = Integer.parseInt(request.getParameter("course"));

		 BatchModel bm = new BatchModel();
		 bm.setBatchname(bname);
		 bm.setDate(date);
		 bm.setCourse(course);

		 BatchDAO bd = new BatchDAO();
		 String status = bd.insertData(bm);

		 if(status.equals("SUCCESS")) {
		        RequestDispatcher rd1 = request.getRequestDispatcher("./admin.jsp");
		        rd1.include(request, response);
			}
			else{
		        RequestDispatcher rd1 = request.getRequestDispatcher("./addBatch.jsp");
		        rd1.include(request, response);
			}
	}

}
