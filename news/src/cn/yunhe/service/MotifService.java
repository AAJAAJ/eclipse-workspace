package cn.yunhe.service;

import java.util.List;

import cn.yunhe.entity.Motif;

public interface MotifService {

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
	 * 	根据ID禁用主题
	 * @param id
	 * @return
	 */
	int setMotifById(int state,int id);
	
	/**
	 * 	根据ID删除主题
	 * @param id
	 * @return
	 */
	int delMotifById(int id);
	
	/**
	 * 	添加主题
	 * @param motif
	 * @return
	 */
	int addMotif(Motif motif);
}