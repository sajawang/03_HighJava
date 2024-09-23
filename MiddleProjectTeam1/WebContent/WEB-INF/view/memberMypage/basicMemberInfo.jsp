<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="../mainScript.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
</head>
<script type="text/javascript">
$(function(){
	
	$("#btnUpdate").on("click", function(){
		var form = document.getElementById("memberForm");
		form.method = "GET";
		form.action = "<%=request.getContextPath()%>/myPageMemberUpdateForm.do";
		form.submit();
	});
	
	$("#btnDelete").on("click", function(){
		alert("탈퇴되었습니다.");  // 알림 메시지 추가
		var form = document.getElementById("memberForm");
		form.action = "<%=request.getContextPath()%>/myMemberDelete.do";
		form.submit();
	});
});
	
</script>
<body>
<jsp:include page="../header.jsp" />

<br>
<nav id="nav_bar">
        <ul>
            <li><a href="<%=request.getContextPath()%>/myPageMaterial.do">내가 푼 학습지</a></li>
            <li><a href="<%=request.getContextPath()%>/tenMinuteViewMaterialist.do">매일10분수학</a></li>
            <li><a href="<%=request.getContextPath()%>/myPageBoardThree.do">이용문의내역</a></li>
            <li><a href="<%=request.getContextPath()%>/myPageBoardTwo.do">수학학습해결소내역</a></li>
            <li><a href="<%=request.getContextPath()%>/myMemberPointSelect.do">나의 포인트조회</a></li>
            <li><a href="<%=request.getContextPath()%>/myPageMemberUpdate.do">회원정보수정</a></li>
        </ul>
</nav>
<br>

<%
	MemberVO memvo = (MemberVO)request.getAttribute("MemberVO");
%>

<div style="display: flex; flex-direction: column; align-items: center;">
<h2>회원 정보 수정</h2><br><br>	
	<form name="memberForm" id="memberForm" >	
		<input type="hidden" id="mem_id" name="mem_id" value="<%=memvo.getMem_name()%>">
	<table border="1" style="margin: 0 auto; width : 500px;">
		<thead>
			<tr>
				<td colspan="2" style="text-align:right;">
					<h3 style="text-align: left;">내 기본 정보</h3><input type="button" id="btnUpdate" value="회원정보수정">
				</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><%=memvo.getMem_name()%>(<%=memvo.getCus_id() %>)</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><%=memvo.getMem_bir()%></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><%=memvo.getMem_mail()%></td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td><%=memvo.getMem_tel()%></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:right;">
					<input type="button" id="btnDelete" value="회원탈퇴">
				</td>
			</tr>
		</thead>
		</table>
	</form>
</div>
<br><br>
<jsp:include page="../footer.jsp" />
</body>
</html>