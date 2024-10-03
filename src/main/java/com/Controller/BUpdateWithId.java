package com.Controller;

import java.io.IOException;
import java.util.List;

import com.Dao.BatchDAO;
import com.Dao.CourseDAO;
import com.Model.BatchModel;
import com.Model.CourseModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/BatchUpdateWithId")
public class BUpdateWithId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bid = Integer.parseInt(request.getParameter("id"));

		BatchModel bm = new BatchModel();
		bm.setBid(bid);

		BatchDAO bd = new BatchDAO();

		List<BatchModel> batchlist = bd.selectWithId(bm);

		request.setAttribute("batchlist", batchlist);

		CourseDAO cd = new CourseDAO();
		List<CourseModel> clist = cd.fetchAllCourse();

		request.setAttribute("courselist", clist);

		RequestDispatcher rd1 = request.getRequestDispatcher("./batchUpdate.jsp");
		rd1.include(request, response);

	}

}
