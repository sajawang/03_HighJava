<%@page import="kr.or.ddit.vo.PostVO"%>
<%@page import="kr.or.ddit.vo.BoardVO"%>
<%@page import="java.util.List"%>
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
<%
	List<PostVO> list = null;
	list = (List<PostVO>)request.getAttribute("list");
%>
<script type="text/javascript">

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

<div style="display: flex; flex-direction: column; align-items: center;">
	<h2>이용문의 </h2>	
	<br><br>
	<table border="1" style="margin: 0 auto;">
		<thead>
			<tr>
				<th>NO</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
	<%
		int i=1;
		for(PostVO vo : list){
	%>
			<tr>
				<td><%=i++%></td>
				<td><a href="<%=request.getContextPath()%>/csDetailPost.do?post_no=<%=vo.getPost_no()%>&board_no=3"><%=vo.getPost_title()%></a></td>
				<td><%=vo.getPost_date()%></td>
				<td><%=vo.getPost_cnt()%></td>
			</tr>
	<%
		}
	%>
		</tbody>	
	</table>
</div>
<br><br>
<jsp:include page="../footer.jsp" />
</body>
</html>