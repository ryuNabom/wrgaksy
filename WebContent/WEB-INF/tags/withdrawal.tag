<%@ tag language="java" pageEncoding="UTF-8"%>

<script type="text/javascript">
    function del(){
        ans=confirm("회원님의 구독정보와 주문정보는 복구되지않습니다. \n정말 탈퇴하시겠습니까?");
        if(ans==true){
            document.withdrawal.submit();
        }
        else{
            return;
        }
    }
</script>

<div class="group-custom-1 group-middle oh-desktop"
	style="margin-top: 60px; width: 80%;">
	<article class="quote-classic quote-classic-3">
		<div class="quote-classic-text">
			<p class="q">회원 탈퇴 시 복구는 되지 않습니다.</p>
			<hr>
			<p class="q2">메뉴 신청했던 글은 작성자만 사라지고 내용은 남습니다. 삭제를 원하시면 탈퇴 전에
				삭제해주세요.</p>
		</div>
		<form method="post" action="deleteUser.me" name="withdrawal">
			<br> <input type="password" name="customer_password"
				placeholder="비밀번호를 입력하세요"> <br>
			<button class="button button-xs button-winona fadeInRight"
				onclick="del()">회원탈퇴</button>
		</form>
	</article>
</div>