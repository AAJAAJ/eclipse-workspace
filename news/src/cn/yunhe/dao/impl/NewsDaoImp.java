package cn.yunhe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yunhe.dao.NewsDao;
import cn.yunhe.entity.News;
import cn.yunhe.utils.DBUtils;

public class NewsDaoImp implements NewsDao {
	/**
	 * 	查看所有新闻
	 */
	@Override
	public List<News> queryNews() {
		Connection ccon = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		News news = new News();
		List<News> list = new ArrayList<News>();
		try {
			ccon=DBUtils.getConnection();
			String sql = "select nid,title,content,sendtime,sid from news";
			ps = ccon.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				news = new News();
				news.setNid(rs.getInt(1));
				news.setTitle(rs.getNString(2));
				news.setContent(rs.getString(3));
				news.setTime(rs.getDate(4));
				news.setMid(rs.getInt(5));
				list.add(news);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(ccon, ps, rs);
		}
		return null;
	}
	/**
	 * 	查看一页的新闻
	 */
	@Override
	public List<News> queryPage(int pageIndex, int pageCount) {
		Connection ccon = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		News news = new News();
		List<News> list = new ArrayList<News>();
		try {
			ccon=DBUtils.getConnection();
			String sql = "select nid,title,content,sendtime,sid from news limit ?,?";
			ps = ccon.prepareStatement(sql);
			ps.setInt(1, (pageIndex-1)*pageCount);
			ps.setInt(2, pageCount);
			rs = ps.executeQuery();
			while(rs.next()) {
				news = new News();
				news.setNid(rs.getInt(1));
				news.setTitle(rs.getNString(2));
				news.setContent(rs.getString(3));
				news.setTime(rs.getDate(4));
				news.setMid(rs.getInt(5));
				list.add(news);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(ccon, ps, rs);
		}
		return null;
	}
	/**
	 * 添加新闻
	 */
	@Override
	public int addNews(String title, String content, int sid) {
		String sql = "insert into news(title,content,sid) values(?,?,?)";
		Object[] objects = {title,content,sid};
		return DBUtils.cudPre(sql, objects);
	}
	/**
	 * 	删除新闻
	 */
	@Override
	public int delNews(int nid) {
		String sql = "delete from news where nid=?";
		return DBUtils.cudPre(sql, nid);
	}
	/**
	 * 	查看总共有多少条新闻
	 */
	@Override
	public int sumNews() {
		Connection ccon = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ccon=DBUtils.getConnection();
			String sql = "select count(nid) from news";
			ps = ccon.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(ccon, ps, rs);
		}
		return 0;
	}
	@Override
	public List<News> select(String title) {
		Connection ccon = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		News news = new News();
		List<News> list = new ArrayList<News>();
		try {
			ccon=DBUtils.getConnection();
			String sql = "select * from news where title=?";
			ps = ccon.prepareStatement(sql);
			ps.setString(1, title);
			rs = ps.executeQuery();
			while(rs.next()) {
				news = new News();
				news.setNid(rs.getInt(1));
				news.setTitle(rs.getNString(2));
				news.setContent(rs.getString(3));
				news.setTime(rs.getDate(4));
				news.setMid(rs.getInt(5));
				list.add(news);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(ccon, ps, rs);
		}
		return null;
	}

}
