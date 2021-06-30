<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ClearFigure</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Chivo:400,900" rel="stylesheet" />
<link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/fonts.css" rel="stylesheet" type="text/css" media="all" />
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
<c:if test="${empty authInfo }">
<form action="login.sm" method="get" name="frm">
<table  align = "center" width="500" height=150">
	<tr><td colspan="3">
		<input type="checkbox" name="idStore" value="store" 
			<c:if test="${isId != null }">checked</c:if>
		/>아이디저장 | 
		<input type="checkbox" name="autologin"  value="auto"/>
		자동로그인</td></tr>
	<tr><td>아이디</td>
		<td><input type="text" name="userId" value="${isId }"/><span>${userFail }</span></td>
		<td rowspan="2">
			<input type="image" src="images/img1.jpg" 
			width="100" alt="login" />
		</td></tr>
	<tr><td>비밀번호</td>
		<td><input type="password" name="userPw"/><span>${pwFail }</span></td></tr>
	<tr><td colspan="3" align="center">
			<a href="idSearch.mem">아이디</a>/<a href="#">비밀번호 찾기</a> |
			<a href="memAgree.mem">회원가입</a>
		</td></tr>
</table>
</form>
</c:if>
<!-- 상품 리스트 -->
<script>
	function goodsBuy(prodNum){
		if(${authInfo == null}){
			alert("로그인을 하셔야 합니다.");
			return false;
		}else{
			location.href='prodInfo.gd?prodNum='+prodNum;
		}
	}
</script>
<table align="center">
	<tr>
	<c:forEach items="${lists }" var="dto" varStatus="cnt">
		<td ><a href="javascript:goodsBuy('${dto.prodNum}')">
			<img width="200" height="200" 
			src='goods/upload/${dto.prodImage.split(",")[0] }' ><br />
			${dto.prodName }<br />
			가격 : <fmt:formatNumber value="${dto.prodPrice }" 
					type="currency" /></a> </td>
		<c:if test="${cnt.count % 3 == 0 }">
			</tr><tr>		
		</c:if>
	</c:forEach>
	</tr>
</table>		
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
