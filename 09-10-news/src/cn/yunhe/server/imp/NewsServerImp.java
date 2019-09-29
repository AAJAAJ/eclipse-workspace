package cn.yunhe.server.imp;

import java.util.List;

import cn.yunhe.dao.NewsDao;
import cn.yunhe.dao.imp.NewsDaoImp;
import cn.yunhe.entity.News;
import cn.yunhe.server.NewsServer;

public class NewsServerImp implements NewsServer {

	NewsDao nd = new NewsDaoImp();
	@Override
	public List<News> queryNews() {
		return nd.queryNews();
	}

	@Override
	public int sumNews() {
		return nd.sumNews();
	}

	@Override
	public List<News> queryPage(int pageIndex, int pageCount) {
		return nd.queryPage(pageIndex, pageCount);
	}

	@Override
	public int addNews(String title, String content, int sid) {
		return nd.addNews(title, content, sid);
	}

	@Override
	public int delNews(int nid) {
		return nd.delNews(nid);
	}

	@Override
	public List<News> select(String title) {
		return nd.select(title);
	}

}
