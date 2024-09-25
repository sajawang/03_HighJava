<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/main/css/chat.css">

<title>스스로수학채팅창</title>

</head>
<%
    MemberVO memberVo = (MemberVO)session.getAttribute("memVo");
   String userGu = (String)session.getAttribute("userGu");
   String userValue = null;
   
   if(userGu.equalsIgnoreCase("student")){
      userValue = "학생";
   }
   if(userGu.equalsIgnoreCase("teacher")){
      userValue = "선생님";
   }
   if(userGu.equalsIgnoreCase("admin")){
      userValue = "운영자";
   }
   
   
    if (memberVo == null) {
        // 로그인이 안 된 경우 로그인 페이지로 리다이렉트
        response.sendRedirect(request.getContextPath() + "/goLogin.do");
        return;
    }
    String rankImg = null;
  
    int memPoint = memberVo.getMem_point();
    
    if(memPoint<1000){
       rankImg = "/images/bronze.png";
    }
    else if(memPoint<4999){
       rankImg = "/images/silver.png";
    }
    else if(memPoint<9999){
       rankImg = "/images/gold.png";
    }
    else{
       rankImg = "/images/diamond.png";
    }
    if(userGu.equalsIgnoreCase("teacher")){
       rankImg = "/images/king.png";
    }
    
    
%>
<body>
   <div id="">
      <div id="chatArea">
         <!-- 메시지 표시 영역 -->
         <textarea id="messageTextArea" readonly="readonly" rows="10" cols="63"></textarea><br><br>
         <!-- 송신 메시지 텍스트박스 -->
         <input type="text" id="messageText" size="40"> <!-- onkeydown="sendMessage()" -->
         <!-- 송신 버튼 -->
         <input type="button" value="Send" id="btnSend">
         <input type="button" value="접속종료" id="btnClose">
      </div>
      <div id="connectArea">
         <!-- 접속자 입력 텍스트박스 -->
         사용자ID : <input type="text" id="userId" size="20" value="<%= ((MemberVO)session.getAttribute("memVo")).getCus_id() %>(<%=userValue %>)" readonly="readonly" >
         <!-- 접속 버튼 -->
         <input type="button" value="접속하기" id="btnConnect">
      </div>
  </div>
    
<script type="text/javascript">
   let webSocket = null; // 웹소켓 변수 선언
   const messageTextArea = document.getElementById("messageTextArea");
   const messageText = document.getElementById("messageText");
   const userText = document.getElementById("userId");
   const contextPath = "<%=request.getContextPath()%>";
   
   function connectting(){
      if(userText.value.trim()==""||userText.value.trim()==null){
         alert("접속자 ID를 입력하세요");
         userText.focus();
         return;
      }
      //웹소켓 초기화
      webSocket = new WebSocket("ws://192.168.146.66" + contextPath +"/websocktMultichat.do");
         
      // 접속 성공하면 
      webSocket.onopen = function onOpen(event){
      document.getElementById("connectArea").style.display = "none";
      document.getElementById("chatArea").style.display = "block";
         webSocket.send(userText.value);
         
      }
      
      //메시지가 오면 messageTextArea요소에 메시지를 추가한다.
      webSocket.onmessage = function processMessge(message){
            //Json 풀기
            let jsonData = JSON.parse(message.data);
            if(jsonData.message != null) {
                  messageTextArea.value += jsonData.message + "\n"
                  messageTextArea.scrollTop = 9999999;
            };
      }
      
      webSocket.onerror = function showErrorMsg(event) {
         alert("오류 : " + event.data);
      }
      
      webSocket.onclose = function(event){
         messageTextArea.value = "";
         messageText.value = "";
         userText.value = "";
         document.getElementById("connectArea").style.display = "block";
         document.getElementById("chatArea").style.display = "none";
      }
   }
         
   //메시지 보내기
   function sendMessage(){
      if(messageText.value.trim()==""){
         messageText.focus();
      return;
   }
//        // 사용자 ID와 이미지를 함께 포함한 HTML 구조
//        const userIdWithImage = `
//            <div style="display: flex; align-items: center;">
<%--                <img src="<%=request.getContextPath() %><%= rankImg %>" alt="rank" style="width: 30px; height: 30px; border-radius: 50%; margin-right: 10px;"> --%>
//                <strong>${userText.value}</strong> : ${messageText.value}
//            </div>`;
      
//            webSocket.send(userIdWithImage);
      webSocket.send(messageText.value);
      messageText.value = "";
   }
   
   function closing(){
      webSocket.close();
   }
   
   // 이벤트 설정
   function addEvent(){           
      document.getElementById("btnConnect").addEventListener("click", connectting, false);
      document.getElementById("btnSend").addEventListener("click", sendMessage, false);
      document.getElementById("btnClose").addEventListener("click", closing, false);
   }
   window.addEventListener("load", addEvent, false);

   window.onbeforeunload = function(){
      closing();
   }
</script>
</body>
</html>