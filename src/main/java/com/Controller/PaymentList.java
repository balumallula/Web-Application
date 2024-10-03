package com.Controller;

import java.io.IOException;
import java.util.List;

import com.Dao.PaymentDAO;
import com.Model.PaymentModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/PaymentList")
public class PaymentList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PaymentDAO cd = new PaymentDAO();

		List<PaymentModel> list = cd.fetchAllPayments();

		request.setAttribute("plist", list);

		RequestDispatcher rd1 = request.getRequestDispatcher("./paymentHistory.jsp");
		rd1.include(request, response);
	}

}
