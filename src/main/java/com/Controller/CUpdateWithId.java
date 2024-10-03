package com.Controller;

import java.io.IOException;
import java.util.List;

import com.Dao.CourseDAO;
import com.Model.CourseModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

 @WebServlet("/CourseUpdateWithId")
public class CUpdateWithId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cid = Integer.parseInt(request.getParameter("id"));

		CourseModel cm = new CourseModel();
		cm.setCid(cid);

		CourseDAO cd = new CourseDAO();

		List<CourseModel> courselist = cd.selectWithId(cm);

		request.setAttribute("courselist", courselist);

		RequestDispatcher rd1 = request.getRequestDispatcher("./courseUpdate.jsp");
		rd1.include(request, response);
	}

}
