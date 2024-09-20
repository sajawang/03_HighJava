<%@page import="kr.or.ddit.vo.FileVO"%>
<%@page import="kr.or.ddit.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 관리</title>
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
</style>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
</head>
<body>
<% List<PostVO> noticeList = (List<PostVO>) request.getAttribute("noticeList"); 
List<FileVO> fileList = (List<FileVO>) request.getAttribute("fileList");
%>
<div class="container">

    <h1>공지사항</h1>

    <!-- 검색 기능 추가 -->
    <div class="search-container">
        <select id="searchType">
            <option value="all">전체</option>
            <option value="author">작성자</option>
            <option value="title">제목</option>
            <option value="content">내용</option>
        </select>
        <input type="text" id="searchKeyword" placeholder="Search">
        <button onclick="searchNotice()">Search</button>
    </div>

    <!-- 공지사항 등록 버튼 -->
    <a id="openRegisterModal" href="javascript:void(0)">공지사항 등록</a>
    
    <!-- 공지사항 모달 -->
    <div id="noticeModal" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <h2 id="modalTitle">공지사항 작성하기</h2>
            <form id="noticeForm" method="post" action="<%=request.getContextPath()%>/AdminNoticeInsert.do" enctype="multipart/form-data">
                <input type="hidden" id="post_no" name="post_no">
                
                  <label for="cus_id">관리자</label>
                  <input type="text" id="cus_id" name="cus_id" required>

                <label for="post_title">제목</label>
                <input type="text" id="post_title" name="post_title" required>

                <label for="post_content">내용</label>
                <textarea id="post_content" name="post_content" rows="5" required></textarea>
				
				 <label for="file">파일 업로드</label>
                <input type="file" id="file" name="file" accept="image/*, .pdf, .doc, .docx">
              
                <button type="submit" id="submitBtn">작성하기</button>
            </form>
        </div>
    </div>

    <!-- 공지사항 테이블 -->
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
                <th>수정</th>
                <th>삭제</th>
            </tr>
        </thead>
       <tbody>
<%  

 if (noticeList != null && !noticeList.isEmpty()) { 
    for(PostVO pvo : noticeList) {
%>



						<!-- postVo에 있는 값 불러서 list 출력하기 -->
            <tr>
                <td><%=pvo.getPost_no()%></td>
                <td><%=pvo.getPost_title() %></td>
                <td><%=pvo.getPost_content() %></td>
                <td><%=pvo.getCus_id() %></td>
                <td><%=pvo.getPost_date() %></td>
                <td><%=pvo.getPost_cnt() %></td>
                <td><%=pvo.getPost_delyn() %></td>
                <td><%=pvo.getFiles_no()%></td>
              
                
                <!--등록하기  -->
                <td><a class="editBtn" href="javascript:void(0)"
                       data-post-no="<%=pvo.getPost_no()%>" 
                       data-title="<%=pvo.getPost_title() %>" 
                       data-content="<%=pvo.getPost_content() %>" 
                       data-author="<%=pvo.getCus_id() %>"> 수정 </a></td>
         
               <td><a class="deleteBtn" href="javascript:void(0)" 
       data-post-no="<%=pvo.getPost_no()%>">삭제</a></td>
            </tr>
<%
    }
} else {
%>
    <tr>
        <td colspan="10">공지 사항 목록이 없습니다.</td>
    </tr>
<%
}
%>
</tbody>
    </table>
</div>

<script>
document.addEventListener("DOMContentLoaded", function() {
    const modal = document.getElementById('noticeModal');
    const openRegisterBtn = document.getElementById('openRegisterModal'); // 등록 버튼
    const closeModalBtn = document.getElementsByClassName('close')[0];
    const submitBtn = document.getElementById('submitBtn');
    const modalTitle = document.getElementById('modalTitle');
    const noticeForm = document.getElementById('noticeForm');
    const editBtns = document.querySelectorAll('.editBtn');
    
    // 등록 모달 열기
    openRegisterBtn.addEventListener('click', function() {
        modal.style.display = 'block';
        modalTitle.innerText = '공지사항 작성하기';
        submitBtn.innerText = '작성하기';
        
        // 등록 모드로 전환 ''을 이용해서 빈칸으로 만들기
        noticeForm.action = '<%=request.getContextPath()%>/AdminNoticeInsert.do';
        document.getElementById('post_no').value = '';
        document.getElementById('cus_id').value = '';
        document.getElementById('post_title').value = '';
        document.getElementById('post_content').value = '';
        document.getElementById('files').value = '';
    });

    // 수정 모달 열기
    editBtns.forEach(function(btn) {
        btn.addEventListener('click', function() {
            modal.style.display = 'block';
            modalTitle.innerText = '공지사항 수정하기';
            submitBtn.innerText = '수정하기';
            
            // 수정 모드로 전환
            const post_no = btn.getAttribute('data-post-no');
            const title = btn.getAttribute('data-title');
            const content = btn.getAttribute('data-content');
            const author = btn.getAttribute('data-author');
            
            document.getElementById('post_no').value = post_no;
            document.getElementById('cus_id').value = author;
            document.getElementById('post_title').value = title;
            document.getElementById('post_content').value = content;

            // 수정할 때의 action 설정
            noticeForm.action = '<%=request.getContextPath()%>/AdminNoticeUpdate.do';
        });
    });

    // 모달 닫기
    closeModalBtn.onclick = function() {
        modal.style.display = 'none';
    }

    // 모달 외부 클릭 시 닫기
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = 'none';
        }
    }
})

document.querySelectorAll('.deleteBtn').forEach(function(btn) { 
    btn.addEventListener('click', function() {
        if (confirm("진짜 삭제하시겠습니까?")) {
            const post_no = btn.getAttribute('data-post-no');
            
            // Ajax를 통해 서버로 삭제 요청을 보냅니다.
            $.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>/AdminNoticeDelete.do",  // 삭제 처리할 URL
                data: { post_no: post_no },
                success: function(response) {
                    // 성공적으로 삭제된 후 리스트를 다시 로드하거나 페이지를 리다이렉트
                    alert("삭제되었습니다.");
                    location.href = "<%=request.getContextPath()%>/AdminNoticeList.do";  // 리스트 페이지로 리다이렉트
                },
                error: function() {
                    alert("삭제 중 오류가 발생했습니다.");
                }
            });
        }
    });
});
</script>

</body>
</html>