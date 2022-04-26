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

public class BoardSearchAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword"); // view 에서 검색 된 키워드
		BoardDAO dao = new BoardDAO();
		// 검색된 키워드를 바탕으로 게시판 제목 %keyword% , 게시판 내용 %keyword% 를 가진 결과값들을 리스트에 저장후 반환
		ArrayList<BoardVO> boardList = dao.selectSearch(keyword);
		request.setAttribute("boardList", boardList);

		// Action
		ActionForward forward = new ActionForward();
		forward.setPath("boardList.jsp");
		forward.setRedirect(false); // dao로 부터 받은 리스트를 넘겨줘야하기 때문에 forward
		return forward;
	}
}
