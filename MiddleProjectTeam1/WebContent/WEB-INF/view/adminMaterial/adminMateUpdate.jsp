<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.QuestionVO"%>
<%@page import="kr.or.ddit.vo.MaterialVO"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style type="text/css">
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
            font-weight: bold;
        }

        table {
            width: 100%;
            max-width: 800px;
            margin: 0 auto;
            border-collapse: collapse;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            border-radius: 8px;
            overflow: hidden;
        }

        table, tr, td {
            border: none;
        }

        td {
            padding: 15px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        td:first-child {
            width: 30%;
            font-weight: bold;
            background-color: #f7f7f7;
        }

        td input[type="text"], 
        td input[type="file"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        td input[type="text"]:focus, 
        td input[type="file"]:focus {
            outline: none;
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }

        td img {
            display: block;
            margin: 0 auto;
            max-width: 100%;
            height: auto;
            border-radius: 8px;
        }

        button, input[type="button"], input[type="reset"] {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: white;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
             margin: 5px; /* 버튼 간 간격 추가 */
   			 display: inline-block;
        }

        button:hover, input[type="button"]:hover, input[type="reset"]:hover {
            background-color: #0056b3;
        }

        input[type="reset"] {
            background-color: #6c757d;
        }

        input[type="reset"]:hover {
            background-color: #5a6268;
        }

        #res {
            max-width: 800px;
            margin: 20px auto;
        }

        @media screen and (max-width: 768px) {
            table {
                width: 100%;
            }

            td {
                display: block;
                width: 100%;
                text-align: center;
            }

            td:first-child {
                width: 100%;
                background-color: transparent;
            }

            td input[type="text"],
            td input[type="file"] {
                width: calc(100% - 20px);
                margin: 10px 0;
            }
            
            .form-buttons {
   			 text-align: center;
			}
            button#send {
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    background-color: #007bff; /* 파란색 */
    color: white;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s ease;
    margin: 5px; /* 버튼 간 간격 추가 */
    display: inline-block;
}
        }
    </style>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.serializejson.min.js"></script>



<script >


<%
// QuestionVO qVo = null;
	MaterialVO mateVo = (MaterialVO) request.getAttribute("mateVo");
	List<QuestionVO> qList = (List<QuestionVO>)request.getAttribute("qVoList");
	
	int queNo = 0;
	int mateNo = 0;
	String queCon = "";
	String queAns = "";
	String queSol = "";
	Integer filesNo = 0;
	
	Integer fileN=null;
	fileN=mateVo.getFiles_no();
	int j = 0;
	
	%>

	
	
	
	$(function(){
	    let i = 0;
	    let j = <%=j%>
	    var rdw = 0;
	    let x = 0;
	    let mypath = '<%=request.getContextPath()%>';
	    
	    $("#btnList").on("click", function() {
	        let code = '';
	        
	        code += '<form enctype="multipart/form-data" id="queUpdate" method="get" action="'+mypath+'/adminQueUpdate.do">';
	        code += '<table border="1">';
	        code += '<tbody>';
	    
	        rdw++;
	        x++;
	        
	        <% for(QuestionVO qvo : qList) {
	        	j++;
	        	
	            queNo = qvo.getQuestion_no();
	            mateNo = qvo.getMaterial_no();
	            queCon = qvo.getQuestion_content();
	            queAns = qvo.getQuestion_answer();
	            queSol = qvo.getQuestion_solve();

	            filesNo = qvo.getFiles_no();
	            
	            
	        %>
	        
	        code += '<input type="hidden" name="question_no'+i+'" id="question_no" value="<%=queNo%>">';
	        code += '<input type="hidden" name="files_no'+i+'" value="<%=filesNo == null ? "" : filesNo %>">';
	        code += '<input type="hidden" name="material_no'+i+'" id="material_no" value="<%=mateNo%>">';
	        
	        
	        code += `<tr><td colspan="2" style="text-align:center;">`;
	        code += `<img src="<%=request.getContextPath()%>/adminMateQueImageView2.do?qno=<%=queNo%>" width="200" height="140">`;
	        code += `</td></tr>`;
	        
// 	        code += '<tr><td>학습지번호 '+j+'</td>';
<%-- 	        code += '<td><input type="text" name="material_no'+i+'" id="material_no" value="<%=mateNo%>"></td></tr>'; --%>
	        
	        code += '<tr><td>문제 내용 '+<%=j%>+'</td>';
	        code += '<td><input type="text" name="question_content'+i+'" id="question_content" value="<%=queCon%>"></td></tr>';
	        
	        code += '<tr><td>문제 정답 '+<%=j%>+'</td>';
	        code += '<td><input type="text" name="question_answer'+i+'" id="question_answer" value="<%=queAns%>"></td></tr>';
	        
	        code += '<tr><td>문제 풀이 '+<%=j%>+'</td>';
	        code += '<td><input type="text" name="question_solve'+i+'" id="question_solve" value="<%=queSol%>"></td></tr>';
	        
	        code += '<tr><td>문제 사진 '+<%=j%>+'</td>';
	        code += `<td><input type="file" id="files_no" ></td></tr>`;
	        i++;
	        <% } %>
	        
	        code += `<tr><td colspan="2" style="text-align:center;">`;
	        code += `<input type="submit" value="저장">`;
	        code += `<input type="button" id="backbtnList" value="학습지 등록 취소 목록으로 돌아가기">`;
	        code += `</td></tr>`;
	        
	        code += `</tbody></table></form>`;
	        
	        $('#res').html(code);
	        let dd = $('#queUpdate').serializeJSON();
	        console.log(dd);
	    });

	
	$('#send').on('click',function(){
		//입력한 모든 값 가져오기

		
		fdata3=$('#ff').serializeJSON();
		console.log(fdata3);
		
		$.ajax({
			url:'/MiddleProjectTeam1/adminMateUpdate.do',
			data:JSON.stringify(fdata3),//script객체를 json형식의 문자열로 직렬화
			type:"post",
			contentType:'application/json',
			success:function(res){
// 			$('#joinspan').html(res.flag).css('color','aqua');
				alert("학습지가 수정되었습니다.");
			
				location.href='adminmaterialList.do';
			
			},
			error : function(xhr){
				alert("오류 : " + xhr.status);
			},
			dataType:'json' //res json 형식의 문자열 -script 객체로 역직렬화
		})
	})
	
	  $(document).on("click", "#backbtnList", function() {
      location.href = '<%=request.getContextPath()%>/adminmaterialList.do'; // 목록으로 돌아가기 URL
		});
});
</script>


</head>
<body>

<h2>문제집 정보 설정</h2>
<form action="<%=request.getContextPath()%>/adminMateUpdate.do" 
		method="post" enctype="multipart/form-data" id="ff">
	<input type="hidden" name="material_no" value="<%=mateVo.getMaterial_no()%>">
	<input type="hidden" name="files_no" value="<%=fileN == null ? "" : fileN %>">
	
<table border="1">
<tbody>
	
	<tr>
	<td colspan="2" style="text-align:center;">
		<img src="<%=request.getContextPath() %>/adminMateQueImageView.do?mno=<%=mateVo.getMaterial_no() %>" width="200" height="140">
		</td>
	</tr>
	<tr>
		<td>학습지 제목</td>
		<td><input type="text" name="material_title" value="<%=mateVo.getMaterial_title() %>"></td>
	</tr>
	<tr>
		<td>학습지 설명</td>
		<td><input type="text" name="material_des" value="<%=mateVo.getMaterial_des()%>"></td>
	</tr>
	<tr>
		<td>학습지 학년</td>
		<td><input type="text" name="material_grade" value="<%=mateVo.getMaterial_grade()%>"></td>
	</tr>
	<tr>
		<td>난이도 등급</td>
		<td><input type="text" name="material_level" value="<%=mateVo.getMaterial_level()%>"></td>
	</tr>
	
	<tr>
		<td>첨부파일</td>
		<td><input type="file" name="material_file" value="<%=mateVo.getFiles_no()%>"></td>
	</tr>	
	
	<tr>
		<td colspan="2" style="text-align:center;">
			<button type="button" id='send' >학습지 수정</button>
			<input type="button" id="btnList" value="문제목록 확인하기"></td>
			<!-- <input type="reset" value="취소">  -->
			
			
			
	</tr>
</tbody>
</table>
</form>
<div id = res>

</div>

</body>
</html>