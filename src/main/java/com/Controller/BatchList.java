package com.Controller;

import java.io.IOException;
import java.util.List;

import com.Dao.BatchDAO;
import com.Model.BatchModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/BatchList")
public class BatchList extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		 BatchDAO bd = new BatchDAO();
		 List<BatchModel> list = bd.fetchAllBatch();

		  
		 request.setAttribute("blist",list );

		   RequestDispatcher rd1 = request.getRequestDispatcher("./batchList.jsp");
		        rd1.include(request, response);

	}

}
