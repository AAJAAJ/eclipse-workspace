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
import com.alibaba.fastjson.JSONObject;

import cn.yunhe.bean.User;
import cn.yunhe.utils.DBUtils;

//点击按钮将所有的用户信息遍历出来
public class UserServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String index = req.getParameter("pageIndex");
		System.out.println(index);
		//从数据库中获取数据封装成一个集合
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from t_user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setPwd(rs.getString(3));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		//通过Json对象返回集合数据 fastjson中的对象将集合转换成json字符串返回
		String jsonStr = JSON.toJSONString(userList);
		out.print(jsonStr);
		out.close();
	}
	
}
