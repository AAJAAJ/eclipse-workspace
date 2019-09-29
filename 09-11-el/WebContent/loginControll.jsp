<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String userName = request.getParameter("username");
	//session.setAttribute("errMsg", "用户名或密码错误");
	session.setAttribute("username", userName);
	response.sendRedirect("login2.jsp");
%>