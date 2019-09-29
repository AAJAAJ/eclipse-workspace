/**
 * 
 */
package yunhe.service.impl;

import java.util.ArrayList;

import yunhe.dao.TopicDao;
import yunhe.dao.impl.TopicDaoImpl;
import yunhe.entity.Reply;
import yunhe.entity.Topic;
import yunhe.service.TopicService;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月3日 上午11:22:54
 */
public class TopicServiceImpl implements TopicService{

	TopicDao topicDao = new TopicDaoImpl();

	@Override
	public ArrayList<Topic> selectAll(int bid) {
		ArrayList<Topic> list = topicDao.selectAll(bid);
		return list;
	}

	@Override
	public Topic selectOne(int tid) {
		
		return topicDao.selectOne(tid);
	}

	@Override
	public ArrayList<Reply> selectReply(int tid) {
		ArrayList<Reply> list = topicDao.selectReply(tid);
		return list;
	}

	@Override
	public int countTopic(int bid) {
		
		return topicDao.countTopic(bid);
	}

	
	

}
