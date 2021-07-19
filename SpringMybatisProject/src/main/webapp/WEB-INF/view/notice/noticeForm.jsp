<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="noticeWrite" method="post" >
	제목 : <input type="text" name="noticeSub"/><br />
	내용 : <textarea rows="5" cols="60" name="noticeCon"></textarea><br />
	종류 : <select name="noticeKind">
			<option>긴급</option>
			<option>일반</option>
			<option>점검</option>
		  </select><br />
	<input type="submit" value="공지 등록"/>
</form>
</body>
</html>