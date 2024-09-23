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
<body>여기서 보내서 MaterialList.java로 가서 거기서 materialList.jsp로 이동

	<h3>Detail Material</h3>
	<table border=1>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용44</th>
			<th>학년11</th>
			<th>난이도</th>
		</tr>
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
		</td>
		</tr>
			<td><input id="mateNo" type="hidden" value="<%=vo.getMaterial_no() %>"><%=vo.getMaterial_no() %></td>
			<td><%=vo.getMaterial_title() %></td>
			<td><%=vo.getMaterial_des() %>dd</td>
			<td><%=vo.getMaterial_grade() %></td>
			<td><%=vo.getMaterial_level() %></td>
		</tr>
		<%	
			}
		%>
		<tr>
			<td colspan="5"><a href="<%=request.getContextPath()%>/adminMaterial/playMaterial.do?mno=<%=vo.getMaterial_no() %>">PlayMaterial</a></td>
		</tr>
		<tr>
		</tr>
	</table>
	
		
			<input type="button" value="학습지 수정" id="mateUp">
			<input type="button" value="학습지 삭제" id="deleteBtn">
		
</body>
</html>