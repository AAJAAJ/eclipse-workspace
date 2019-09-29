<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet" %>
<%@ page import="cn.yunhe.controller.UserController,cn.yunhe.entity.User,java.net.*" %>
<%
	//设置编码格式
	request.setCharacterEncoding("utf-8");
	//获取用户输入的用户名和密码
	String userName = request.getParameter("username");
	String pwd = request.getParameter("password");
	
	UserController userController = new UserController();
	User user = userController.queryUser(userName, pwd);
	if(null != user){
		Cookie cookie = new Cookie("username",URLEncoder.encode(user.getUserName(),"utf-8"));
		//设置cookie有效期为五分钟
		cookie.setMaxAge(60);
		response.addCookie(cookie);
		session.setAttribute("user", user);
		response.sendRedirect("index.jsp");
		return;
	}
	session.setAttribute("errMsg", "用户名或密码错误");
	response.sendRedirect("login.jsp");
%>