<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.vo.CommentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//controller에서 저장값 꺼내기

List<CommentVO> list = (List<CommentVO>)request.getAttribute("list");

Gson gson = new GsonBuilder().setPrettyPrinting().create();
String comments = gson.toJson(list);

out.print(comments);
out.flush();



%>