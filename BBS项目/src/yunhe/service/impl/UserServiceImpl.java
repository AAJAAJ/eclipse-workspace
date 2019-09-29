/**
 * 
 */
package yunhe.service.impl;

import yunhe.dao.UserDao;
import yunhe.dao.impl.UserDaoImpl;
import yunhe.entity.Reply;
import yunhe.entity.Topic;
import yunhe.entity.User;
import yunhe.service.UserService;
/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月2日 下午5:01:54
 * 
 */
public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(String userName, String password) {
		//根据需求去数据库中拿数据
		User user = userDao.login(userName, password);
		//将获取到的数据反馈给控制层
		return user;
	}

	@Override
	public int regist(String userName, String pwd) {
		return userDao.regist(userName, pwd);
	}

	@Override
	public int sendTopic(Topic topic) {
		return userDao.sendTopic(topic);
	}

	@Override
	public int reply(Reply reply) {
		return userDao.reply(reply);
	}

}
