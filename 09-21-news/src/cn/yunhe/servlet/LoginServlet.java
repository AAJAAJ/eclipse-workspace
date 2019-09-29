package cn.yunhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yunhe.controller.UserController;
import cn.yunhe.entity.User;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		PrintWriter out= response.getWriter();
		//获取用户输入的用户名和密码
		String userName = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		UserController userController = new UserController();
		User user = userController.queryUser(userName, pwd);
		if(null != user){
			Cookie cookie = new Cookie("username",URLEncoder.encode(user.getUserName(),"utf-8"));
			//设置cookie有效期为五分钟
			cookie.setMaxAge(5*60);
			response.addCookie(cookie);
			session.setAttribute("user", user);
			out.print("success");
			return;
		}
		session.setAttribute("errMsg", "用户名或密码错误");
		out.print("fail");
	}

}
