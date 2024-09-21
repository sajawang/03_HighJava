<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Insert title here</title>

<style type="text/css">
	table, tr, td { border:1px solid blue; border-collapse: collapse; }
	td { padding:5px;}
</style>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>

<script type="text/javascript">

$(function(){
	$("#btnList").on("click", function(){
		location.href="<%=request.getContextPath()%>/AdminTeacherList.do";
	});
	

	
	$("#idCheck").on("click", function(){
		var cusId = $("#cus_id").val();
		if(cusId==""){
			alert("ID를 입력하세요");
			return;
		}
		
		$.ajax({
	    	 url : '<%=request.getContextPath()%>/AdminCusIdCheck.do',
	    	 data : { "cus_id" : cusId },
	    	 dataType : 'json',
	    	 success : function(result){
	    		 if(result=="OK"){
	    			 $("#idChkResult").html("사용가능");
	    		 }else{
	    			 $("#idChkResult").html("ID 중복 - 사용불가");
	    		 }
	    	 },
	    	 error : function(xhr){
	    		 alert("status :" + xhr.status);
	    	 }
	     })
	});
	
	$("#Teacherinsert").on("submit", function(){
		var idchk = $("#idChkResult").html();
		
		if(idchk!="사용가능"){
			alert("ID 중복되거나 중복체크를 하지 않았습니다.");
			return false;  // 전송 중단.
		}
		
		if($("#cus_pass").val()=="" || $("#cus_pass").val()!= $("#cus_pass2").val()){
			alert("비밀번호와 비밀번호 확인이 다릅니다. 다시 확인하세요.");
			return false;   // 서버로 전송을 하지 않는다.
		}
		
		
		return true;
	});
});

</script>
</head>


<body>
<h2>선생님 정보 입력</h2>
<form id="Teacherinsert" method="post" enctype="multipart/form-data"
	action="<%=request.getContextPath()%>/AdminTeacherInsert.do" >
<table border="1">
<tbody>
	<tr>
		<td>회원ID</td>
		<td>
			<input type="text" name="cus_id" id="cus_id">
			<input id="idCheck" type="button" value="중복확인"><br>
			<span id="idChkResult"></span>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="cus_pass" id="cus_pass"></td>
	</tr>
	<tr>
		<td>비밀번호 확인</td>
		<td><input type="password" name="cus_pass2" id="cus_pass2"></td>
	</tr>	
	<tr>
		<td>회원이름</td>
		<td><input type="text" name="mem_name"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="text" name="mem_tel"></td>
	</tr>

		<td>생일</td>
		<td>  <input type="date" name="mem_bir"></td>
	</tr>
	
	<tr>
		<td>우편번호</td>
		<td><input type="text" name="mem_zip"></td>
	</tr>
	
	<tr>
		<td>주소</td>
		<td><input type="text" name="mem_add1"></td>
	</tr>
	
	<tr>
		<td>상세주소</td>
		<td><input type="text" name="mem_add2"></td>
	</tr>
	
	<tr>
		<td>이메일</td>
		<td><input type="text" name="mem_mail"></td>
	</tr>
	
	<tr>
		<td>선생님 인증 </td>
		<td><input type="file" name="mem_auth"></td>
	</tr>
	
	<tr>
		<td colspan="2" style="text-align:center;">
			<input type="submit" value="저장"> <input type="button"  id="btnList" value="회원 등록 취소 목록으로 돌아가기">
			</td>
	</tr>
</tbody>
</table>
</form>
</body>
</html>