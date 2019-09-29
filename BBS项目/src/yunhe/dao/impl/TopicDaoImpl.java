/**
 * 
 */
package yunhe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import yunhe.dao.TopicDao;
import yunhe.entity.Reply;
import yunhe.entity.Topic;
import yunhe.util.DBUtils;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月3日 上午11:20:39
 */
public class TopicDaoImpl implements TopicDao{

	@Override
	public ArrayList<Topic> selectAll(int bid) {
		Connection conn = null;
		// 预编译SQL语句的对象
		PreparedStatement ps = null;
		// 返回集
		ResultSet rs = null;
		//topic
		Topic topic = null;
		//定义一个数组用来装topic
		ArrayList<Topic> list = new ArrayList<Topic>();
		try {
			String sql = "select tid,title,ptime,uname from topic t inner join user u on t.uid = u.uid where bid = ?";
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					// 将获取到的值封装到一个topic对象中
					topic = new Topic();
					topic.setTid(rs.getInt(1));
					topic.setTitle(rs.getString(2));
					topic.setTtime(rs.getTime(3));
					
					list.add(topic);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Topic selectOne(int tid) {
		Connection conn = null;
		// 预编译SQL语句的对象
		PreparedStatement ps = null;
		// 返回集
		ResultSet rs = null;
		//topic
		Topic topic = null;
		
		try {
			String sql = "select tid,title,context,ptime,t.uid,bid,uname from topic t inner join user u on t.uid = u.uid where tid = ?";
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					// 将获取到的值封装到一个topic对象中
					topic = new Topic();
					topic.setTid(rs.getInt(1));
					topic.setTitle(rs.getString(2));
					topic.setContext(rs.getString(3));
					topic.setTtime(rs.getTime(4));
					topic.setUid(rs.getInt(5));
					topic.setBid(rs.getInt(6));
					System.out.println("昵称： "+rs.getString(7));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topic;
	}

	@Override
	public ArrayList<Reply> selectReply(int tid) {
		Connection conn = null;
		// 预编译SQL语句的对象
		PreparedStatement ps = null;
		// 返回集
		ResultSet rs = null;
		//reply
		Reply reply = null;
		//定义一个数组用来装topic
		ArrayList<Reply> list = new ArrayList<Reply>();
		try {
			String sql = "select rid,title,context,ptime,r.uid,tid,uname from reply r inner join user u on r.uid = u.uid where tid = ?";
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					// 将获取到的值封装到一个topic对象中
					reply = new Reply();
					reply.setRid(rs.getInt(1));
					reply.setTitle(rs.getString(2));
					reply.setContext(rs.getString(3));
					reply.setRtime(rs.getTime(4));
					reply.setUid(rs.getInt(5));
					reply.setTid(rs.getInt(6));
					list.add(reply);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int countTopic(int bid) {
		Connection conn = null;
		// 预编译SQL语句的对象
		PreparedStatement ps = null;
		// 返回集
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "select count(title) from topic where bid = ?;";
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					count = rs.getInt(1);
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
}
