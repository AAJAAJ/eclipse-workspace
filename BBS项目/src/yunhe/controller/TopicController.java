/**
 * 
 */
package yunhe.controller;

import java.util.ArrayList;
import java.util.Scanner;

import yunhe.entity.Reply;
import yunhe.entity.Topic;
import yunhe.service.TopicService;
import yunhe.service.impl.TopicServiceImpl;

/**
 * @author 性感渣渣傲在线打bug 2019年9月3日 上午11:19:43
 */
public class TopicController {

	static Scanner scan = new Scanner(System.in);
	TopicService topicService = new TopicServiceImpl();

	/**
	 * 	查看所有帖子
	 */
	public void selectAllTopic(int bid) {
		ArrayList<Topic> list = topicService.selectAll(bid);
		System.out.println("-----帖子-----");
		for (Topic topic : list) {
			System.out.println(topic.getTid() +". "+ topic.getTitle()+"   "+ topic.getTtime());
		}
		System.out.println("---------------");
	}
	
	/**
	 * 	查看单个帖子
	 */
	public void selectOne(int tid) {
		System.out.println("---------------------");
		Topic topic = topicService.selectOne(tid);
		System.out.println("标题：  "+topic.getTitle());
		System.out.println("作者：  ");
		System.out.println("时间：  "+topic.getTtime());
		System.out.println("内容：  "+topic.getContext());
		System.out.println("---------------------");
	}
	
	/**
	 * 	查看帖子回复
	 */
	public void selectReply(int tid) {
		ArrayList<Reply> list = topicService.selectReply(tid);
		System.out.println("-----所有回复-----");
		for (Reply reply : list) {
			System.out.println(reply.getRid() +". "+ reply.getTitle()+"   "+ reply.getRtime());
		}
		System.out.println("--------------------");
	}
	/**
	 *	 查看帖子总数
	 */
	public int countTopic(int bid) {
		int count = topicService.countTopic(bid);
		System.out.println("该版块下的帖子总数为【"+count+"】");
		return bid;
	}
	
	
	
	
	
	
	
	
	
	
}
