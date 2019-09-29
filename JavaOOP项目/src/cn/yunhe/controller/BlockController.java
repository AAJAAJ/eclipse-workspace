package cn.yunhe.controller;

import java.util.List;

import cn.yunhe.entity.Block;
import cn.yunhe.service.BlockService;
import cn.yunhe.service.impl.BlockServiceImpl;

public class BlockController {

	BlockService blockService = new BlockServiceImpl();
	
	/**
	 * 添加版块
	 * @param bname
	 */
	public void addBlock(String bname) {
		Block block = blockService.addBlock(bname);
		if(block != null) {
			System.out.println("版块添加成功");
			queryBlock();
			//给用户选择接下来的操作
		}else {
			System.out.println("添加失败");
			//失败后的操作
		}
	}

	/**
	 * 删除指定ID的版块
	 * @param bid
	 */
	public void delBlock(int bid) {
		int result = blockService.delBlock(bid);
		System.out.println("删除成功");
	}
	
	/**
	 * 展示所有的版块信息
	 */
	public void queryBlock() {
		//展示所有的版块--查询所有的版块信息
		List<Block> blockList = blockService.queryBlock();
		System.out.println("版块ID\t\t版块名称");
		for(Block b : blockList) {
			System.out.println(b.getBid()+"\t\t\t"+b.getBname());
		}
		//展示完之后的操作
	}
}
