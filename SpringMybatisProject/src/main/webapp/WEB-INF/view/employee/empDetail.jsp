<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	사원번호 : ${employeeCommand.employeeId }<br />
	아이디 : ${employeeCommand.empUserId }<br />
	이름 : ${employeeCommand.empName }<br />
	입사일 : ${employeeCommand.hireDate }<br />
	직무 : ${employeeCommand.jobId }<br />
	연락처 : ${employeeCommand.phNumber }<br />
	사무실 번호 : ${employeeCommand.officeNumber }<br />
	이메일 : ${employeeCommand.email }<br />
	주소 : ${employeeCommand.empAddress }<br />
	<button onclick="javascript:location.href='empUpdate'">수정</button>
</body>
</html>