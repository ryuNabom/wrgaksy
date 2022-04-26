package controller.product;

import controller.Action;
import controller.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductVO> productList = dao.selectAll();

		request.setAttribute("productList", productList);
		// Action 값 지정
		ActionForward forward = new ActionForward();
		forward.setPath("productList.jsp");
		forward.setRedirect(false); // dao로 부터 받은 리스트를 넘겨줘야하기 때문에 forward

		return forward;
	}
}
