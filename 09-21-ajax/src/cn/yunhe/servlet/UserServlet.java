package cn.yunhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//在服务器端通过out(PrintWriter)对象返回
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		System.out.println(request.getParameter("index"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if("juni".equals(uname)) {
			out.write("[\r\n" + 
					"{\r\n" + 
					"\"uname\":\"juni\",\r\n" + 
					"\"sex\":\"male\",\r\n" + 
					"\"age\":18\r\n" + 
					"},\r\n" + 
					"{\r\n" + 
					"\"uname\":\"jack\",\r\n" + 
					"\"sex\":\"female\",\r\n" + 
					"\"age\":20\r\n" + 
					"}\r\n" + 
					"]");
		}else {
			out.write("恭喜,名称可用");
		}
		out.close();
	}

}
