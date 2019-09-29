/**
 * 
 */
package cn.yunhe.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yunhe.entiy.User;
import cn.yunhe.jdbc.DBLinks;

/**
 * @author 魏无羡 
 *2019年9月22日
 */
public class ShowServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest requset, HttpServletResponse respone) throws ServletException, IOException {
		requset.setCharacterEncoding("utf-8");
		respone.setCharacterEncoding("utf-8");
		HttpSession session = requset.getSession();
		//向数据库查询
		// 链接数据库
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			connection = DBLinks.getConnection();
			String sql = "select uid,uname,password from user ";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUid(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setPassword(rs.getString(3));
				list.add(user);
			}
			session.setAttribute("list", list);
			respone.sendRedirect("show3.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBLinks.close(connection, ps, rs);
		}
	

}

}
