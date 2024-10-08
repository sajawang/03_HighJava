<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.MaterialVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../mainScript.jsp" %>
<title>스스로 수학 - 학습지</title>
<style type="text/css">
	.action, .action2{
		border: 1px solid #d6d6d6;
	    width: calc(80% / 4);
	    float: left;
	    height: 41px;
	    line-height: 1;
	    padding: 5px 22px;
	    word-break: keep-all;
	    background: #fff;
	    font-size: 1.5rem;
	    color: #9a9a9a;
	    position: relative;
	}
	.hakki{
	 	float: left;
	 	/* width: calc(100% - 6.2rem); */
	 	overflow: hidden;
	 	margin: 4px;
	}
	
	.mactive {
		border: 1px solid black;
    	color: black;
	}
	
	.pagination1{
	    display: inline-block;
	    padding-left: 0;
	    margin: 20px 0;
	    border-radius: 4px;
	}
	.pagination1>li{
		display : inline;	
	}
	.active{
		width: 100%
		margin : auto;
		min-height: 200px;
	}
	
	.pagination1>li:first-child>a {
		margin-left: 0;
	}
	
	.pagination1>.active>a, .pagination1>.active>a:focus, .pagination1>.active>a:hover {
	    z-index: 3;
	    color: black;
	    cursor: default;
	}
	
	.pagination1>li>a{
	    position: relative;
	    float: left;
	    padding: 6px 12px;
	    margin-left: -1px;
	    line-height: 1.42857143;
	    color: #337ab7;
	    text-decoration: none;
	    background-color: #fff;
	}
</style>
<script type="text/javascript">
mypath =  '<%= request.getContextPath()%>';
currentPage = 1;
$(function(){
	$.listPageServer2();
	
	// 다음 버튼 이벤트
	$(document).on('click', '#next', function(){
		// 나열되어 있는페이지 번호들(pageno)의 마지막 값을 가져온다.
		currentPage = parseInt($('.pageno').last().text()) + 1;
		$.listPageServer2();
	})
	// 이전 버튼 이벤트
	$(document).on('click', '#prev', function(){
		currentPage = parseInt($('.pageno').first().text()) - 1;
		$.listPageServer2();
	})
	// 페이지 번호 클릭 이벤트
	$(document).on('click', '.pageno', function(){
		currentPage = parseInt( $(this).text() );
		$.listPageServer2();
	})
	
	$(document).on('click', '.action', function(){
		currentPage = 1;
		target = $(this);
		cate = target.attr('data-cate');
		$('.action').removeClass('mactive');
		$(this).addClass('mactive');
		$('#cate').val(cate);
		$.listPageServer2();
	})
	
	$(document).on('click', '.action2', function(){
		currentPage = 1;
		target = $(this);
		level = target.attr('data-level');
		$('.action2').removeClass('mactive');
		$(this).addClass('mactive');
		$('#level').val(level);
		$.listPageServer2();
	})
})
</script>
</head>
<%
	List<MaterialVO> materList = (List<MaterialVO>)request.getAttribute("materList");
	String school = (String) request.getParameter("school");
	String grade = (String) request.getParameter("grade");
	String cate = (String) request.getParameter("cate");
	String level = (String) request.getParameter("level");
	//int cnt = (int)request.getAttribute("cnt");
	String schooltxt = ""; 
	
	if(school.equals("element") || school == "element"){
		schooltxt = "초등";
	} else if (school.equals("middle") || school == "middle"){
		schooltxt = "중";
	} else if (school.equals("high") || school == "high"){
		schooltxt = "고등";
	}
	
%>
<body>
<jsp:include page="../header.jsp" />
	<article>
		<section style="background-color: #F8FAFF; padding-bottom: 10px;">
			<input type="hidden" name="school" id="school" value="<%=school%>">
			<input type="hidden" name="grade" id="grade" value="<%=grade%>">
			<input type="hidden" name="cate" id="cate" value="1">
			<input type="hidden" name="level" id="level" value="basic">
			<div style="margin: 32px 32px 32px 60px; padding: 10px;">
				<h3 style="font-size: 2.8rem; font-weight: bold;"><%=schooltxt%>학교 <%=grade%>학년</h3>
				<ul style="list-style: none; padding-left: 0px;">
					<li style="display:flex; margin: 20px 0px 20px 0px;">
						<div class="hakki">
							<strong style="display: inline-block; font-size: 2rem; width: 62px;">학기</strong>
						</div>
						<div style="width:100%">
							<button type="button" class="action mactive" data-cate="1" >1학기</button>
							<button type="button" class="action" data-cate="2" >2학기</button>											
						</div>
					</li>
					<li  style="display:flex; margin: 20px 0px 20px 0px;">
						<div class="hakki"> <!-- width: calc(100% - 6.2rem); -->
							<strong style="display: inline-block; font-size: 2rem; width: 62px;">난이도</strong>
						</div>
						<div style="width:100%">
							<button type="button" class="action2 mactive" data-level="basic" >기본</button>
							<button type="button" class="action2" data-level="deep" >심화</button>						
						</div>
					</li>
				</ul>
			</div>
		</section>
		<section>
			<div style="margin: 15px 10px 10px 20px;">
				<%-- <span>총 <%=cnt %>건의 컨텐츠가 있습니다.</span> --%>
			</div>
			<ul id="result" style="width: 100%; display: flex; flex-wrap: wrap; justify-content: flex-start; margin: 3.2rem 0 0 0;">
				<%
					for(MaterialVO vo : materList) {
				%>
				<li style="list-style: none; margin: 10px; flex: 1;" onclick="location.href='<%=request.getContextPath()%>/material/detailMaterial.do?mno=<%=vo.getMaterial_no()%>'">
					<div>
						<div class="thumnail">
							<img alt="" src="<%=request.getContextPath() %>/images/imageView.do?path=<%=vo.getFiles_name() %>">
						</div>
						<div>
							<p><strong><%=vo.getMaterial_grade() %></strong><span> | <%=vo.getMaterial_level() %></span></p>
							<p><strong><%=vo.getMaterial_title() %></strong></p>
						</div>
					</div>
				</li>
				<%
					}
				%>
			</ul>
		</section>
	</article>
	<div id="pagelist" style="width:100%; text-align:center;">
		
	</div>
	
<jsp:include page="../footer.jsp" />
</body>
</html>