package controller.component;

public class TemporaryPassword {
	public String getTempPassword() {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '*',
				'!', '@', '#', '$', '%', '^', '&', '*' }; // 임의로 숫자, 특수문자, 문자로 구성된 charSet 을 생성
		int idx = 0;
		String tempPassword = "";
		for (int i = 0; i < 8; i++) { // 임시 비밀번호 12 자 생성
			// charSet 의 길이만큼의 랜덤한 숫자를 뽑아 랜덤 index 생성 후 해당 인덱스의 값을 결과에 더해준다
			idx = (int) (charSet.length * Math.random());
			tempPassword += charSet[idx];
		}
		return tempPassword;
	}
}
