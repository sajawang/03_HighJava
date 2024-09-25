<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학생 수학 설정 관리</title>
	<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
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
            text-align: center;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        .button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            margin-top: 10px;
        }
        .button.delete {
            background-color: #f44336;
        }
        .button.edit {
            background-color: #008CBA;
        }
        .button:hover {
            opacity: 0.8;
        }
        .form-container {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .form-container input, .form-container select {
            padding: 10px;
            margin: 5px;
            width: 200px;
        }
        .form-container label {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h1>학생 수학 설정 관리</h1>

    <!-- 학생 목록을 표시할 테이블 -->
    <table id="mathSettingTable">
        <thead>
            <tr>
                <th>학생 ID</th>
                <th>수학 시간(분)</th>
                <th>학년</th>
                <th>난이도</th>
                <th>수정</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>

    <!-- 학생 등록 폼 -->
    <div class="form-container" id="studentFormContainer">
        <h3>학생 등록</h3>
        <form id="mathSettingForm">
            <label for="cusId">학생 ID:</label>
            <input type="text" id="cusId" name="cusId">

            <label for="minute">수학 시간(분):</label>
            <select id="minute" name="minute">
                <option value="10분">10분</option>
                <option value="20분">20분</option>
                <option value="30분">30분</option>
            </select>

           <label for="grade">학년:</label>
            <select id="grade" name="grade">
                <option value="초등 3학년 1학기">초등 3학년 1학기</option>
                <option value="초등 3학년 2학기">초등 3학년 2학기</option>
                <option value="초등 4학년 1학기">초등 4학년 1학기</option>
                <option value="초등 4학년 2학기">초등 4학년 2학기</option>
                <option value="초등 5학년 1학기">초등 5학년 1학기</option>
                <option value="초등 5학년 2학기">초등 5학년 2학기</option>
                <option value="초등 6학년 1학기">초등 6학년 1학기</option>
                <option value="초등 6학년 2학기">초등 6학년 2학기</option>
                <option value="중등 1학년 1학기">중등 1학년 1학기</option>
                <option value="중등 1학년 2학기">중등 1학년 2학기</option>
                <option value="중등 2학년 1학기">중등 2학년 1학기</option>
                <option value="중등 2학년 2학기">중등 2학년 2학기</option>
                <option value="중등 3학년 1학기">중등 3학년 1학기</option>
                <option value="중등 3학년 2학기">중등 3학년 2학기</option>

            </select>

            <label for="level">난이도:</label>
            <select id="level" name="level">
                <option value="기본">기본</option>
                <option value="심화">심화</option>
            </select>

            <!-- 등록하기 버튼 (기본으로 보임) -->
    <button type="button" class="button" id="submitButton" onclick="submitForm()">등록하기</button>

    <!-- 수정하기 버튼 (처음엔 숨김) -->
    <button type="button" class="button" id="updateButton" style="display:none;" onclick="updateForm()">수정하기</button>
        </form>
    </div>

 <script>
 $(function(){
	    loadMathSettings();  // 초기 데이터를 로드
	});

	function loadMathSettings() {
	    $.ajax({
	        url: "<%=request.getContextPath()%>/AdminTenList.do",
	        type: "GET",
	        data: { cus_id: 'studentList' },
	        success: function(response) {
	            console.log("서버 응답 데이터:", response);
	            var tableBody = $("#mathSettingTable tbody");
	            tableBody.empty();

	            if (response && response.length > 0) {
	                var code = '';
	                $.each(response, function(i, v) {
	                    code += '<tr><td>' + v.cus_id + '</td>' +
	                            '<td>' + v.mathsetting_minute + '</td>' +
	                            '<td>' + v.mathsetting_grade + '</td>' +
	                            '<td>' + v.mathsetting_level + '</td>' +
	                            '<td><button class="button edit" onclick="editSetting(\'' + v.cus_id + '\')">수정</button></td>' +
	                            '<td><button class="button delete" onclick="deleteSetting(\'' + v.cus_id + '\')">삭제</button></td></tr>';
	                });
	                tableBody.html(code);
	            } else {
	                tableBody.html('<tr><td colspan="6">목록이 없습니다.</td></tr>');
	            }
	        },
	        error: function(xhr) {
	            console.log("에러 발생: ", xhr.status, xhr.responseText);
	            alert("응답 코드: " + xhr.status);
	        },
	        dataType: "json"
	    });
	}
	
	 function deleteSetting(cusId) {
	        if (confirm("정말 삭제하시겠습니까?")) {
	            $.ajax({
	                url: "<%=request.getContextPath()%>/Adminmathdelete.do",
	                type: "POST",
	                data: { cusId: cusId }, 
	                success: function() {
	                    $("#mathSettingTable tbody tr").filter(function() {
	                        return $(this).find("td:first").text() === cusId;
	                    }).remove();

	                    alert("삭제되었습니다.");
	                },
	                error: function(xhr) {
	                    alert("삭제 중 오류 발생");
	                }
	            });
	        }
	    }
	
	function submitForm() {
	    var cusId = $("#cusId").val();
	    var minute = $("#minute").val();
	    var grade = $("#grade").val();
	    var level = $("#level").val();

	    $.ajax({
	        url: "<%=request.getContextPath()%>/AdminmathInsert.do",  // 등록용 URL
	        type: "POST",
	        data: {
	            cus_Id: cusId, 
	            mathsetting_minute: minute,
	            mathsetting_grade: grade,
	            mathsetting_level: level
	        },
	        dataType: "json",  // 서버에서 받은 응답을 JSON으로 자동 파싱
	        success: function(response) {
	            // 서버로부터 JSON 응답을 받았을 경우 처리
	            if (response.status === "success") {
	                alert("등록이 성공적으로 처리되었습니다.");
	                resetForm();
	                loadMathSettings();  // 테이블 갱신
	            } else {
	                alert("등록에 실패했습니다: " + response.message);
	            }
	        },
	        error: function(xhr) {
	            alert("오류가 발생했습니다. 다시 시도해 주세요.");
	        }
	    });
	}

	function updateForm() {
	    var cusId = $("#cusId").val();
	    var minute = $("#minute").val();
	    var grade = $("#grade").val();
	    var level = $("#level").val();

	    $.ajax({
	        url: "<%=request.getContextPath()%>/AdminmathUpdate.do",  // 수정용 URL
	        type: "POST",
	        data: {
	            cus_Id: cusId, 
	            mathsetting_minute: minute,
	            mathsetting_grade: grade,
	            mathsetting_level: level
	        },
	        success: function(response) {
	            if (response === "success") {
	                alert("수정이 성공적으로 처리되었습니다.");
	                resetForm();
	                loadMathSettings();  // 테이블 갱신
	            } else {
	                alert("수정에 실패했습니다.");
	            }
	        },
	        error: function(xhr) {
	            alert("오류가 발생했습니다. 다시 시도해 주세요.");
	        }
	    });
	}

	function editSetting(cusId) {
	    $.ajax({
	        url: "<%=request.getContextPath()%>/AdminmathUpdate.do",  // 수정 데이터 조회용 URL
	        type: "GET",
	        data: { cus_id: cusId },
	        success: function(data) {
	            if (data && data.cus_id) {
	                $("#cusId").val(data.cus_id);
	                $("#minute").val(data.mathsetting_minute);
	                $("#grade").val(data.mathsetting_grade);
	                $("#level").val(data.mathsetting_level);

	                // 수정 모드로 전환: 등록 버튼을 숨기고, 수정 버튼을 표시
	                $("#submitButton").hide();
	                $("#updateButton").show();
	            } else {
	                alert("학생 데이터를 불러오는 중 문제가 발생했습니다.");
	            }
	        },
	        error: function(xhr) {
	            alert("학생 정보를 가져오는 중 오류가 발생했습니다.");
	        }
	    });
	}

	function resetForm() {
	    // 폼을 초기화
	    $("#cusId").val("");
	    $("#minute").val("10분");
	    $("#grade").val("초등 3학년 1학기");
	    $("#level").val("기본");

	    // 등록 모드로 돌아가기: 수정 버튼을 숨기고, 등록 버튼을 보이게 설정
	    $("#submitButton").show();
	    $("#updateButton").hide();
	}
</script>
</body>
</html>