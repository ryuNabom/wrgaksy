<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<%@ attribute name="pageSector"%>



<header class="section page-header">
	<!-- RD Navbar-->
	<div class="rd-navbar-wrap">
		<nav class="rd-navbar rd-navbar-modern" data-layout="rd-navbar-fixed"
			data-sm-layout="rd-navbar-fixed" data-md-layout="rd-navbar-fixed"
			data-md-device-layout="rd-navbar-fixed"
			data-lg-layout="rd-navbar-static"
			data-lg-device-layout="rd-navbar-fixed"
			data-xl-layout="rd-navbar-static"
			data-xl-device-layout="rd-navbar-static"
			data-xxl-layout="rd-navbar-static"
			data-xxl-device-layout="rd-navbar-static"
			data-lg-stick-up-offset="56px" data-xl-stick-up-offset="56px"
			data-xxl-stick-up-offset="56px" data-lg-stick-up="true"
			data-xl-stick-up="true" data-xxl-stick-up="true">
			<div class="rd-navbar-inner-outer">
				<div class="rd-navbar-inner">
					<!-- RD Navbar Panel-->
					<div class="rd-navbar-panel">
						<!-- RD Navbar Toggle-->
						<button class="rd-navbar-toggle"
							data-rd-navbar-toggle=".rd-navbar-nav-wrap">
							<span></span>
						</button>
						<!-- RD Navbar Brand-->
						<div class="rd-navbar-brand">
							<a class="brand" href="index.jsp"><img
								class="brand-logo-dark" src="images/headLogo.png"
								alt="brandLogo" width="230px" height="90px" /></a>
						</div>
					</div>
					<div class="rd-navbar-right rd-navbar-nav-wrap">
						<div class="rd-navbar-aside">
							<ul class="rd-navbar-contacts-2">
							</ul>
							<ul class="list-share-2">

								<!-- 로그인 상태가 아니라면 로그인 버튼만 제공 -->
								<c:choose>
									<c:when test="${customer_id==null}">
										<a href="login.jsp" class="btn button-xxs button-white">로그인</a>
										<a href="signup.jsp" class="btn button-xxs button-white">회원가입</a>
									</c:when>
									<c:otherwise>
                    ${customer_name}님 환영합니다.
                    <a href="logout.me"
											class="btn button-xxs button-white">로그아웃</a>
										<a href="cart.jsp" class="btn button-xxs button-white">장바구니</a>
										<a href="mypage.me" class="btn button-xxs button-white">MyPage</a>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>

						<div class="rd-navbar-main">
							<!-- RD Navbar Nav-->
							<!-- page가 어디부분인지 버튼에 밑줄로 안내 -->
							<ul class="rd-navbar-nav">
								<li
									class="${pageSector eq 'subscription' ? 'rd-nav-item active' : 'rd-nav-item'}"><a
									class="rd-nav-link" href="subscription.jsp">정기 구독</a></li>
								<li
									class="${pageSector eq 'product' ? 'rd-nav-item active' : 'rd-nav-item'}"><a
									class="rd-nav-link" href="productList.pd">단품 구매</a></li>
								<li
									class="${pageSector eq 'board' ? 'rd-nav-item active' : 'rd-nav-item'}"><a
									class="rd-nav-link" href="boardList.do">상품 신청</a></li>
							</ul>
						</div>
					</div>
					<div class="rd-navbar-project">
						<div class="rd-navbar-project-header">
							<div
								class="rd-navbar-project-hamburger rd-navbar-project-hamburger-close"
								data-multitoggle=".rd-navbar-inner"
								data-multitoggle-blur=".rd-navbar-wrap"
								data-multitoggle-isolate="data-multitoggle-isolate">
								<div class="project-close">
									<span></span><span></span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</nav>
	</div>
</header>