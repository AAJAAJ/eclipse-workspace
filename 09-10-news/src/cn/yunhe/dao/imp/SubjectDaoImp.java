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

import cn.yunhe.dao.SubjectDao;
import cn.yunhe.entity.Subject;
import cn.yunhe.jdbc.DBLinks;

/**
 * @author 魏无羡 
 *2019年9月11日
 */
public class SubjectDaoImp implements SubjectDao {
	/**
	 * 	查询所有主题
	 */
	@Override
	public List<Subject> selectlList() {
		Connection ccon = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Subject subject = new Subject();
		List<Subject> list = new ArrayList<Subject>();
		try {
			ccon=DBLinks.getConnection();
			String sql = "select sid,title,settime,state from subject";
			ps = ccon.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				subject = new Subject();
				subject.setSid(rs.getInt(1));
				subject.setTitle(rs.getString(2));
				subject.setSettimeDate(rs.getTimestamp(3));
				subject.setState(rs.getString(4));
				list.add(subject);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBLinks.close(ccon, ps, rs);
		}
		return null;
	}
	/**
	 * 	查询一个主题
	 */
	@Override
	public Subject selectSubject(int id) {
		Connection ccon = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Subject subject = new Subject();
		try {
			ccon=DBLinks.getConnection();
			String sql = "select * from subject where sid=?";
			ps = ccon.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				subject = new Subject();
				subject.setTitle(rs.getString(2));
				subject.setState(rs.getString(4));
				return subject;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBLinks.close(ccon, ps, rs);
		}
		return null;
	}
	/**
	 * 	添加主题
	 */
	@Override
	public int addSubject(String title) {
		String sql = "insert into subject(title) values(?) ";
		
		return DBLinks.cudPre(sql, title);
	}
	/**
	 * 	修改主题状态
	 */
	@Override
	public int noSubject(int state,int id) {
		String sql = "update subject set state=? where sid=?";
		Object[] objects = {state,id}; 
		
		return DBLinks.cudPre(sql, objects);
	}
	/**
	 * 	修改主题名
	 */
	@Override
	public int delSbuject(int id) {
		String sql = "delete from subject where sid=?";
		
		return DBLinks.cudPre(sql, id);
	}
	/**	
	 * 	查询主题总条数
	 */
	@Override
	public int sumPage() {
		
		Connection ccon = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ccon=DBLinks.getConnection();
			String sql = "select count(sid) from subject";
			ps = ccon.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBLinks.close(ccon, ps, rs);
		}
		return 0;
	}
	/**
	 * 	分页查询
	 * 	pageCount 一页多少条
	 * 	pageIndex 页码
	 */
	@Override
	public List<Subject> selectPage(int pageIndex, int pageCount) {
		Connection ccon = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Subject subject = new Subject();
		List<Subject> list = new ArrayList<Subject>();
		try {
			ccon=DBLinks.getConnection();
			String sql = "select sid,title,settime,state from subject limit ?,?";
			ps = ccon.prepareStatement(sql);
			ps.setInt(1, (pageIndex-1)*pageCount);
			ps.setInt(2, pageCount);
			rs = ps.executeQuery();
			while(rs.next()) {
				subject = new Subject();
				subject.setSid(rs.getInt(1));
				subject.setTitle(rs.getString(2));
				subject.setSettimeDate(rs.getTimestamp(3));
				subject.setState(rs.getString(4));
				list.add(subject);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBLinks.close(ccon, ps, rs);
		}
		return null;
	}

}
