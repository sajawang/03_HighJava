<%@page import="kr.or.ddit.vo.ViewListVO"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    



<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
   <script src="../js/jquery.serializejson.min.js"></script>
  <%
  	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter format=DateTimeFormatter.ofPattern("yy/MM/dd");
	String str = now.format(format);
	
// 	ViewListVO date = (ViewListVO)session.getAttribute("vVo");
// 	String dada = date.getView_date();
	
	String id = "";
		id = (String)session.getAttribute("id");
	
	boolean tf = true;
	String dada= "";
	
	if(id!=null){
		
		dada=(String)session.getAttribute("sysdate");
	}
	
	System.out.println(str + " " + dada);
	
// 	boolean tf = false;
	int key = 0;
	String suc="";
	
	if(str.equals(dada)){
		key=100;
	suc="오늘 학습지를 풀었습니다.";
	}
	
	//2. 전체 학습지중 접속 기록만 있는 학습지만 체크 됨.
	Integer countMate = 0 ;
	Integer countViewList = 0;
	double nano =0;

if(id!=null){
	
 countMate = (Integer) session.getAttribute("countMate");

	countViewList=(Integer)session.getAttribute("countViewList");
	 nano =(double)countViewList/countMate*100;
	
}
System.out.println(countMate+" "+countViewList +" "+ nano);

  %>


<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#gogo {
    width: 350px;
    height: 220px;
    border: 1px solid red;
  }

  .graph {
    background-color: #dadced;
    height: 25px;
    display: flex;
    align-items: center;
    border-radius: 100px;
    overflow: hidden;
    position: relative;
  }

  .graph-wrap {
    max-width: 300px;
    margin: 0 auto;
    margin-top: 5%;
  }

  .tit {
    font-weight: bold;
    padding-bottom: 10px;
  }

  /* 왼쪽에 붙는 데이터 블록 */
  .data.data1 {
    background-color: #eb8686;
    width: 20%; /* 너비는 데이터 값에 따라 조정 */
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  /* 텍스트를 가운데에 배치 */
  .data.data2 {
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    z-index: 1;
    color: black;
/*     background: linear-gradient(90deg, #fdfbfb 0%, #ebedee 100%); */
  }

  /* 오른쪽에 붙는 데이터 블록 */
  
  #dw {
    text-align: center;
  }
</style>


<script type="text/javascript">

let ko = <%=key%>;
function graph(id,g1,g2,g3){
	  var target = $("#"+id);
	  var arr = [g1, g2, g3];
	  
	  $(target).find(".data").each(function(i){
	    $(this).css("width",arr[i] + "%");
	  })
	}

	$(document).ready(function(){
	  graph("graph1", <%=key%>);
	  graph("graph2", <%=nano%>);
	  graph("graph3", 0);
	})
	
	
	
</script>
</head>
<body>
<div id="gogo">
<div class="graph-wrap" id="graph1">
  <a class="tit">일일 학습지</a>
  <div class="graph" >
    <div class="data data1" id="dw"><%=suc %></div>
    <div class="data data2"></div>
    <div class="data data3"></div>
  </div>
</div> 

<div class="graph-wrap" id="graph2">
  <a class="tit">내가 푼 학습지 갯수</a>
  <div class="graph" >
    <div class="data data1"></div>
    <div class="data data2"><%=countViewList  %> / <%=countMate%></div>
    <div class="data data3"></div>
  </div>
</div>
<div class="graph-wrap" id="graph3">
  <a class="tit">올해 푼 문제집!</a>
  <div class="graph" >
    <div class="data data1"></div>
    <div class="data data2"><%=countViewList %> 개 풀었습니다.
    </div>
    <div class="data data3"></div>
  </div>
</div>
</div>


</body>
</html>