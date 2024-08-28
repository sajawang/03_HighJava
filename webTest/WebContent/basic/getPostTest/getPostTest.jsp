<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
window.onload=function(){
	document.getElementById("getBtn").addEventListener("click",function(){
		location.href = "/webTest/servletTest03.do";
		//location.href = "http://localhost/webTest/servletTest03.do";
	});
}

</script>
</head>
<body>
	<h2>Servlet 요청 연습</h2><br>
	
	<h3>GET방식 요청1 ==> 링크 방식</h3>
	<a href="/webTest/servletTest03.do">GET방식 요청1</a>
	<hr><br>
	
	<h3>GET방식 요청2 ==> JavaScript의 location.href속성을 이용한 경우</h3>
	<form action="">
		<input type="button" value="GET방식 요청2" id="getBtn">
	</form>
	<hr><br>
	
	<h3>GET방식 요청3 ==>form태그의 method속성을 생략하거나 'GET'으로 지정한 경우</h3>
	<form action="http://localhost/webTest/servletTest03.do" method="get">
		<input type="submit" value="GET방식 요청3">
	</form>
	<hr color="red"><br>

	<h3>POST방식 요청 ==>form태그의 method속성을 생략하거나 'POST'으로 지정한 경우</h3>
	<form action="http://localhost/webTest/servletTest03.do" method="post">
		<input type="submit" value="POST방식 요청">
	</form>
	<hr color="red"><br>
</body>
</html>







































