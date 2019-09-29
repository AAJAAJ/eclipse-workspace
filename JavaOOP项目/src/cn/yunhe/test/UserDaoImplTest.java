package cn.yunhe.test;

import org.junit.Test;

import cn.yunhe.dao.UserDao;
import cn.yunhe.dao.impl.UserDaoImpl;
import cn.yunhe.entity.User;

public class UserDaoImplTest {
	
	UserDao userDao = new UserDaoImpl();

	@Test
	public void testLogin() {
		String userName = "admin";
		String password = "admin";
		User user = userDao.login(userName, password);
		System.out.println(user);
	}

	@Test
	public void testRegist() {
	}

	@Test
	public void testSendTopic() {
	}

	@Test
	public void testReply() {
	}

}
