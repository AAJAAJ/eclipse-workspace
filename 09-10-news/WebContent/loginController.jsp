<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet" %>
<%@ page import="cn.yunhe.controller.UserController,cn.yunhe.entity.User,java.net.*" %>
<%
	//设置编码格式
	request.setCharacterEncoding("utf-8");
	//获取用户输入的用户名和密码
	String userName = request.getParameter("username");
	String pwd = request.getParameter("password");
	/* //从数据库中获取数据进行对比判断
	//数据库操作步骤:导jar-->注册驱动-->获取数据库链接对象-->SQL语句-->执行SQL的对象-->增删改操作-->关闭数据库
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/news?serverTimezone=UTC", "root", "root");
	String sql = "select * from t_user where username=? and password=?";
	//预编译SQL
	PreparedStatement ps = conn.prepareStatement(sql);
	//设置值
	ps.setString(1, userName);
	ps.setString(2, pwd);
	//获取返回结果集
	ResultSet rs = ps.executeQuery();
	while(rs.next()){
		String queryName = rs.getString(2);
		if(null != queryName){
			//免登录---存储登录的用户名,若用户名存在代表已登录成功过,存储其用户名下次免登录
			//将用户名使用cookie存储到本地
			Cookie cookie = new Cookie("username",queryName);
			//设置cookie有效期为五分钟
			cookie.setMaxAge(5*60);
			response.addCookie(cookie);
			response.sendRedirect("index.html");
			return;
		}
	}
	session.setAttribute("errMsg", "用户名或密码错误");
	response.sendRedirect("login.jsp"); */
	
	UserController userController = new UserController();
	User user = userController.queryUser(userName, pwd);
	if(null != user){
		Cookie cookie = new Cookie("username",URLEncoder.encode(user.getUserName(),"utf-8"));
		//设置cookie有效期为五分钟
		cookie.setMaxAge(5*60);
		response.addCookie(cookie);
		session.setAttribute("user", user);
		response.sendRedirect("index.jsp");
		return;
	}
	session.setAttribute("errMsg", "用户名或密码错误");
	response.sendRedirect("login.jsp");
%>