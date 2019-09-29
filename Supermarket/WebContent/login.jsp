<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>xx超市系统欢迎您</h1>
	<c:if test="${not empty errMsg }">
        	<p style="color:red;text-align:center;">${errMsg }</p>
    </c:if>
	<form action="LoginServlet" method="post">
		<div id="err"><span></span></div>
		用户名:<input type="text" name="username" id="username" />
		<br /><br />
		密&nbsp;&nbsp;&nbsp;码:<input type="text" name="password" id="password" />
		<br /><br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="登录"/>
		<br />
		
	</form>
	<input type="button" onclick="signin()" value="注册"/>
	
	<script>
	function signin(){
		location.href='signin.jsp'
	}
	</script>
</body>
</html>