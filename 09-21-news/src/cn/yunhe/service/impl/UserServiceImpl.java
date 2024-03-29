package cn.yunhe.service.impl;

import cn.yunhe.dao.UserDao;
import cn.yunhe.dao.impl.UserDaoImpl;
import cn.yunhe.entity.User;
import cn.yunhe.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	
	@Override
	public User queryUser(String userName, String pwd) {
		return userDao.queryUser(userName, pwd);
	}

}
