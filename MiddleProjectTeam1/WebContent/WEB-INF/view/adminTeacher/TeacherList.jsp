<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.vo.CustomerVO"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>선생님 회원 목록 보기</title>

    <style type="text/css">
        /* 페이지 중앙 정렬 */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        /* 전체 컨테이너 */
        .container {
            width: 80%;
            max-width: 1200px;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
        }

        h2 {
            font-size: 32px;
            margin-bottom: 20px;
            color: #333;
        }

        /* 테이블 스타일 */
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            font-size: 18px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
        }

        thead {
            background-color: #ffd700; /* 헤더에 노란색 배경 */
            color: #000;
        }

        thead th {
            padding: 12px 15px;
            text-align: center;
        }

        tbody tr {
            border-bottom: 1px solid #ddd;
        }

        tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tbody td {
            padding: 12px 15px;
            text-align: center;
        }

        tbody tr:hover {
            background-color: #f1f1f1;
            transition: background-color 0.3s;
        }

        /* 버튼 스타일 */
        .button-container {
            text-align: right;
            margin-bottom: 10px;
        }

        button {
            background-color: #f44336;
            color: white;
            padding: 10px 20px;
            font-size: 18px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #d32f2f;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>

<script type="text/javascript">
$(document).ready(function() {
    // jQuery 코드를 여기에 작성하세요
    $("#addBtn").on("click", function(){
        location.href = "<%=request.getContextPath()%>/AdminTeacherInsert.do";
    });
});
</script>
</head>
<body>
<% List<MemberVO> TeacherList = (List<MemberVO>)request.getAttribute("TeacherList"); 
	Map<String, CustomerVO> customerMap = (Map<String, CustomerVO>) request.getAttribute("customerMap"); %>
	
 <div class="container">
        <h2>선생님 회원 목록 보기</h2>
        <div class="button-container">
            <button id="addBtn">회원추가</button>
        </div>
	 <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>이 름</th>
                    <th>전 화</th>
                    <th>주 소</th>
                    <th>회원유무</th>
                </tr>
            </thead>
            <tbody>
	<% 
if (TeacherList != null) { 
    for(MemberVO memvo : TeacherList){
    	
    	 CustomerVO cusVo = customerMap.get(memvo.getCus_id()); 
%>
        <tr>
            <td><a href="<%=request.getContextPath()%>/AdminTeacherView.do?cus_id=<%=memvo.getCus_id()%>"> 
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
                <td colspan="5">선생님 목록이 없습니다.</td>
            </tr>
        <% 
        } 
        %>
        </tbody>
</table>
</body>
</html>