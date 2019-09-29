/**
 * 
 */
package yunhe.controller;

import java.util.ArrayList;


import yunhe.entity.Block;
import yunhe.service.BlockService;
import yunhe.service.impl.BlockServiceImpl;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月2日 下午4:05:47
 * 
 * 	查看版块
 */
public class BlockController {

	BlockService blockService = new BlockServiceImpl();
	
	/**
	 * 查看板块
	 */
	public void selectAllBlock() {
		ArrayList<Block> list =blockService.selectAll();
		System.out.println("-----版块-----");
		for (Block block : list) {
			System.out.println(block.getBid() +". "+ block.getBname());
		}
		System.out.println("0.返回");
		System.out.println("---------------");
		System.out.println("请选择版块");
	}
}
