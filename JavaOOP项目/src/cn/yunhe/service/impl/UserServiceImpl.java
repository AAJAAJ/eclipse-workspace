package cn.yunhe.service.impl;

import cn.yunhe.dao.UserDao;
import cn.yunhe.dao.impl.UserDaoImpl;
import cn.yunhe.entity.Reply;
import cn.yunhe.entity.Topic;
import cn.yunhe.entity.User;
import cn.yunhe.service.UserService;
/**
 * 业务逻辑实现类
 */
public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(String userName, String password,int flag) {
		//根据需求去数据库中拿数据
		User user = userDao.login(userName, password,flag);
		//将获取到的数据反馈给控制层
		return user;
	}

	@Override
	public int regist(String userName, String pwd) {
		return userDao.regist(userName, pwd);
	}

	@Override
	public int sendTopic(Topic topic) {
		return 0;
	}

	@Override
	public int reply(Reply reply) {
		return 0;
	}

}
