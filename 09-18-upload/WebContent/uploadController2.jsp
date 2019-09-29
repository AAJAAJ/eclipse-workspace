<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory,org.apache.commons.fileupload.FileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload,org.apache.commons.fileupload.FileItem" %>
<%@ page import="java.util.*,java.io.*" %>
<%
//需求:限制上传的文件为指定后缀的图片

//创建FileItemFactory对象--用于生产FileItem对象
FileItemFactory factory = new DiskFileItemFactory ();
//创建ServletFileUpload对象	
ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
servletFileUpload.setSizeMax(1024*80);
long fileSize = 0;
try{
//解析form表单中所有文件
List<FileItem> fileItemList = servletFileUpload.parseRequest(request);

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
				//1 自定义需要限制的文件后缀
				String[] suffixArr = {".png",".jpg",".JPEG",".gif"};
				//2 获取到上传的文件的后缀
				String suffix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
				//3 对获取到的后缀和指定的后缀进行比较,需要忽略大小写
				//System.out.println(fileName.lastIndexOf(".")+"--"+suffix);
				List<String> suffixList = Arrays.asList(suffixArr);
				if(!suffixList.contains(suffix)){
					session.setAttribute("errMsg", "图片格式:"+suffixList);
					response.sendRedirect("upload.jsp");
				}else{
					//为图片重命名避免名字冲突  先生成一个名字--当前时间戳
					
					String oldFileName = fileName.split("\\.")[0];
					String newFileName = new Date().getTime()+"";
					String name = oldFileName + newFileName + suffix;
					//获取的地址是部署到服务器上的绝对路径
					String serverPath = request.getServletContext().getRealPath("/imgs/");
					File dirFile = new File(serverPath);
					if(!dirFile.exists()){
						dirFile.mkdir();
					}
					File file = new File(serverPath,name);
					fileItem.write(file);
					fileSize = fileItem.getSize();
					session.setAttribute("picPath", name);
					//session.setAttribute("sizeErr", "最大字节数:"+servletFileUpload.getSizeMax()+",上传的图片大小:"+fileSize);
					response.sendRedirect("show.jsp");
				}
			}
		}
	}
}catch(Exception e){
	session.setAttribute("sizeErr", "最大字节数:"+servletFileUpload.getSizeMax()+",上传的图片大小:"+fileSize);
	response.sendRedirect("upload.jsp");
}

%>