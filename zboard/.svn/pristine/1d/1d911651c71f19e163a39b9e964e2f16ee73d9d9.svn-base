<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스스로 학습 아이디 찾기</title>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/jquery.serializejson.min.js"></script>
<script type="text/javascript">

$(function(){
	
	
	$('#idFind').on('click',function(){
	vname=$('#name').val();
	vmail=$('#mail').val();
			console.log(vname);
			console.log(vmail);
		
		$.ajax({
			
		url:'<%=request.getContextPath() %>/idFindController.do',
		type:'post',
		data:{name:vname,mail:vmail},
		success:function(res){
			
			alert(vname+" 님의 이름으로 등록된 아이디는 "+res.id+" 입니다.");
			
			
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
   <td>가입자 성함: </td>
<td><input type = "text" class="text-field" placeholder="이름을 입력하세요" name ="cus_id" id="name" ></td>
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
<input type="button" class= "submit-btn" name="idFind" id="idFind"  value="아이디찾기">

</td>
</tr>

</table>
</form>



</body>
</html>