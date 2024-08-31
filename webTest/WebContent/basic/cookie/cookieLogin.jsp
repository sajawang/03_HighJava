<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 .login-container {
            width: 300px;
            margin: 0 auto;
            border: 1px solid #ccc;
            padding: 20px;
        }
 .login-container button {
			margin-left:100px;
      }
  
</style>
</head>
<body>

<div class="login-container">
	<form action="" method="">
		<label for="id">ID : </label>
		<input type="text" id="id" name="id" placeholder="ID 입력하세요.">
		<br>
		
		<label for="password">PASS : </label>
		<input type="password" id="password" name="password" placeholder="PassWord 입력하세요.">
		<br>
		
		<input type="checkbox" id="remember" name="remember">
		<label for="remember">id 기억하기</label>
		<br><br>
		
		<button type="submit">Login</button>
	</form>
</div>

	
</body>
</html>