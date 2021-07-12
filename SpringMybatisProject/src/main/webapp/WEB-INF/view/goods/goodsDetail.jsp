<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsDetail.jsp</title>
</head>
<body>
test는  정수값만 가지고 있다 : ${test}<br />

카테고리 : ${dto.ctgr }<br />
상품번호 : ${dto.prodNum }<br />
상품명 : ${dto.prodName }<br />
상품 가격 : ${dto.prodPrice }<br />
규격 : ${dto.prodCapacity }<br />
공급 업체 :  ${dto.prudSupplyer }<br />
배송비 : ${dto.prodDelFee }<br />
추천 여부 : ${dto.recommend }<br />
상세 정보 ${dto.prodDetail }<br />
이미지 

</body>
</html>