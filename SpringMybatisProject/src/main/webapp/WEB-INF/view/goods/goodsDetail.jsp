<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsDetail.jsp</title>
</head>
<body>
<a href="prodModify?prodNum=${dto.prodNum }" >수정</a><br />
카테고리 :
	<c:if test="${dto.ctgr == 'wear'}">의류</c:if>
	<c:if test="${dto.ctgr == 'cosmetic'}">화장품</c:if>
	<c:if test="${dto.ctgr == 'food'}">음식</c:if>
	<c:if test="${dto.ctgr == 'car'}">자동차용품</c:if>
	<br />
상품번호 : ${dto.prodNum }<br />
상품명 : ${dto.prodName }<br />
상품 가격 : <fmt:formatNumber value="${dto.prodPrice }" type="currency"/> 
	<br />
규격 : ${dto.prodCapacity }<br />
공급 업체 :  ${dto.prudSupplyer }<br />
배송비 : ${dto.prodDelFee }<br />
추천 여부 :
	<c:if test="${dto.recommend == 'Y'}">추천</c:if> 
	<c:if test="${dto.recommend == 'N'}">비 추천</c:if> 
	<br />
상세 정보 ${dto.prodDetail }<br />
<c:forTokens items="${dto.prodImage }" delims="," var="prodImage">
	<img src="../goods/upload/${prodImage }" /><br />
</c:forTokens>

</body>
</html>