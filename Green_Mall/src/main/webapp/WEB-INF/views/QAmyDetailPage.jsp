<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/common.jsp"%>
<style>
   	#header #header-top .search{ visibility: visible; }
</style>
<script>
	var ContextPath = "${pageContext.request.contextPath}";
	var sc = window.location.search;
	var mode = "${mode}";
</script>

<script src="<c:url value='/js/QAmyDetail.js'/>" ></script>
<%@include file="include/header.jsp"%>

	<div class="contents">
		<div class="container" id="qa-list-container">
			<div class="QAdetailBox">
				<h2 class="writing-header"> My 문의 ${mode=="read"? "읽기" : "쓰기"}</h2>
				<form action="" id="QAform" class="frm">
				<c:if test="${mode ne 'new'}">
					<input type="hidden" name="qano" value="${QADto.qano}" readonly="readonly">
					<input type="hidden" name="writer" value="${QADto.writer}" readonly="readonly">
					<input type="text" name="reg_date" value="${QADto.reg_date}" readonly="readonly">
				</c:if>
					<input type="text" id="pro_title" name="pro_title" value="${QADto.pro_title}" readonly="readonly">
					<textarea name="text" rows="20" ${mode=="new"? "" : 'readonly="readonly"'}>${QADto.text}</textarea>
					
					<c:if test="${mode eq 'new'}">
						<button type="button" id="writeBtn" class="brdBtn btn-write">등록</button>
					</c:if>
					
					<c:if test="${mode ne 'new' && QADto.writer eq loginId}">
						<button type="button" id="modifyBtn" class="brdBtn btn-modify">수정</button>
	           			<button type="button" id="removeBtn" class="brdBtn btn-remove">삭제</button>
           			</c:if>
           			
            		<button type="button" id="listBtn" class="brdBtn btn-list">목록</button>
					
				</form>
			</div>
			<br>
			<!-- 댓글 입력창 -->
			<!-- 관리자 아이디 일때만 입력가능 -->
				<div id="comment-writebox">
				    <div class="commenter commenter-writebox">관리자</div>
				    <div class="modify-writebox-content">
				        <textarea name="comment" class="wrtBox_txt" cols="30" rows="5" placeholder="댓글을 남겨보세요"></textarea>
				    </div>
				    <div id="comment-writebox-bottom">
				        <div class="register-box">
				            <a href="#" class="cmt_btn" id="btn-write-comment">등록</a>
				        </div>
				    </div>
				</div>
			
			<!--댓글 목록-->
			<div id="commentList"></div>
			
			<!-- 댓글 수정 -->
			<div id="modalWin" class="modal">
			    <!-- Modal content -->
			    <div class="modal-content">
			        <span class="close">&times;</span>
			        <p>
			        <h2> | 댓글 수정</h2>
			        <div id="modify-writebox">
			            <div class="commenter commenter-writebox"></div>
			            <div class="modify-writebox-content">
			                <textarea name=mod_comment" class="wrtBox_txt" cols="30" rows="5" placeholder="댓글을 남겨보세요"></textarea>
			            </div>
			            <div id="modify-writebox-bottom">
			                <div class="register-box">
			                    <a href="#" class="cmt_btn" id="btn-write-modify">등록</a>
			                </div>
			            </div>
			        </div>
			        </p>
			    </div>
			</div>
			
		</div>
	</div>

<%@include file="include/footer.jsp"%>
</body>
</html>