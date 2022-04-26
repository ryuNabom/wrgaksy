<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>


<!DOCTYPE html>
<html class="wide wow-animation" lang="ko">
<head>
<title>메인화면</title>
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
<link rel="stylesheet" href="css/style.css?ver=2">
<!--[if lt IE 10]>
  <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
  <script src="js/html5shiv.min.js"></script>
  <![endif]-->
</head>
<body>
	<mytag:preloader />
	<div class="page">

		<!-- Page Header-->
		<mytag:pageHeader pageSector=" " />

		<!-- Swiper -->
		<section
			class="section swiper-container swiper-slider swiper-slider-2 swiper-slider-3"
			data-loop="true" data-autoplay="5000" data-simulate-touch="false"
			data-slide-effect="fade">
			<div class="swiper-wrapper text-sm-left">
				<div class="swiper-slide context-dark"
					data-slide-bg="images/main_balanced.jpg">
					<div class="swiper-slide-caption section-md">
						<div class="container">
							<div class="row">
								<div
									class="col-sm-9 col-md-8 col-lg-7 col-xl-7 offset-lg-1 offset-xxl-0">
									<h1 class="oh swiper-title">
										<span class="d-inline-block" data-caption-animate="slideInUp"
											data-caption-delay="0">균형잡힌<br>영양소
										</span>
									</h1>
									<p class="big swiper-text" data-caption-animate="fadeInLeft"
										data-caption-delay="300">전문 영양사가 식단의 균형잡힌 영양을 보장합니다.</p>
									<mytag:mainSubscrBtn />
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="swiper-slide context-dark"
					data-slide-bg="images/main_clean.jpg">
					<div class="swiper-slide-caption section-md">
						<div class="container">
							<div class="row">
								<div
									class="col-sm-9 col-md-8 col-lg-7 col-xl-7 offset-lg-1 offset-xxl-0">
									<h1 class="oh swiper-title">
										<span class="d-inline-block" data-caption-animate="slideInUp"
											data-caption-delay="0">철저한<br>위생관리
										</span>
									</h1>
									<p class="big swiper-text" data-caption-animate="fadeInLeft"
										data-caption-delay="300">우렁각시는 ㈜CESCO의 철저한 위생관리를 받고 있습니다.</p>
									<mytag:mainSubscrBtn />
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="swiper-slide context-dark"
					data-slide-bg="images/main_fresh.jpg">
					<div class="swiper-slide-caption section-md">
						<div class="container">
							<div class="row">
								<div class="col-sm-8 col-lg-7 offset-lg-1 offset-xxl-0">
									<h1 class="oh swiper-title">
										<span class="d-inline-block"
											data-caption-animate="slideInDown" data-caption-delay="0">신선한<br>유통
										</span>
									</h1>
									<p class="big swiper-text" data-caption-animate="fadeInRight"
										data-caption-delay="300">상온/냉장/냉동에 맞는 보관법으로 귀하의 집 앞까지 온전히
										전달됩니다.</p>
									<div class="button-wrap oh">
										<mytag:mainSubscrBtn />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Swiper Pagination-->
			<div class="swiper-pagination" data-bullet-custom="true"></div>
			<!-- Swiper Navigation-->
			<div class="swiper-button-prev">

				<div class="swiper-button-arrow"></div>
			</div>
			<div class="swiper-button-next">
				<div class="swiper-button-arrow"></div>

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