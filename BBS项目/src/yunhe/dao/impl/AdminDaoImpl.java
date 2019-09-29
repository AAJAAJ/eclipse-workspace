/**
 * 
 */
package yunhe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import yunhe.dao.AdminDao;
import yunhe.entity.User;
import yunhe.util.DBUtils;

/**
 * @author 性感渣渣傲在线打bug 2019年9月3日 上午11:20:56
 */
public class AdminDaoImpl implements AdminDao {

	@Override
	public ArrayList<User> selectUser() {
		Connection conn = null;
		// 预编译SQL语句的对象
		PreparedStatement ps = null;
		// 返回集
		ResultSet rs = null;

		User user = null;
		// 定义一个数组用来装user
		ArrayList<User> list = new ArrayList<User>();
		try {
			String sql = "select uId,uName,state,flag from user";
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					// 将获取到的值封装到一个topic对象中
					user = new User();
					user.setUid(rs.getInt(1));
					user.setUname(rs.getString(2));
					user.setState(rs.getInt(3));
					user.setFlag(rs.getInt(4));
					list.add(user);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int alterUser(int uid, int state) {

		String sql = "update user set state = ? where uid = ?";

		Object[] obj = { state, uid };

		return DBUtils.cudPre(sql, obj);
	}

	@Override
	public int addBlock(String bname) {
		String sql = "insert into block(bName) values(?)";

		Object[] obj = { bname };

		return DBUtils.cudPre(sql, obj);
	}

	@Override
	public int removeTopic(int tid) {
		String sql = "delete from topic where tid = ? ";

		Object[] obj = { tid };

		return DBUtils.cudPre(sql, obj);
	}

	@Override
	public User selectHotUser() {
		Connection conn = null;
		// 预编译SQL语句的对象
		PreparedStatement ps = null;
		// 返回集
		ResultSet rs = null;

		User user = null;
		
		try {
			String sql = "select uname from (select uname,count(title) c from user u inner join topic t on u.uid = t.uid group by t.uid) a order by c";
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					// 将获取到的值封装到一个topic对象中
					user = new User();
					user.setUname(rs.getString(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
