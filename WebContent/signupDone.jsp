<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>


<!DOCTYPE html>
<html class="wide wow-animation" lang="ko">
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
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<mytag:preloader />

	<div class="page">
		<!-- Page Header-->
		<mytag:pageHeader pageSector=" " />

		<!-- boardDone -->
		<section class="body">
			<h3>회원가입 완료</h3>
			<hr>
			<h6>가입해주셔서 감사합니다.</h6>
			<br>
			<button
				class="button button-md button-primary button-winona wow fadeInRight"
				onclick="location.href='login.jsp'">로그인하러 가기</button>
			<br> <br>
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