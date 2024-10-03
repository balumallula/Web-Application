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

 @WebServlet("/BatchDeleteWithId")
public class BDeleteWithId extends HttpServlet {
	private static final long serialVersionUID = 1L;


	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bid = Integer.parseInt(request.getParameter("id"));
 
		BatchModel bm = new BatchModel();
		bm.setBid(bid);

		BatchDAO cd = new BatchDAO();

		List<BatchModel> batchlist = cd.selectWithId(bm);
 
		request.setAttribute("blist", batchlist);

		RequestDispatcher rd1 = request.getRequestDispatcher("./batchDelete.jsp");
		rd1.include(request, response);

	}

}
