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

public class LogInAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = null; // 로그인 되지 않았다면 null 이 되도록
		CustomerDAO dao = new CustomerDAO();
		CustomerVO vo = new CustomerVO();
		String customer_id = request.getParameter("customer_id");
		String customer_password = request.getParameter("customer_password");
		vo.setCustomer_id(customer_id);
		vo.setCustomer_password(customer_password);
		CustomerVO data = dao.login_check(vo);
		System.out.println(data);
		if (data != null) { // 만약 아이디, 비밀번호가 동일하다면
			HttpSession session = request.getSession(); // spring 식 session 을 받는법
			session.setAttribute("customer_id", data.getCustomer_id());
			session.setAttribute("customer_name", data.getCustomer_name()); // "000님 환영합니다"에 쓰임
			System.out.println(data.getCustomer_name());
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true); // 세션에 저장하였기 때문에 넘겨줘야할 데이터가 없다 가정
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); // 스크립트 printwriter
			out.println("<script>alert('해당 아이디는 존재하지 않습니다!');history.go(-1);</script>"); // forward가 null 일때는 front
																							// controller 가 끝나고 난뒤 이 문항을
																							// 실행한다
		}

		return forward;
	}
}
