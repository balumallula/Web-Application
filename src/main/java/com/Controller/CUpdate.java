package com.Controller;

import java.io.IOException;

import com.Dao.CourseDAO;
import com.Model.CourseModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CourseUpdate")
public class CUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int	cid = Integer.parseInt(request.getParameter("cid"));
		String	cname =request.getParameter("cname");
		int	cfee = Integer.parseInt(request.getParameter("cfee"));
		String duartion =request.getParameter("duration");

		 CourseModel cm = new CourseModel();
           cm.setCid(cid);
           cm.setCoursename(cname);
		   cm.setCoursefees(cfee);
		   cm.setDuration(duartion);


		CourseDAO cd = new CourseDAO();
		String status = cd.update(cm);

		if(status=="SUCCESS") {
			 response.sendRedirect("CourseList");

		}
		else{
 	        RequestDispatcher rd1 = request.getRequestDispatcher("/courseUpdate.jsp");
	        rd1.include(request, response);
		}


	}

}
