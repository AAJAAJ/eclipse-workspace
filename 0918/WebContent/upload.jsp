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
	<c:if test="${not empty sizeErr }">${sizeErr }</c:if>
	<form action="uploadController2.jsp" method="post" enctype="multipart/form-data">
		<input type="text" name="username"/><br>
		<input type="text" name="pwd"/><br>
		<input type="file" name="filename"/>
		<c:if test="${not empty errMsg }">
		<span style="color:red">${errMsg }
		</span>
		</c:if>
		<br>
		<input type="submit" value="上传"/>
	</form>
	<c:remove var="errMsg"/>
</body>
</html>