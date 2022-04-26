<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>

<div class="tableWrapper">
	<form action="updateUser.me" method="post">
		<table>
			<tr>
				<th colspan="3" style="text-align: center;">회원정보 수정</th>
			</tr>
			<tr>
				<td>이름</td>
				<td><input name="customer_name" type="text"
					placeholder="${customer_name}" required></td>
				<td style="color: rgba(0, 0, 0, 0);">비밀번호가 일치하지 않습니다</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" placeholder="${customer_id}"
					disabled="disabled"></td>
				<td></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="pw1" name="customer_password"
					placeholder="비밀번호는 안전하게" required></td>
				<td></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" id="pw2" class="pwcheck"
					name="password_check" required></td>
				<td><font id="checkPw"></font></td>
			</tr>
			<tr>
				<td rowspan="2">주소</td>
				<td><input name="ZIP_CODE" type="text" id="sample4_postcode"
					placeholder="${userData.ZIP_code}" required></td>
				<td><input id="input" type="button"
					style="border-radius: 10px;" onclick="sample4_execDaumPostcode()"
					value="우편번호 찾기">
				<mytag:postcode /></td>
			</tr>
			<tr>
				<td colspan="2"
					style="text-align: left; border-top: solid #9b9b9b 0.7px;"><input
					name="detailed_address" type="text" id="sample4_detailAddress"
					placeholder="${userData.detailed_address}" required></td>
			</tr>
			<tr>
				<td>핸드폰 번호</td>
				<td><input name="phone_number" type="text"
					placeholder="${userData.phone_number}" required></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><button
						class="button2 button-md button-primary button-winona wow fadeInRight"
						type="submit" formmethod="post">변경하기!</button></td>
			</tr>
		</table>
	</form>
</div>
<script>
    let pwChecked=false;
    $(".pwcheck").focusout(function() { // 아이디를 입력할때 마다 중복검사 실행
        checkPw($(this).val())
    })
    function checkPw(pw){
        if(pw==""){
            $("#checkId").text("");
            return; // 아직 입력된 상태가 아니라면 아무런 문구를 출력하지 않는다
        }

        if($('#pw1').val()!=$('#pw2').val()){
            // 만약 pw1과 pw2가 알치하지 않는다면
            $("#checkPw").html('비밀번호가 일치하지 않습니다'); // 문구 출력
            $("#checkPw").attr('color', 'red');
            $('#pw2').val(''); // 값을 비움
            $('#pw2').focus(); // 포인터를 pw2 로 맞춘다
            pwChecked=false;
        }
        else{
            $("#checkPw").html('비밀번호가 일치합니다'); // 문구 출력
            $("#checkPw").attr('color', 'green');
            pwChecked=true;
        }
    }
</script>
