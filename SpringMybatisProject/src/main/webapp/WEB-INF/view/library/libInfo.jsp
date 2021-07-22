<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>\
<%@ include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	글번호 : ${dto.noticeNo }<br />
	제목 : ${dto.noticeSub }<br />
	내용 : ${dto.noticeCon }<br />
	등록일 : ${dto.noticeDate }<br />
	조회수 : ${dto.noticeCount }<br />
	등록자 : ${dto.employeeId }<br />
	파일 :<br /> 
	<c:forTokens items="${dto.noticeOrgFile }" delims="," var="fileName" 
			varStatus="idx">
		<a href="fileDown?str=${dto.noticeFile.split(',')[idx.index]}&org=${fileName}" >
		${fileName }</a> / ${dto.noticeFileSize.split(',')[idx.index]}바이트<br />
	</c:forTokens>
	<a href="libDetail?noticeNo=${dto.noticeNo }" >수정</a>
</body>
</html>