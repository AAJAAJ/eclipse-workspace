<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<h2>登录</h2>
	<%
	request.setCharacterEncoding("utf-8");
	String userName = request.getParameter("username");
	String passWord = request.getParameter("password");
	String sex = request.getParameter("sex");
	String introduction = request.getParameter("introduction");
	
	
	session.setAttribute("username", userName);
	session.setAttribute("password", passWord);
	session.setAttribute("sex", sex);
	session.setAttribute("introduction", introduction);
	%>
	<form name="login" action="cotroller.jsp" onsubmit="return check(this)">
		用户名：<input type="text" name="username" id="username" value="<%=userName %>"/>
		<br>
		密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="password"/>
		<br>
		<input type="submit" value="登录"/>
	</form>
	
</body>
</html>