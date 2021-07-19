<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<meta name="description" lang="ko" content="네이버 - 다시 한번 확인해주세요.">
<title>다시 한번 확인해주세요.</title>
<link rel="stylesheet" href="https://ssl.pstatic.net/sstatic/search/pc/css/error_page.css">
<script type="text/javascript">
  (function () {
    function trim_space (q)
    {
      var head_re = /^ */;
      var tail_re = / *$/;
      q = q.replace(head_re, "");
      q = q.replace(tail_re, "");
      return q;
    }

    function nx_get_cookie(name)
    {
      var cookie_list = document.cookie.split(/\s*;\s*/);

      for (var i = 0; i < cookie_list.length; i++) {
        var tmp_list = cookie_list[i].split("=");
        var c_name = trim_space(tmp_list[0]);
        var c_value = tmp_list[1];
        if (name == c_name) {
          return unescape(c_value);
        }
      }
      return null;
    }

    function loadCssFile(filename) {
      var linktag = document.createElement("link");

      linktag.setAttribute("rel", "stylesheet");
      linktag.setAttribute("type", "text/css");
      linktag.setAttribute("href", filename);
      linktag.setAttribute("media", "(prefers-color-scheme: dark)");
      document.getElementsByTagName("head")[0].appendChild(linktag);
    }

    var isSystemDark = window.matchMedia && window.matchMedia("(prefers-color-scheme: dark)").matches;
    var matched = navigator.userAgent.match(/NAVER\((.+?)\)/);
    var isNaverFamilyApp = !!matched;
    var darkErrorPageCssFile = "https://ssl.pstatic.net/sstatic/search/pc/css/error_page_dark.css";

    if (isNaverFamilyApp) {
      var splited = (matched || ["", ""])[1].split("; ");
      var agentInfo = {
        "browserServiceCode": splited[2] || ""
      };

      if (isSystemDark && parseInt(agentInfo.browserServiceCode, 10) >= 1000) {
        loadCssFile(darkErrorPageCssFile);
      }
    } else {
      var nscs = nx_get_cookie("NSCS");
      if (typeof nscs !== "undefined" && parseInt(nscs, 10) === 1) {
        loadCssFile(darkErrorPageCssFile);
      }
    }
  })();
</script>
</head>
<body>
	<div id="u_skip" class="u_skip">
		<a href="#content">본문 바로가기</a>
	</div>
	<div class="wrap">
		<div class="header" role="banner">
      <h1 class="logo"><a href="https://www.naver.com" class="common_pc logo_link"><img src="https://ssl.pstatic.net/sstatic/search/pc/img/naver_logo2.png" width="83" height="15" alt="네이버"></a><a href="https://m.naver.com" class="common_m logo_link"><img src="https://ssl.pstatic.net/sstatic/search/pc/img/naver_logo2.png" width="83" height="15" alt="네이버"></a></h1>
			<div class="nav" role="navigation">
				<a href="https://www.naver.com" class="nav_link">네이버홈</a>
				<a href="https://help.naver.com" class="nav_link">네이버 고객센터</a>
			</div>
		</div>
		<hr>
		<div class="container" role="main">
			<div class="content" id="content">
				<div class="image_area _notFoundImage">
				</div>

				<div class="info_area">
					<div class="info_txt">
						<strong class="tit">다시 한번 확인해주세요!</strong>
						<p class="txt">
							지금 입력하신 주소의 페이지는<br>
							사라졌거나 다른 페이지로 변경되었습니다.<br>
							주소를 다시 확인해주세요.
						</p>
					</div>
					<div class="common_pc info_link">
						<a href="javascript:{history.back();}" class="link_prev">이전 페이지</a><a href="https://www.naver.com" class="link_home">네이버 홈</a>
					</div>
					<div class="common_m info_link">
						<a href="javascript:{history.back();}" class="link_prev">이전 페이지</a><a href="https://m.naver.com" class="link_home">네이버 홈</a>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<div class="footer" role="contentinfo">
			<address>
				<span>Copyright</span> ©<a href="http://www.navercorp.com" class="link_naver" target="_blank">NAVER Corp.</a> <span>All Rights Reserved.</span>
			</address>
		</div>
	</div>
	<script src="https://ssl.pstatic.net/static/fe/grafolio.js"></script>
</body>
</html>