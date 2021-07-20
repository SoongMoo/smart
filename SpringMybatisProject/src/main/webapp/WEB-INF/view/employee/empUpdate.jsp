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
<form:form action="empUpdateOk" method="post" modelAttribute="employeeCommand">
	사원번호 : <form:input path="employeeId" readonly="true"/><br />
	아이디 : <form:input path="empUserId" readonly="true"/><br />
	이름 : <form:input path="empName" readonly="true"/><br />
	입사일 : <input type="text" name="hireDate" readonly="readonly" 
			value="<fmt:formatDate value='${employeeCommand.hireDate }' 
									type='date' pattern='yyyy-MM-dd'/>" /><br />
	직무 : <form:input path="jobId" readonly="true"/><br />
	연락처 :<input type="text" name="phNumber" value = "${employeeCommand.phNumber }" /><br />
		  <form:errors path="phNumber"/><br />
	사무실 번호 : <form:input path="officeNumber" /><br />
		  <form:errors path="officeNumber"/><br />
	이메일 : <input type="text" name="email" 
						value="${employeeCommand.email }" /><br />
			<form:errors path="email"/><br />
	주소 : <input type="text" name="empAddress" 
						value="${employeeCommand.empAddress }" /><br />
		 <form:errors path="empAddress"/><br />
	비밀번호 : <input type="text" name="empPw" /><br />
		 <form:errors path="empPw" /><br />
	<input type="submit" value="정보 수정" />	
</form:form>	
</body>
</html>