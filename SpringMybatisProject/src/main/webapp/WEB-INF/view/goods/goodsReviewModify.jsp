<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="reviewUpdate" method="post" >
<input type="hidden" name="prodNum" value="${dto.prodNum }"/>
<input type="hidden" name="purchaseNum" value="${dto.purchaseNum }" />
<table >
	<tr><td>리뷰작성</td>
	    <td><textarea rows="5" cols="30" name="reviewContent">${dto.reviewContent }</textarea></td></tr>
	<tr><td colspan="2">
		<img src="../goods/upload/${dto.reviewImg }" width=200  />
		</td></tr>
	<tr><td colspan="2"><input type="submit" value="리뷰등록" /></td></tr>		
</table>
</form>
</body>
</html>