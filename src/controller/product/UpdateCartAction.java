package controller.product;

import controller.Action;
import controller.ActionForward;
import model.product.ProductCart;
import model.product.ProductSingleCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class UpdateCartAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int product_number = Integer.parseInt(request.getParameter("product_number"));
		int product_count = Integer.parseInt(request.getParameter("product_count"));
//        System.out.println("count : "+request.getParameter("product_number")+"\nnumber : "+request.getParameter("product_count"));

		HttpSession session = request.getSession();
		ProductCart cart = (ProductCart) session.getAttribute("cart"); // 세션에서 카트 정보를 갖고 온다
		ArrayList<ProductSingleCart> singleProducts = cart.getSingleProducts();

		int totalPrice = 0;
		for (ProductSingleCart singleProduct : singleProducts) {
			if (singleProduct.getProductVO().getProduct_number() == product_number) {
				singleProduct.setProduct_count(product_count);
			}
			totalPrice += singleProduct.getProduct_price();
		}
		session.setAttribute("totalPrice", totalPrice); // 전체 금액을 세션에 저장
		cart.setSingleProducts(singleProducts); // 추가 한것으로 업데이트
		session.setAttribute("cart", cart);
		ActionForward forward = new ActionForward();
		forward.setPath("cart.jsp");
		forward.setRedirect(true); // 넘겨줄 데이터 X
		return forward;
	}
}
