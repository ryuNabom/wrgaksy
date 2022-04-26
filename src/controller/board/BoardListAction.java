package controller.board;

import controller.Action;
import controller.ActionForward;
import model.board.BoardDAO;
import model.board.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class BoardListAction implements Action {

	// 게시판에 등록된 모든 글을 조회
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시판 테이블을 Board 라고 가정하고 진행, 게시판 페이지를 board.jsp 라고 가정하고 진행
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> boardList = dao.selectAll(); // dao 에서 조회된 데이터들을 받아옴
		request.setAttribute("boardList", boardList);
		// Action 값 지정
		ActionForward forward = new ActionForward();
		forward.setPath("boardList.jsp");
		forward.setRedirect(false); // dao로 부터 받은 리스트를 넘겨줘야하기 때문에 forward

		return forward;
	}
}
