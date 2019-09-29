package cn.yunhe.service;

import cn.yunhe.entity.Reply;
import cn.yunhe.entity.Topic;
import cn.yunhe.entity.User;

/**
 * 用户业务层
 * 为什么和数据层一样?
 * 	数据层包含的是需要从数据库中调用或修改数据的操作
 * 	业务层包含了需要对数据的操作业务,同时也包含了其它业务
 */
public interface UserService {
	
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @return
	 */
	User login(String userName,String password,int flag);
	
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
