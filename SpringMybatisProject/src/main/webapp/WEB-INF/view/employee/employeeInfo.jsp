<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
사원번호 : ${emp.employeeId }<br />
아이디: ${emp.empUserId }<br />
이름 : ${emp.empName }<br />
입사일: <fmt:formatDate value="${emp.hireDate }" type="date" pattern="yyyy-MM-dd"/> <br />
직무 : ${emp.jobId }<br />
연락처 : ${emp.phNumber }<br />
사무실번호 : ${emp.officeNumber }<br />
이메일: ${emp.email }<br />
주소 : ${emp.empAddress }<br />
<a href="empModify?empId=${emp.employeeId }">수정</a> | 
<a href="empList" >리스트로 가기</a>  
</body>
</html>