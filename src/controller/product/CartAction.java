package controller.product;

import controller.Action;
import controller.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class CartAction implements Action {
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
			ArrayList<ProductVO> cart = (ArrayList<ProductVO>) session.getAttribute("cart");
			ProductDAO dao = new ProductDAO();
			ProductVO vo = new ProductVO();
			int product_number = Integer.parseInt(request.getParameter("product_number"));
			System.out.println(product_number);
			vo.setProduct_number(product_number); // vo 에 product_number 세팅 후 dao 를 통하여 쿼리 수행
			ProductVO productVO = dao.selectOne(vo);

			if (cart == null) {
				// 현재 장바구니가 비어있다면
				System.out.println("새로운 장바구니 생성!");
				cart = new ArrayList<ProductVO>(); // 새로운 장바구니 생성
			}
			cart.add(productVO); // 카트에 제품 넣기
			session.setAttribute("cart", cart); // 세션에 추가된 장바구니 저장

			// 장바구니 페이지로 이동

			forward.setPath("cart.jsp");
			forward.setRedirect(true); // 넘겨줄 데이터 X
		}

		return forward;
	}
}
