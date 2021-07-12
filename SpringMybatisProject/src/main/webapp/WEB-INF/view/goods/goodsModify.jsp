<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="goodsUpdate" name="frm" method="get" 
	modelAttribute="goodsCommand">
<input type="hidden" name="prodNum" value="${goodsCommand.prodNum }"/>
<input type="hidden" name="prodName" value="${goodsCommand.prodName }"/>
상품번호 : ${goodsCommand.prodNum }<br />
상품명 : ${goodsCommand.prodName }<br />
가격 : <input type="number" name="prodPrice" min="0" step="1" value="${goodsCommand.prodPrice }"/>
      <form:errors path="prodPrice"/><br />
규격 : <input type="number" name="prodCapacity" min="0" value="${goodsCommand.prodCapacity }"/>
	  <form:errors path="prodCapacity"/><br />
공급처 : <input type="text" name="prodSupplyer" value="${goodsCommand.prodSupplyer }"/>
	  <form:errors path="prodSupplyer"/> <br />
배송비 : <input type="number" name="prodDelFee" min="0" step="100" value="${goodsCommand.prodDelFee }"/>
		<form:errors path="prodDelFee"/><br />
추천 여부 :
	<input type="radio" name="recommend" value="Y" 
	<c:if test="${goodsCommand.recommend == 'Y'}">checked</c:if> /> 추천
	
	<input type="radio" name="recommend" value="N" 
	<c:if test="${goodsCommand.recommend == 'N'}">checked</c:if> /> 비추천
		<br />
카테고리 : <select name="ctgr">
			<option value="wear" 
			<c:if test="${goodsCommand.ctgr == 'wear'}">selected</c:if> >의류</option>
			<option value="cosmetic" 
			<c:if test="${goodsCommand.ctgr == 'cosmetic'}">selected</c:if>>화장품</option>
			<option value="food"
			<c:if test="${goodsCommand.ctgr == 'food'}">selected</c:if>>음식</option>
			<option value="car"
			<c:if test="${dto.ctgr == 'car'}">selected</c:if>>자동차 용품</option>
		</select> <br /> 
상세내용 : <textarea rows="5" cols="50" name="prodDetail">${goodsCommand.prodDetail }</textarea>
		<form:errors path="prodDetail"/><br />
이미지<br />
<input type="submit" value="수정하기" />
<input type="button" value="삭제하기" />
<input type="button" value="리스트" />
</form:form>
</body>
</html>