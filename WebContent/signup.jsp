<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>


<!DOCTYPE html>
<html class="wide wow-animation" lang="ko">
<script>
    function disableselect(L){
        return false
    }
    function reEnable(){
        return true
    }
    //웹브라우저 익스플로러  4.0이상일 경우
    document.onselectstart=new Function ("return false")

    //웹브라우저 네스페케이프 6.0일 경우
    if (window.sidebar){
        document.onmousedown=disableselect
        document.onclick=reEnable
    }
</script>
<head>
<title>회원가입</title>
<meta name="format-detection" content="telephone=no">
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="utf-8">
<mytag:icon />
<!-- Stylesheets-->
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Roboto:100,300,300i,400,500,600,700,900%7CRaleway:500">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/fonts.css">
<link rel="stylesheet" href="css/style.css?after">
<script src="js/jquery.js"></script>
</head>
<body>
	<mytag:preloader />
	<div class="page">

		<!-- Page Header-->
		<mytag:pageHeader pageSector=" " />

		<!-- 회원가입 form -->
		<section class="body">
			<h3>회원가입</h3>
			<div class="tableWrapper">
				<form action="new.me" method="post" id="signUpForm">
					<table>
						<tr>
							<td>이름</td>
							<td><input name="customer_name" type="text" placeholder="이름"
								required></td>
							<td style="color: rgba(0, 0, 0, 0);">사용할 수 없는 아이디입니다.</td>
						</tr>
						<tr>
							<td>아이디</td>
							<td><input type="text" name="customer_id" class="input_id"
								placeholder="아이디" required></td>
							<%--            <td><button class="btn button-xs button-like idck">중복확인</button></td>--%>
							<td><font id="checkId"></font></td>
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
							<td><input name="ZIP_code" type="text" id="sample4_postcode"
								placeholder="우편번호" required></td>
							<td><input id="input" type="button"
								onclick="sample4_execDaumPostcode()" value="우편번호 찾기"> <mytag:postcode /></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: left;"><input
								name="detailed_address" type="text" id="sample4_detailAddress"
								placeholder="상세주소" required></td>
						</tr>
						<tr>
							<td>핸드폰 번호</td>
							<td><input name="phone_number" type="text"
								placeholder="eg.) 01012341234" required></td>
							<td></td>
						</tr>
						<tr style="border-bottom: none;">
							<td colspan="3"><button
									class="button2 button-md button-primary button-winona wow fadeInRight"
									type="submit" formmethod="post" disabled="disabled">가입하기!</button></td>
						</tr>
					</table>
				</form>
				<%--        아이디 확인 스크립트 --%>
				<script>
                let idChecked=false; // 중복 확인을 거쳤는지 확인
                $("input[name='customer_id']").keyup(function() { // 아이디를 입력할때 마다 중복검사 실행
                    checkId($(this).val())
                })
                function checkId(id) {
                    if (id == "") {
                        $("#checkId").text("");
                        return; // 만약 아이디 입력란이 공백일 경우 중복확인 문구 X
                    }

                    $.ajax({
                        url: "idCheck.me",
                        type: "post",
                        async: true,
                        data: {id: id},
                        dataType: 'json',
                        success: function (result) {
                            if (result == "0") {
                                $("#checkId").html('사용할 수 없는 아이디입니다.');
                                $("#checkId").attr('color', 'red');
                                idChecked = false; // id체크 true
                            } else {
                                $("#checkId").html('사용 가능한 아이디입니다.');
                                $("#checkId").attr('color', 'green');
                                idChecked = true;
                            }
                        },
                        error: function () {
                            alert("서버요청실패");
                        }
                    })
                    setAble();
                }
            </script>
				<%--        비밀 번호 확인 스크립트 --%>
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
                    setAble();
                }
            </script>
				<script>
                function setAble(){
                    console.log("idChecked : "+idChecked+"\npwChecked : "+pwChecked);
                    if(idChecked && pwChecked){
                        // 만약 아이디와 비밀번호의 유효성 검사를 마쳤다면
                        $("button[type=submit]").removeAttr("disabled");
                    }else{
                        $("button[type=submit]").attr("disabled","disabled"); // 유효성 검사 실시하지 않았다면 button이 눌려지지 않도록
                    }
                }
            </script>
			</div>
		</section>

		<!-- Page Footer-->
		<mytag:pageFooter />
	</div>
	<!-- Global Mailform Output-->
	<div class="snackbars" id="form-output-global"></div>
	<!-- Javascript-->
	<script src="js/core.min.js"></script>
	<script src="js/script.js"></script>

	<!-- coded by 마른오징어-->
</body>
</html>