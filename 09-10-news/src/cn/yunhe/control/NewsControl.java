package cn.yunhe.control;

import java.util.List;

import cn.yunhe.entity.News;
import cn.yunhe.server.NewsServer;
import cn.yunhe.server.imp.NewsServerImp;

public class NewsControl {
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

	public int addNews(String title, String content, int sid) {
		return ns.addNews(title, content, sid);
	}

	public int delNews(int nid) {
		return ns.delNews(nid);
	}
	public List<News> select(String title){
		return ns.select(title);
	}
}
