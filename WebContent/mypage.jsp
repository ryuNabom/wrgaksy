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
<title>MyPage</title>
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

		<!-- mypage -->
		<!-- Breadcrumbs -->
		<section class="body">
			<h3>My Page</h3>
		</section>
		<section class="section section-lg bg-default">
			<div class="container">
				<div
					class="tabs-custom row row-50 justify-content-center flex-lg-row-reverse text-center text-md-left"
					id="tabs-4">
					<div class="col-lg-4 col-xl-3">
						<h5 class="text-spacing-200 text-capitalize">♥</h5>
						<ul class="nav list-category list-category-down-md-inline-block">
							<li class="list-category-item wow fadeInRight"
								role="presentation" data-wow-delay="0s"><a class="active"
								href="#tabs-4-1" data-toggle="tab">회원정보 수정</a></li>
							<c:if test="${order_set!=null}">
								<li class="list-category-item wow fadeInRight"
									role="presentation" data-wow-delay=".1s"><a
									href="#tabs-4-2" data-toggle="tab">내 밥상 보기</a></li>
							</c:if>
							<li class="list-category-item wow fadeInRight"
								role="presentation" data-wow-delay=".2s"><a
								href="#tabs-4-3" data-toggle="tab">회원 탈퇴</a></li>
						</ul>
					</div>
					<div class="col-lg-8 col-xl-9">
						<!-- Tab panes-->
						<div class="tab-content tab-content-1">
							<div class="tab-pane fade show active" id="tabs-4-1">
								<mytag:updateUser />
							</div>
							<c:if test="${order_set!=null}">
								<div class="tab-pane fade" id="tabs-4-2">
									<mytag:mytable />
								</div>
							</c:if>
							<div class="tab-pane fade" id="tabs-4-3">
								<mytag:withdrawal />
							</div>
						</div>
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