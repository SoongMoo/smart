<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function checkQty(prodNum, prodPrice, cartQty){
		if(cartQty > 1){
			location.href="goodsCartQtyDown.gd?prodNum="+prodNum+"&prodPrice="+prodPrice;
		}else{
			alert("최소 수량이 1이어야합니다.");
			return false;
		}
	}
</script>
</head>
<body>
카트페이지입니다.
<form action="goodsBuy.gd" method="post">
<c:set var="price" value="0"/>
<c:forEach items="${lists }" var="dto">
<table border=1 width =600 align="center">
	<tr><td colspan="4">
		<input type="checkbox" value="${dto.productDTO.prodNum}"/>
		${dto.productDTO.prodSupplyer }</td>
		<td>적용금액</td><td>배송비</td><td>총 적용금액</td>
		<td rowspan="2"><input type="button" value="삭제"/></td>
		</tr>
	<tr><td>
		<img src="goods/upload/${dto.productDTO.prodImage.split(',')[0] }" 
			 width="50"/>
		</td><td>${dto.productDTO.prodName }</td>
	    <td align="center">
	    	<a href="javascript:checkQty('${dto.productDTO.prodNum}','${dto.productDTO.prodPrice }','${dto.cartDTO.cartQty }')">-</a> 
	    	&nbsp;&nbsp; ${dto.cartDTO.cartQty }&nbsp;&nbsp; 
	    	 <a href="goodsCartAdd.gd?prodNum=${dto.productDTO.prodNum}&qty=1&&prodPrice=${dto.productDTO.prodPrice }">+</a>
	    </td>
	    <td align="right"><fmt:formatNumber value="${dto.productDTO.prodPrice }" 
					type="currency" />원</td>
	    <td align="right"><fmt:formatNumber value="${dto.cartDTO.cartPrice }" 
					type="currency" />원</td>
	    <td align="right"><fmt:formatNumber value="${dto.productDTO.prodDelFee }" 
					type="currency" />원</td>
	    <td align="right"><fmt:formatNumber value="${dto.cartDTO.cartPrice + dto.productDTO.prodDelFee}" 
					type="currency" />원</td>
		</tr>
</table>
<c:set var="price" value="${dto.cartDTO.cartPrice + dto.productDTO.prodDelFee + price }" />
</c:forEach>
총금액 : ${price }
<input type="submit" value="구매하기"/> 
</form>
</body>
</html>