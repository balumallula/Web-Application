package com.Controller;

import java.io.IOException;
import java.util.List;

import com.Dao.CourseDAO;
import com.Dao.FacultyDAO;
import com.Model.CourseModel;
import com.Model.FacultyModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

 @WebServlet("/FacUpdateWithId")
public class FUpdateWithId extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int fid = Integer.parseInt(request.getParameter("id"));

		FacultyModel fm = new FacultyModel();
		fm.setFid(fid);

		FacultyDAO fd = new FacultyDAO();

		List<FacultyModel> list = fd.selectWithId(fm);

 		request.setAttribute("list", list);

		CourseDAO cd = new CourseDAO();
		List<CourseModel> clist = cd.fetchAllCourse();

 		 request.setAttribute("courselist", clist);

		RequestDispatcher rd1 = request.getRequestDispatcher("./facultyUpdate.jsp");
		rd1.include(request, response);
	}

}
