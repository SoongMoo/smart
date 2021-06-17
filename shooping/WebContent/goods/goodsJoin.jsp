<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="goodsJoin.gd" method="post" name="frm" 
								enctype="multipart/form-data">
	<table border = 1>
		<tr><th>상품 번호</th>
			<td><select>
					<option value="wear">의류</option>
					<option value="cosmetic">화장품</option>
					<option value="food">음식</option>
					<option value="car">자동차용품</option>
				</select></td></tr>		
		<tr><th>상품명</th><td></td></tr>
		<tr><th>가격</th><td></td></tr>
		<tr><th>용량</th><td></td></tr>
		<tr><th>공급처</th><td></td></tr>
		<tr><th>배송비</th><td></td></tr>
		<tr><th>추천여부</th><td></td></tr>
		<tr><th>내용</th><td></td></tr>
		<tr><th>파일</th><td></td></tr>
		<tr><th colspan="2"></th></tr>
	</table> 
</form>
</body>
</html>