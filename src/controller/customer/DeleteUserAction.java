package controller.customer;

import controller.Action;
import controller.ActionForward;
import model.customer.CustomerDAO;
import model.customer.CustomerVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteUserAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = null;
		CustomerDAO dao = new CustomerDAO();
		CustomerVO vo = new CustomerVO();
		HttpSession session = request.getSession();
		vo.setCustomer_id((String) session.getAttribute("customer_id"));
		vo.setCustomer_password(request.getParameter("customer_password"));
		if (dao.delete(vo)) { // 회원 탈퇴가 정상적으로 되었다면
			session.invalidate(); // 세션에 남아있던 회원정보 지우기
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true); // 넘겨줄 데이터가 없기 때문에 redirect
		} else { // 아이디에 해당하는 비밀번호가 일치하지 않을시
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); // 스크립트 printwriter
			out.println("<script>alert('비밀번호가 일치하지 않습니다');history.go(-1);</script>");
		}
		return forward;
	}
}
