package controller.product;

import controller.Action;
import controller.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductDetailAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		ProductDAO dao = new ProductDAO();
		ProductVO vo = new ProductVO();
		vo.setProduct_number(Integer.parseInt(request.getParameter("product_number")));
		ProductVO productVO = dao.selectOne(vo);

		request.setAttribute("productVO", productVO);
		forward.setPath("productSingle.jsp"); // 아직 구현되지 않은 페이지
		forward.setRedirect(false); // 넘겨줘야할 데이터 O
		return forward;
	}
}
