<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>공공데이터</title>
</head>
<body>
	<h1>공공데이터</h1>
	<c:forEach var="dvo" items="${d_list }">
		<p>측정 일시: ${dvo.dataTime }</p>
		<p>일산화탄소: ${dvo.coValue } | 등급: ${dvo.coGrade }</p>
		<p>미세먼지: ${dvo.pm10Value } | 등급: ${dvo.pm10Grade }</p>
		<p>통합대기: ${dvo.khaiValue } | 등급: ${dvo.khaiGrade }</p>
	</c:forEach>

</body>
</html>
