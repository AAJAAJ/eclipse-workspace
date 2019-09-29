<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory,org.apache.commons.fileupload.FileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload,org.apache.commons.fileupload.FileItem" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//创建FileItemFactory对象--用于生产FileItem对象
FileItemFactory factory = new DiskFileItemFactory();
//创建ServletFileUpload对象
ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
//解析form表单中所有文件
List<FileItem> fileItemList = servletFileUpload.parseRequest(request);;
//遍历集合获取对应的fileItem对象
if(fileItemList != null){
	for(FileItem fileItem : fileItemList){
		//判断是否是上传的字段
		if(fileItem.isFormField()){//true代表普通字段
			String key = fileItem.getFieldName();
			if("username".equals(key)){
				System.out.println("用户名:"+fileItem.getString());
			}else if("pwd".equals(key)){
				System.out.println("密码:"+fileItem.getString());
			}
		}else{//false代表上传的字段
			//获取上传的文件名
			String fileName = fileItem.getName();
			System.out.println("上传的文件名为:"+fileName);
		}
	}
}

%>