/**
 * 
 */
package cn.yunhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 魏无羡 
 *2019年9月21日
 */
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest requset, HttpServletResponse respone) throws ServletException, IOException {
		requset.setCharacterEncoding("utf-8");
		respone.setCharacterEncoding("utf-8");
		//在服务器端通过out(printWrite)对象返回
		PrintWriter out = respone.getWriter();
		String uname = requset.getParameter("username");
		if ("boss".equals(uname)) {
			out.print("成功");
		}else {
			out.print("失败");
		}
	}
	
	
}
