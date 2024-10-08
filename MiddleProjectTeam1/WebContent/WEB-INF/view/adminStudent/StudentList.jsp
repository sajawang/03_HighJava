<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.vo.CustomerVO"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Insert title here</title>
<style type="text/css">
   
/* 전체 레이아웃 */
body {
    font-family: 'Noto Sans', sans-serif;
    background-color: #f9fafc;
    margin: 0;
    padding: 0;
}

.container {
    width: 95%;
    max-width: 1200px;
    margin: 0 auto;
    background-color: #fff;
    padding: 30px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
}

/* 제목 스타일 */
h1 {
    text-align: center;
    color: #333;
    margin-bottom: 30px;
    font-size: 2.5rem;
    font-weight: 700;
    letter-spacing: -0.5px;
}

/* 회원 테이블 */
.member-table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 30px;
    background-color: #fff;
    border-radius: 8px;
    overflow: hidden;
}

.member-table th,
.member-table td {
    padding: 15px;
    text-align: left;
    border-bottom: 1px solid #e6e6e6;
    font-size: 0.9rem;
     text-align: center; 
}

.member-table th {
    background-color: rgb(255, 226, 20);
    color: #333;
    font-weight: 600;
}

.member-table tr:hover {
    background-color: #f3f4f6;
}

.member-table td {
    color: #666;
    text-align: center;
}

.member-table a {
    color: blue;
    text-decoration: underline;
     display: inline-block;
    width: 100%; /* 링크가 셀 너비에 맞게 확장되도록 설정 */
    text-align: center; /* 링크를 가운데로 정렬 */
}

.member-table td a {
    display: inline-block; /* 링크를 블록 요소처럼 취급하여 중앙 정렬 가능 */
    width: 100%; /* 테이블 셀 내에서 가로를 100% 차지하도록 설정 */
    text-align: left; /* 좌측 정렬을 위해 추가 */
    padding: 10px 0; /* 간격을 맞추기 위해 패딩 설정 */
    color: blue;
    text-decoration: underline;
}

/* 회원 추가 버튼 */
.new-member-btn {
    display: inline-block;
    padding: 12px 24px;
    background-color: tomato;
    color: white;
    font-weight: 600;
    border-radius: 5px;
    text-decoration: none;
    transition: background-color 0.3s;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    margin-bottom: 20px;
}

.new-member-btn:hover {
    background-color: #27ae60;
    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
}

/* 반응형 처리 */
@media (max-width: 768px) {
    .container {
        padding: 20px;
    }

    .member-table {
        display: block;
        overflow-x: auto;
    }

    .member-table th, .member-table td {
        white-space: nowrap;
    }
}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>

<script type="text/javascript">
$(document).ready(function() {
    // jQuery 코드를 여기에 작성하세요
    $("#addBtn").on("click", function(){
        location.href = "<%=request.getContextPath()%>/AdminStudentInsert.do";
    });
});
</script>
</head>
<body>
<% 
    List<MemberVO> studentList = (List<MemberVO>) request.getAttribute("studentList"); 
    Map<String, CustomerVO> customerMap = (Map<String, CustomerVO>) request.getAttribute("customerMap"); 
%>
	
<div class="container">
    <h1>학생 회원 목록 보기</h1>

    <!-- 회원 추가 버튼 -->
    <a class="new-member-btn" id="addBtn">회원 추가</a>
    
    <table class="member-table">
        <thead>
            <tr>
                <th>ID</th>
                <th>이 름</th>
                <th>전 화</th>
                <th>주소</th>
                <th>회원유무</th>
            </tr>
        </thead>
        <tbody>
        <% 
        if (studentList != null) { 
            for(MemberVO memvo : studentList) {
                CustomerVO cusVo = customerMap.get(memvo.getCus_id());  // cus_id로 삭제 여부를 확인
        %>
                <tr>
                    <td><a href="<%=request.getContextPath()%>/AdminStudentView.do?cus_id=<%=memvo.getCus_id()%>"> 
                        <%=memvo.getCus_id() %></a></td>
                    <td><%=memvo.getMem_name() %></td>
                    <td><%=memvo.getMem_tel() %></td>
                    <td><%=memvo.getMem_add1() %></td>
                   <td>
                        <%
                            if (cusVo != null && "Y".equals(cusVo.getCus_del())) {
                        %>
                            탈퇴
                        <%
                            } else {
                        %>
                            회원            	 
                        <%
                            }
                        %>
                    </td>
                </tr>
        <%
            }
        } else {
        %>
            <tr>
                <td colspan="5">학생 목록이 없습니다.</td>
            </tr>
        <% 
        } 
        %>
        </tbody>
    </table>
    </table>
</div>
</body>
</html>