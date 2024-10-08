<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Insert title here</title>

<style type="text/css">
/* 배경 및 기본 폼 정렬 */
body {
    font-family: Arial, sans-serif;
    background-color: #f5f5f5;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: flex-start; /* 상단에 맞춤 */
    height: 100vh;
    flex-direction: column; /* 제목과 폼을 세로로 배치 */
}

/* 제목 스타일 */
h2 {
    text-align: center;
    color: #333;
    margin: 0; /* 위 아래 여백 제거 */
    padding-top: 10px; /* 제목과 상단의 여백 조정 */
    font-size: 24px; /* 제목 크기를 키움 */
    width: 100%;
    background-color: #f5f5f5;
}

/* form 정렬 */
form {
    width: 100%;
    max-width: 700px; /* 폼 최대 너비 */
    padding: 20px;
    background-color: #fff;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
    margin-top: 10px; /* 제목 아래의 간격 조정 */
}

/* 테이블 스타일 */
table {
    width: 100%;
    border-collapse: collapse;
    background-color: #fff;
}

td {
    padding: 10px;
    vertical-align: middle;
    color: #333;
}

td:first-child {
    text-align: right;
    font-weight: bold;
    width: 30%;
}

input[type="text"], input[type="password"], input[type="date"], input[type="file"], input[type="button"] {
    width: 100%;
    padding: 10px;
    margin: 5px 0;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 4px;
}

input[type="button"], input[type="submit"] {
    width: calc(50% - 10px);
    background-color: #4CAF50;
    color: white;
    border: none;
    cursor: pointer;
    padding: 10px;
    border-radius: 4px;
    transition: background-color 0.3s ease;
    margin: 10px 5px 0 0;
}

input[type="button"]:hover, input[type="submit"]:hover {
    background-color: #45a049;
}

#idChkResult {
    margin-top: 10px;
    font-weight: bold;
    color: #ff0000;
}

/* 반응형 */
@media screen and (max-width: 600px) {
    form {
        max-width: 100%;
    }
    
    td:first-child {
        text-align: left;
    }
}


table {
    width: 100%;
    max-width: 700px;
    margin: 0 auto;
    border-collapse: collapse;
    background-color: #fff;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
}

thead th {
    text-align: center;
    font-size: 24px;
    padding: 20px 0;
    background-color: #f5f5f5;
    color: #333;
    font-weight: bold;
}

tbody td {
    padding: 10px;
    text-align: left;
    vertical-align: middle;
}
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
<form id="Teacherinsert" method="post" enctype="multipart/form-data"
	action="<%=request.getContextPath()%>/AdminTeacherInsert.do" >
<table>
<thead>
<tr>
<th colspan ="2">선생님 정보 입력</th>

</tbody>
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