/**
 * 
 */
package yunhe.service.impl;

import java.util.ArrayList;

import yunhe.dao.BlockDao;
import yunhe.dao.impl.BlockDaoImpl;
import yunhe.entity.Block;
import yunhe.service.BlockService;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月3日 上午11:19:13
 */
public class BlockServiceImpl implements BlockService{

	BlockDao blockdao = new BlockDaoImpl();
	@Override
	public ArrayList<Block> selectAll() {
		ArrayList<Block> list = blockdao.selectAll();
		return list;
	}

}
