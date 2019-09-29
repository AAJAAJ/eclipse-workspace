<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>登录</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/login.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="./lib/layui/layui.js" charset="utf-8"></script>
</head>
<body class="login-bg">
	<%
    //设置编码格式
    request.setCharacterEncoding("utf-8");
  /*   //获取对象值
    Object obj = session.getAttribute("errMsg");
    String errmsg = "";
    if(null!=obj){
    	errmsg =(String)obj;
    	session.removeAttribute("errMsg"); 
    }
     */
    //判断存储的cookie是否有效
    //先获取cookie
    Cookie[] cookies = request.getCookies();
    if(cookies!=null && cookies.length>0){
    	for(Cookie cookie : cookies){
    		String key = URLDecoder.decode(cookie.getName(), "utf-8");
    		if("username".equals(key)){
    			response.sendRedirect("mainpage.jsp");
    			return;
    		}
    	}
    }
    %>
	<div class="login layui-anim layui-anim-up">
		<div class="message">新闻管理登录</div>
		<div id="darkbannerwrap"></div>
		<!-- 判断 -->
		<c:if test="${not empty errMsg }">
			<P style="color: red; text-align: center;">${errMsg }</P>
		</c:if>
		<form method="post" class="layui-form" action="logincontrol.jsp">
			<input name="username" placeholder="用户名" type="text"
				lay-verify="required" class="layui-input">
			<hr class="hr15">
			<input name="password" lay-verify="required" placeholder="密码"
				type="password" class="layui-input">
			<hr class="hr15">
			<input value="登录" lay-submit lay-filter="login" style="width: 100%;"
				type="submit">
			<hr class="hr20">
		</form>
	</div>
	<!-- 移除错误警告 -->
	<c:remove var="errMsg" scope="session" />
</body>
</html>