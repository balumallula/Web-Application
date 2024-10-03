package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.Dao.FacultyDAO;
import com.Model.FacultyModel;

 @WebServlet("/FacListWithId")
public class FacultyListWithId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 int fid = Integer.parseInt(request.getParameter("id"));
		 
		FacultyModel fm = new FacultyModel();
		fm.setFid(fid);

		FacultyDAO fd = new FacultyDAO();
 
		
		List<FacultyModel> facultywithid = fd.selectWithId(fm);

		if (facultywithid == null || facultywithid.isEmpty()) {
		    
			request.setAttribute("NA", "Not Available");
		    RequestDispatcher rd1 = request.getRequestDispatcher("/facultyList.jsp");  
		    rd1.forward(request, response);
		} else {
			request.setAttribute("fidlist", facultywithid);
		    RequestDispatcher rd1 = request.getRequestDispatcher("/facultyListWithId.jsp");
		    rd1.forward(request, response);  
		}

	}

}
