package cn.yunhe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yunhe.dao.MotifDao;
import cn.yunhe.entity.Motif;
import cn.yunhe.utils.DBUtils;

public class MotifDaoImpl implements MotifDao {

	@Override
	public List<Motif> queryMotifList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Motif> motifList = new ArrayList<Motif>();
		try {
			conn = DBUtils.getConnection();
			String sql = "select sid,title,settime,state from subject";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Motif motif = new Motif();
				motif.setId(rs.getInt(1));
				motif.setMotif(rs.getString(2));
				motif.setCreate_date(rs.getTimestamp(3));
				motif.setState(rs.getString(4));
				motifList.add(motif);
			}
			return motifList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public Motif queryMotifById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select sid,title,settime,state from subject where sid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Motif motif = new Motif();
				motif.setId(rs.getInt(1));
				motif.setMotif(rs.getString(2));
				motif.setCreate_date(rs.getTimestamp(3));
				motif.setState(rs.getString(4));
				return motif;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return null;
	}
	@Override
	public int setMotifById(int state,int id) {
		String sql = "update subject set state=? where sid=?";
		Object[] objects = {state,id};
		return DBUtils.cudPre(sql, objects);
	}
	
	@Override
	public int delMotifById(int id) {
		String sql = "delete from subject where sid = ? ";
		Object[] obj = { id };
		return DBUtils.cudPre(sql, obj);
	}

	@Override
	public int addMotif(Motif motif) {
		String sql = "insert into subject(title) values(?)";
		return DBUtils.cudPre(sql, motif.getMotif());
	}

}
