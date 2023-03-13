<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/common.jsp"%>
<style>
   	#header #header-top .search{ visibility: visible; }
</style>
<%@include file="include/header.jsp"%>     

	<div class="contents" id="qa-contents">
		<div class="container" id="qa-list-container">
			<div class="QAlistBox">
				<div class="QAlist">
					<table>
						<tr>
			                <th class="no">번호</th>
			                <th class="text">내용</th>
			                <th class="pro_title">상품명</th>
			                <th class="writer">작성자</th>
			                <th class="regdate">등록일</th>
			            </tr>
		                
	             	<c:if test="${empty QAmyList}">
	                    <tr>
	                    	<td colspan="5">등록된 문의가 없습니다</td>
						</tr>
                    </c:if>
	            	<c:if test="${not empty QAmyList}">    
	                <c:forEach var="QAmyList" items="${QAmyList}" varStatus="status">
		                <tr>
		                    <td class="no"><span class="ellipsis_text">${QAmyList.qano}</span></td>
		                    <!--  
		                    <td class="text"><span class="ellipsis_text"><a href="<c:url value="/QAmyDetailPage/read${ph.sc.queryString}&qano=${QAmyList.qano}&writer=${QAmyList.writer}"/>">${QAmyList.text}</a></span></td>
		                    -->
		                    <td class="text"><span class="ellipsis_text"><a href="<c:url value="/QAmyDetailPage/read${ph.sc.queryString}&qano=${QAmyList.qano}"/>">${QAmyList.text}</a></span></td>
		                    <td class="pro_title"><span class="ellipsis_text"><a href="#">${QAmyList.pro_title}</a></span></td>
		                    <td class="writer"><span class="ellipsis_text">${QAmyList.writer}</span></td>
		                    <td class="regdate"><span class="ellipsis_text">${QAmyList.reg_date}</span></td>
		                </tr>
	                </c:forEach>
	            	</c:if>
					</table>
				</div>
				
				<div class="paging-container">
					<div class="paging" id="QAlistPaging">
						<c:if test="${ph.totalCnt!=null && ph.totalCnt!=0}">
                   			<c:if test="${ph.showPrev=='true'}">
                   				<a class="page" href="<c:url value='/QAmyListPage${ph.sc.getQueryString(ph.beginPage-1)}&id=${loginId}' />">&lt;</a>
                   			</c:if>
                   			<c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                   				<a class="page ${i==ph.sc.page? 'paging-active' : ''}" id="qList${i}" href="<c:url value='/QAmyListPage${ph.sc.getQueryString(i)}&id=${loginId}' /> " >${i}</a>
                   			</c:forEach>
                   			<c:if test="${ph.showNext=='true'}">
                   				<a class="page" href="<c:url value='/QAmyListPage${ph.sc.getQueryString(ph.endPage+1)}&id=${loginId}' />">&gt;</a>
                   			</c:if>	                    			
                   		</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>

<%@include file="include/footer.jsp"%>
</body>
</html>