<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
		SimpleDateFormat sm = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		String date = sm.format(new Date());
	%>
	<h2><%=date%></h2>
	<br>
		<%
			for (int i = 1; i < 10; i++) {
				for (int j = 1; j <= i; j++) {
					out.println(j+"*"+i+"="+j*i);
				}
				out.println("<br>");
			}
		%>
	<br>
	<h2>计算2000—2013年中存在几个闰年</h2>
		<%
		int count = 0;
		for (int i = 2000; i <= 2013; i++) {
			if(i%4 == 0){
				out.println(i+"<br>");
				count++;
			}
		}
		%>
	<h3>2000—2013年中存在<%=count %>个闰年</h3>
	

		
		
		
		
		
		
</body>
</html>