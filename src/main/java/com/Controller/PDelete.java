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

 @WebServlet("/PaymentDelete")
public class PDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int	sno = Integer.parseInt(request.getParameter("sno"));

		 PaymentModel pm = new PaymentModel();

			pm.setSno(sno);

			PaymentDAO pd = new PaymentDAO();
			String status = pd.delete(pm);

			if(status=="SUCCESS") {
				response.sendRedirect("PaymentList");

			}
			else{
	 	        RequestDispatcher rd1 = request.getRequestDispatcher("/paymentDelete.jsp");
		        rd1.include(request, response);
			}

	}

}
