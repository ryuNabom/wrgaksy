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

public class UpdateUserAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = null;
		CustomerDAO dao = new CustomerDAO();
		CustomerVO vo = new CustomerVO();
		// 기존 회원 정보 불러오기
		HttpSession session = request.getSession();
		vo.setCustomer_id((String) session.getAttribute("customer_id"));
		vo.setCustomer_name(request.getParameter("customer_name"));
		vo.setCustomer_password(request.getParameter("customer_password"));
		vo.setPhone_number(request.getParameter("phone_number")); // String 으로 바껴야 할것같음
		vo.setZIP_code(request.getParameter("ZIP_CODE")); // String 으로 (0 부터 시작할 경우 0 이 사라짐 처리할수가 없음)
		vo.setDetailed_address(request.getParameter("detailed_address"));
		System.out.println(vo);
		// 회원 구독 정보 불러오기

		int check = dao.update(vo);
		if (check == 1) {
			session.setAttribute("customer_name", vo.getCustomer_name());
			forward = new ActionForward();
			// 업데이트 성공
			forward.setPath("mypage.me");
			forward.setRedirect(true); // 넘겨야 할 데이터 없기때문에 true
		} else { // 업데이트 실패시
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); // 스크립트 printwriter
			out.println("<script>alert('회원 업데이트가 실패하였습니다');history.go(-1);</script>");
		}

		return forward;
	}
}
