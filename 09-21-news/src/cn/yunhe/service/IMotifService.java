package cn.yunhe.service;

import java.util.List;

import cn.yunhe.entity.Motif;

public interface IMotifService {
	/**
	 * 	查询所有的主题列表
	 * @return
	 */
	List<Motif> queryMotifList();
	
	/**
	 * 	根据ID查看主题信息
	 * @param id
	 * @return
	 */
	Motif queryMotifById(int id);
	
	/**
	 * 	根据ID删除主题
	 * @param id
	 * @return
	 */
	int delMotifById(String state,int id);
	
	/**
	 * 	添加主题
	 * @param motif
	 * @return
	 */
	int addMotif(Motif motif);
	
	/**
	 * 获取总条数
	 * @return
	 */
	int getCount();
	
	/**
	 * 	分页查询
	 * @param pageCount
	 * 		每页要展示的数据条数
	 * @param pageIndex
	 * 		页码数
	 * @return
	 */
	List<Motif> queryMotifList(int pageCount,int pageIndex);
}
