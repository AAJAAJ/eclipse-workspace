package cn.yunhe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.yunhe.dao.UserDao;
import cn.yunhe.entity.Reply;
import cn.yunhe.entity.Topic;
import cn.yunhe.entity.User;
import cn.yunhe.utils.DBUtils;

/**
 * 用户数据层实现类
 */
public class UserDaoImpl implements UserDao{

	/**
	 * 查询的目的:
	 * 	1 用于判断用户是否存在做登录使用
	 * 	2 存储用户的信息用户之后的操作使用---查看个人信息
	 */
	@Override
	public User login(String userName, String password) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			String sql = "select uid,uname,upass,state,flag from t_user where uname=? and upass=?";
			//获取连接对象
			connection = DBUtils.getConnection();
			//获取预编译对象
			ps = connection.prepareStatement(sql);
			//设置参数
			ps.setString(1, userName);
			ps.setString(2, password);
			//执行查询操作
			rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					//将获取到的值封装到一个user对象中
					user = new User();
					user.setUid(rs.getInt(1));
					user.setUname(rs.getString(2));
					user.setUpass(rs.getString(3));
					user.setState(rs.getInt(4));
					user.setFlag(rs.getInt(5));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int regist(String userName, String pwd, String repwd) {
		return 0;
	}

	@Override
	public int sendTopic(Topic topic) {
		return 0;
	}

	@Override
	public int reply(Reply reply) {
		return 0;
	}

	
}
