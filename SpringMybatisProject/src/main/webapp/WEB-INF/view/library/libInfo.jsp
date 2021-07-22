<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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
	<a href="libDetail?noticeNo=${dto.noticeNo }" >수정</a>
</body>
</html>