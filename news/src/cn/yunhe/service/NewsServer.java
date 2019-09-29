package cn.yunhe.service;

import java.util.List;

import cn.yunhe.entity.News;

public interface NewsServer {
	/**
	 * 	查看所有新闻
	 */
	List<News> queryNews();
	/**
	 * 	查询有多少条新闻
	 */
	int sumNews();
	/**
	 * 	查询一页新闻
	 */
	List<News> queryPage(int pageIndex, int pageCount);
	/**
	 * 	添加新闻
	 */
	int addNews(String title,String content,int sid);
	/**
	 * 	删除新闻
	 */
	int delNews(int nid);
	/**
	 * 	根据新闻标题查找新闻
	 */
	List<News> select(String title);	
}
