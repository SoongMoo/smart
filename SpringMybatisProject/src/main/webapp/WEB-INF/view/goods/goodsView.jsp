<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/includeTags.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.js"></script>
<script type="text/javascript">
	$(function(){
		$("#cart").click(function(){
			var cartQty = $("#cartQty").val();
			var prodNum = ${goodsCommand.prodNum};
			$.ajax({
				type : "post",	
				url : "<c:url value='/cart/goodsCartAdd' />",
				dataType : "text",
				data : {"cartQty":cartQty,"prodNum":prodNum,
						"prodPrice":${goodsCommand.prodPrice} },
				// data : "cartQty="+cartQty +"&prodNum="+prodNum
				success : function(result){
					if(result.trim() == "1"){// 정상적으로 장바구니에 상품 등록
						if(confirm("계속쇼핑하시려면 '아니오'를 누르시오")){
							location.href="<c:url value='/cart/goodsCartList'/>";
						}
					}else{
						alert("장바구니에 담기지 않았습니다.\n다시 시도 해주세요.");
					}
				}
			});
		});
	});
</script>
</head>
<body>
<table>
	<tr><td rowspan="5">
	<img src= "../goods/upload/${goodsCommand.prodImage.split(',')[0] }" /></td>
									<td>${goodsCommand.prodName }</td></tr>
	<tr>					        <td>${goodsCommand.prodPrice }</td></tr>
	<tr>				            <td>${goodsCommand.prodDelFee }</td></tr>
	<tr>				            <td>수량 
			<input type="number" min= "1" step="1" value="1" name="cartQty" id ="cartQty"/>
									</td></tr>
	<tr>				            <td>
									<button id="cart">장바구니</button>
									&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; 
									<button id="buy">바로구매</button>
									</td></tr>
	<tr>
	<td colspan="2">
	${fn:replace(goodsCommand.prodDetail, br , "<br />") }
	<p>
	<c:forTokens items="${goodsCommand.prodImage }" delims="," var="image">
		<img src="../goods/upload/${image }" /><br />
	</c:forTokens>
	</p>
	</td></tr>
</table>
</body>
</html>