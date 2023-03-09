<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/common.jsp"%>
<script src="<c:url value='/js/main.js'/>" ></script>
<%@include file="include/header.jsp"%> 
        <div class="contents">
            <div class="cont">
                <div class="container">
                    <div id="loginBox">
                        <div id="logo">Campus</div>
                        <!-- form 시작 -->
                        <form action="<c:url value='/login/login'/>" method="post" onsubmit="return formCheck(this);">
                            <div id="msg">
                        		<c:if test="${msg eq 'loginFail'}">
                        			<p>아이디 혹은 비밀번호가 일치하지 않습니다</p>
                        		</c:if>
                        	</div>
                            <input type="text" name="id" value="${cookie.id.value}" placeholder="아이디">
                            <input type="password" name="pwd" placeholder="비밀번호">
                            <input type="hidden" name="toURL" value="${param.toURL}">
                            <button type="submit">로그인</button>
                            <div id="Box_bt">
                            	<label><input type="checkbox" name="rememberId" ${empty cookie.id.value? "" : "checked"}> 아이디 기억 | </label>
                            	<a href="#">아이디/비밀번호 찾기</a> |
                            	<a href="<c:url value='/registerPage'/>" >회원가입</a>
                        	</div>
                        </form>
                        <!-- form 끝 -->
                        <div class="social-Login">
                        	<div class="social-Login-kakao">카카오로 1초 만에 시작하기</div>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- contents -->
        <%@include file="include/footer.jsp"%> 
</body>
</html>