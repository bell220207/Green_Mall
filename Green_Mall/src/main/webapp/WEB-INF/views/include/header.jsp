<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</head>
<body>
    <div id="wrap">
        <div id="header">
            <div id="header-top">
	            <div class="container">
	                <div id="logo"><a href="<c:url value='/'/>">Green</a></div>
                    <div class="search">
	                    <form action="<c:url value='/productsList'/>" method="get">
	                        <input type="text" name="keyword" placeholder="검색어 입력">
	                    </form>
                    </div>
                    <div id="header_menu">
                    	<ul>
	                    	<li><a href='<c:url value="${loginOutLink}"/>' >${loginOut}</a></li>
	                        <li class="${Reg}">
	                        	
	                        	<c:if test="${Reg eq 'Register'}">
	                        		<a href='<c:url value="${RegLink}"/>' >${Reg}</a>
	                        	</c:if>
	                        	
	                        	<c:if test="${Reg eq 'My'}">
	                        		<span onclick='dropdown(this)'>${Reg}</span>
		                        	<div class="myBox">
		                        		<div><span><a href="#">마이페이지</a></span></div>
		                        		<div><span><a href="<c:url value="/QAmyListPage"/>" >문의내역</a></span></div>
		                        	</div>
	                        	</c:if>
	                        </li>
	                        <li id="li_last"><a href='<c:url value=""/>' >Cart</a></li>
                    	</ul>
                    </div>
                    
	            </div>
            </div>
        </div> <!-- header -->