package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.Dao.BatchDAO;
import com.Model.BatchModel;
 
@WebServlet("/BatchListForStud")
public class BatchListForStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 

		 BatchDAO bd = new BatchDAO();
		 List<BatchModel> list = bd.fetchAllBatch();

		  
		 request.setAttribute("blist",list );

		   RequestDispatcher rd1 = request.getRequestDispatcher("./batchListForStudList.jsp");
		        rd1.include(request, response);

	}

}
