<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.MaterialVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    // 학습지 등록 버튼 클릭 시 페이지 이동
    $("#mateInsert").on("click", function(){
        location.href = "<%=request.getContextPath()%>/goMateInsert.do";
    });
});
</script>
<title>Material List</title>

<!-- CSS Styling -->
<style>
    body {
        font-family: 'Arial', sans-serif;
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

    th {
        background-color: #FFEB3B; /* 노란색 헤더 스타일 적용 */
        color: #333;
        font-weight: bold;
        border: 1px solid #ddd;
        padding: 12px 15px;
        text-align: center;
    }

    td {
        border: 1px solid #ddd;
        padding: 12px 15px;
        text-align: center;
        font-size: 16px;
        color: #555;
    }

    a {
        color: #007BFF;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }

    /* 학습지 등록 버튼을 오른쪽 상단으로 이동 */
    .header-button {
        display: flex;
        justify-content: flex-end;
        margin-bottom: 20px;
    }

    input[type="button"] {
        padding: 10px 20px;
        font-size: 16px;
        color: #fff;
        background-color: #28a745;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="button"]:hover {
        background-color: #218838;
    }
</style>

</head>
<%
	List<MaterialVO> materList = (List<MaterialVO>)request.getAttribute("materList");
	int cnt = 0;
%>
<body>
	<!-- 학습지 등록 버튼을 오른쪽 상단으로 이동 -->
	<div class="header-button">
	    <input type="button" value="학습지 등록" id="mateInsert">
	</div>

	<h3>Material List</h3>
	<table>
		<tr>
			<th>번호</th> <!-- 여기 노란색 배경 적용 -->
			<th>제목</th> <!-- 여기 노란색 배경 적용 -->
			<th>내용</th>   <!-- 여기 노란색 배경 적용 -->
			<th>학년</th>   <!-- 여기 노란색 배경 적용 -->
			<th>난이도</th> <!-- 여기 노란색 배경 적용 -->
		</tr>
		<% 
			if(materList == null || materList.size() == 0){
		%>
		
		<tr>
			<td colspan="5"> 내용이 없습니다.</td>
		</tr>
		
		<%
			} else {
				for(MaterialVO vo : materList) {
					cnt++;
		%>
		
		<tr>
			<td><input type="hidden" value="<%=vo.getMaterial_no() %>"><%=cnt %></td>
			<td><a href="<%=request.getContextPath()%>/material/admindetailMaterial.do?mno=<%=vo.getMaterial_no() %>"><%=vo.getMaterial_title() %></a></td>
			<td><%=vo.getMaterial_des() %></td>
			<td><%=vo.getMaterial_grade() %></td>
			<td><%=vo.getMaterial_level() %></td>
		</tr>
		
		<%	
				}
			}
		%>
	</table>
</body>
</html>