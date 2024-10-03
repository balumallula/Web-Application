 package com.Controller;

import java.io.IOException;

import com.Dao.PaymentDAO;
import com.Model.PaymentModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int studid = Integer.parseInt(request.getParameter("studid"));
		int paid = Integer.parseInt(request.getParameter("paid"));
		String date = request.getParameter("paiddate");

		PaymentModel pm = new PaymentModel();
		pm.setStudid(studid);
		pm.setPaid(paid);
		pm.setDate(date);

		PaymentDAO pd = new PaymentDAO();
		String status = pd.insertData(pm);

		if(status.equals("SUCCESS")) {
	        RequestDispatcher rd1 = request.getRequestDispatcher("./admin.jsp");
	        rd1.include(request, response);
		}
		else if(status.equals("CLEAR")){
	        RequestDispatcher rd1 = request.getRequestDispatcher("./payment.jsp?mf=Your due is already cleared...");
	        rd1.include(request, response);
		}
		else if(status.equals("EXCEEDED")){
			 RequestDispatcher rd1 = request.getRequestDispatcher("./payment.jsp?mf=Don't exceed your due...!");
		        rd1.include(request, response);
		}
		else if(status.equals("ID NOT FOUND")){
			 RequestDispatcher rd1 = request.getRequestDispatcher("./payment.jsp?mdm=Student id doesn't exist");
		        rd1.include(request, response);
		}
		else {
			 RequestDispatcher rd1 = request.getRequestDispatcher("./payment.jsp");
		        rd1.include(request, response);
		}
	}

}
