<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>


<!DOCTYPE html>
<html class="wide wow-animation" lang="ko">
<head>
<title>정기구독</title>
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
		<mytag:pageHeader pageSector="subscription" />


		<!-- 정기구독 안내 -->
		<section class="body">
			<h3>정기구독</h3>
			<hr>
			<mytag:subscripTable />
		</section>

		<!-- Icon Classic-->
		<section class="section section-lg bg-gray-100">
			<div class="container">
				<div class="row row-md row-50">
					<div class="col-sm-6 col-xl-4 wow fadeInUp" data-wow-delay="0s">
						<article class="box-icon-classic">
							<div
								class="unit unit-spacing-lg flex-column text-center flex-md-row text-md-left">
								<div class="unit-left">
									<div class="box-icon-classic-icon linearicons-helicopter"></div>
								</div>
								<div class="unit-body">
									<h5 class="box-icon-classic-title">무료배송</h5>
									<p class="box-icon-classic-text">독자적인 배송시스템을 무료로 이용하세요!</p>
								</div>
							</div>
						</article>
					</div>
					<div class="col-sm-6 col-xl-4 wow fadeInUp" data-wow-delay=".1s">
						<article class="box-icon-classic">
							<div
								class="unit unit-spacing-lg flex-column text-center flex-md-row text-md-left">
								<div class="unit-left">
									<div class="box-icon-classic-icon linearicons-pizza"></div>
								</div>
								<div class="unit-body">
									<h5 class="box-icon-classic-title">다양한 식단</h5>
									<p class="box-icon-classic-text">신메뉴 연구와 고객 의견 반영에 적극 힘쓰고
										있습니다.</p>
								</div>
							</div>
						</article>
					</div>
					<div class="col-sm-6 col-xl-4 wow fadeInUp" data-wow-delay=".2s">
						<article class="box-icon-classic">
							<div
								class="unit unit-spacing-lg flex-column text-center flex-md-row text-md-left">
								<div class="unit-left">
									<div class="box-icon-classic-icon linearicons-leaf"></div>
								</div>
								<div class="unit-body">
									<h5 class="box-icon-classic-title">균형잡힌 식단</h5>
									<p class="box-icon-classic-text">전문 영양사가 엄선한 식단을 고민없이
										즐겨보세요!</p>
								</div>
							</div>
						</article>
					</div>
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