package controller.customer;

import controller.ActionForward;
import controller.MainAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerFrontController", value = "/CustomerFrontController")
public class CustomerFrontController extends HttpServlet {
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
		} else if (command.equals("login")) {
			try {
				forward = new LogInAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("login.do 수행중 문제 발생");
			}
		} else if (command.equals("logout")) {
			try {
				forward = new LogOutAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("logout.do 수행중 문제 발생");
			}
		} else if (command.equals("new")) {
			try {
				forward = new NewAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("new.do 수행중 문제 발생");
			}
		} else if (command.equals("idCheck")) {
			try {
				forward = new IdCheckAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("idCheck.do 수행중 문제 발생");
			}
		} else if (command.equals("updateUser")) {
			try {
				forward = new UpdateUserAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("updateUser.do 수행중 문제 발생");
			}
		} else if (command.equals("deleteUser")) {
			try {
				System.out.println("delete수행");
				forward = new DeleteUserAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("deleteUser.do 수행중 문제 발생");
			}
		} else if (command.equals("mypage")) {
			try {
				forward = new MyPageAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("mypage.do 수행중 문제 발생");
			}
		} else if (command.equals("findPw")) {
			try {
				forward = new FindPwAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("findpw.do 수행중 문제 발생");
			}
		} else if (command.equals("findId")) {
			try {
				forward = new FindIdAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("findid.do 수행중 문제 발생");
			}
		}
//        else if(command.equals("myorder")){
//            try{
//                forward = new MyOrderAction().execute(request, response);
//            } catch (Exception e){
//                System.out.println("myorderAction 수행중 문제 발생");
//            }
//        }
//        else if(command.equals("withdrawal")){
//            try{
//                forward = new WithdrawalAction().execute(request, response);
//            } catch (Exception e){
//                System.out.println("myorderAction 수행중 문제 발생");
//            }
//        }
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
