<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.net.URLDecoder"%>

<c:set var="loginId" value="${sessionScope.SessionId}"/>
<c:set var="loginOutLink" value="${loginId==null ? '/loginPage' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId==null ? 'Login' : 'LogOut'}"/>
<c:set var="RegLink" value="${loginId==null ? '/registerPage' : '#'}"/>
<c:set var="Reg" value="${loginId==null ? 'Register' : 'My'}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value='/css/reset.css?after'/>" />
    <link rel="stylesheet" href="<c:url value='/css/common.css?after'/>" />
    <link rel="stylesheet" href="<c:url value='/css/home.css?after'/>" />
    <link rel="stylesheet" href="<c:url value='/css/registerPage.css?after'/>" />
    <link rel="stylesheet" href="<c:url value='/css/loginPage.css?after'/>">   
    <link rel="stylesheet" href="<c:url value='/css/productsList.css?after'/>">    
    <link rel="stylesheet" href="<c:url value='/css/product.css?after'/>"> 
    <link rel="stylesheet" href="<c:url value='/css/QApage.css?after'/>"> 
    <style> 
        @import url('https://fonts.googleapis.com/css2?family=Fredoka+One&family=Rubik+Mono+One&display=swap');
    </style>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script>
    	let msg = "${msg}";
    </script>
    <script src="<c:url value='/js/main.js'/>" ></script>