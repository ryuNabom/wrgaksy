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

public class ProductSearchAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		ArrayList<ProductVO> productList = dao.selectSearch(keyword);
		request.setAttribute("productList", productList);

		ActionForward forward = new ActionForward();
		forward.setPath("productList.jsp");
		forward.setRedirect(false); // forward 로 넘김
		return forward;
	}
}
