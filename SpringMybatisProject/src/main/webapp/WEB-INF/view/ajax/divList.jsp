<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${n == 1}">
<div  id="op1" >
	<table>
		<tr><th>ID(성별,연령)</th><th>이력서제목</th><th>학력</th><th>경력</th></tr>
		<tr><td>aa11</td><td>aaaa</td><td>aaaaa</td><td>aaaa</td></tr>
	</table>
</div>
</c:if>
<c:if test="${n == 2}">
<div  id="op2" >
	<table>
		<tr><th>ID(성별,연령)</th><th>이력서제목</th><th>학력</th><th>경력</th></tr>
		<tr><td>bbb</td><td>bbb</td><td>bbb</td><td>bbbb</td></tr>
	</table>
</div>
</c:if>
<c:if test="${n == 3}">
<div  id="op3" >
	<table>
		<tr><th>ID(성별,연령)</th><th>이력서제목</th><th>학력</th><th>경력</th></tr>
		<tr><td>cccc</td><td>cccc</td><td>cccc</td><td>cccc</td></tr>
	</table>
</div>
</c:if>