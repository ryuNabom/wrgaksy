<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${customer_id!=null}">
		<button
			class="button2 button-md button-primary button-winona wow fadeInRight"
			style="float: left;" onclick="location.href='boardRequest.jsp'">나도
			신청하기</button>
	</c:when>
	<c:otherwise>
		<button
			class="button2 button-md button-primary button-winona wow fadeInRight"
			style="float: left;" onclick="location.href='login.jsp'">로그인
			후 신청가능</button>
	</c:otherwise>
</c:choose>