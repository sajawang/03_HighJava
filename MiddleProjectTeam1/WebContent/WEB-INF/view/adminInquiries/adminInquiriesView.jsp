<%@page import="kr.or.ddit.vo.CommentVO"%>
<%@page import="kr.or.ddit.vo.FileVO"%>
<%@page import="kr.or.ddit.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용문의 관리</title>
<style>
    body {
        font-family: Arial, sans-serif;
    }
    .modal {
        display: none;
        position: fixed;
        z-index: 1;
        left: 0;
        top: 0;
        width: 80%;
        height: 80%;
        background-color: rgba(0, 0, 0, 0.5);
    }
    .modal-content {
        background-color: #fefefe;
        margin: 15% auto;
        padding: 20px;
        border: 1px solid #888;
        width: 50%;
        border-radius: 8px;
        box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
    }
    .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }
    .close:hover, .close:focus {
        color: black;
        text-decoration: none;
        cursor: pointer;
    }
    input, textarea {
        width: 100%;
        padding: 10px;
        margin-top: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    button {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    button:hover {
        background-color: #45a049;
    }
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }
    .comment-form {
    /*
    댓글 등록 폼 스타일 추가
    */
        display: none;
        margin-top: 20px;
        border: 1px solid #ccc;
        padding: 20px;
        background-color: #f9f9f9;
    }
</style>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
</head>
<body>

<!-- 게시글 출력 -->
<% 
    PostVO pvo = (PostVO)request.getAttribute("pvo");
%>
<table class="notice-table">
    <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>내용</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
            <th>삭제여부</th>
            <th>파일</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><%=pvo.getPost_no()%></td>
            <td><%=pvo.getPost_title() %></td>
            <td><%=pvo.getPost_content() %></td>
            <td><%=pvo.getCus_id() %></td>
            <td><%=pvo.getPost_date() %></td>
            <td><%=pvo.getPost_cnt() %></td>
            <td><%=pvo.getPost_delyn() %></td>
            <td><%=pvo.getFiles_no()%></td>
        </tr>
    </tbody>
</table>

<!-- 댓글 목록 출력 -->
<div id="commentlist">
    <h3>댓글 목록</h3>
    <ul>
    <%  
        List<CommentVO> commentList = (List<CommentVO>) request.getAttribute("commentList");
        if (commentList != null && !commentList.isEmpty()) {
            for (CommentVO cvo : commentList) {
    %>
                <li>
                    <p><strong><%=cvo.getCus_id()%></strong> <span>(<%=cvo.getComment_date()%>)</span></p>
                    <p><%=cvo.getComment_content()%></p>
                    <!-- 수정 및 삭제 버튼 -->
                    <a href="javascript:void(0)" class="editCommentBtn" 
                       data-comment-no="<%=cvo.getComment_no()%>">수정</a> | 
                    <a href="javascript:void(0)" class="deleteCommentBtn" 
                       data-comment-no="<%=cvo.getComment_no()%>">삭제</a>
                </li>
    <%
            }
        } else {
    %>
            <li>댓글이 없습니다.</li>
            <button id="addCommentBtn">답변 등록</button>
    <%
        }
    %>
    </ul>
</div>

<!-- 답변 작성 폼 -->
<div class="comment-form" id="commentForm">
    <h3>답변 작성</h3>
    <form action="<%=request.getContextPath()%>/adminInquiriesAddComment.do" method="get">
        <input type="hidden" name="post_no" value="<%=pvo.getPost_no()%>">
        <input type="hidden" name="cus_id" value="admin">
        <textarea name="comment_content" placeholder="댓글 내용을 입력하세요"></textarea>
        <button type="submit">등록</button>
    </form>
</div>

<script>
$(document).on('click', '.editCommentBtn', function() {
    var commentNo = $(this).data('comment-no');
    var newContent = prompt("수정할 댓글 내용을 입력하세요:");
    if (newContent) {
        $.ajax({
            url: '<%=request.getContextPath()%>/adminInquiriesEditComment.do',
            type: 'get',
            data: {
                comment_no: commentNo,
                comment_content: newContent
            },
            success: function(response) {
                // 성공 시 페이지 새로고침 또는 댓글 목록 업데이트
                location.reload();
            },
            error: function(xhr, status, error) {
                alert('댓글 수정 중 오류가 발생했습니다.');
            }
        });
    }
});

// 댓글 삭제 버튼 클릭 시 처리
$(document).on('click', '.deleteCommentBtn', function() {
    var commentNo = $(this).data('comment-no');
    if (confirm("정말 이 댓글을 삭제하시겠습니까?")) {
        $.ajax({
            url: '<%=request.getContextPath()%>/adminInquiriesDeleteComment.do',
            type: 'get',
            data: {
                comment_no: commentNo
            },
            success: function(response) {
                // 성공 시 페이지 새로고침 또는 댓글 목록 업데이트
                location.reload();
            },
            error: function(xhr, status, error) {
                alert('댓글 삭제 중 오류가 발생했습니다.');
            }
        });
    }
});

    // 댓글이 없을 때 답변 등록 버튼 클릭 시 폼 표시
    $('#addCommentBtn').on('click', function() {
        $('#commentForm').toggle();
    });
</script>

</body>
</html>