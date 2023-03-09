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
	                        <li><a href='<c:url value="${RegLink}"/>' >${Reg}</a></li>
	                        <li id="li_last"><a href='<c:url value=""/>' >Cart</a></li>
                    	</ul>
                    </div>
                    
	            </div>
            </div>
        </div> <!-- header -->