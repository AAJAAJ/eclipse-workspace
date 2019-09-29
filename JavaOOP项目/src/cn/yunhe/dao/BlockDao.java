package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.Block;

/**
 * 版块数据层
 */
public interface BlockDao {
	
	/**
	 * 添加版块
	 * @param bname
	 * @return
	 */
	Block addBlock(String bname);
	
	/**
	 * 根据ID删除指定版块
	 * @param bid
	 * @return
	 */
	int delBlock(int bid);

	/**
	 * 查询所有的版块信息
	 * @return
	 */
	List<Block> queryBlock();
}
