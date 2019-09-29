<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>欢迎【管理员】<%=session.getAttribute("userName") %></h1>
<h2>性别:<%=session.getAttribute("sex") %></h2>
<h2>自我介绍:<%=session.getAttribute("introduction") %></h2>
</body>
</html>