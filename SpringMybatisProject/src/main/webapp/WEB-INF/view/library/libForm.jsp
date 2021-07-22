<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="libwrite" method="post" enctype="multipart/form-data">
	<table border = 1>
		<tr><td>제목</td>
			<td><input type="text" name="noticeSub" /></td></tr>
		<tr><td>내용</td>
			<td><textarea rows="6" cols="30" 
			name="noticeCon"></textarea></td></tr>
		<tr><td>파일</td>
			<td>
				<input type="file" name="noticeFile" multiple="multiple"/>
			</td></tr>
		<tr><td colspan="2">
			<input type="submit" value="자료실 등록" />
			<input type="reset" value="초기화" />
		</td></tr>
	</table>
</form>
</body>
</html>