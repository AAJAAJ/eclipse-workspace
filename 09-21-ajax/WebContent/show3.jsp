<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
	<table cellspacing="0" cellpadding="5px" border="1" align="center" width="50%">
		<tr>
			<th>序号</th>
			<th>账号</th>
			<th>密码</th>
		</tr>
	<c:if test="${not empty list }">
	<c:forEach items="${list }" var="list">
	<tr>
			<th>${list.uid }</th>
			<th>${list.uname }</th>
			<th>${list.password }</th>
	</tr>
	</c:forEach>
	</c:if>
	</table>
	
	
</body>
</html>