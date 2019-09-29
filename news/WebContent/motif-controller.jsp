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
	
	MotifController motifController = new MotifController();
	Motif motif = new Motif();
	
	//删除一个
	if("del".equals(type)){
		//string转int
		int idInt = Integer.parseInt(id);
		//调用删除
		int result = motifController.delMotifById(idInt);
		
		if (result == 1) {
			response.sendRedirect("motif-list.jsp?type=del");
		} else {
			out.println("<javascript>alert('删除失败')</javascript>");
			response.sendRedirect("motif-list.jsp");
		}
	}
	//删除选中
	if("delall".equals(type)){
		String[] ids = id.split(",");
		for (int i = 0; i < ids.length; i++) {
			int idInt = Integer.parseInt(ids[i]);
			int result = motifController.delMotifById(idInt);
		}
		response.sendRedirect("motif-list.jsp?type=del");
	}
	
	//添加主题
	if("add".equals(type)){
		String motifName = new String(request.getParameter("motifName").getBytes("iso-8859-1"),"utf-8");
		motif.setMotif(motifName);
		int result = motifController.addMotif(motif);
		if(result == 1){
			response.sendRedirect("motif-list.jsp?type=add");
		}else{
			out.println("<javascript>alert('添加失败')</javascript>");
			response.sendRedirect("motif-list.jsp");
		}
	}
	//禁用启用
	if("Prohibit".equals(type)){
		int idInt = Integer.parseInt(id);
		int stateInt = Integer.parseInt(request.getParameter("state"));
		int result = motifController.setMotifById(stateInt, idInt);
		if(stateInt == 1){
			response.sendRedirect("motif-list.jsp?type=stop");
		}else{
			response.sendRedirect("motif-list.jsp?type=start");
		}
	}
	
	
	
	
%>














