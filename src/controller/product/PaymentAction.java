package controller.product;

import controller.Action;
import controller.ActionForward;
import model.order.OrderDAO;
import model.order.OrderSet;
import model.order.Order_detailVO;
import model.order.Order_singleVO;
import model.product.ProductCart;
import model.product.ProductSingleCart;
import model.subscription.Order_subscriptionVO;
import model.subscription.Order_suscriptionDAO;
import model.subscription.Product_setVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class PaymentAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String customer_id = (String) session.getAttribute("customer_id");
		OrderDAO dao = new OrderDAO();
		OrderSet os = new OrderSet();
		Order_singleVO oss = new Order_singleVO();
		oss.setCustomer_id(customer_id);
		os.setSingle(oss); // id 넣기

		// 상품 관련 장바구니
		if (session.getAttribute("cart") != null) {
			ProductCart cart = (ProductCart) session.getAttribute("cart");
			ArrayList<ProductSingleCart> products = cart.getSingleProducts();
			ArrayList<Order_detailVO> orderDetail = new ArrayList<>();
			for (ProductSingleCart product : products) {
				Order_detailVO od = new Order_detailVO();
				od.setProduct_number(product.getProductVO().getProduct_number());
				od.setProduct_count(product.getProduct_count());
				orderDetail.add(od);
				session.removeAttribute("cart");
				session.removeAttribute("totalPrice"); // 세션에 장바구니관련 정보 없애기
			}
			os.setDetails(orderDetail);
			dao.insert(os);
			System.out.println("주문 정보 저장완료");
		}

		// 구독관련 장바구니
		ActionForward forward = null;
		Order_suscriptionDAO odao = new Order_suscriptionDAO();
		Order_subscriptionVO ovo = new Order_subscriptionVO();
		if (session.getAttribute("product_set") != null) { // 구독 주문을 하였다면
			Product_setVO productSetVO = (Product_setVO) session.getAttribute("product_set");
			ovo.setCustomer_id(customer_id);
			if (odao.selectIsExist(ovo)) { // 만약 해당 기간내에 주문정보가 존재한다면
				session.removeAttribute("product_set");
				session.removeAttribute("product_set_price"); // 장바구니에서 구독정보를 삭제해준다
				forward = new ActionForward();
				forward.setPath("orderFail.jsp");
				forward.setRedirect(true);
				return forward;
			}
			ovo.setSoup_check(productSetVO.getSoup_check());
			ovo.setProduct_set_number(productSetVO.getProduct_set_number());
			boolean isOk = odao.insert(ovo); // 구독 주문정보 저장
			System.out.println("ovo :" + ovo);
			if (isOk) {
				System.out.println("구독 주문 정보 저장완료");
				session.removeAttribute("product_set");
				session.removeAttribute("product_set_price"); // 세션에 저장된 구독관련 정보 없애기
			}
		}
		forward = new ActionForward();
		forward.setPath("orderDone.jsp");
		forward.setRedirect(true);
		return forward;

	}
}
