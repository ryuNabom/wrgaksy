<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<%--    내 글이라면 --%>
	<c:when test="${boardDetail.customer_id==customer_id}">
		<section class="body">
			<h3>상품신청</h3>
			<hr>
			<div style="padding: 40px;">
				<h4>ㆍ${boardDetail.board_title}ㆍ</h4>
				<br>
				<p style="align: right;">추천 수 : ${boardDetail.board_fav}</p>
				<button
					class="button2 button-md button-primary button-winona wow fadeInRight"
					onclick="location.href='updateBoard.do?board_number=${boardDetail.board_number}'">나도
					추천!</button>
				<br>
				<hr>
				<p style="color: black; font-size: 18px;">${boardDetail.board_content}</p>
				<hr>
				<br>
				<p>글 번호 : ${boardDetail.board_number}</p>
				<p style="align: right;">작성자 :
					${boardDetail.customer_id}&nbsp;&nbsp;작성일 :
					${boardDetail.board_date}</p>
				<a href="boardDelete.do?board_number=${boardDetail.board_number}">글
					삭제하기</a>
			</div>
		</section>
	</c:when>
	<c:otherwise>
		<section class="body">
			<h3>상품신청</h3>
			<hr>
			<div style="padding: 40px;">
				<h4>ㆍ${boardDetail.board_title}ㆍ</h4>
				<br>
				<p style="align: right;">추천 수 : ${boardDetail.board_fav}</p>
				<button
					class="button2 button-md button-primary button-winona wow fadeInRight"
					onclick="location.href='updateBoard.do?board_number=${boardDetail.board_number}'">나도
					추천!</button>
				<br>
				<hr>
				<p style="color: black; font-size: 18px;">${boardDetail.board_content}</p>
				<hr>
				<br>
				<p>글 번호 : ${boardDetail.board_number}</p>
				<p style="align: right;">작성자 :
					${boardDetail.customer_id}&nbsp;&nbsp;작성일 :
					${boardDetail.board_date}</p>
			</div>
		</section>
	</c:otherwise>
</c:choose>

