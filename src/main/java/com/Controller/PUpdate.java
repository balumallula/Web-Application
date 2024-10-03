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

 @WebServlet("/PaymentUpdate")
public class PUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		int	sno = Integer.parseInt(request.getParameter("sno"));
		int	sid = Integer.parseInt(request.getParameter("sid"));
		int	amount = Integer.parseInt(request.getParameter("amount"));
		String date =request.getParameter("date");

		 PaymentModel pm = new PaymentModel();
           pm.setSno(sno);
           pm.setStudid(sid);
		   pm.setPaid(amount);
		   pm.setDate(date);


		PaymentDAO pd = new PaymentDAO();
		String status = pd.update(pm);

		if(status=="SUCCESS") {
			 response.sendRedirect("PaymentList");

		}
		else if(status.equals("CLEAR")){
	        RequestDispatcher rd1 = request.getRequestDispatcher("./paymentUpdate.jsp?mf=Your due is already cleared...");
	        rd1.include(request, response);
		}
		else if(status.equals("EXCEEDED")){
			 RequestDispatcher rd1 = request.getRequestDispatcher("./paymentUpdate.jsp?mf=Don't exceed your due...!");
		        rd1.include(request, response);
		}
		else if(status.equals("ID NOT FOUND")){
			 RequestDispatcher rd1 = request.getRequestDispatcher("./paymentUpdate.jsp?mdm=Student id doesn't exist");
		        rd1.include(request, response);
		}
		else {
			 RequestDispatcher rd1 = request.getRequestDispatcher("./paymentUpdate.jsp");
		        rd1.include(request, response);
		}

	}

}
