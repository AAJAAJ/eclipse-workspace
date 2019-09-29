/**
 * 
 */
package yunhe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import yunhe.dao.BlockDao;
import yunhe.entity.Block;
import yunhe.util.DBUtils;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月3日 上午11:21:24
 */
public class BlockDaoImpl implements BlockDao{

	@Override
	public ArrayList<Block> selectAll() {
		Connection conn = null;
		// 预编译SQL语句的对象
		PreparedStatement ps = null;
		// 返回集
		ResultSet rs = null;
		//block
		Block block = null;
		//定义一个数组用来装block
		ArrayList<Block> list = new ArrayList<Block>();
		try {
			String sql = "select bId,bName from block";
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					// 将获取到的值封装到一个user对象中
					block = new Block();
					block.setBid(rs.getInt(1));
					block.setBname(rs.getString(2));
					list.add(block);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
