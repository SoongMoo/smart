<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="empPwUpdateOk" method="post" 
									modelAttribute="EmployeeCommand">
		현재 비밀번호 : <input type="text" name="oldPw" />
					<form:errors path="oldPw"/><br />
		바꿀 비밀번호 : <input type="text" name="empPw" />
					<form:errors path="empPw" /><br />
		바꿀 비밀번호 확인 : <input type="text" name="empPwCon" /> 
					<form:errors path="empPwCon"/><br />
		<input type="submit" value="비밀번호 변경" />
	</form:form>
</body>
</html>