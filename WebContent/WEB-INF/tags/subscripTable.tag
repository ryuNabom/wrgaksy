<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="tableWrapper3">
	<table>
		<tr>
			<th><span>[국 미포함 밥상]</span></th>
			<th><span>[국 포함 밥상]</span></th>
		</tr>
		<tr>
			<td><span>메인 3 + 사이드 5&nbsp;&nbsp;&nbsp;</span></td>
			<td><span>메인 3 + 사이드 5 + <span style="color: red;">국1</span></span>
			</td>
		</tr>
		<tr>
			<td><span>190,000
					원/월&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
			<td><span>190,000<span style="color: red;">+30,000</span>
					원/월&nbsp;&nbsp;
			</span></td>
		</tr>
		<tr
			style="align-items: center; text-align: center; justify-content: center;">
			<td>
				<!-- 로그인이 안되있다면 로그인 페이지로 --> <c:choose>
					<c:when test="${customer_id==null}">
						<button
							class="button2 button-md button-primary button-winona fadeInRight"
							onclick="location.href='login.jsp'">구독하기</button>
					</c:when>
					<c:otherwise>
						<button
							class="button2 button-md button-primary button-winona fadeInRight"
							onclick="location.href='subscription.pd?isSoup=미포함'">구독하기</button>
					</c:otherwise>
				</c:choose>
			</td>
			<td>
				<!-- 로그인이 안되있다면 로그인 페이지로 --> <c:choose>
					<c:when test="${customer_id==null}">
						<button
							class="button2 button-md button-redtext button-winona fadeInRight"
							onclick="location.href='login.jsp'">구독하기</button>
					</c:when>
					<c:otherwise>
						<button
							class="button2 button-md button-redtext button-winona fadeInRight"
							onclick="location.href='subscription.pd?isSoup=포함'">구독하기</button>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
</div>