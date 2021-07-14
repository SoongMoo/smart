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
<table>
	<tr><td rowspan="5">
	<img src= "../goods/upload/${goodsCommand.prodImage.split(',')[0] }" /></td>
									<td>${goodsCommand.prodName }</td></tr>
	<tr>					        <td>${goodsCommand.prodPrice }</td></tr>
	<tr>				            <td>${goodsCommand.prodDelFee }</td></tr>
	<tr>				            <td>수량 
			<input type="number" min= "1" step="1" value="1"/>
									</td></tr>
	<tr>				            <td>장바구니 / 바로구매</td></tr>
	<tr>
	<td colspan="2">
	${goodsCommand.prodDetail }
	<p>
	<c:forTokens items="${goodsCommand.prodImage }" delims="," var="image">
		<img src="../goods/upload/${image }" /><br />
	</c:forTokens>
	</p>
	</td></tr>
</table>
</body>
</html>