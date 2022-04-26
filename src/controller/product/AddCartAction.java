package controller.product;

import controller.Action;
import controller.ActionForward;
import model.product.ProductCart;
import model.product.ProductDAO;
import model.product.ProductSingleCart;
import model.product.ProductVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class AddCartAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션에 카트 저장
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		if (session.getAttribute("customer_id") == null) { // 만약 로그인 되지 않은 계정이라면 로그인 페이지로 이동
			forward.setPath("login.jsp");
			forward.setRedirect(true); // 넘겨줄 데이터 X
		} else { // 로그인이 된 상태라면 카트에 담아준다
					// 상품 수량 hashMap 에 저장
			ProductSingleCart singleCart = new ProductSingleCart();
			int product_count = 1;
			if (request.getParameter("product_count") != null) { // 만약 상품 수량이 있다면
				product_count = Integer.parseInt(request.getParameter("product_count")); // request에서 받은 수량으로 저장
			}
			singleCart.setProduct_count(product_count); // 수량 체크

			ProductDAO dao = new ProductDAO();
			ProductVO vo = new ProductVO();
			int product_number = Integer.parseInt(request.getParameter("product_number"));
			System.out.println(product_number);
			vo.setProduct_number(product_number); // vo 에 product_number 세팅 후 dao 를 통하여 쿼리 수행
			ProductVO productVO = dao.selectOne(vo);
			singleCart.setProductVO(productVO);

			int totalPrice = 0;

			ProductCart cart = null;
			// 만약 현재 장바구니에 아무것도 담겨져 있지 않다면? 새로만들기
			ArrayList<ProductSingleCart> singleProducts = null;
			boolean isContain = false;

			if (session.getAttribute("cart") != null) {
				cart = (ProductCart) session.getAttribute("cart");
				singleProducts = cart.getSingleProducts();
				// 만약 장바구니에 해당 상품이 있을때는 수량 + 해줌
				for (ProductSingleCart singleProduct : singleProducts) {
					if (singleProduct.getProductVO().getProduct_number() == product_number) {
						isContain = true;
						singleProduct.setProduct_count(singleProduct.getProduct_count() + product_count); // 기존에 있던 수량 +
																											// 받아온 수량
						break;
					}
				}
			} else {
				cart = new ProductCart();
				System.out.println("새로운 장바구니 생성");
				singleProducts = new ArrayList<>();
			}
			if (!isContain) { // 새롭게 추가된 상품이라면
				singleProducts.add(singleCart); // 카트에 상품을 추가
				cart.setSingleProducts(singleProducts); // 다시 추가된 것을 업데이트
			}

			// 개별 상품에 대해 가격을 모두 더해줌
			for (ProductSingleCart singleProduct : singleProducts) {
				totalPrice += singleProduct.getProduct_price();
			}

			// 장바구니 페이지로 이동
			session.setAttribute("totalPrice", totalPrice); // 전체 금액을 세션에 저장
			session.setAttribute("cart", cart);
			forward.setPath("cart.jsp");
			forward.setRedirect(true); // 넘겨줄 데이터 X
		}

		return forward;
	}
}
