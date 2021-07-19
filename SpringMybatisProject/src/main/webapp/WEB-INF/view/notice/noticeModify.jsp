<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="noticeModify" method="post">
글번호 : <input type="text" value="${dto.noticeNo }"  name="noticeNo" 
		readonly="readonly"/><br />
글제목 : <input type="text" value="${dto.noticeSub }" name ="noticeSub"/><br />
글 내용 : <textarea rows="5" cols="35" name="noticeCon">${dto.noticeCon }</textarea><br />
등록일 : ${dto.noticeDate }<br />
종류 : ${dto.noticeKind }<br />
조회수 : ${dto.noticeCount }<br />
등록한 사원번호 : ${dto.employeeId }<br />
<br />
<input type="submit" value="수정 완료" />
<input type="button" value="공지사항 삭제" 
	onclick ="javascript:location.href='noticeDel?noticeNo=${dto.noticeNo }'" />
</form>
</body>
</html>