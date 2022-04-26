<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>


<!DOCTYPE html>
<html class="wide wow-animation" lang="ko">
<head>
<title>로그인</title>
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
</head>
<body>
	<mytag:preloader />
	<div class="page">

		<!-- Page Header-->
		<mytag:pageHeader pageSector=" " />

		<!-- login form -->
		<section class="body">
			<h3>로그인</h3>
			<div class="tableWrapper">
				<form action="login.me" method="post">
					<table>
						<tr>
							<td>아이디</td>
							<td><input name="customer_id" type="text"></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input name="customer_password" type="password"></td>
						</tr>
						<tr style="padding: 10px;">
							<td rowspan="3"><a
								style="border-radius: 20px; margin-top: 5px;"
								class="button2 button-md button-primary button-winona wow fadeInRight"
								href="findIdPwd.jsp">아이디/비밀번호 찾기</a></td>
						</tr>
						<tr style="padding: 10px;">
							<td rowspan="3"><button
									class="button2 button-md button-primary button-winona wow fadeInRight"
									type="submit" formmethod="post">로그인</button></td>
						</tr>
					</table>
				</form>
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