<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.yunhe.controller.*,cn.yunhe.entity.*" %>
<%
	request.setCharacterEncoding("utf-8");
	//先获取标识,判断当前的操作类型
	String type = request.getParameter("type");
	MotifController motifController = new MotifController();
	if("add".equals(type)){
		String motifName = new String(request.getParameter("motifName").getBytes("iso-8859-1"),"utf-8");
		System.out.println(motifName);
		Motif motif = new Motif();
		motif.setMotif(motifName);
		int result = motifController.addMotif(motif);
		if(result == 1){
			response.sendRedirect("motif-list.jsp");
		}else{
			out.println("<javascript>alert('添加失败')</javascript>");
			response.sendRedirect("motif-list.jsp");
		}
	}
%>