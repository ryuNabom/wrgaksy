package controller.board;

import controller.Action;
import controller.ActionForward;
import model.board.BoardDAO;
import model.board.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BoardInsertAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시글을 작성
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();

		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		// 작성자 아이디를 uid , 제목을 title, 내용을 content 라고 가정하고 진행
		vo.setCustomer_id((String) session.getAttribute("customer_id"));
		vo.setBoard_content(request.getParameter("board_content"));
		vo.setBoard_title(request.getParameter("board_title"));
		System.out.println("현재 vo: " + vo);
		dao.insert(vo);
		forward.setPath("boardDone.jsp");
		forward.setRedirect(true); // 넘겨야 할 데이터 X
		return forward;
	}
}
