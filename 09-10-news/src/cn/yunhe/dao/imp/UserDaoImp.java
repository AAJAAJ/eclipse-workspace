/**
 * 
 */
package cn.yunhe.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.yunhe.dao.UserDao;
import cn.yunhe.entity.User;
import cn.yunhe.jdbc.DBLinks;

/**
 * @author 魏无羡 
 *2019年9月10日
 */
public class UserDaoImp implements UserDao {

	@Override
	public User user(String userName, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//查询
		try {
			//获取数据库链接对象
			conn = DBLinks.getConnection();
			//sql语句
			String sql = "select uname,password from user where uname = ? and password = ?";
			//预编译
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			rs = ps.executeQuery();
			//遍历
			while (rs.next()) {
				String queryName = rs.getString(1);
				if (null != queryName) {
					User user = new User();
					user.setName(rs.getString(1));
					user.setPassword(rs.getString(2));
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBLinks.close(conn, ps, rs);
		}
		return null;
	}

}
