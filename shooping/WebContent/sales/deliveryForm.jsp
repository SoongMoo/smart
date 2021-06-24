<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="deliveryOk.vnt" method="post" name="frm">
<table>
	<tr><th>구매번호</th>
		<td>
			<input type="text" name="purchaseNum" 
					value="${purchaseNum }" readonly/>
		</td></tr>
	<tr><th>택배사명</th>
	<td><input type="text" name="deliveryCom" 
					value="${dto.deliveryCom }" />
	</td></tr>
	<tr><th>송장번호</th>
	<td><input type="text" name="deliveryNum" 
					value="${dto.deliveryNum }" />
	</td></tr>
	<tr><th>배송일</th>
		<td><input type="text" name="deliveryExpDate" 
					value="${dto.deliveryExpDate }" /></td></tr>
	<tr><th>도착예정일</th>
		<td><input type="text" name="ArrivalExpDate" 
					value="${dto.arrivalExpDate }" />
		</td></tr>
	<tr>
		<th colspan="2"><input type="submit" value="배송등록" /></th>
	</tr>
</table>
</form>
</body>
</html>