/**
 * 
 */
package yunhe.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import yunhe.dao.UserDao;
import yunhe.entity.Reply;
import yunhe.entity.Topic;
import yunhe.entity.User;
import yunhe.util.DBUtils;

/**
 * @author 性感渣渣傲在线打bug 2019年9月2日 下午4:37:46
 */
public class UserDaoImpl implements UserDao {

	@Override
	public User login(String userName, String password) {
		// 连接对象
		Connection conn = null;
		// 预编译SQL语句的对象
		PreparedStatement ps = null;
		// 返回集
		ResultSet rs = null;
		// user对象
		User user = null;
		try {
			String sql = "select uId,uName,uPass,state,flag from user where uName=? and uPass=?";
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					// 将获取到的值封装到一个user对象中
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
	public int regist(String userName, String pwd) {

		String sql = "insert into user(uName,uPass) values(?,?)";

		Object[] obj = { userName, pwd };

		return DBUtils.cudPre(sql, obj);
	}

	@Override
	public int sendTopic(Topic topic) {

		String sql = "insert into topic(title,context,uId,bId) values(?,?,?,?)";

		Object[] obj = { topic.getTitle(), topic.getContext(), topic.getUid(), topic.getBid() };

		return DBUtils.cudPre(sql, obj);
	}

	@Override
	public int reply(Reply reply) {

		String sql = "insert into reply(title,context,uId,tId) values(?,?,?,?)";

		Object[] obj = { reply.getTitle(), reply.getContext(), reply.getUid(), reply.getTid() };

		return DBUtils.cudPre(sql, obj);
	}

}
