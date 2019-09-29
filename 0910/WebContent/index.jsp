<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		
		//设置多个参数
		session.setAttribute("name", "admin");
		session.setAttribute("age", 120);
		
		//获取并打印参数
		String name = (String)session.getAttribute("name");
		int age = (Integer)session.getAttribute("age");
		
		out.print("移除前的姓名:"+name);
		out.print("移除前的年龄:"+age);
		
		//移除age
		session.removeAttribute("age");
		
		out.print("移除后的age:"+session.getAttribute("age"));
	%>
</body>
</html>