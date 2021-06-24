<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매 현황</title>
</head>
<body>
판매 리스트  | <a href="customerTotal.vnt" target="_blank">고객별 판매 현황</a>  | 상품별 판매 현황  | 년별 판매 현황  | 월별 판매 현황   

<br />
<form action="venta.vnt" method="post" name="frm">
아이디 : <input type="text" name="memId"/><br />
		<input type="submit" value="검색" />
</form>
<table border =1>
	<tr><td>고객 아이디</td><td>고객명</td><td>상품명</td>
		<td>수량</td><td>판매일</td><td>배송상태</td></tr>
	<c:forEach items="${list }" var="dto">
	<tr><td>
			<c:if test="${dto.memId == null}" >비회원</c:if>
			<c:if test="${dto.memId != null}" >
			<a href="userSales.vnt?memId=${dto.memId}" target="_blank">${dto.memId}</a></c:if>
		</td>
		<td>
			<c:if test="${dto.memName == null}" >비회원</c:if>
			<c:if test="${dto.memName != null}" >${dto.memName}</c:if>
		</td>
		<td>${dto.prodName }</td><td>${dto.purchaseQty }</td>
		<td>${dto.purchaseDate }</td>
		<td>
			<a href="createDelivery.vnt?purchaseNum=${dto.purchaseNum }">
			<c:if test="${dto.deliveryNum == null}">배송등록</c:if> 
			<c:if test="${dto.deliveryNum != null}">배송수정</c:if>
			</a>
		</td>	
		</tr>
	</c:forEach>
</table>
</body>
</html>