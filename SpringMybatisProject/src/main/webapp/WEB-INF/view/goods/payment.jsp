<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
결제 페이지입니다.
<form action="doPayment.gd" method="post" >
<input type="hidden" name="purchaseNum" value="${purchNo }" />
<input type="hidden" name="paymentApprPrice" value="${payPrice }" />
<table >
	<tr><td>구매번호</td><td>${purchNo }</td></tr>
	<tr><td>결제금액</td><td>${payPrice }원</td></tr>
	<tr><td>결제방법</td><td>카드</td></tr>
	<tr><td>카드번호</td><td><input type="text" name="paymentNumber"/></td></tr>
	<tr><td align = "center" colspan="2">
		<input type="submit" value="결제 완료" />
		</td>
	</tr>
</table>
</form>
</body>
</html>