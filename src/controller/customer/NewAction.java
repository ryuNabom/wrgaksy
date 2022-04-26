package controller.customer;

import controller.Action;
import controller.ActionForward;
import model.customer.CustomerDAO;
import model.customer.CustomerVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = null;
		CustomerDAO dao = new CustomerDAO();
		CustomerVO vo = new CustomerVO();
		vo.setCustomer_id(request.getParameter("customer_id"));
		vo.setCustomer_password(request.getParameter("customer_password"));
		vo.setCustomer_name(request.getParameter("customer_name"));
		vo.setPhone_number(request.getParameter("phone_number"));
		vo.setZIP_code(request.getParameter("ZIP_code"));
		vo.setDetailed_address(request.getParameter("detailed_address"));
		if (dao.insert(vo)) { // 회원 가입에 성공했다면
			forward = new ActionForward();
			// 로그인 페이지로 이동
			forward.setPath("signupDone.jsp");
			forward.setRedirect(true);
		} else {
			// 회원 가입 실패시 forward=null
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); // 스크립트 printwriter
			out.println("<script>alert('회원가입 실패!');history.go(-1);</script>");
		}
		return forward;
	}
}
