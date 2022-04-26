package controller.customer;

import controller.Action;
import controller.ActionForward;
import controller.component.CoolSms;
import controller.component.TemporaryPassword;
import model.customer.CustomerDAO;
import model.customer.CustomerVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FindPwAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String customer_id = request.getParameter("id");
		String phone_number = request.getParameter("phoneNumber");
		CustomerDAO dao = new CustomerDAO();
		CustomerVO vo = new CustomerVO();
		vo.setCustomer_id(customer_id);
		vo.setPhone_number(phone_number);
		System.out.println("입력된 id: " + customer_id + "\n전화번호: " + phone_number);
		if (dao.validationPw(vo)) {
			// 만약 유효한 아이디와 전화번호라면
			// 작업 수행
			System.out.println("id: " + customer_id + "\n전화번호: " + phone_number); // 로깅
			// 랜덤한 비밀번호 생성
			TemporaryPassword temporaryPassword = new TemporaryPassword();
			CoolSms sendSms = new CoolSms();
			String tempPassword = temporaryPassword.getTempPassword();

			if (sendSms.sendMsg(phone_number, tempPassword)) {
				// 만약 보내기에 성공 했다면
				// 먼저 DAO를 통하여 비밀번호를 임시 비밀번호로 재설정해준다
				CustomerVO tempVO = new CustomerVO();
				tempVO.setCustomer_id(customer_id);
				tempVO.setCustomer_password(tempPassword);
				if (dao.updateTemp(tempVO)) { // 만약 업데이트에 성공하였다면
					// 성공 메시지 출력
					out.write("회원님의 임시 비밀번호가 설정되었습니다! \n로그인 후 마이페이지를 통해 변경 해주세요");
				}
			} else {
				out.write("문자 전송 실패하였습니다");
			}
		} else { // 아이디와 전화번호가 일치하지 않았다면 실패 메시지 출력
			out.println("해당하는 아이디가 존재하지 않습니다!");
		}
		return null;
	}

}
