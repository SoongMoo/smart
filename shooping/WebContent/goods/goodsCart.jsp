<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	function checkQty(prodNum, prodPrice, cartQty){
		if(cartQty > 1){
			location.href="goodsCartQtyDown.gd?prodNum="+prodNum
					     +"&prodPrice="+prodPrice;
		}else{
			alert("최소 수량이 1이어야합니다.");
			return false;
		}
	}
	function prodChk(){
		var prodTot = 0;
		var chk = document.getElementsByName("prodCk"); //check를 배열로
		var hddchk = document.getElementsByName("cartPrice");
		var cnt = 0;
		for(var i = 0; i < chk.length; i++){
			if(chk[i].checked == true){
				prodTot += Number(hddchk[i].value);
				cnt ++;
			}
		}
		document.getElementById("totalPrice").innerHTML=prodTot;
		document.getElementById("prodCnt").innerHTML= cnt ;
	}
</script>
</head>
<body>
카트페이지입니다.

<table border=1 width =600 align="center">
<form action="goodsBuy.gd" method="post">
<c:set var="price" value="0"/><!-- 자바변수 생성 -->
<c:set var="cnt"  value= "0" />
<c:forEach items="${lists }" var="dto">
	<tr><td colspan="4">
		<input type="checkbox" value="${dto.productDTO.prodNum}" 
			name="prodCk" onchange="prodChk();"	checked />
		<input type="hidden" name="cartPrice" 
			value="${dto.cartDTO.cartPrice + dto.productDTO.prodDelFee}" />
		
		${dto.productDTO.prodSupplyer }</td>
		<td>적용금액</td><td>배송비</td><td>총 적용금액</td>
		<td rowspan="2"><input type="button" value="삭제" 
		onclick="javascript:location.href='cartProdDel.gd?prodNum=${dto.productDTO.prodNum }';"/></td>
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
<c:set var="cnt" value="${cnt = cnt + 1 }" />
<c:set var="price" value="${dto.cartDTO.cartPrice + dto.productDTO.prodDelFee + price }" />
</c:forEach>
<tr><td colspan="4" valign="top">전체 합계</td>
    <td colspan="2" align="left"> 상품 수 :<br />
		                        총합계 : </td>
	 <td colspan="2" align="right"><span id="prodCnt">${cnt }</span>개<br />
	 				<span id="totalPrice">
	 				${price }</span>원</td></tr>

<tr><td colspan="8" align="center">
	<input type="submit" value="구매하기"/>
	</td></tr> 
</form>
</table>

</body>
</html>