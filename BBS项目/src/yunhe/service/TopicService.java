/**
 * 
 */
package yunhe.service;

import java.util.ArrayList;

import yunhe.entity.Reply;
import yunhe.entity.Topic;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月3日 上午11:22:09
 */
public interface TopicService {

	/**
	 * 	传入版块ID查看所有帖子
	 */
	ArrayList<Topic> selectAll(int bid);
	
	/**
	 *	 传入帖子ID查看帖子内容
	 */
	Topic selectOne(int tid);
	
	/**
	 *	 传入帖子ID查看帖子回复
	 */
	ArrayList<Reply> selectReply(int tid);
	/**
	 *	 查看帖子总数
	 */
	int countTopic(int bid);
	
	
}
