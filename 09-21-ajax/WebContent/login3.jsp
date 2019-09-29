<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 判断 -->
		<c:if test="${not empty errMsg }">
			<P style="color: red; text-align: center;">${errMsg }</P>
		</c:if>
	<form action="loginServlet3" method="post">
	用户名：<input type="text" name="username" id="username">
	<br>
	密码	：<input type="password" name="pwd" id="pwd">
	<br>
	<input type="submit" id="submit">
	</form>
	<!-- 移除错误警告 -->
	<c:remove var="errMsg" scope="session" />
</body>
</html>