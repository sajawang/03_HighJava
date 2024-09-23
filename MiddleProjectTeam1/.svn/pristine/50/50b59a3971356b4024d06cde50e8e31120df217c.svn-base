
<%@page import="kr.or.ddit.vo.MaterialVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {
		border : 1px solid black;
		
	}
	.bl{
		border-bottom: 1px solid #e1e1e1;
	}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<script type="text/javascript">
	$(()=>{
		
	})
	function scoreCheck(){
			$(document).on('click','.score', function(){
				test1 = $('#test1').val();
				test2 = $('#test2').val();
				test3 = $('#test3').val();
				test4 = $('#test4').val();
				test5 = $('#test5').val();
				mno = $('#mno').val();
				console.log(test1);
				console.log(test2);
				console.log(test3);
				console.log(test4);
				console.log(test5);
				
				$.ajax({
					url : '<%=request.getContextPath() %>/material/scoreCheck.do',
					type : "post",
					data : {'test1' : test1, 'test2' : test2, 'test3' : test3, 'test4' : test4, 'test5' : test5, 'mno' : mno},
					success : res => {
						console.log(res);
					},
					error : xhr =>{
						alert("오류 : " + xhr.status);
					},
					dataType : 'json'
				})
			})
	}
</script>
<%
	List<MaterialVO> materList = (List<MaterialVO>)request.getAttribute("materList");
	int cnt = 0;
	int mno = (int)request.getAttribute("mno");
%>
</head>
<body>
	<h3>Play Material</h3>
	<div style="width : 30%;">
		<div  class=".bl" style="text-align:right;">
			<input type="hidden" id="mno" value="<%=mno %>">
			<button type="button" class="score" onclick="scoreCheck()">채점</button>
		</div>
		<%
			if(materList == null || materList.size() == 0 ) {
		%>
				<div><span>왜없어?</span></div>
		<%
			} else {
				for(MaterialVO vo : materList) {
					cnt++;
		%>
		<div class=".bl">
			<div>
				<div>
					<span><%=cnt %>.</span>
					<span><%=vo.getQuestion_content() %></span>
				</div>
				<div>
					<img alt="<%=vo.getFiles_name() %>" src="<%=request.getContextPath()%>/images/<%=vo.getFiles_name() %>">
				</div>
				<div>
					<input type="text" id="test<%=cnt %>" name="test<%=cnt %>" >
				</div>
			<%
				
			%>
				<div>
					
				</div>
				
				<div>
					
				</div>
				
				<div>
					
				</div>
			<%
				
			%>
			</div>
		</div>
		<%
				}
			}
		%>
		<div  class=".bl" style="text-align:right;">
			<button type="button" class="score" onclick="scoreCheck()">채점</button>
		</div>
	</div>
</body>
</html>