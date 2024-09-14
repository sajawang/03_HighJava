<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<script type="text/javascript">
	

</script>
</head>
<body>
<h1>로그인</h1>
<form action="<%=request.getContextPath()%>/mypage/mypagemain.jsp">
<input type="text" name="memId">
<input type="submit" value="로그인" id="btn"> 
</form>
</body>
</html>