package cn.yunhe.dao;

import cn.yunhe.entity.Reply;
import cn.yunhe.entity.Topic;
import cn.yunhe.entity.User;

/**
 * 用户数据层
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
	int regist(String userName,String pwd,String repwd) ;
	
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
