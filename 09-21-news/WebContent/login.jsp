<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    
    <%
    	/* //判断存储的cookie是否有效,有效则直接跳转到index界面
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null && cookies.length>0){
    		for(Cookie cookie : cookies){
    			String key = URLDecoder.decode(cookie.getName(),"utf-8");
    			if("username".equals(key)){
    				response.sendRedirect("index.jsp");
    				return;
    			}
    		}
    	} */
    %>
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">新闻发布系统后台</div>
        <div id="darkbannerwrap"></div>
        <c:if test="${not empty errMsg }">
        	<p style="color:red;text-align:center;">${errMsg }</p>
        </c:if>
        <form class="layui-form">
            <input name="username" id="username" placeholder=""  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="password" id="pwd" lay-verify="required" placeholder=""  type="password" class="layui-input">
            <hr class="hr15">
            <input value="登录" style="width:100%;" type="submit">
            <hr class="hr20" >
        </form>
    </div>
	<c:remove var="errMsg"/>
	
	<script>
		$(function(){
			$('form').submit(function(){
				var username = $('#username').val();
				var pwd = $('#pwd').val();
				
				$.ajax({
					url:"loginServlet",
					type:"post",
					data:{
						"username":username,
						"password":pwd
					},
					dataType:"text",
					success:function(data){
						if("success" == data){
							location.href = "index.jsp";
						}else{
							location.href = "login.jsp";
						}
					}
				})
				return false;
			})
		})
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>