<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.js"></script>
<script type="text/javascript">
function testDiv(num){
	//location.href="ajaxTest1?n="+num //  동기식
	$.ajax({ // 비동기식
		type : "post",
		url : "ajaxTest1",
		dataType : "html",
		data : "n="+num,
		success : function(result){ //익명함수 
			$("#notice_content").html(result);
		},
		error: function(){
			alert('에러가 나왔다 홀홀홀~');
			return;
		}
	});
}
</script>
</head>
<body>
	<ul>
		<li onclick="testDiv(1)">경력3년이상</a></li>
		<li onclick="testDiv(2)">석박사급</li>
		<li onclick="testDiv(3)">IT개발자</li>
	</ul>
	<div id="notice_content"> </div>
<form name="frm" id="frm">
	<input type="text" id="n" >
</form>
	<button id="btn3" >버튼2</button>
	<button id="btn4" >버튼3</button>
	<button id="btn5" >버튼4</button>
</body>
</html>