<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>>자료 등록</title>
  <style>
        .container {
            width: 60%;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .container label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }
        .container input[type="text"],
        .container textarea {
            width: 100%;
            padding: 15px; /* 패딩을 늘려서 입력 필드를 크게 만듭니다 */
            margin-bottom: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 18px; /* 폰트 크기를 크게 조정 */
        }
        .container textarea {
            height: 200px; /* 텍스트 영역의 높이를 크게 조정 */
        }
        .container input[type="file"] {
            margin-bottom: 12px;
        }
        .container input[type="submit"] {
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .container input[type="submit"]:hover {
            background-color: #218838;
        }
       
        #fileNameDisplay {
            margin-top: 10px;
            font-style: italic;
            color: #555;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>선생님 자료 등록</h2>
    <form action="<%=request.getContextPath()%>/AdminTeacherLibraryInsert.do" 
    method="post" enctype="multipart/form-data">
       
       
        <label for="post_gu">학년선택</label>
		<select id="post_gu" name="post_gu" required>
    	
    	<option value="초등5">초등5</option>
    	<option value="초등6">초등6</option>
    	<option value="중등1">중등1</option>
    	<option value="중등2">중등2</option>
    	<option value="중등3">중등3</option>
    	<option value="고등1">고등1</option>
    	<option value="고등2">고등2</option>
    	<option value="고등3">고등3</option>
	</select>
        
        
        <label for="title">제목</label>
        <input type="text" id="title" name="post_title" required>

        <label for="content">내용</label>
        <textarea id="content" name="post_content" required></textarea>

        <label for="file">파일 선택</label>
        <input type="file" id="file" name="file_upload" required>

        <input type="submit" value="등록">
    </form>
</div>

</body>
</html>

</head>

