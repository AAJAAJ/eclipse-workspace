<%@page import="cn.yunhe.entity.News"%>
<%@page import="cn.yunhe.controller.NewsController"%>
<%@page import="cn.yunhe.entity.Motif"%>
<%@page import="cn.yunhe.controller.MotifController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet" %>
<%@ page import="cn.yunhe.controller.UserController,cn.yunhe.entity.User,java.net.*" %>
<%
	//设置编码格式
	request.setCharacterEncoding("utf-8");
	//获取数据
	String type = request.getParameter("type");
	String id = request.getParameter("id");
	
	NewsController newsController = new NewsController();
	News news = new News();
	
	//删除一个
	if("del".equals(type)){
		//string转int
		int idInt = Integer.parseInt(id);
		//调用删除
		int result = newsController.delNews(idInt);
		
		if (result == 1) {
			response.sendRedirect("news-list.jsp?type=del");
		} else {
			out.println("<javascript>alert('删除失败')</javascript>");
			response.sendRedirect("news-list.jsp");
		}
	}
	//删除选中
	if("delall".equals(type)){
		String[] ids = id.split(",");
		for (int i = 0; i < ids.length; i++) {
			int idInt = Integer.parseInt(ids[i]);
			int result = newsController.delNews(idInt);
		}
		response.sendRedirect("news-list.jsp?type=del");
	}
	
	//添加主题
	if("add".equals(type)){
		String title = new String(request.getParameter("title").getBytes("iso-8859-1"),"utf-8");
		String content = new String(request.getParameter("content").getBytes("iso-8859-1"),"utf-8");
		String mid = new String(request.getParameter("id").getBytes("iso-8859-1"),"utf-8");
		
		int midInt = Integer.parseInt(id);
		
		int result = newsController.addNews(title, content, midInt);
		if(result == 1){
			response.sendRedirect("news-list.jsp?type=add");
		}else{
			out.println("<javascript>alert('添加失败')</javascript>");
			response.sendRedirect("motif-list.jsp");
		}
	}

	
%>














