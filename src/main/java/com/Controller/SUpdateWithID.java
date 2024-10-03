package com.Controller;

import java.io.IOException;
import java.util.List;

import com.Dao.BatchDAO;
import com.Dao.StudentDAO;
import com.Model.BatchModel;
import com.Model.StudentModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/StudUpdateWithId")
public class SUpdateWithID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int sid = Integer.parseInt(request.getParameter("id"));

		StudentModel sm = new StudentModel();
		sm.setSid(sid);

		StudentDAO cd = new StudentDAO();

		List<StudentModel> list = cd.selectWithId(sm);

		 
		request.setAttribute("list", list);

		BatchDAO bd = new BatchDAO();
		List<BatchModel> blist = bd.fetchAllBatch();

 		request.setAttribute("batchlist", blist);

		RequestDispatcher rd1 = request.getRequestDispatcher("./studentUpdate.jsp");
		rd1.include(request, response);

	}

}
