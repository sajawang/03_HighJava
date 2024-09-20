<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.MaterialVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.serializejson.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/material.js?v=<%=System.currentTimeMillis()%>"></script>
<title>Insert title here</title>
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
	
	.active {
		border: 1px solid black;
    	color: black;
	}
</style>
<script type="text/javascript">
mypath =  '<%= request.getContextPath()%>';
currentPage = 1;
$(function(){
	$.listPageServer();
	
	// 다음 버튼 이벤트
	$(document).on('click', '#next', function(){
		// 나열되어 있는페이지 번호들(pageno)의 마지막 값을 가져온다.
		currentPage = parseInt($('.pageno').last().text()) + 1;
		$.listPageServer();
	})
	// 이전 버튼 이벤트
	$(document).on('click', '#prev', function(){
		currentPage = parseInt($('.pageno').first().text()) - 1;
		$.listPageServer();
	})
	// 페이지 번호 클릭 이벤트
	$(document).on('click', '.pageno', function(){
		currentPage = parseInt( $(this).text() );
		$.listPageServer();
	})
	
	$(document).on('click', '.action', function(){
		target = $(this);
		cate = target.attr('data-cate');
		$('.action').removeClass('active');
		$(this).addClass('active');
		$('#cate').val(cate);
		$.listPageServer();
	})
	
	$(document).on('click', '.action2', function(){
		target = $(this);
		level = target.attr('data-level');
		$('.action2').removeClass('active');
		$(this).addClass('active');
		$('#level').val(level);
		$.listPageServer();
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
	int cnt = (int)request.getAttribute("cnt");
%>
<body>
	<%-- <jsp:include page="../header.jsp" /> --%>
	<article>
		<section style="background-color: #F8FAFF; padding-bottom: 10px;">
			<input type="hidden" name="school" id="school" value="<%=school%>">
			<input type="hidden" name="grade" id="grade" value="<%=grade%>">
			<input type="hidden" name="cate" id="cate" value="1">
			<input type="hidden" name="level" id="level" value="basic">
			<div style="margin: 32px 32px 32px 60px;">
				<h3 style="font-size: 2.8rem; font-weight: bold;">초등학교 3학년</h3>
				<ul style="list-style: none; padding-left: 0px;">
					<li style="display:flex; margin: 20px 0px 20px 0px;">
						<div class="hakki">
							<strong style="display: inline-block; font-size: 2rem; width: 62px;">학기</strong>
						</div>
						<div style="width:100%">
							<button type="button" class="action active" data-cate="1" >1학기</button>
							<button type="button" class="action" data-cate="2" >2학기</button>											
						</div>
					</li>
					<li  style="display:flex; margin: 20px 0px 20px 0px;">
						<div class="hakki"> <!-- width: calc(100% - 6.2rem); -->
							<strong style="display: inline-block; font-size: 2rem; width: 62px;">난이도</strong>
						</div>
						<div style="width:100%">
							<button type="button" class="action2 active" data-level="basic" >기본</button>
							<button type="button" class="action2" data-level="deep" >심화</button>						
						</div>
					</li>
				</ul>
			</div>
		</section>
		<section>
			<div>
				<span>총 <%=cnt %>건의 컨텐츠가 있습니다.</span>
			</div>
			<ul id="result" style="width: 100%; display: flex; flex-wrap: wrap; justify-content: flex-start; margin: 3.2rem 0 0 0;">
				<%
					for(MaterialVO vo : materList) {
				%>
				<li style="list-style: none; margin: 10px;" onclick="location.href='<%=request.getContextPath()%>/material/detailMaterial.do?mno=<%=vo.getMaterial_no()%>'">
					<div>
						<div class="thumnail">
							<img alt="" src="<%=request.getContextPath() %>/images/<%=vo.getFiles_name() %>">
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
	<%-- <jsp:include page="../footer.jsp" /> --%>
</body>
</html>