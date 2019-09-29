/**
 * 
 */
package cn.yunhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.alibaba.fastjson.JSON;

import cn.yunhe.entiy.User;
import cn.yunhe.jdbc.DBLinks;

/**
 * @author 魏无羡 
 *2019年9月22日
 */
public class Login2Servlet extends HttpServlet{
	
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
		String type = requset.getParameter("type");
		if ("blur".equals(type)) {
			//获得输入的用户名
			String username = requset.getParameter("username");
			if (select(username)) {
				out.print("正确");
			}else {
				out.print("错误");
			}
		}else if ("submit".equals(type)) {
			String name = requset.getParameter("username");
			String pwd = requset.getParameter("pwd");
			System.out.println(quert(name, pwd));
			System.out.println(name);
			System.out.println(pwd);
			if (quert(name, pwd)) {
				out.print(1);
				System.out.println("成功");
			}else {
				out.print("错误");
				System.out.println("错误");
			}
		}else if ("show".equals(type)) {
			Connection connection = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			List<User> list = new ArrayList<User>();
			try {
				connection = DBLinks.getConnection();
				String sql = "select uid,uname,password from user";
				ps = connection.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					User user = new User();
					user.setUid(rs.getInt(1));
					user.setUname(rs.getString(2));
					user.setPassword(rs.getString(3));
					list.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBLinks.close(connection, ps, rs);
			}
			//通过Json对象返回集合数据 fastjson中的对象将集合转换成json字符串返回
			String jsonStr = JSON.toJSONString(list);
			out.print(jsonStr);
			out.close();
		}
	}
	public void all() {
		
	}
	public boolean select(String name) {
		//链接数据库
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = DBLinks.getConnection();
			String sql = "select uname from user where uname=?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
			return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBLinks.close(connection, ps, rs);
		}
		return false;
	}
	public boolean quert(String name,String pwd) {
		// 链接数据库
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = DBLinks.getConnection();
			String sql = "select uname,password from user where uname = ? and password = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if (rs!=null) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBLinks.close(connection, ps, rs);
		}
		return false;
	}
}
