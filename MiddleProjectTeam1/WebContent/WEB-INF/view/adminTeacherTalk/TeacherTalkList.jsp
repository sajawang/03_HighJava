<%@page import="kr.or.ddit.vo.CommentVO"%>
<%@page import="kr.or.ddit.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쌤 톡톡 게시판</title>
<style>
/* 페이지 전반적인 스타일 */
body {
   font-family: 'Arial', sans-serif;
   margin: 20px;
   background-color: #f5f5f5;
}

h2, h3 {
   color: #333;
   text-align: center;
}

/* 테이블 스타일 */
table {
   width: 100%;
   border-collapse: collapse;
   margin-top: 20px;
   background-color: white;
   box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
}

th, td {
   padding: 15px;
   text-align: left;
   border-bottom: 1px solid #ddd;
}

th {
   background-color: #f2f2f2;
   font-weight: bold;
   color: #555;
}

td {
   color: #666;
}

/* 링크 스타일 */
td a {
   color: #007bff;
   text-decoration: none;
   font-weight: bold;
}

td a:hover {
   text-decoration: underline;
}

/* 버튼 스타일 */
input[type="submit"] {
   padding: 7px 12px;
   background-color: #ff4d4d;
   border: none;
   color: white;
   font-weight: bold;
   cursor: pointer;
   border-radius: 4px;
   transition: background-color 0.3s ease;
}

input[type="submit"]:hover {
   background-color: #e03b3b;
}

/* 모달창 스타일 */
.modal {
   display: none;
   position: fixed;
   z-index: 1;
   left: 0;
   top: 0;
   width: 100%;
   height: 100%;
   background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
   background-color: #fff;
   margin: 15% auto;
   padding: 20px;
   border-radius: 10px;
   width: 50%;
   box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
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

.comment-table th, .comment-table td {
   padding: 10px;
   border-bottom: 1px solid #ddd;
}

.delete-btn {
   padding: 5px 10px;
   background-color: #ff4d4d;
   border: none;
   color: white;
   cursor: pointer;
   border-radius: 3px;
}

.delete-btn:hover {
   background-color: #e03b3b;
}
</style>
<script>
    var contextPath = '<%=request.getContextPath()%>';
    
    // 게시글 삭제 확인 함수
    function confirmDeletePost() {
        return confirm("정말로 이 게시글을 삭제하시겠습니까?");
    }

    // 댓글 삭제 확인 함수
    function confirmDeleteComment() {
        return confirm("정말로 이 댓글을 삭제하시겠습니까?");
    }

    // 모달 창 열기 및 댓글 리스트 불러오기
 function openModal(postNo) {
    code = '';
    $.ajax({
        url: '<%=request.getContextPath()%>/AdminTeacherTalkComment.do',
        type: "POST",
        data: "post_no=" + postNo,
        success: function(data) {
            var l = data.length;
            if (l > 0) {
                $.each(data, function(i, v) {
                    // comment_delyn 값이 'Y'인 경우 "관리자에 의해 삭제되었습니다" 메시지를 표시
                  

                    code += '<tr><td>' + v.comment_no + '</td>'
                        + '<td>' + v.cus_id + '</td>'
                        + '<td>' + v.comment_content + '</td>'
                        + '<td>' + v.comment_date + '</td>'
                        + '<td>' + v.comment_like + '</td>'
                        + '<td><form action="' + contextPath + '/AdminTalkDelectComment.do" method="post" onsubmit="return confirmDeleteComment()">'
                        + '<input type="hidden" name="comment_no" value="' + v.comment_no + '">'
                        + '<input type="submit" value="삭제" class="delete-btn"></form></td></tr>';
                });
            } else {
                code += '<tr><td colspan="5">댓글이 없습니다.</td></tr>';
            }
            $('#commentModal #tbodyHear').html(code);
        },
        error: function(xhr) {
            alert("응답 코드 : " + xhr.status);
        },
        dataType: "json"
    });
    $('#commentModal').css('display', 'block');
}
    // 모달 창 닫기
    function closeModal() {
        document.getElementById("commentModal").style.display = "none";
    }

</script>
</head>
<body>
   <h2>선생님 게시판 관리</h2>

   <table>
      <thead>
         <tr>
            <th>번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>내용</th>
            <th>조회수</th>
            <th>작성일</th>
            <th>삭제유무</th>
            <th>삭제</th>
         </tr>
      </thead>
      <tbody>
         <%
                List<PostVO> TalkPostList = (List<PostVO>) request.getAttribute("TalkPostList");
                for (PostVO post : TalkPostList) {
            %>
         <tr>
            <td><%= post.getPost_no() %></td>
            <td><%= post.getCus_id() %></td>
            <td><a href="javascript:void(0);" onclick="openModal(<%= post.getPost_no() %>)"> <%= post.getPost_title() %></a></td>
            <td><%= post.getPost_content() %></td>
            <td><%= post.getPost_cnt() %></td>
            <td><%= post.getPost_date() %></td>
            <td><%= "y".equals(post.getPost_delyn()) ? "삭제됨" : "정상" %></td>
            <td>
               <form action="<%=request.getContextPath()%>/AdminTeacherTalkDelect.do" method="post" onsubmit="return confirmDeletePost()">
                  <input type="hidden" name="post_no" value="<%= post.getPost_no() %>"> 
                  <input type="submit" value="삭제">
               </form>
            </td>
         </tr>
         <%
                }
            %>
      </tbody>
   </table>

   <!-- 모달창 -->
   <div id="commentModal" class="modal">
      <div class="modal-content">
         <span class="close" onclick="closeModal()">&times;</span>
         <h3>댓글 리스트</h3>
         <div id="commentContent">
            <!-- 여기에 AJAX를 통해 댓글이 로드됩니다 -->
            <table class="comment-table">
               <thead>
                  <tr>
                     <th>댓글번호</th>
                     <th>작성자</th>
                     <th>내용</th>
                     <th>작성일</th>
                     <th>좋아요</th>
                     <th>삭제</th>
                  </tr>
               </thead>
               <tbody id="tbodyHear">

               </tbody>
            </table>
         </div>
      </div>
   </div>

</body>
</html>