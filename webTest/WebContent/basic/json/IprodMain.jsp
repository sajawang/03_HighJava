<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<script type="text/javascript">
$(function(){
	$("#lprodBtn").on("click",function(){
		$.ajax({
			//전송3개
			url : "<%=request.getContextPath()%>/lprodList.do",			
			type : "POST", 		
			//data : "choice=on",		
			
			
			//받는거3개
			success : function(data){	
				let htmlCode="<h3>Lprod자료 목록</h3>";
				htmlCode += "<table border='1'>";
				htmlCode += "<tr><td>아이디</td><td>gu</td><td>nm</td></tr>"
				$.each(data, function(i,v){
					htmlCode += "<tr><td>"+v.lprod_id+"</td>";
					htmlCode += "<td>"+v.lprod_gu+"</td>";
					htmlCode += "<td>"+v.lprod_nm+"</td><tr>";
				});
				htmlCode += "</table>";
			
				$("#result").html(htmlCode);
			},
			error : function(xhr){		
			alert("응답코드 : "+xhr.status);
			},
			dataType : "json" 
		})
	});
	//----------------------------------------------------------------------------------
	$("#lprodBtn2").on("click",function(){
		location.href="<%=request.getContextPath()%>/lprodList2.do";
	})
	
})
</script>
</head>
<body>
<form action="">
<input type="button" id="lprodBtn" value="Lprod 자료 가져오기(Ajax 비동기방식)">
<input type="button" id="lprodBtn2" value="Lprod 자료 가져오기(동기방식)">
</form>

<h3>Lprod자료목록</h3>
<div id="result"></div>
</body>
</html>