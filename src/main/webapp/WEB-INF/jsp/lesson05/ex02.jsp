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
	
	<h1>2. 반복문 (c:forEach)</h1>
	<%-- money in pocket --%>
	<%--
		for (int i = 0; i <= 5; i++)
	 --%>
	 <%-- 0 ~ 5까지 6번 --%>
	<c:forEach var="i" begin="0" end="5" step="1">
		${i}
	</c:forEach>
	<br>
	<%-- 16 ~ 20: 5번 --%>
	<c:forEach var="j" begin="16" end="20" step="1" varStatus="status">
		${j}
		current : ${status.current} <br>
		first(반복문이 첫회 돌았을 때 찍힌다.): ${status.first} <br>
		last (반복문이 마지막회에 돌았을 때 찍힌다.) : ${status.last}<br>
		count : ${status.count} <br>
		index : ${status.index}<br>
		<br>
	</c:forEach>
	
	<%-- 서버에서 가져온 List --%>
	<c:forEach var="fruit" items="${fruits}" varStatus="status">
		${fruit} ::::: ${status.count} ::::: ${status.index} <br>
	</c:forEach>
	
	<%-- 서버에서 가져온 List Map --%>
	<c:forEach var="user" items="${users}" varStatus="status">
		<h3>${status.count}번째 사람 정보</h3>
		
		이름: ${user.name}<br>
		나이: ${user.age}<br>
		취미: ${user.hobby}<br>
	</c:forEach>
	
	<%-- 테이블 구성 --%>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>취미</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${user.name}</td>
				<td>${user.age}</td>
				<td>${user.hobby}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>