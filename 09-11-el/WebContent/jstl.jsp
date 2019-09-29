<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cn.yunhe.entity.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl</title>
</head>
<body>
	<c:set var="index" value="8" scope="request"/>
	${requestScope.index }
	
	<hr/>
	<%
		Order order = new Order();
		request.setAttribute("order", order);
		request.setAttribute("date", new Date());
	%>
	设置前的oid值:${requestScope.order.oid }
	
	<c:set target="${order }" property="oid" value="123456"/>
	设置后的oid值:${requestScope.order.oid }
	<hr/>
	使用out输出:<c:out value="${requestScope.order.oid }"/><br/>
	使用带有默认值的out输出:<c:out value="${requestScope.order.createTime }" default="${date }"/>
	
	<c:remove var="index" scope="request"/>
	移除后使用out输出:<c:out value="${requestScope.index }" default="0"/><br/>
</body>
</html>