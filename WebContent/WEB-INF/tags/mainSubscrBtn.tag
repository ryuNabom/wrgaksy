<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${customer_id==null}">
		<a
			class="button button-lg button-primary button-winona button-shadow-2"
			href="login.jsp" data-caption-animate="fadeInUp"
			data-caption-delay="300">정기구독</a>
	</c:when>
	<c:otherwise>
		<a
			class="button button-lg button-primary button-winona button-shadow-2"
			href="subscription.jsp" data-caption-animate="slideInUp"
			data-caption-delay="0">정기구독</a>
	</c:otherwise>
</c:choose>