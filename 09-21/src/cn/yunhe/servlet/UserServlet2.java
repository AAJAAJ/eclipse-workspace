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

import cn.yunhe.bean.User;
import cn.yunhe.dao.UserDao;
import cn.yunhe.dao.imp.UserDaoImp;
import cn.yunhe.utils.DBUtils;

//点击按钮将所有的用户信息遍历出来
public class UserServlet2 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		UserDao userDao = new UserDaoImp();
		List<User> userlist = userDao.alluser();
		
		String jsonStr = JSON.toJSONString(userlist);
		
		out.print(jsonStr);
		
		out.close();
	}
	
}
