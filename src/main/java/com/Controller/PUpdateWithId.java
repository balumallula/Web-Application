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

@WebServlet("/PUpdateWithId")
public class PUpdateWithId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int sno = Integer.parseInt(request.getParameter("id"));

		PaymentModel pm = new PaymentModel();
		pm.setSno(sno);

		PaymentDAO pd = new PaymentDAO();

		List<PaymentModel> paylist = pd.selectWithId(pm);

		HttpSession session = request.getSession();
		session.setAttribute("paylist", paylist);


		RequestDispatcher rd1 = request.getRequestDispatcher("./paymentUpdate.jsp");
		rd1.include(request, response);
	}

}
