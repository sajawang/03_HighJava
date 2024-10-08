<%@page import="kr.or.ddit.vo.MaterialVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>

<title>Insert title here</title>
<%
	MaterialVO vo = (MaterialVO)request.getAttribute("materVo");
	
%>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 20px;
    }

    h3 {
        text-align: center;
        color: #333;
        font-size: 24px;
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin: 0 auto 20px;
        background-color: #fff;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    th, td {
        border: 1px solid #ddd;
        padding: 12px 15px;
        text-align: center;
    }

    th {
        background-color: #f7f7f7;
        color: #333;
        font-weight: bold;
    }

    td {
        font-size: 16px;
    }

    .image-cell {
        width: 200px;
        height: 200px;
    }

    img {
        display: block;
        margin: 10px auto;
        width: 100%;
        height: 100%;
        object-fit: cover;
        border-radius: 8px;
        border: 1px solid #ddd;
    }

    input[type="button"] {
        display: inline-block;
        padding: 10px 20px;
        font-size: 16px;
        margin: 10px;
        color: #fff;
        background-color: #007BFF;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="button"]:hover {
        background-color: #0056b3;
    }

    .action-buttons {
        text-align: center;
        margin-top: 20px;
    }
</style>



<script type="text/javascript">
$(function(){
	
	
	
	$('#mateUp').on('click',function(){
        location.href = "<%=request.getContextPath()%>/goAdminMateUpdate.do?mno=<%=vo.getMaterial_no() %>";
	})
	
	
	$('#deleteBtn').on('click', function(){
	    
        const mateNo = $('#mateNo').val();
	    // 삭제 전 확인 메시지
	    if (confirm(mateNo + "번 학습지를 삭제하시겠습니까?")) {
	        // mateNo 값을 가져옵니다.
	        
	        // Ajax를 통해 서버로 삭제 요청을 보냅니다.
	        $.ajax({
	            type: 'POST',
	            url: '<%=request.getContextPath()%>/adminMateDelete.do',  
	            data: { mateNo: mateNo },
	            success: function(response) {
	                alert("제거가 완료되었습니다.");
	                location.href = "<%=request.getContextPath()%>/adminmaterialList.do"; 
	            },
	            error: function(err) {
	                // 오류가 발생하면 알림
	                alert("삭제 중 오류가 발생했습니다. " + err.status);
	            }
	        });
	    }
	});
})

</script>

</head>
<body>
	<h3>Detail Material</h3>
	<table border=1>
	
		<% 
			if(vo == null){
		%>
		<tr>
			<td colspan="5"> 내용이 없습니다.</td>
		</tr>
		<%
			} else {
		%>
		<tr>
		<tr>
		<td colspan="2" style="text-align:center;">
		<img src="<%=request.getContextPath() %>/adminMateQueImageView.do?mno=<%=vo.getMaterial_no() %>" width="200" height="140">
<%-- 		<img src="<%=request.getContextPath()%>/adminMateQueImageView2.do?mno=<%=vo.getMaterial_no()%>" width="200" height="140"> --%>
		</td>
		</tr>
		
			<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>학년</th>
			<th>난이도</th>
		</tr>
		<tr>
			<td><input id="mateNo" type="hidden" value="<%=vo.getMaterial_no() %>"><%=vo.getMaterial_no() %></td>
			<td><%=vo.getMaterial_title() %></td>
			<td><%=vo.getMaterial_des() %></td>
			<td><%=vo.getMaterial_grade() %></td>
			<td><%=vo.getMaterial_level() %></td>
		</tr>
		<%	
			}
		%>
		
		<tr>
			<td colspan="5"><a href="<%=request.getContextPath()%>/adminMaterial/playMaterial.do?mno=<%=vo.getMaterial_no() %>">PlayMaterial</a></td>
		</tr>
	</table>
	
		
			<input type="button" value="학습지 수정" id="mateUp">
			<input type="button" value="학습지 삭제" id="deleteBtn">
		
</body>
</html>