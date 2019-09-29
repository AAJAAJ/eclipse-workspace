package cn.yunhe.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yunhe.controller.UserController;
import cn.yunhe.entity.User;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		//获取用户输入的用户名和密码
		String userName = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		UserController userController = new UserController();
		User user = userController.queryUser(userName, pwd);
		
		HttpSession session = request.getSession();
		
		if(null != user){
			Cookie cookie = new Cookie("username",URLEncoder.encode(user.getUserName(),"utf-8"));
			//设置cookie有效期为五分钟
			cookie.setMaxAge(60);
			response.addCookie(cookie);
			session.setAttribute("user", user);
			response.sendRedirect("index.jsp");
			return;
		}
		session.setAttribute("errMsg", "用户名或密码错误");
		response.sendRedirect("login.jsp");
	}

}
