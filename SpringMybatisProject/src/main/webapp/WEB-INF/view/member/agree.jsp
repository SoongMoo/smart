<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>agree.jsp</title>
</head>
<body>
<form action="memRegist" method="post">
	<input type="checkbox" name="agree" >동의<br />
	<span>${err }</span><br />
	<input type="submit" value="다음" />
</form>
</body>
</html>