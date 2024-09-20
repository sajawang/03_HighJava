<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>공지사항 작성</title>
    <style>
        /* 기본 스타일 설정 */
        body {
            font-family: Arial, sans-serif;
        }

        /* 모달 창 숨기기 (기본값) */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5); /* 반투명 배경 */
        }

        /* 모달 콘텐츠 스타일 */
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 50%;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        }

        /* 닫기 버튼 스타일 */
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

        /* 폼 스타일 */
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
    </style>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>



</head>
<body>
    <button id="openModal">공지사항 작성</button>

    <div id="modal" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
           <h2>공지사항 작성하기</h2>
            <form id="noticeForm" method="post" 	action="<%=request.getContextPath()%>/AdminNoticeInsert.do" enctype="multipart/form-data" >
                <label for="cus_id">관리자</label>
                <input type="text" id="cus_id" name="cus_id" required>
                
                <label for="post_title">제목</label>
                <input type="text" id="post_title" name="post_title" required>

                <label for="post_content">내용</label>
                <textarea id="content" name="post_content" rows="5" required></textarea>

				<label for="file">파일 업로드</label>
				<input type="file" id="files_no" name="files_no">
	
                <button type="submit">작성하기</button>
            </form>
        </div>
    </div>

    <script>
        // 모달 관련 요소들 선택
        const modal = document.getElementById('modal');
        const openModalBtn = document.getElementById('openModal');
        const closeModalBtn = document.getElementsByClassName('close')[0];

        // 모달 열기
        openModalBtn.onclick = function() {
            modal.style.display = 'block';
        }

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

     // 폼 제출 시 모달 닫기 (데이터 처리 가능)
        const noticeForm = document.getElementById('noticeForm');
        noticeForm.onsubmit = function(event) {
          
        
            // 모달 닫기
            modal.style.display = 'none';
        }
    </script>
</body>
</html>