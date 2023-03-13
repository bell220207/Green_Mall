<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/common.jsp"%>
<style>
   	#header #header-top .search{ visibility: visible; }
</style>
<script>
	var ct = "${ph.sc.category}";
	var sub_ct = "${ph.sc.sub_cate}";
</script>
<script src="<c:url value='/js/productList.js'/>" ></script>
<%@include file="include/header.jsp"%>       
        <div class="contents" id="pro">
            <div class="cont">                
                <div class="container" >
                    <div class="proBox">
                    	<div id="proNav">
							<div class="navLine all">
								<div>
                    				<label><a href="<c:url value="/productsList"/>">전체</a></label>
                    			</div>
                    		</div>
                    		<div class="navLine">
                    			<div class="top">
                    				<label><a href="<c:url value="/productsList?category=top"/>">상의</a></label>
                    			</div>
                    			<ol>
		                            <li class="top-half"><a href="<c:url value="/productsList?category=top&sub_cate=half"/>">반팔</a></li>
		                            <li class="top-long"><a href="<c:url value="/productsList?category=top&sub_cate=long"/>">긴팔</a></li>
		                            <li class="top-shirt"><a href="<c:url value="/productsList?category=top&sub_cate=shirt"/>">셔츠</a></li>
		                            <li class="top-hoodie"><a href="<c:url value="/productsList?category=top&sub_cate=hoodie"/>">후드</a></li>
		                            <li class="top-outer"><a href="<c:url value="/productsList?category=top&sub_cate=outer"/>">아우터</a></li>
                        		</ol>
                    		</div>
                    		<div class="navLine">
                    			<div class="bottom">
                    				<label><a href="<c:url value="/productsList?category=bottom"/>">하의</a></label>
		                    	</div>
		                    	<ol>
		                    		<li class="bottom-half"><a href="<c:url value="/productsList?category=bottom&sub_cate=half"/>">반바지</a></li>
		                            <li class="bottom-long"><a href="<c:url value="/productsList?category=bottom&sub_cate=long"/>">긴바지</a></li>
		                            <li class="bottom-skirt"><a href="<c:url value="/productsList?category=bottom&sub_cate=skirt"/>">스커트</a></li>
		                            <li class="bottom-onepiece"><a href="<c:url value="/productsList?category=bottom&sub_cate=onepiece"/>">원피스</a></li>
		                        </ol>
                    		</div>
                    		<div class="navLine">
                    			<div class="accessary">
	                    			<label><a href="<c:url value="/productsList?category=accessary"/>">악세사리</a></label>
		                    	</div>
		                    	<ol>
		                            <li class="acce-bag"><a href="<c:url value="/productsList?category=accessary&sub_cate=bag"/>">가방</a></li>
		                            <li class="acce-shoes"><a href="<c:url value="/productsList?category=accessary&sub_cate=shoes"/>">신발</a></li>
		                            <li class="acce-hair"><a href="<c:url value="/productsList?category=accessary&sub_cate=hair"/>">헤어</a></li>
		                            <li class="acce-acc"><a href="<c:url value="/productsList?category=accessary&sub_cate=acc"/>">장신구</a></li>
		                            <li class="acce-ect"><a href="<c:url value="/productsList?category=accessary&sub_cate=ect"/>">기타</a></li>
		                        </ol>
                    		</div>   
                    	</div> <!-- proNav -->
                    	
                    	<div class="proCont">
	                    	<div class="proUp">
	                    	<!-- /////////////////////////////////////////////// -->
	                    	<c:if test="${empty list}">
	                    		<span class="noProduct">등록된 상품이 없습니다</span>
	                    	</c:if>
	                    	<c:if test="${not empty list}">
	                    		<c:forEach var="boardDto" items="${list}">
		                    		<div class="proColumn">
		                    			<a href="<c:url value="/product?pro_title=${boardDto.pro_title}" />">
		                    				<input type="hidden" value="${boardDto.bno}">
	                                		<img src="img/product_Head/${boardDto.cont_img}.jpg" >
	                                		<h3>${boardDto.pro_title}</h3>
	                                		<p>${boardDto.price}<span>원</span></p>
	                            		</a>	
			                    	</div>
		                    	</c:forEach>
	                    	</c:if>
	                    	</div> <!-- proUp -->
	                    	
	                    	<div class="paging-container">
	                    		<div class="paging" id="pListPaging">
	                    		<c:if test="${ph.totalCnt!=null && ph.totalCnt!=0}">
	                    			<c:if test="${ph.showPrev=='true'}">
	                    				<a class="page" href="<c:url value='/productsList${ph.sc.getQueryString(ph.beginPage-1)}' />">&lt;</a>
	                    			</c:if>
	                    			<c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
	                    				<a class="page ${i==ph.sc.page? 'paging-active' : ''}" id="pList${i}" href="<c:url value='/productsList${ph.sc.getQueryString(i)}' /> " >${i}</a>
	                    			</c:forEach>
	                    			<c:if test="${ph.showNext=='true'}">
	                    				<a class="page" href="<c:url value='/productsList${ph.sc.getQueryString(ph.endPage+1)}'/>">&gt;</a>
	                    			</c:if>	                    			
	                    		</c:if>
	                    		</div> <!-- paging -->
	                    	</div> <!-- proBottom -->
                    	</div> <!-- proCont -->
  
                    	<div id="proFoot"></div>

                    </div>
				</div>
			</div>
        </div> <!-- contents -->

<%@include file="include/footer.jsp"%>
</body>
</html>