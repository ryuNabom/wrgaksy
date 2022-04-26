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

public class ProductCategoryAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		String filter = request.getParameter("filter"); // view 로 부터 받아온 필터 값
		ProductDAO dao = new ProductDAO();
		request.setAttribute("filter", filter);
		System.out.println(filter);
		ArrayList<ProductVO> productList = new ArrayList<>();
		if (filter.equals("main")) {
			productList = dao.selectMain();
		} else if (filter.equals("side")) {
			productList = dao.selectSide();
		} else if (filter.equals("soup")) {
			productList = dao.selectSoup();
		}
		request.setAttribute("productList", productList);
		forward.setPath("productList.jsp");
		forward.setRedirect(false); // 보내야할 데이터가 있기때문에 forward
		return forward;
	}
}
