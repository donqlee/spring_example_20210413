<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core  라이브러리</title>
</head>
<body>
	<h1>조건문 (c:choose, c:when, c:otherwise)</h1>
	
	<%-- 몸무게가 70이하면 치킨, 80이하면 샐러드, 그 이상이면 굶자 --%>
	
	<c:set var="weight">100</c:set>
	
	<c:choose>
		<c:when test="${weight <= 70}">
			치킨
		</c:when>
		<c:when test="${weight <= 80}">
			샐러드
		</c:when>
		<c:otherwise>
			굶자
		</c:otherwise>
	</c:choose>
</body>
</html>