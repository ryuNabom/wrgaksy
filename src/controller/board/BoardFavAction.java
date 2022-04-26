package controller.board;

import controller.Action;
import controller.ActionForward;
import model.board.BoardDAO;
import model.board.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardFavAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		// 해당 게시글의 글 번호를 받아와 글번호를 갖고 추천수를 늘려준다
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setBoard_number(Integer.parseInt(request.getParameter("board_number")));// view 로 부터 받아온 글번호 bid 를 받아와 vo 객체에
																					// 저장
		dao.update(vo); // update board set fav=fav+1 where bid = ?

		// 좋아요를 누른 이후 신청 리스트로 빠져나온다
		forward.setPath("boardList.do");
		forward.setRedirect(true); // 넘겨줄 데이터가 없기 때문에 board.do 로 이동
		return forward;
	}
}
