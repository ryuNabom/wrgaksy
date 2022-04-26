<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>


<!DOCTYPE html>
<html class="wide wow-animation" lang="ko">
<head>
<title>장바구니</title>
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
		<mytag:pageHeader pageSector="" />

		<!-- productList -->
		<section class="body">
			<h3>장바구니</h3>
			<hr>
			<h5>${customer_name}님의장바구니입니다.</h5>

			<!-- 장바구니 -->
			<section class="section section-lg bg-default">
				<div class="container">
					<!-- <h3 class="oh-desktop"><span class="d-inline-block wow slideInUp">Selected Pizzas</span></h3> -->

					<!-- 구독권 안내 -->
					<div class="tableWrapper4">
						<table>
							<colgroup>
								<col width="40%">
								<col width="30%">
								<col width="30%">
							</colgroup>
							<tr>
								<th colspan="4">[구독권]</th>
							</tr>
							<tr>
								<c:choose>
									<c:when test="${product_set==null}">
										<!-- 구독 선택하지 않았다면 -->
										<td colspan="3">선택 안함</td>
										<td><a class="btn btn-lg btn-round btn-b"
											href="subscription.jsp">구독하러 가기</a></td>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${product_set.soup_check=='포함'}">
												<td>30일 정기구독권(국포함)</td>
												<td colspan="2">${product_set_price}</td>
												<td><a href="deleteCart.pd?undoSubscribe=yes">X</a></td>
											</c:when>
											<c:otherwise>
												<td>30일 정기구독권</td>
												<td colspan="2">가격</td>
												<td><a href="deleteCart.pd?undoSubscribe=yes">X</a></td>
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>

							</tr>
						</table>

						<!-- 단품목록 안내 -->
						<table>
							<colgroup>
								<col width="40%">
								<col width="30%">
								<col width="30%">
							</colgroup>
							<tr>
								<th colspan="4">[단품]</th>
							</tr>
							<tr>
								<td>상품명</td>
								<td>개당 가격</td>
								<td colspan="2">수량(최대:99)</td>
							</tr>
							<tr>
								<c:choose>
									<c:when test="${cart.singleProducts==null}">
										<!-- 단품을 선택하지 않았다면 -->
										<td colspan="3">선택 안함</td>
										<td><a class="btn btn-lg btn-round btn-b"
											href="productList.pd">단품 추가하기</a></td>
									</c:when>
									<c:otherwise>
										<!-- 단품을 선택했다면 -->
										<c:forEach var="v" items="${cart.singleProducts}">
											<tr>
												<form action="updateCart.pd" method="post">
													<input type="hidden" name="product_number"
														value="${v.productVO.product_number}">
													<td>${v.productVO.product_name}</td>
													<td>${v.product_price}</td>
													<td><input type="number" name="product_count" min="1"
														max="99" value="${v.product_count}"> <input
														type="submit" value="변경하기">
													<td><a
														href="deleteCart.pd?product_number=${v.productVO.product_number}">X</a></td>
												</form>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tr>
						</table>
					</div>

					<!-- 종합 가격 안내 -->
					<div class="tableWrapper4">
						<table>
							<tr>
								<th colspan="5">가격종합</th>
								<!-- 링크추가하기 -->
							</tr>
							<tr>
								<td>구독권</td>
								<td>+</td>
								<td>단품</td>
								<td>=</td>
								<td>총합</td>
							</tr>
							<tr>
								<td>${product_set_price}</td>
								<td></td>
								<td>${totalPrice}</td>
								<td></td>
								<td>${product_set_price+totalPrice}</td>
							</tr>
						</table>
					</div>
					<a href="checkout.pd" class="btn btn-lg btn-round btn-b">이대로
						결제!</a>
					<%--                    <input type="submit" value="이대로 결제!" class="btn btn-lg btn-round btn-b">--%>
				</div>
			</section>
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