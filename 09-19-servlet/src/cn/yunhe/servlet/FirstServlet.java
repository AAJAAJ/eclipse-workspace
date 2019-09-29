package cn.yunhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{

	public FirstServlet() {
		System.out.println("--------FirstServlet--------");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("--------init--------");
		super.init();
	}

	@Override
	public void destroy() {
		System.out.println("--------destroy--------");
		super.destroy();
	}

	/**
	 * 所有的请求都会先经过service再到具体的get或post的方法中
	 * 作用:用于分配请求
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("接收到请求");
		super.service(req, res);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("--执行了doGet请求---");
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("--执行了doPost请求---");
		PrintWriter out = resp.getWriter();
		out.write("<html>");
		out.write("<head><title>servlet</title></head>");
		out.write("<body>");
		out.write("<h3>hello Servlet</h3>");
		out.write(getServletContext().getInitParameter("applicationContextKey"));
		out.write("</body>");
		out.write("</html>");
		
		out.close();
	}
	
	
}
