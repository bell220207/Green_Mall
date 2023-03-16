<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/common.jsp"%>
<style>
   	#header #header-top .search{ visibility: visible; }
</style>
<%@include file="include/header.jsp"%>      
        <div id="header-nav">
            <div class="container">
            	<div>
            		<img id="list_img" src="img/icon/list.png" width="30px" onclick="showList()">
            	</div>
                
                <div id="nav" class="nav">
                    <h3><a href="<c:url value="/productsList"/>">전체상품</a></h3>
                    <div class="navBox">
                        <h3><a href="<c:url value="/productsList?category=top"/>">상의</a></h3>
                        <ol>
                            <li><a href="<c:url value="/productsList?category=top&sub_cate=half"/>">반팔</a></li>
                            <li><a href="<c:url value="/productsList?category=top&sub_cate=long"/>">긴팔</a></li>
                            <li><a href="<c:url value="/productsList?category=top&sub_cate=shirt"/>">셔츠</a></li>
                            <li><a href="<c:url value="/productsList?category=top&sub_cate=hoodie"/>">후드</a></li>
                            <li><a href="<c:url value="/productsList?category=top&sub_cate=outer"/>">아우터</a></li>
                        </ol>
                    </div>
                    <div class="navBox">
                        <h3><a href="<c:url value="/productsList?category=bottom"/>">하의</a></h3>
                        <ol>
                            <li><a href="<c:url value="/productsList?category=bottom&sub_cate=long"/>">긴바지</a></li>
                            <li><a href="<c:url value="/productsList?category=bottom&sub_cate=half"/>">반바지</a></li>
                            <li><a href="<c:url value="/productsList?category=bottom&sub_cate=skirt"/>">스커트</a></li>
                            <li><a href="<c:url value="/productsList?category=bottom&sub_cate=onepiece"/>">원피스</a></li>
                        </ol>
                    </div>
                    <div class="navBox">
                        <h3><a href="<c:url value="/productsList?category=accessary"/>">악세사리</a></h3>
                        <ol>
                            <li><a href="<c:url value="/productsList?category=accessary&sub_cate=bag"/>">가방</a></li>
                            <li><a href="<c:url value="/productsList?category=accessary&sub_cate=shoes"/>">신발</a></li>
                            <li><a href="<c:url value="/productsList?category=accessary&sub_cate=hair"/>">헤어</a></li>
                            <li><a href="<c:url value="/productsList?category=accessary&sub_cate=acc"/>">장신구</a></li>
                            <li><a href="<c:url value="/productsList?category=accessary&sub_cate=ect"/>">기타</a></li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>

        <div id="banner">
            <img src="img/ban01.jpg" width="1200px" height="400px">
        </div> <!-- banner -->
        
        <div class="contents" id="homeContents">
            <div class="cont">
                <div class="container">
                    <div class="products">
                    	
                        <c:forEach var="boardDto" items="${HomeList}">
	                        <div class="column">
	                        <a href="<c:url value="/product?pro_title=${boardDto.pro_title}" />">
	                            	<img src="img/product_Head/${boardDto.cont_img}.jpg" width="100%" height="70%">
	                                <h3>${boardDto.pro_title}</h3>
	                                <p>${boardDto.price}<span>원</span></p>
	                            </a>
	                        </div>
                        </c:forEach>
                        
                    </div>
                </div>
            </div>
        </div> <!-- contents -->
    	<%@include file="include/footer.jsp"%>   
</body>
</html>