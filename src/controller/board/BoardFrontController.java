package controller.board;

import controller.ActionForward;
import controller.MainAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BoardFrontController", value = "/BoardFrontController")
public class BoardFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDO(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDO(request, response);
	}

	private void actionDO(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = null;
		// 1.요청을 파악
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		// 문자열 조작을 통하여 .do 파일에 대한 분석 (ex: main.do -> command = main)
		String command = uri.substring(cp.length() + 1, uri.length() - 3);
		System.out.println(command);

		// 로직이 바뀌어도 서버데이터에 부담을 주지 않는다
		if (command.equals("main")) {
			try {
				forward = new MainAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("main.do 수행중 문제 발생");
			}
		}
		// 상품 신청하기 메인
		else if (command.equals("boardList")) {
			try {
				forward = new BoardListAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("boardList.do 수행중 문제 발생");
			}
		}
		// 최신순, 좋아요순, 내글보기 버튼 클릭시 수행 액션
		else if (command.equals("categoryBoard")) {
			try {
				forward = new BoardCategoryAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("categoryBoard.do 수행중 문제 발생");
			}
		}
		// 좋아요 버튼 클릭시 수행 액션
		else if (command.equals("updateBoard")) {
			try {
				forward = new BoardFavAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("updateBoard.do 수행중 문제 발생");
			}
		}
		// 검색하기 버튼 클릭시 수행 액션
		else if (command.equals("searchBoard")) {
			try {
				forward = new BoardSearchAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("searchBoard.do 수행중 문제 발생");
			}
		}
		// 상품 신청하기 클릭시 수행 액션
		else if (command.equals("insertBoard")) {
			try {
				forward = new BoardInsertAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("insertBoard.do 수행중 문제 발생");
			}
		} else if (command.equals("boardDelete")) {
			try {
				forward = new BoardDeleteAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("boardDelete.do 수행중 문제 발생");
			}
		} else if (command.equals("boardDetail")) {
			try {
				forward = new BoardDetailAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("boardDetail.do 수행중 문제 발생");
			}
		}

		// 만약 forward 가 null 이라면 null pointer exception 이 발생하기 떄문에 대비
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}
}
