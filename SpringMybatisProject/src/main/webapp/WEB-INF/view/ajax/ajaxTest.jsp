<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function testDiv(num){
		if(num == 1){
			op1.style.display="";
			op2.style.display="none";
			op3.style.display="none";
		}else if(num == 2){
			op1.style.display="none";
			op2.style.display="";
			op3.style.display="none";
		}else if(num == 3){
			op1.style.display="none";
			op2.style.display="none";
			op3.style.display="";
		}
	}
</script>
</head>
<body>
	<ul>
		<li onclick="testDiv(1)">경력3년이상</a></li>
		<li onclick="testDiv(2)">석박사급</li>
		<li onclick="testDiv(3)">IT개발자</li>
	</ul>
<div  id="op1" >
	<table>
		<tr><th>ID(성별,연령)</th><th>이력서제목</th><th>학력</th><th>경력</th></tr>
		<tr><td>aa11</td><td>aaaa</td><td>aaaaa</td><td>aaaa</td></tr>
	</table>
</div>
<div  id="op2" style="display:none">
	<table>
		<tr><th>ID(성별,연령)</th><th>이력서제목</th><th>학력</th><th>경력</th></tr>
		<tr><td>bbb</td><td>bbb</td><td>bbb</td><td>bbbb</td></tr>
	</table>
</div>
<div  id="op3" style="display:none">
	<table>
		<tr><th>ID(성별,연령)</th><th>이력서제목</th><th>학력</th><th>경력</th></tr>
		<tr><td>cccc</td><td>cccc</td><td>cccc</td><td>cccc</td></tr>
	</table>
</div>
</body>
</html>