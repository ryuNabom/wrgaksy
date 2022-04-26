package controller.product;

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
import java.io.PrintWriter;

public class SubscribeAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isSoup = request.getParameter("isSoup");
		int product_set_price = 190000;
		if (isSoup.equals("포함")) {
			product_set_price = 220000;
		}

		Order_suscriptionDAO dao = new Order_suscriptionDAO();
		Order_subscriptionVO vo = new Order_subscriptionVO();
		HttpSession session = request.getSession();
		vo.setCustomer_id((String) session.getAttribute("customer_id"));
		vo.setSoup_check(isSoup);
		System.out.println("vo :" + vo);
		Product_setVO product_set = dao.selectRandom(vo);
		if (product_set != null) {
			// 밥상 insert
			session.setAttribute("product_set", product_set);
			session.setAttribute("product_set_price", product_set_price);
			System.out.println("밥상 장바구니 추가 완료!");
			System.out.println(product_set);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); // 스크립트 printwriter
			out.println("<script>alert('밥상 장바구니 추가 완료! 장바구니를 통해 확인해주세요!');history.go(-1);</script>");
		} else {
			System.out.println("실패!");
		}
		return null;
	}
}
