package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

 import com.Dao.StudentDAO;
 import com.Model.StudentModel;

 @WebServlet("/StudListWithId")
public class StudentListWithId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 int sid = Integer.parseInt(request.getParameter("id"));
		 
		 StudentModel sm = new StudentModel();
		   sm.setSid(sid);;

		StudentDAO sd = new StudentDAO();
 
		
		List<StudentModel> studentwithid = sd.selectWithId(sm);

		if (studentwithid == null || studentwithid.isEmpty()) {
		    
			request.setAttribute("NA", "Not Available");
		    RequestDispatcher rd1 = request.getRequestDispatcher("/studentsList.jsp");  
		    rd1.forward(request, response);
		} else {
			request.setAttribute("studlist", studentwithid);
		    RequestDispatcher rd1 = request.getRequestDispatcher("./studentListWithId.jsp");
		    rd1.forward(request, response);  
		}

	}

}
