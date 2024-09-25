<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재발급</title>

<!-- <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script> -->
<%-- <script src="${pageContext.request.contextPath}/js/jquery.serializejson.min.js"></script> --%>
<jsp:include page="/WEB-INF/view/mainScript.jsp" />

<style type="text/css">
.container {
  font-family: arial;
  font-size: 24px;
  margin: 25px;
  width: 350px;
  height: 200px;
/*   outline: dashed 1px black; */
  /* 설정 */
  position: relative;
}
.child {
  width: 50px;
  height: 50px;
/*   background-color: red; */
  /* 상하좌우 정중앙 정렬하기 */
  position: absolute;
  top: 50%;
  left: 50%;
  margin: -110px 0 0 -70px; /* 자식 요소 전체를 중앙 정렬하기 위해, 상단 및 왼쪽 margin을 마이너스 값으로 적용하기 */
}
#das{
background: #FF9966;
}

#img{
margin-left: 40px;
}

#newPass{

margin-left: 120px;
}
#bar{
color:black;
margin-left: 100px;
font-weight: bolder;
}

</style>
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
<body id="das">
<div class="container" id="fw" >
<div class="child">
<form  class="login-form" action="<%=request.getContextPath() %>/newPassword.do"  method="post">
<table border-collapse= 'collapse'   width='100%'>
  <caption  id="bar"> 스스로 비밀번호 찾기</caption>
<thead>
	<del>
	 <img id="img" src="${pageContext.request.contextPath}/images/로고.png" class="logo" style= "text-align: center">
	
	</del>
	
	
</thead>
<tr>
   <td>ID: </td>
<td><input type = "text" class="text-field" placeholder="아이디를 입력하세요" name ="cus_id" id="id" ></td>
</tr>
<tr>
   <td>EMAIL:</td>
<td><input type = "text" class="text-field" placeholder="이메일을 입력하세요" name ="mem_mail" id ="mail"></td>
</tr>
</table>
<br>
<input type="button" class= "submit-btn" name="newPass" id="newPass"  value="비밀번호 재발급">


</form>
</div>
</div>



</body>
</html>