package cn.yunhe.controller;

import java.util.List;

import cn.yunhe.entity.News;
import cn.yunhe.service.NewsServer;
import cn.yunhe.service.impl.NewsServerImp;

public class NewsController {
	NewsServer ns =  new NewsServerImp();
	
	public List<News> queryNews() {
		return ns.queryNews();
	}

	public int sumNews() {
		return ns.sumNews();
	}

	public List<News> queryPage(int pageIndex, int pageCount) {
		return ns.queryPage(pageIndex, pageCount);
	}

	public int addNews(String title, String content, int mid) {
		return ns.addNews(title, content, mid);
	}

	public int delNews(int nid) {
		return ns.delNews(nid);
	}
	public List<News> select(String title){
		return ns.select(title);
	}
}
