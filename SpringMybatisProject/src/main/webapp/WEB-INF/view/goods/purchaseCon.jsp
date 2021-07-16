<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="800">
	<tr><td>주문일(결제번호)</td>
		<td>상품명/주문번호</td>
		<td>판매자</td>
		<td>주문상태</td></tr>
<c:forEach items="${list }" var="dto">
	<tr><td >
		${dto.purchaseDate } / ${dto.paymentApprNum }   </td>
		<td rowspan="2">
		<img width="50" src="../goods/upload/${dto.prodImage.split(',')[0] }" />
		${dto.prodName } / ${dto.purchaseNum }</td>
		<td rowspan="2">${dto.prodSupplyer }</td>
		<td rowspan="2"><c:if test="${dto.paymentApprNum == null}">
		<a href="paymentOk.gd?purchNo=${dto.purchaseNum }&payPrice=${dto.purchaseTotPrice }">결제하기</a></c:if>
					   <c:if test="${dto.paymentApprNum != null}">
					   	      결제완료<br />
						   <c:if test="${dto.reviewContent == null }">
						   		<a href="goodsReview?purchaseNum=${dto.purchaseNum }&prodNum=${dto.prodNum }">리뷰작성</a>
						   </c:if>		
						   <c:if test="${dto.reviewContent != null }">
						   		<a href="goodsReviewUpdate?purchaseNum=${dto.purchaseNum }&prodNum=${dto.prodNum }">리뷰수정</a>
						   </c:if>				  
					   </c:if>
		</td></tr>
	<tr><td>결제금액 : ${dto.purchaseTotPrice }</td></tr>
	<tr><td colspan="4"></td></tr>
</c:forEach>	
</table>
</body>
</html>