/**
 * 
 */
package cn.yunhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月19日 下午3:01:08
 */
public class FirstServlet extends HttpServlet{

	public FirstServlet() {
		System.out.println("--------FirstServlet--------");
	}
	@Override
	public void destroy() {
		System.out.println("--------destroy--------");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("--------init--------");
		super.init();
	}
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("接收到请求");
		super.service(req, resp);
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
