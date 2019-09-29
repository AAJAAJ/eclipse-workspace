<%@page import="cn.yunhe.entity.News"%>
<%@page import="cn.yunhe.control.NewsControl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="cn.yunhe.entity.Page"%>
<%@page import="java.util.List"%>
<%@page import="cn.yunhe.control.SubjectControl"%>
<%@page import="cn.yunhe.entity.Subject"%>
<%
	request.setCharacterEncoding("utf-8");
	//先获取标识 判断当前操作
	String type = request.getParameter("type");
	NewsControl nc = new NewsControl();
	
	if("addNews".equals(type)){
		String title = new String(request.getParameter("title").getBytes("ISO-8859-1"), "UTF-8");
		String content = new String(request.getParameter("content").getBytes("ISO-8859-1"), "UTF-8");
		int sid = Integer.valueOf(new String(request.getParameter("id").getBytes("ISO-8859-1"), "UTF-8")) ;
		int result = nc.addNews(title, content, sid);
		if (result == 1) {
			response.sendRedirect("news-list.jsp");
		} else {
			out.println("<javascript>alert('添加失败')</javascript>");
			response.sendRedirect("news-list.jsp");
		}
	}else if("queryNews".equals(type)){
		// 总共多少条信息
		int sumNews = nc.sumNews();
		// 每页展示几条信息
		int pageCount = 3;
		// 页码
		int pageIndex = 1;
		//获取分页的页码数
		String newPageIndex = request.getParameter("pageIndex");
		if(newPageIndex != null){
			pageIndex = Integer.valueOf(newPageIndex);
		}
		//数据列表
		List<News> list = nc.queryPage(pageIndex, pageCount);
		
		//每页显示的
		Page paging = new Page();
		//获取每页数据数
		paging.setPageCount(pageCount);
		//设置总条数
		paging.setTotal(sumNews);
		//获取集合
		paging.setList(list);
		paging.setPageIndex(pageIndex);
		
		session.setAttribute("news", paging);
		response.sendRedirect("news-list.jsp");
	}else if("delnews".equals(type)){
		int nid = Integer.valueOf( request.getParameter("nid"));
		int result = nc.delNews(nid);
		if (result == 1) {
			response.sendRedirect("news-list.jsp");
		} else {
			out.println("<javascript>alert('删除失败')</javascript>");
			response.sendRedirect("news-list.jsp");
		}
	}
%>