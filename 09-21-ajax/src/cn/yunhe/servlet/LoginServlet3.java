/**
 * 
 */
package cn.yunhe.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yunhe.jdbc.DBLinks;

/**
 * @author 魏无羡 
 *2019年9月21日
 */
public class LoginServlet3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest requset, HttpServletResponse respone) throws ServletException, IOException {
		requset.setCharacterEncoding("utf-8");
		respone.setCharacterEncoding("utf-8");
		HttpSession session = requset.getSession();
		String uname = requset.getParameter("username");
		String pwd = requset.getParameter("pwd");
		//向数据库查询
		// 链接数据库
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = DBLinks.getConnection();
			String sql = "select uname,password from user where uname = ? and password = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if (rs!=null) {
				respone.sendRedirect("showServlet");
				return;
			}
			session.setAttribute("errMsg", "用户名或密码错误");
			respone.sendRedirect("login3.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBLinks.close(connection, ps, rs);
		}
	}

}
