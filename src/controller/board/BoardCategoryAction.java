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
import java.util.ArrayList;

public class BoardCategoryAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		String category = request.getParameter("category"); // 각 버튼 별 카테고리로 분류하여 파라미터로 넘겨받는다
		// 카테고리는 내글보기, 최신순, 좋아요 순으로 세가지가 존재한다
		// 내글보기: mine, 최신순: recent, 좋아요순: favorite 의 카테고리 값을 가진다고 가정하고 진행
		BoardDAO dao = new BoardDAO();
		if (category.equals("mine")) {
			HttpSession session = request.getSession();
			BoardVO vo = new BoardVO();
			// 현재 로그인된 uid 를 통하여 select 쿼리로 찾을 수 있을 것이다.
			vo.setCustomer_id((String) session.getAttribute("customer_id"));
			ArrayList<BoardVO> boardList = dao.selectMine(vo);
			request.setAttribute("boardList", boardList);

			forward.setPath("boardList.jsp");
			forward.setRedirect(false); // 보내야할 데이터가 있기때문에 forward
		} else if (category.equals("recent")) {
			// 기본상태가 최신순 이기 때문에 바로 board.do 로 넘겨준다
			forward.setPath("boardList.do");
			forward.setRedirect(true); // 넘겨줄 데이터 없으니 sendRedirect
		} else if (category.equals("favorite")) {
			// order by fav 로 된 dao 가 selectFav 라고 가정한다
			ArrayList<BoardVO> boardList = dao.selectFav();
			request.setAttribute("boardList", boardList);

			forward.setPath("boardList.jsp");
			forward.setRedirect(false); // 좋아요 순으로 정렬된 데이터를 보내줘야 하기때문에 forward
		}
		return forward; // 최종적으로 forward 를 반환한다
	}
}
