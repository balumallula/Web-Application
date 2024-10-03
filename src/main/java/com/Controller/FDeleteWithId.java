package com.Controller;

import java.io.IOException;
import java.util.List;

import com.Dao.FacultyDAO;
import com.Model.FacultyModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

 @WebServlet("/FacDeleteWithId")
public class FDeleteWithId extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int fid = Integer.parseInt(request.getParameter("id"));

		FacultyModel fm = new FacultyModel();
		fm.setFid(fid);

		FacultyDAO cd = new FacultyDAO();

		List<FacultyModel> list = cd.selectWithId(fm);

		HttpSession session = request.getSession();
		session.setAttribute("list", list);

		RequestDispatcher rd1 = request.getRequestDispatcher("./facultyDelete.jsp");
		rd1.include(request, response);
	}

}
