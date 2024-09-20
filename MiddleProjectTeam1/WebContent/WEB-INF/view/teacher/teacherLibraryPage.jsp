<%@page import="kr.or.ddit.vo.PostVO"%>
<%@page import="kr.or.ddit.vo.MaterialVO"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// controller에서 저장한 값 꺼내기
	List<PostVO> list = (List<PostVO>)request.getAttribute("list");

	int startp = (Integer)request.getAttribute("startPage");
	int endp = (Integer)request.getAttribute("endPage");
	int totalp = (Integer)request.getAttribute("totalPage");
	
	
	JsonObject obj = new JsonObject();
	obj.addProperty("sp", startp);
	obj.addProperty("ep", endp);
	obj.addProperty("tp", totalp);
	
	Gson gson = new Gson();
	// 트리로 저장
	JsonElement ellist = gson.toJsonTree(list);
	
	obj.add("datas", ellist);
	out.print(obj);
	out.flush();
	
%>	