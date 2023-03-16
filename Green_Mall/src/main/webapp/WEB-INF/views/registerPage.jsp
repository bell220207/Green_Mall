<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/common.jsp"%>
<%@include file="include/header.jsp"%>        
        <div class="contents">
            <div class="cont">
                <div class="container">
                    <div id="regBox">
                        <div id="logo">Register</div>
                    	<form:form modelAttribute="userDto">
                            <div id="msg" class="msg">
						        <form:errors path="id"/>
						    	<form:errors path="idCheck"/>
						        <form:errors path="pwd"/>
						        <form:errors path="name"/>
						        <form:errors path="email"/>
						    </div>
                            <label for="id">아이디</label>
                            <div id="check">
	                            <input type="text" id="id" name="id" value="${user.id}" placeholder="5~12자리의 최소 하나의 영문자와 숫자 조합">
	                            <input type="hidden" id="idCheck" name="idCheck" value="${user.idCheck}">
	                            <a href="#" id="idCheckBtn" onclick="idCheck()">중복체크</a>
                            </div>
                            <label for="pwd">비밀번호</label>
                            <input type="password" id="pwd" name="pwd" value="${user.pwd}" placeholder="5~12자리의 최소 하나의 영문자와 숫자 조합">

                            <label for="name">이름</label>
                            <input type="text" id="name" name="name" value="${user.name}" placeholder="이름">

                            <label for="email">이메일</label>
                            <input type="text" id="email" name="email" value="${user.email}" placeholder="이메일">

                            <label for="birth">생일</label>
                            <input type="date" id="birth" name="birth" value="${user.birth}" placeholder="생일" max="2023-12-31" min="1920-01-01">

                            <label for="address">주소</label>
                            <input type="text" id="address" name="address" value="주소" placeholder="주소">
							<input type="text" id="addressDetail" name="addressDetail" value="상세주소" placeholder="상세주소">
                            <button type="submit">회원가입</button>
                    	</form:form>                    	
                    </div>
                </div>
            </div>
        </div> <!-- contents -->
<%@include file="include/footer.jsp"%>   
</body>
</html>