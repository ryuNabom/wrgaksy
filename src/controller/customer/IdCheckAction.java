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

public class IdCheckAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String customer_id = request.getParameter("id");
		CustomerDAO dao = new CustomerDAO();
		CustomerVO vo = new CustomerVO();
		vo.setCustomer_id(customer_id); // request 로 받은 id 를 넣는다
		System.out.println(customer_id);

		int idCheck = dao.id_check(vo);

		System.out.println(idCheck + "\n0: 존재하는 아이디, 1: 사용가능"); // 아이디 체크 로깅
		PrintWriter out = response.getWriter();
		out.write(idCheck + "");
		// 문자열로 값을 내보냄
		// null 을 보냄으로서 페이지에 머무를 수 있도록 함
		return null;
	}
}
