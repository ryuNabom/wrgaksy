<%@ tag language="java" pageEncoding="UTF-8"%>

<script>
    $(document).on('click', '.toggleBG', function () {
        var toggleBG = $(this);
        var toggleFG = $(this).find('.toggleFG');
        var left = toggleFG.css('left');
        if(left == '40px') {
            toggleBG.css('background', '#CCCCCC');
            toggleActionStart(toggleFG, 'TO_LEFT');
        }else if(left == '0px') {
            toggleBG.css('background', '#53FF4C');
            toggleActionStart(toggleFG, 'TO_RIGHT');
        }
    });

    // 토글 버튼 이동 모션 함수
    function toggleActionStart(toggleBtn, LR) {
        // 0.01초 단위로 실행
        var intervalID = setInterval(
            function() {
                // 버튼 이동
                var left = parseInt(toggleBtn.css('left'));
                left += (LR == 'TO_RIGHT') ? 5 : -5;
                if(left >= 0 && left <= 40) {
                    left += 'px';
                    toggleBtn.css('left', left);
                }
            }, 10);
        setTimeout(function(){
            clearInterval(intervalID);
        }, 201);
    }

    //버튼 상태 가져오는 함수
    function getToggleBtnState(toggleBtnId){
        const left_px = parseInt( $('#'+toggleBtnId).css('left') );
        return (left_px > 0)? "on" : "off";
    }
</script>

<div class='toggleBG'>
	<button id="toggleBtnId" class='toggleFG'></button>
</div>