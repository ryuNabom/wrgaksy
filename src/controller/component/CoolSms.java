package controller.component;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class CoolSms {
	// 노출되면 안되는 개인 키값을 private 으로 캡슐화
	private String api_key = "NCSNVKJQGWT4JF7D";
	private String api_secret = "TR2C0PGJ1CSXBJODRC0T0HKATJ8TNMLV";

	public boolean sendMsg(String phone_number, String tempPassword) {
		Message coolsms = new Message(api_key, api_secret);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", phone_number); // 수신전화번호
		params.put("from", "01098041056"); // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
		params.put("type", "SMS");
		params.put("text", "회원님의 임시 비밀번호는 " + tempPassword + " 입니다.\n확인후 로그인 해주세요");
		params.put("app_version", "test app 1.2"); // application name and version
		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			return true;
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
		return false; // 만약 전송 실패시 로깅과 함께 실패 메시지
	}
}
