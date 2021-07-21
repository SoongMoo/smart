<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트</title>
</head>
<body>
회원리스트 페이지입니다.<br />
<table border=1>
	<tr><td>아이디</td><td>이름</td><td>연락처</td>
		<td>이메일</td><td>주소</td></tr>
	<c:forEach items="${lists }" var="dto">
	<tr><td>
	<a href="memInfo/${dto.memId }">${dto.memId }</a></td>
		<td>${dto.memName }</td>
		<td>${dto.memPhone }</td><td>${dto.memEmail }</td>
		<td>${dto.memAddress } ${dto.detailAdd }</td></tr>
	</c:forEach>
	<tr><td colspan="5">
		<c:if test="${page <= 1 }">[이전]</c:if>
		<c:if test="${page > 1 }">
			<a href="memList?page=${page -1 }">[이전]</a>
		</c:if>
		<c:forEach begin="${startPage }" end="${endPage }" var="i" 
				step="1" >
		<a href="memList?page=${i }">[${i }]</a> &nbsp;
		</c:forEach>
		<c:if test="${page >= maxPage }">[다음]</c:if>
		<c:if test="${page < maxPage }">
			<a href="memList?page=${page + 1 }">[다음]</a>
		</c:if>
	</td></tr>
</table>
</body>
</html>