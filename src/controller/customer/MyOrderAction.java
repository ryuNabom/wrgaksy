package controller.customer;

import controller.Action;
import controller.ActionForward;
import model.subscription.Order_subscriptionVO;
import model.subscription.Order_suscriptionDAO;
import model.subscription.Product_setVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyOrderAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String customer_id = (String) session.getAttribute("customer_id");
		Order_suscriptionDAO odao = new Order_suscriptionDAO();
		Order_subscriptionVO ovo = new Order_subscriptionVO();
		ovo.setCustomer_id(customer_id);
		Order_subscriptionVO order = odao.selectOne(ovo);
		Product_setVO product_set = odao.selectProductSet(order);
		request.setAttribute("order", product_set);
		System.out.println("유저 order : " + product_set);
		ActionForward forward = new ActionForward();
		forward.setPath("mypage.jsp#tabs-4-2");
		forward.setRedirect(false);
		return forward;
	}
}
