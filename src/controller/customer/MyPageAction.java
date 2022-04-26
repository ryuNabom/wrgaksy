package controller.customer;

import controller.Action;
import controller.ActionForward;
import model.customer.CustomerDAO;
import model.customer.CustomerVO;
import model.subscription.Order_subscriptionVO;
import model.subscription.Order_suscriptionDAO;
import model.subscription.Product_setVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyPageAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		// mypage 로 이동
		/*
		 * 마이페이지에서는 select 을 통하여 수정, 탈퇴, 구독 정보보기를 진행할 예정 그렇기에 mypage 로 이동할때 모든 정보를 들고 갈
		 * 수 있도록 한다 userData: 회원 정보 , userSubscribe : 구독정보
		 * 
		 * 그렇기에 mypage 로 넘어올때 customer_id 를 parameter로 받는다
		 */
		// 로그인이 되어있는 경우 마이페이지에 접근할 수 있기 때문에 customer_id 가 세션에 저장되어있다 가정하고 진행한다
		HttpSession session = request.getSession();
		String customer_id = (String) session.getAttribute("customer_id");
		CustomerDAO customerDAO = new CustomerDAO();
		CustomerVO cvo = new CustomerVO();
		cvo.setCustomer_id(customer_id);
		CustomerVO userData = customerDAO.selectOne(cvo); // 유저 데이터를 받아옴
		// 유저 데이터 저장
		request.setAttribute("userData", userData);
		// 유저 구독 정보 저장
		Order_suscriptionDAO odao = new Order_suscriptionDAO();
		Order_subscriptionVO ovo = new Order_subscriptionVO();
		ovo.setCustomer_id(customer_id);
		Order_subscriptionVO order = odao.selectOne(ovo);
		if (order != null) {
			Product_setVO product_set = odao.selectProductSet(order);
			System.out.println(product_set);
			request.setAttribute("order", order);
			request.setAttribute("order_set", product_set);
			System.out.println("넘버 : " + product_set.getProduct_set_number());
			System.out.println("유저 order : " + product_set);
		}

		forward.setPath("mypage.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
