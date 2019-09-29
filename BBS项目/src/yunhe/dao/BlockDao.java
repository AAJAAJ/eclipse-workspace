/**
 * 
 */
package yunhe.dao;

import java.util.ArrayList;

import yunhe.entity.Block;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月2日 上午11:45:05
 * 
 * 		查看板块
 */
public interface BlockDao {

	//查看所有版块
	ArrayList<Block> selectAll();
	
	/*
	 * //增加 int addBlock(int bname);
	 * 
	 * 
	 * //删除 int removeBlock(int bid);
	 */
	
}
