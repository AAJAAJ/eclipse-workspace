<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>控制层</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		//获取传递的值
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		
		String user = (String)session.getAttribute("username");
		String pwd = (String)session.getAttribute("password");
		
		if(user.equals(userName) && pwd.equals(passWord)){
			session.setAttribute("userName", userName);
			session.setAttribute("passWord", passWord);
			
			if("admin".equals(userName)){
				response.sendRedirect("adminHome.jsp");
			}else{
				response.sendRedirect("userHome.jsp");
			}	
			
		}else{
			out.println("用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	%>
</body>
</html>