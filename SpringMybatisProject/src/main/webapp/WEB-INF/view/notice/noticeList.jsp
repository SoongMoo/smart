<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table >
	<tr><td>번호</td><td>제목</td><td>등록일</td><td>조회수</td></tr>
	<c:forEach items="${lists }" var="dto" varStatus="cnt">
	<tr><td>${cnt.count }</td>
		<td><a href="noticeDetail?noticeNo=${dto.noticeNo }" >${dto.noticeSub }</a></td>
		<td>${dto.noticeDate }</td><td>${dto.noticeCount }</td></tr>
	</c:forEach>
</table>
<hr />
<a href="noticeForm">공지사항 등록</a>
</body>
</html>