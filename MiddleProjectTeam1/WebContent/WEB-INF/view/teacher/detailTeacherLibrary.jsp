<%@page import="kr.or.ddit.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../mainScript.jsp" %>
<title>선생님 공간</title>
</head>
<%
	PostVO pvo = (PostVO)request.getAttribute("pvo");
%>
<body>
<jsp:include page="../header.jsp" />
	<article>
		<section>
				<ul>
					<li>
						<img src="<%=request.getContextPath() %>/images/<%=pvo.getFiles_name() %>" alt="<%=pvo.getFiles_name() %>">
					</li>
					<li>
						<span><%=pvo.getPost_title() %></span>
					</li>
					<li>
						<span><%=pvo.getPost_content() %></span>
					</li>
				</ul>			
		</section>
	</article>
<jsp:include page="../footer.jsp" />
</body>
</html>