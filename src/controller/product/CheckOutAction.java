package controller.product;

import controller.Action;
import controller.ActionForward;
import model.customer.CustomerDAO;
import model.customer.CustomerVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckOutAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		// 회원 정보를 불러옴
		HttpSession session = request.getSession();
		String customer_id = (String) session.getAttribute("customer_id");
		CustomerDAO customerDAO = new CustomerDAO();
		CustomerVO cvo = new CustomerVO();
		cvo.setCustomer_id(customer_id);
		CustomerVO userData = customerDAO.selectOne(cvo); // 유저 데이터를 받아옴
		System.out.println(userData);
		// 유저 데이터 저장
		request.setAttribute("userData", userData);
		forward.setPath("payment.jsp");
		forward.setRedirect(false); // 전달할 데이터가 있으니 forward
		return forward;
	}
}
