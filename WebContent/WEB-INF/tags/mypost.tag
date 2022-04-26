<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${customer_id!=null}">
    |&nbsp;<a href="categoryBoard.do?category=mine" class="filter">내
		글 보기</a>
</c:if>