<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html  class="x-admin-sm">
<head>
	<title>新闻发布系统</title>
	<meta charset="UTF-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/login.css">
	  <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-bg">
    
    <!-- 输入用户名判断,用户名为admin时该页面显示为欢迎管理员admin,用户名为Juni时显示欢迎Juni,若都是则显示登陆表单 -->
    
    <c:if test="${empty username }">
	    <div class="login layui-anim layui-anim-up">
	        <div class="message">新闻发布系统后台</div>
	        <div id="darkbannerwrap"></div>
	        <form method="post" class="layui-form" action="loginControll.jsp">
	            <input name="username" placeholder=""  type="text" lay-verify="required" class="layui-input" >
	            <hr class="hr15">
	            <input name="password" lay-verify="required" placeholder=""  type="password" class="layui-input">
	            <hr class="hr15">
	            <input value="登录" style="width:100%;" type="submit">
	            <hr class="hr20" >
	        </form>
	    </div>
    </c:if>
    <c:if test="${not empty username }">
    	<c:if test='${username eq "admin" }'>
    		欢迎管理员${username }
    	</c:if>
    	<c:if test='${username == "Juni" }'>
    		欢迎${username }
    	</c:if>
    </c:if>
    <c:remove var="username"/>
</body>
</html>