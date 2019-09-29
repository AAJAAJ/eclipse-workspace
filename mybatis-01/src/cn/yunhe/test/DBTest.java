package cn.yunhe.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.yunhe.utils.DBUtils;

public class DBTest {

	/**
	 * ��ʾ���е��û���Ϣ
	 */
	@Test
	public void showUserInfos() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			String sql = "select * from t_user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+
						rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
	}
	
	/**
	 *	 �޸��û�״̬
	 */
	@Test
	public void updateUserInfo() {
		String sql = "update t_user set flag = ? where uid = ?";
		Object[] objects = {0,6};
		int result = DBUtils.insertOrUpdateOrDel(sql, objects);
		System.out.println(result);
	}
}
