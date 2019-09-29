<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.yunhe.entity.Order,java.util.*,cn.yunhe.entity.Goods" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el表达式</title>
</head>
<body>
	<%
		//先设置一个值存储到某个作用域中,再通过el表达式进行获取
		pageContext.setAttribute("userName", "Juni");
		request.setAttribute("age", 12);
		session.setAttribute("sex", "male");
		application.setAttribute("weight", 120);
	%>
	
	<hr/>
	page:<%=pageContext.getAttribute("userName") %><br/>
	request:<%=request.getAttribute("age") %><br/>
	session;<%=session.getAttribute("sex") %><br/>
	application:<%=application.getAttribute("weight") %>
	<hr/>
	page:${pageScope.userName }<br/>
	request:${requestScope.age }<br/>
	session;${sessionScope.sex }<br/>
	application:${applicationScope.weight }
	<hr/>
	
	<%
		//生成一个订单,订单中包含两件不同的商品,分别打印出来
		Order order = new Order();
		List<Goods> goodsList = new ArrayList<Goods>();
		goodsList.add(new Goods(1,"羊毛衫",120));
		goodsList.add(new Goods(2,"羽绒服",49));
		order.setGoodsList(goodsList);
		//放到作用域中
		request.setAttribute("order", order);
		
		/* Order order1 = (Order)request.getAttribute("order");
		List<Goods> list = order1.getGoodsList();
		Goods goods = list.get(0);
		goods.getPrice(); */
	%>
	羊毛衫的价格:${requestScope.order.goodsList[0].price }
	
	<hr/>
	
	<%
		Map<String,String> map = new HashMap<String,String>();
		map.put("size", "XL");
		map.put("price", "360");
		request.setAttribute("map", map);
	%>
	size:${requestScope.map.get("size") }
	price:${requestScope.map.get("price") }
	
	<hr/>
	${not empty order }
	${1 >= 2 }
	
	<form action="test.jsp">
		<input type="text" name="uname" value="zhangsan"/>
		<input type="checkbox" name="hobby" value="basketball">篮球
		<input type="checkbox" name="hobby" value="soccer">足球
		<input type="checkbox" name="hobby" value="pingpang">乒乓球
		<input type="submit">
	</form>
</body>
</html>









