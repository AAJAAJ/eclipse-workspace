/**
 * 
 */
package cn.yunhe.server.imp;

import cn.yunhe.dao.UserDao;
import cn.yunhe.dao.imp.UserDaoImp;
import cn.yunhe.entity.User;
import cn.yunhe.server.UserServer;

/**
 * @author 魏无羡 
 *2019年9月10日
 */
public class UserServerImp implements UserServer {


	UserDao ud = new UserDaoImp();
	@Override
	public User user(String userName, String password) {
		User user =  ud.user(userName, password);
		return user;
	}

}
