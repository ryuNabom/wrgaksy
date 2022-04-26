<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>


<!DOCTYPE html>
<html class="wide wow-animation" lang="ko">
<head>
<title>결제페이지</title>
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
		<mytag:pageHeader pageSector="" />


		<section class="section section-lg bg-default">
			<h3>주문서</h3>
			<hr>
			<div class="container">

				<!--결제하기 페이지 -->
				<form action="payment.pd" method="post">
					<!--주문 고객 정보  -->
					<div class="tableWrapper6">
						<table>
							<colgroup>
								<col width="40%">
								<col width="60%">
							</colgroup>
							<tr>
								<th colspan="3">1.주문 고객 정보</th>
							</tr>
							<tr>
								<td>이름 :</td>
								<td>${userData.customer_name}</td>
							</tr>
							<tr>
								<td>전화 번호 :</td>
								<td>${userData.phone_number}</td>
							</tr>
						</table>
					</div>
					<!--배송지 정보  -->
					<div class="tableWrapper6">
						<table>
							<colgroup>
								<col width="35%">
								<col width="25%">
								<col width="40%">
							</colgroup>
							<tr>
								<th colspan="3">2.배송지 정보</th>
							</tr>
							<tr>
								<td>배송 주소 :</td>
								<td>${userData.ZIP_code}</td>
								<td>${userData.detailed_address}</td>
							</tr>
							<tr>
								<td>희망 보관장소</td>
								<td colspan="2"><select style="border: 0.6px solid black;">
										<option value="choice1" selected="selected">직접 받고
											부재시문 앞</option>
										<option value="choice2">문 앞</option>
										<option value="choice3">택배함</option>
										<option value="choice4">경비실</option>
								</select></td>
							</tr>
						</table>
					</div>
					<!--상품 보여주기 -->
					<div class="tableWrapper6">
						<table>
							<colgroup>
								<col width="50%">
								<col width="30%">
								<col width="20%">
							</colgroup>
							<tr>
								<th colspan="3">3.상품 정보</th>
							</tr>
							<tr>
								<td>상품명</td>
								<td>개당 가격</td>
								<td>수량</td>
							</tr>
							<tr>
								<c:if test="${product_set!=null}">
									<c:choose>
										<c:when test="${product_set.soup_check eq '포함'}">
											<!-- 국 포함이라면-->
											<td>30일 정기구독권(국포함)</td>
											<td>${product_set_price}</td>
											<td>1</td>
										</c:when>
										<c:otherwise>
											<td>30일 정기구독권</td>
											<td>${product_set_price}</td>
											<td>1</td>
										</c:otherwise>
									</c:choose>
								</c:if>
							</tr>

							<c:if test="${cart.singleProducts!=null}">

								<c:forEach var="v" items="${cart.singleProducts}">
									<tr>
										<td>${v.productVO.product_name}</td>
										<td>${v.product_price}</td>
										<td>${v.product_count}</td>
									</tr>
								</c:forEach>
							</c:if>

							<tr>
								<td>총 결제 금액 :</td>
								<td colspan="2">${product_set_price+totalPrice}</td>
							</tr>
						</table>
					</div>
					<!-- 결제방법 -->
					<div class="tableWrapper6">
						<table>
							<tr>
								<th colspan="3" style="text-align: center;">4.결제 수단</th>
							</tr>
							<tr>
								<td><input type="radio" name="pay" required> 카드로 결제</td>
								<td><input type="radio" name="pay" required> 핸드폰으로
									결제</td>
								<td><input type="radio" name="pay" required> 무통장 입금</td>
							</tr>
						</table>
					</div>

					위 주문 내용을 확인하였으며, 회원 본인은 결제에 동의합니다.<input type="checkbox" id=check
						required><br>
					<br>
					<br> <input type="submit" value="결제"
						class="class=button2 button-md button-primary button-winona fadeInRight">
				</form>
			</div>
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
