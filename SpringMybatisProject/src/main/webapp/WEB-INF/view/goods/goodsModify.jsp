<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
상품번호 : ${dto.prodNum }<br />
상품명 : ${dto.prodName }<br />
가격 : <input type="number" name="prodPrice" min="10" step="10" value="${dto.prodPrice }"/><br />
규격 : <input type="number" name="prodCapacity" min="0" value="${dto.prodCapacity }"/><br />
공급처 : <input type="text" name="prodSupplyer" value="${dto.prudSupplyer }"/><br />
배송비 : <input type="number" name="prodDelFee" min="0" step="100" value="${dto.prodDelFee }"/><br />
추천 여부 :
	<input type="radio" name="recommend" value="Y" 
	<c:if test="${dto.recommend == 'Y'}">checked</c:if> /> 추천
	
	<input type="radio" name="recommend" value="N" 
	<c:if test="${dto.recommend == 'N'}">checked</c:if> /> 비추천
		<br />
카테고리 : <select name="ctgr">
			<option value="wear" 
			<c:if test="${dto.ctgr == 'wear'}">selected</c:if> >의류</option>
			<option value="cosmetic" 
			<c:if test="${dto.ctgr == 'cosmetic'}">selected</c:if>>화장품</option>
			<option value="food"
			<c:if test="${dto.ctgr == 'food'}">selected</c:if>>음식</option>
			<option value="car"
			<c:if test="${dto.ctgr == 'car'}">selected</c:if>>자동차 용품</option>
		</select> <br /> 
상세내용 : <textarea rows="5" cols="50">${dto.prodDetail }</textarea><br />
이미지
</body>
</html>