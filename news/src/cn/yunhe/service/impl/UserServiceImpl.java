/**
 * 
 */
package cn.yunhe.service.impl;

import cn.yunhe.dao.UserDao;
import cn.yunhe.dao.impl.UserDaoImpl;
import cn.yunhe.entity.User;
import cn.yunhe.service.UserService;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月10日 下午7:47:14
 */
public class UserServiceImpl implements UserService{

	UserDao userDao = new UserDaoImpl();
	@Override
	public User queryUser(String userName, String pwd) {
		// TODO Auto-generated method stub
		return userDao.queryUser(userName, pwd);
	}

}
