package controller.customer;

import controller.Action;
import controller.ActionForward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOutAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		session.invalidate(); // session 에 있는 데이터 flush (모두 삭제)
		forward.setPath("main.do");
		forward.setRedirect(true); // 넘길 데이터 없음
		return forward;
	}
}
