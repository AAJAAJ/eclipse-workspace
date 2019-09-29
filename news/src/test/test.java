/**
 * 
 */
package test;

import java.util.List;

import cn.yunhe.controller.MotifController;
import cn.yunhe.controller.NewsController;
import cn.yunhe.controller.UserController;
import cn.yunhe.entity.News;
import cn.yunhe.entity.User;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月11日 下午3:49:07
 */
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewsController newsController = new NewsController();
		List<News> newsList = newsController.queryNews();
		for (News news:newsList) {
			System.out.println(news.getTitle());
		}
	}

}
