package cn.yunhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yunhe.bean.User;
import cn.yunhe.dao.UserDao;
import cn.yunhe.dao.imp.UserDaoImp;

/**
 * Servlet implementation class SigninServlet
 */
@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String repwd = request.getParameter("repwd");
		
		System.out.println(pwd);
		System.out.println(repwd);
		
		PrintWriter out = response.getWriter();
		UserDao userDao = new UserDaoImp();
		List<User> userlist = userDao.alluser();
		int count = 0;
		for (User user : userlist) {
			if(user.getUname().equals(username)) {
				count++;
			}
		}
		
		if(count != 0) {
			out.write("用户名已存在");
		}else {
			out.write("恭喜,名称可用");
		}
		
		
		if (pwd != repwd) {
			out.write("输入密码不一致");
		}
		
		
		
		out.close();
		
	}
		
		
		
		
	}

