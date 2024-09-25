<%@page import="kr.or.ddit.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 목록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f5;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: rgb(255, 226, 20);
        }
        .actions a {
            margin: 0 5px;
            text-decoration: none;
            padding: 8px 12px;
            border: 1px solid #007BFF;
            color: #007BFF;
            border-radius: 4px;
        }
        .actions a:hover {
            background-color: #007BFF;
            color: white;
        }
        .new-member-btn {
            display: inline-block;
            margin-bottom: 20px;
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            border-radius: 4px;
            text-decoration: none;
            font-size: 16px;
        }
        .new-member-btn:hover {
            background-color: #218838;
        }
    </style>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>

    <script type="text/javascript">
    $(document).ready(function() {
        // 등록 버튼 클릭 시, 페이지 이동 처리
        $("#addBtn").on("click", function(){
            location.href = "<%=request.getContextPath()%>/AdminTeacherLibraryInsert.do";
        });
    });
    </script>
</head>
<body>
    <div class="container">
        <h1>선생님 자료실</h1>

        <!-- 등록 버튼 -->
        <a class="new-member-btn" id="addBtn">자료 등록</a>

        <!-- 게시글 목록 테이블 -->
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                    <th>삭제여부</th>
                    <th>수정</th>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<PostVO> libraryList = (List<PostVO>) request.getAttribute("libraryList");

                if (libraryList != null && !libraryList.isEmpty()) {
                    for (PostVO post : libraryList) { 
                %>
                <tr>
                    <td><%= post.getPost_no() %></td>
                    <td><%= post.getPost_title() %></td>
                    <td><%= post.getPost_content() %></td>
                    <td><%= post.getCus_id() %></td>
                    <td><%= post.getPost_date() %></td>
                    <td><%= post.getPost_cnt() %></td>
                    <td><%= post.getPost_delyn() %></td>
                    <td class="actions">
                        <a href="#" class="editBtn" data-bs-toggle="modal" data-bs-target="#editModal"
                           data-post-no="<%= post.getPost_no() %>"
                           data-post-title="<%= post.getPost_title() %>"
                           data-post-content="<%= post.getPost_content() %>"
                           data-files-name="<%= post.getFiles_name() != null ? post.getFiles_name() : "" %>">수정</a>
                    </td>
                   <td class="actions">
  				 <a href="<%=request.getContextPath()%>/AdminTeacherLibraryDelete.do?post_no=<%= post.getPost_no() %>" 
     			  onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
				</td>
                </tr>
                <% 
                    } 
                } else { 
                %>
                <tr>
                    <td colspan="9">게시글이 없습니다.</td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>

    <!-- 수정 모달 -->
    <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editModalLabel">게시글 수정</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="editForm" action="<%=request.getContextPath()%>/AdminTeacherLibarayUpdate.do" method="post" enctype="multipart/form-data">
                        <input type="hidden" id="editPostNo" name="post_no">
                        <div class="mb-3">
                            <label for="editPostTitle" class="form-label">제목</label>
                            <input type="text" class="form-control" id="editPostTitle" name="post_title" required>
                        </div>
                        <div class="mb-3">
                            <label for="editPostContent" class="form-label">내용</label>
                            <textarea class="form-control" id="editPostContent" name="post_content" rows="3" required></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="editFile" class="form-label">파일 수정</label>
                            <input type="file" class="form-control" id="editFile" name="file_upload">
                            <p class="small" id="currentFile"></p>
                        </div>
                        <button type="submit" class="btn btn-primary">수정</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS 추가 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // 수정 버튼 클릭 시, 해당 게시글 데이터를 모달에 채우기
        document.addEventListener('DOMContentLoaded', function() {
            var editBtns = document.querySelectorAll('.editBtn');
            editBtns.forEach(function(btn) {
                btn.addEventListener('click', function() {
                    var postNo = btn.getAttribute('data-post-no');
                    var postTitle = btn.getAttribute('data-post-title');
                    var postContent = btn.getAttribute('data-post-content');
                    var currentFile = btn.getAttribute('data-files-name');
                    
                    // 모달 폼에 데이터 채우기
                    document.getElementById('editPostNo').value = postNo;
                    document.getElementById('editPostTitle').value = postTitle;
                    document.getElementById('editPostContent').value = postContent;
                    document.getElementById('currentFile').textContent = currentFile ? "현재 파일: " + currentFile : "파일 없음";
                });
            });
        });
    </script>
</body>
</html>