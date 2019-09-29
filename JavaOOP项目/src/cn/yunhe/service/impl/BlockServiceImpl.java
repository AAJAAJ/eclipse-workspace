package cn.yunhe.service.impl;

import java.util.List;

import cn.yunhe.dao.BlockDao;
import cn.yunhe.dao.impl.BlockDaoImpl;
import cn.yunhe.entity.Block;
import cn.yunhe.service.BlockService;

public class BlockServiceImpl implements BlockService{

	BlockDao blockDao = new BlockDaoImpl();
	
	@Override
	public Block addBlock(String bname) {
		return blockDao.addBlock(bname);
	}

	@Override
	public int delBlock(int bid) {
		return blockDao.delBlock(bid);
	}

	@Override
	public List<Block> queryBlock() {
		return blockDao.queryBlock();
	}

}
