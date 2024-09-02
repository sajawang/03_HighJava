<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
String loginId=(String)session.getAttribute("ID");
if(loginId==null){
	loginId="";
}
%>
<body>

<div class="login-container">
	<form action="<%=request.getContextPath()%>/sessionLogin.do" method="get">
		<label for="id">ID : </label>
		<input type="text" id="userid" name="userid" placeholder="ID 입력하세요." value="<%=loginId%>">
		<br>
		
		<label for="password">PASS : </label>
		<input type="password" id="userpass" name="userpass" placeholder="PassWord 입력하세요.">
		<br>
		
		<button type="submit">Login</button>
	</form>
</div>

	
</body>
</html>
</body>
</html>