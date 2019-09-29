<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>页面信息</title>
</head>
<body>
<h1>登陆成功</h1>
	<%
		request.setCharacterEncoding("utf-8");
		//获取传递的值
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String introduction = request.getParameter("introduction");
	%>
	用户名:<%=userName %>
	密码:<%=password %>
	性别:<%=sex %>
	自我介绍:<%=introduction %>
</body>
</html>