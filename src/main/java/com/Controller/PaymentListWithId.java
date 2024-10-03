package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

 
import com.Dao.PaymentDAO;
 
import com.Model.PaymentModel;

@WebServlet("/PayListWithId")
public class PaymentListWithId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 int sno = Integer.parseInt(request.getParameter("id"));
		 
		PaymentModel pm = new PaymentModel();
		pm.setSno(sno);;

		PaymentDAO fd = new PaymentDAO();
 
		
		List<PaymentModel> paywithid = fd.selectWithId(pm);

		if (paywithid == null || paywithid.isEmpty()) {
		    
			request.setAttribute("NA", "Not Available");
		    RequestDispatcher rd1 = request.getRequestDispatcher("/paymentHistory.jsp");  
		    rd1.forward(request, response);
		} else {
			request.setAttribute("paywithlist", paywithid);
		    RequestDispatcher rd1 = request.getRequestDispatcher("/paymentHistoryWithId.jsp");
		    rd1.forward(request, response);  
		}

	}

}
