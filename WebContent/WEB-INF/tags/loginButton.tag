<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${customer_id==null}">
		<a href="login.jsp" class="btn button-xxs button-white">로그인</a>
	</c:when>
	<c:otherwise> 
	${customer_name}님 환영합니다.<a href="logout.do"
			class="btn button-xxs button-white">로그아웃</a>
	</c:otherwise>
</c:choose>