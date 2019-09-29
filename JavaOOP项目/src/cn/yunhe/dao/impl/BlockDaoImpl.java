package cn.yunhe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yunhe.dao.BlockDao;
import cn.yunhe.entity.Block;
import cn.yunhe.utils.DBUtils;

/**
 * 版块数据层实现类
 */
public class BlockDaoImpl implements BlockDao {

	@Override
	public Block addBlock(String bname) {
		Block block = null;
		String sql = "insert into t_block(bname) values(?)";
		int result = DBUtils.cudPre(sql, bname);
		if(result == 1) {
			block = new Block();
			block.setBname(bname);
		}
		return block;
	}

	/**
	 * 1 如果该版块下没有其他数据,那可直接删除
	 * 2 如果该版块下有对应的数据
	 * 	需要先删除关联的数据,在执行删除版块的操作
	 */
	@Override
	public int delBlock(int bid) {
		String sql = "delete from t_block where bid=?";
		return DBUtils.cudPre(sql, bid);
	}

	@Override
	public List<Block> queryBlock() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Block> blockList = new ArrayList<>();
		try {
			String sql = "select bid,bname from t_block";
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Block block = new Block();
				block.setBid(rs.getInt(1));
				block.setBname(rs.getString(2));
				blockList.add(block);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return blockList;
	}

}
