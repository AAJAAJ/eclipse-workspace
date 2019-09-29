/**
 * 
 */
package cn.yunhe.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 性感渣渣傲在线打bug 2019年9月19日 下午4:28:40
 */
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 处理请求
		req.setCharacterEncoding("utf-8");
		String userName = req.getParameter("username");
		String pwd = req.getParameter("pwd");

		// 将用户名存到某个作用域中---session
		HttpSession session = req.getSession();
		session.setAttribute("username", userName);

		// 跳转
		resp.sendRedirect("home.jsp");
	}

}
