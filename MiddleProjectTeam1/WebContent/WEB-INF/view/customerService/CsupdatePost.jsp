<%@page import="kr.or.ddit.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../mainScript.jsp" %>

<title>게시글수정</title>

<style>
    .detail-view {
        width: 70%;
        margin: 40px auto;
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        padding: 30px;
    }

    .detail-view h3 {
        text-align: center;
        font-size: 2.5em;
        color: white;
        background-color: #007bff;
        padding: 20px;
        margin: -30px -30px 20px -30px; /* 타이틀 부분을 테두리 밖으로 확장 */
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
    }

    .detail-view table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
        table-layout: fixed;
        text-align: center; /* 가운데 정렬 */
    }

    .detail-view td.label {
        background-color: #f9f9f9;
        font-weight: bold;
        border-bottom: 1px solid #ddd;
        color: #333;
    }

    .detail-view td.value {
        padding: 15px;
        border-bottom: 1px solid #ddd;
        color: #333;
        background-color: #fff;
    }

    .detail-view td.content {
        padding: 20px;
        background-color: #f9f9f9;
        color: #444;
        border-radius: 5px;
        border: 1px solid #ddd;
        line-height: 1.6;
        text-align: center;
    }

    .button-container {
        text-align: center;
        margin-top: 30px;
    }

    .button-container form {
        display: inline-block;
        margin: 0 10px; /* 버튼 간격 조절 */
    }

    .button-container button {
        background-color: #28a745;
        color: white;
        padding: 12px 25px;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    .button-container button:hover {
        background-color: #218838;
    }

    .detail-view {
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.15);
        border-radius: 10px;
    }
</style>

<% 
	PostVO pvo = (PostVO)request.getAttribute("pvo");
	int board_no = pvo.getBoard_no();
%>
</head>
<body>
<jsp:include page="../header.jsp" />

<div class="detail-view">
    <h3>게시글 상세보기</h3>
    <form action="<%=request.getContextPath() %>/csUpdatePost.do">
        <table>
            <tr>
                <td>제목</td>
                <td colspan="3" class="value"><input type="text" name="post_title" value="<%=pvo.getPost_title() %>"></td>
            </tr>
            <tr>
                <td>게시글번호</td>
                <td colspan="3" class="value"><input type="hidden" name="post_no" value="<%=pvo.getPost_no() %>"><%=pvo.getPost_no() %></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td colspan="3" class="value"><input type="hidden" name="cus_id" value="<%=pvo.getCus_id() %>"><%=pvo.getCus_id() %></td>
            </tr>
            <tr>
                <td>작성일</td>
                <td colspan="3" class="value"><input type="hidden" name="post_date" value="<%=pvo.getPost_date() %>"><%=pvo.getPost_date() %></td>
            </tr>
            <tr>
                <td>조회수</td>
                <td colspan="3" class="value"><input type="hidden" name="post_cnt" value="<%=pvo.getPost_cnt() %>"><%=pvo.getPost_cnt() %></td>
            </tr>
            <tr>
                <td>첨부파일</td>
                <td colspan="3" class="value"><input type="file" name="file_name" value="<%=pvo.getFiles_name() %>"><%=pvo.getFiles_name() %></td>
            </tr>
            <tr>
                <td colspan="4" class="content"><textarea rows="5" cols="40" name="post_content"><%=pvo.getPost_content() %></textarea></td>
            </tr>
            <tr>
                <td colspan="4">
                	<input type="hidden" name="board_no" value="<%=pvo.getBoard_no() %>">
                    <input type="submit" value="저장">
                    <input type="reset" value="초기화">
                    <input type="button" value="돌아가기" onclick="location.href='<%=request.getContextPath()%>/mainToJsp.do?board_no=<%=pvo.getBoard_no()%>'">
                </td>
            </tr>
        </table>
    </form>
</div>

<jsp:include page="../footer.jsp" />
</body>
</html>