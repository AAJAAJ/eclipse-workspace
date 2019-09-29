package cn.yunhe.test;

import org.junit.Test;

import cn.yunhe.controller.UserController;

public class UserControllerTest {
	
	UserController userCon = new UserController();

	@Test
	public void testLogin() {
		String userName = "admin";
		String password = "admins";
		userCon.login(userName, password,0);
	}

}
