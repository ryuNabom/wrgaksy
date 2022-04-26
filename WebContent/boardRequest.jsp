<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>


<!DOCTYPE html>
<html class="wide wow-animation" lang="ko">
<head>
<title>상품신청 작성</title>
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
<!--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
    <![endif]-->
</head>
<body>
	<mytag:preloader />
	<div class="page">

		<!-- Page Header-->
		<mytag:pageHeader pageSector="board" />

		<!-- Tell-->
		<section class="section section-sm section-first bg-default">
			<div class="container">
				<h3 class="heading-3">상품신청</h3>
				<div class="rd-form form-style-1">
					<%--                <form class="rd-form rd-mailform form-style-1" method="post" action="insertBoard.do">--%>
					<form method="post" action="insertBoard.do">
						<div class="row row-20 gutters-20">
							<div class="col-md-6 col-lg-4 oh-desktop">
								<div class="form-wrap wow slideInDown">
									<input class="form-input" id="hopemenu" type="text"
										name="board_title" data-constraints="@Required"
										required="required"> <label class="form-label"
										for="hopemenu">음식명 (예시:해물파전)</label>
								</div>
							</div>
							<div class="col-12">
								<div class="form-wrap wow fadeIn">
									<label class="form-label" for="explainyourmenu">음식설명</label>
									<textarea class="form-input textarea-lg" id="explainyourmenu"
										name="board_content" data-constraints="@Required"
										required="required"></textarea>
								</div>
							</div>
						</div>
						<div class="group-custom-1 group-middle oh-desktop">
							<button
								class="button button-lg button-primary button-winona wow fadeInRight"
								type="submit">신청</button>
							<!-- Quote Classic-->
							<article class="quote-classic quote-classic-3 wow slideInDown">
								<div class="quote-classic-text">
									<p class="q">게시 후에는 수정이 불가하오니 신중하게 작성 부탁드립니다.</p>
									<hr>
									<p class="q2">이미 신청목록에 있는 메뉴라면 새로 신청하기보다 좋아요를 눌러주는 것이 반영될
										확률이 더 큽니다!</p>
								</div>
							</article>
						</div>
					</form>
				</div>
			</div>
		</section>

		<!-- Page Footer-->
		<mytag:pageFooter />
	</div>

	<!-- Javascript-->
	<script src="js/core.min.js"></script>
	<script src="js/script.js"></script>
	<!-- coded by 마른오징어-->
</body>
</html>