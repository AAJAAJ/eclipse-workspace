package cn.yunhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	public void destroy() {
    	System.out.println("-----destroy-------");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("-----init-------");
		super.init();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
    	
        super();
        System.out.println("-----SecondServlet-------");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<html>");
		out.write("<head><title>servlet</title></head>");
		out.write("<body>");
		out.write("<h3>hello Servlet</h3>");
		out.write(getServletContext().getInitParameter("applicationContextKey"));
		out.write("</body>");
		out.write("</html>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
