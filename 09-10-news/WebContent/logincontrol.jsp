<%@page import="java.net.URLEncoder"%>
<%@page import="cn.yunhe.entity.User"%>
<%@page import="cn.yunhe.control.UserControl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//设置编码格式	
	request.setCharacterEncoding("utf-8");
	//获取用户输入的用户名和密码	
	String userName = request.getParameter("username");
	String pw = request.getParameter("password");
	//从数据库中查找	
	UserControl control = new UserControl();
	User user = control.user(userName,pw);
	//判断	如果用户存在 设置免登陆
	if(null!=user){
	   //将用户名使用cookie存储到本地	
	   Cookie cookie = new Cookie("username",URLEncoder.encode(user.getName(),"utf-8"));
	   //设置一个对象
	   session.setAttribute("user",user );
	   //设置cookie有效期	
	   cookie.setMaxAge(5*60);
	   //写入cookie
	   response.addCookie(cookie);
	   //重定向	
	   response.sendRedirect("mainpage.jsp");
	   return;
	} 
	session.setAttribute("errMsg", "用户名或密码错误");
	response.sendRedirect("login.jsp");
%>