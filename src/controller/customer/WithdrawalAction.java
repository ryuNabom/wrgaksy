package controller.customer;

import controller.Action;
import controller.ActionForward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WithdrawalAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath("mypage.jsp#tabs-4-3");
		forward.setRedirect(false);
		return forward;
	}
}
