/**
 * 
 */
package yunhe.dao;

import yunhe.entity.Reply;
import yunhe.entity.Topic;
import yunhe.entity.User;


/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月2日 上午11:44:45
 * 	用户数据
 * 	       实现
 * 		登录
 * 		注册
 * 		发帖
 * 		回帖
 */
public interface UserDao {

	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @return
	 */
	User login(String userName,String password);
	
	/**
	 * 用户注册
	 * @param userName
	 * @param pwd
	 * @param repwd
	 * @return
	 */
	int regist(String userName,String pwd) ;
	
	/**
	 * 发送帖子
	 * @param topic
	 * @return
	 */
	int sendTopic(Topic topic) ;
	
	/**
	 * 回复帖子
	 * @param reply
	 * @return
	 */
	int reply(Reply reply) ;
}
