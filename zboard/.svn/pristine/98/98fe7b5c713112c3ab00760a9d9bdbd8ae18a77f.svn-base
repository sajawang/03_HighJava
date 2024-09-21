<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재발급</title>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/jquery.serializejson.min.js"></script>
<script type="text/javascript">

$(function(){
	
	
	$('#newPass').on('click',function(){
	vid=$('#id').val();
	vmail=$('#mail').val();
			console.log(vid);
			console.log(vmail);
		
		$.ajax({
			
		url:'<%=request.getContextPath() %>/newPassword.do',
		type:'post',
		data:{id:vid,mail:vmail},
		success:function(res){
			
			alert("비밀번호 재발급 완료. 이메일을 확인하세요.");
			
		},
		error:function(err){
			alert(err.status);
			
		},
		dataType:'json'
		})
	})
})

</script>


</head>
<body>

<form  class="login-form" action="<%=request.getContextPath() %>/idFindController.do"  method="post">
<table border-collapse= 'collapse'   width='100%'>
<div class="container">
  <h1>LOGIN</h1>
  <tr>
<td><img src="../../images/로고.png" class="logo" style= "text-align: center"></td>
</tr>
</div> 
<tr>
   <td>ID: </td>
<td><input type = "text" class="text-field" placeholder="아이디를 입력하세요" name ="cus_id" id="id" ></td>
</tr>
<tr>
<br>
   <td>EMAIL:</td>
<td><input type = "text" class="text-field" placeholder="이메일을 입력하세요" name ="mem_mail" id ="mail"></td>
</tr>
 <tr>    
<td colspan="2" style="text-align: center">
<br>
<br>
<input type="button" class= "submit-btn" name="newPass" id="newPass"  value="비밀번호 재발급">

</td>
</tr>

</table>
</form>



</body>
</html>