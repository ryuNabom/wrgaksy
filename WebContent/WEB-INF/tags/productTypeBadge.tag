<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="filter"%>

<c:choose>
	<c:when test="${filter=='메인'}">
		<span class="product-badge product-badge-main">main</span>
	</c:when>
	<c:when test="${filter=='반찬'}">
		<span class="product-badge product-badge-side">side</span>
	</c:when>
	<c:when test="${filter=='국'}">
		<span class="product-badge product-badge-soup">soup</span>
	</c:when>
	<c:otherwise></c:otherwise>
</c:choose>