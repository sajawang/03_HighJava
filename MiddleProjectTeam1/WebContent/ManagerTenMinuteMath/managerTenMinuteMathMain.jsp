<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="kr.or.ddit.vo.MathSettingVO"%>
<%@page import="java.util.List"%>
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
	$("#addBtn").on("click", function(){
		//회원전체목록 출력
		location.href="<%=request.getContextPath()%>/managerAllMemberList.do";
		
		// location.href="<%=request.getContextPath()%>/ManagerTenMinuteMath/managerTenMinuteMathAdd.jsp";
	});
	$(".updateBtn").on("click", function(){
		//alert($(this).data("cusid"));
		let cusid = $(this).data("cusid");
		location.href="<%=request.getContextPath()%>/ManagerTenMinuteMath/managerTenMinuteMathUpdate.jsp?cusid=" + cusid;
	});
});
</script>
</head>
<%
List<MathSettingVO> mathsettinglist = null;
mathsettinglist=(List<MathSettingVO>)request.getAttribute("mathsettinglist");
%>
<body>

<h1>10분수학 구독 회원 검색</h1>
<hr>

<table border="1">
	<thead>
		<tr>
			<td colspan="2">
				<input type="button" id="addBtn" value="구독 회원추가">
			</td>
		</tr>
		<tr>
			<th>아이디</th>
			<th>관리</th>
		</tr>
	</thead>
	<tbody>
		<tr>
<%for(MathSettingVO mvo : mathsettinglist){
%>	
			<td>
				<%= mvo.getCus_id()%>
			</td>
			<td>
				<input type="button" class="updateBtn" data-cusid="<%= mvo.getCus_id()%>" value="구독수정">
				<input type="button" class="addBtn" value="구독취소">
			</td>
		</tr>
<% 		
}
%>
	</tbody>
</table>

</body>
</html>