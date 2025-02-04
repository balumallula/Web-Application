package com.Controller;

import java.io.IOException;
import java.util.List;

import com.Dao.StudentDAO;
import com.Model.StudentModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/StudList")
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bid = Integer.parseInt(request.getParameter("id"));
		StudentModel sm = new StudentModel();
		sm.setBatch(bid);
		
		StudentDAO sd = new StudentDAO();
		List<StudentModel> students = sd.selectWithBatch(sm);

		request.setAttribute("list", students);

		RequestDispatcher rd1 = request.getRequestDispatcher("./studentsList.jsp");
		rd1.include(request, response);
	}

}
