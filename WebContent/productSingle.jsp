<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>


<!DOCTYPE html>
<html class="wide wow-animation" lang="ko">
<head>
<title>단품구매</title>
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
		<mytag:pageHeader pageSector="product" />

		<!-- productList -->
		<section class="body">
			<h3>단품구매</h3>
			<hr>
			<ul class="breadcrumbs-custom-path">
				<li><a href="productList.pd">상품목록</a></li>
				<li class="active">상세보기</li>
			</ul>

			<!-- --------------------------------------------------------------------------------------------- -->

			<div style="margin-top: 50px; margin-bottom: 100px;">
				<section>
					<div class="container">
						<div class="row">
							<div class="col-sm-6 mb-sm-40">
								<a href="${productVO.product_image}"><img
									style="border-radius: 20px;" src="${productVO.product_image}"
									alt="Single Product Image" /></a>
							</div>
							<div class="col-sm-6">
								<div class="row">
									<div style="width: 100%;">
										<h3 class="product-title font-alt">${productVO.product_name}</h3>
									</div>
								</div>
								<div style="margin-top: 50px; margin-bottom: 50px;">
									<article class="quote-classic quote-classic-3 wow slideInDown">
										<div class="quote-classic-text">
											<p class="q">${productVO.product_price}원</p>
											<hr>
											<p class="q2">
												${productVO.details}<br> <br>Categories:
												${productVO.product_type} </>
											</p>
										</div>
									</article>
								</div>
								<form action="productAdd.pd" method="post">
									<div class="row mb-20">
										<input type="hidden" name="product_number"
											value="${productVO.product_number}">
										<div class="col-sm-4 mb-sm-20">
											<input class="form-control input-lg" type="number"
												name="product_count" value="1" max="99" min="1"
												required="required" style="margin-left: 40px;" />
										</div>
										<div class="col-sm-8">
											<button
												class="button2 button-md button-primary button-winona wow fadeInRight"
												type="submit"
												style="visibility: visible; animation-name: fadeInRight; width: 300px; height: 52px;">장바구니에
												추가</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</section>
			</div>

			<!-- --------------------------------------------------------------------------------------------- -->
		</section>
		<!-- Page Footer-->
		<mytag:pageFooter />

	</div>
	<!-- /div page -->

	<!-- Javascript-->
	<script src="js/core.min.js"></script>
	<script src="js/script.js"></script>
	<!-- coded by 마른오징어-->
</body>
</html>