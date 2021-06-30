<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	pageContext.setAttribute("br", "\n");
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ClearFigure</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Chivo:400,900" rel="stylesheet" />
<link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/fonts.css" rel="stylesheet" type="text/css" media="all" />
<script>
	function onQty(){
		var qty = document.frm.PurchaseQty.value;
		document.getElementById("tot").innerHTML = 
			qty * ${dto.prodPrice}
	}
	function goodsCartAdd(prodNum){
		var qty = document.frm.PurchaseQty.value;
		location.href="goodsCartAdd.gd?prodNum="+prodNum+"&qty="
					  +qty+"&prodPrice=${dto.prodPrice}";
	}
</script>
</head>
<body>
<div id="wrapper">
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<h1><a href="#">ClearFigure</a></h1>
				<p>Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a></p>
			</div>
		</div>
	</div>
	<div id="menu-wrapper">
		<div id="menu" class="container">
			<ul>
				<li><a href="main.sm">홈으로</a></li>
			<c:if test="${!empty authInfo }">
				<c:if test="${authInfo.grade == 1 }">
				<!-- 일반 회원 -->
				<li><a href="myPage.mem">마이페이지</a></li>
				<li><a href="goodsCartList.gd">장바구니</a></li>
				<li><a href="purchaseCon.gd">주문확인</a></li>
				</c:if>
				<c:if test="${authInfo.grade != 1 }">
				<a href="empMyPage.em">마이페이지</a>
				<li class="current_page_item"><a href="empMyPage.em">마이페이지</a></li>
				<li><a href="goodsList.gd">상품등록</a></li>
				<li><a href="#">공지사항</a></li>
				<li><a href="empList.em">직원 리스트</a></li>
				<li><a href="memList.mem" >회원 리스트</a></li>
				<li><a href="venta.vnt" >판매현황</a></li>
				</c:if>
				<li><a href="logout.sm">로그아웃</a></li>
			</c:if>
			</ul>
		</div>
		<!-- end #menu --> 
	</div>
	<div id="page" class="container">
<form action="#" name="frm" method="post">
<input type="hidden" name="prodNum" value="${dto.prodNum }"/>
<table width="800" align = "center" ">
	<tr><td colspan="2" >${dto.ctgr }의 ${dto.prodName } 상품 설명입니다.</td></tr>
	<tr><td rowspan="6" width="300">
		<img  height ="300" src="goods/upload/${dto.prodImage.split(',')[0] }" />
		</td><td>${dto.prodName }</td></tr>
	<tr><td align="left">${dto.prodPrice }원</td></tr>
	<tr><td align="left"><c:if test="${dto.prodDelFee == 0 }">무료배송</c:if>
			<c:if test="${dto.prodDelFee != 0 }">${dto.prodDelFee}원</c:if>
			</td></tr>
	<tr><td>
		<input type="number" size = "3" min = "1" name="PurchaseQty" value="1"
		 onchange="onQty();"/>
		
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		${dto.prodPrice }
		</td></tr>
	<tr><td align = "right">총 상품금액 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<span id="tot">${dto.prodPrice }</span></td></tr>
	<tr><td align = "right">
			<input type="button" value="장바구니" 
			onclick = "goodsCartAdd('${dto.prodNum}');"	/>
			<input type="submit" value="바로구매" /></td></tr>
	<tr><td colspan="2">
		용량 : ${dto.prodCapacity }<br />
		공급업체 : ${dto.prodSupplyer }<br />
		${dto.prodDetail }<br />
		<c:forTokens items="${dto.prodImage }" delims="," var="file">
			<c:if test="${file != 'null' }">
			<img width="800" src="goods/upload/${file }" /><br />
			</c:if>
		</c:forTokens>
		</td></tr>
</table>
</form>
<table width="800" align = "center">
<tr><td>
리뷰
<hr />
<c:forEach items="${list }" var="dto">
	<p>
	<c:if test="${dto.memId == null}">일반사용자</c:if>
	<c:if test="${dto.memId != null}">${dto.memId}</c:if>
	 / ${dto.reviewDate }<br />
	${fn:replace(dto.reviewContent, br , "<br />") }<br />
	<c:if test="${dto.reviewImg != null }">
		<img src="goods/review/${dto.reviewImg }" />
	</c:if>
	<hr />
	</p>
</c:forEach>
</td></tr>
</table>
	</div>
</div>

<div id="footer-wrapper">
	<div id="footer" class="container">
		<div id="box1">
			<div class="title">
				<h2>Latest Post</h2>
			</div>
			<ul class="style1">
				<li><a href="#">Semper mod quis eget mi dolore</a></li>
				<li><a href="#">Quam turpis feugiat sit dolor</a></li>
				<li><a href="#">Amet ornare in hendrerit in lectus</a></li>
				<li><a href="#">Consequat etiam lorem phasellus</a></li>
				<li><a href="#">Amet turpis, feugiat et sit amet</a></li>
				<li><a href="#">Semper mod quisturpis nisi</a></li>
			</ul>
		</div>
		<div id="box2">
			<div class="title">
				<h2>Popular Links</h2>
			</div>
			<ul class="style1">
				<li><a href="#">Semper mod quis eget mi dolore</a></li>
				<li><a href="#">Quam turpis feugiat sit dolor</a></li>
				<li><a href="#">Amet ornare in hendrerit in lectus</a></li>
				<li><a href="#">Consequat etiam lorem phasellus</a></li>
				<li><a href="#">Amet turpis, feugiat et sit amet</a></li>
				<li><a href="#">Semper mod quisturpis nisi</a></li>
			</ul>
		</div>
		<div id="box3">
			<div class="title">
				<h2>Follow Us</h2>
			</div>
			<p>Proin eu wisi suscipit nulla suscipit interdum. Aenean lectus lorem, imperdiet magna.</p>
			<ul class="contact">
				<li><a href="#" class="icon icon-twitter"><span>Twitter</span></a></li>
				<li><a href="#" class="icon icon-facebook"><span>Facebook</span></a></li>
				<li><a href="#" class="icon icon-dribbble"><span>Dribbble</span></a></li>
				<li><a href="#" class="icon icon-tumblr"><span>Tumblr</span></a></li>
				<li><a href="#" class="icon icon-rss"><span>Pinterest</span></a></li>
			</ul>
				<a href="#" class="icon icon-arrow-right button">Read More</a> </div>
		</div>
	</div>
</div>
<div id="copyright" class="container">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>
