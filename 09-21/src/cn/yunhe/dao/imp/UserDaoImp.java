/**
 * 
 */
package cn.yunhe.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yunhe.bean.User;
import cn.yunhe.dao.UserDao;
import cn.yunhe.utils.DBUtils;


/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月22日 下午3:35:44
 */
public class UserDaoImp implements UserDao{

	@Override
	public List<User> alluser() {//从数据库中获取数据封装成一个集合
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setPwd(rs.getString(3));
				userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return userList;
		}
	}