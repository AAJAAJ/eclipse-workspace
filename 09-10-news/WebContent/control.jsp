<%@page import="cn.yunhe.entity.Page"%>
<%@page import="java.util.List"%>
<%@page import="cn.yunhe.control.SubjectControl"%>
<%@page import="cn.yunhe.entity.Subject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	//先获取标识 判断当前操作
	String type = request.getParameter("type");

	SubjectControl sc = new SubjectControl();
	//添加操作
	if ("add".equals(type)) {
		String subjectName = new String(request.getParameter("subjectName").getBytes("ISO-8859-1"), "UTF-8");
		Subject subject = new Subject();
		subject.setTitle(subjectName);
		int result = sc.addSubject(subjectName);
		if (result == 1) {
			response.sendRedirect("motif-list.jsp");
		} else {
			out.println("<javascript>alert('添加失败')</javascript>");
			response.sendRedirect("motif-list.jsp");
		}
	} else if ("stop".equals(type)) {
		int state = Integer.valueOf(new String(request.getParameter("state").getBytes("ISO-8859-1"), "UTF-8"));
		int id = Integer.valueOf(new String(request.getParameter("id").getBytes("ISO-8859-1"), "UTF-8"));
		int result = sc.noSubject(state,id);
		if (result == 1) {
			response.sendRedirect("motif-list.jsp");
		} else {
			out.println("<javascript>alert('添加失败')</javascript>");
			response.sendRedirect("motif-list.jsp");
		}
	}else if("query".equals(type)){
		
		//数据总条数
		int total = sc.sumPage();
		// 每页数据数
		int pageCount = 3;
		//页码
		int pageIndex = 1;
		//获取分页的页码数
		String newPageIndex = request.getParameter("pageIndex");
		if(newPageIndex != null){
			pageIndex = Integer.valueOf(newPageIndex);
		}
		//数据列表
		List<Subject> list = sc.selectPage(pageIndex, pageCount);
		//每页显示的
		Page paging = new Page();
		//获取每页数据数
		paging.setPageCount(pageCount);
		//设置总条数
		paging.setTotal(total);
		//获取集合
		paging.setList(list);
		paging.setPageIndex(pageIndex);
		
		session.setAttribute("page", paging);
		response.sendRedirect("motif-list.jsp");
	}
%>