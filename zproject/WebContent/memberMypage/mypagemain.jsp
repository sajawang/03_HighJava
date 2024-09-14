<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>마이페이지 main페이지 입니다.</h1>
<a href="<%=request.getContextPath()%>/SolvedProblems.do">내문제</a>
<a href="<%=request.getContextPath()%>/IncorrectProblems.do">오답노트</a>
<a href="<%=request.getContextPath()%>/">매일10분수학</a>
<a href="<%=request.getContextPath()%>/">이용문의내역</a>
<a href="<%=request.getContextPath()%>/">수학학습해결소내역</a>
<a href="<%=request.getContextPath()%>/MemberUpdate.do?memId=<%=request.getParameter("memId")%>">회원정보수정</a>

<p>현재 저장된 아이디 : <%=request.getParameter("memId")%></p>

</form>
</body>
</html>