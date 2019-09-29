/**
 * 
 */
package cn.yunhe.controller;

import cn.yunhe.entity.User;
import cn.yunhe.service.UserService;
import cn.yunhe.service.impl.UserServiceImpl;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月10日 下午7:46:21
 */
public class UserController {

	UserService userService = new UserServiceImpl();
	
	public User queryUser(String userName,String pwd) {
		return userService.queryUser(userName, pwd);
	}
	
	public static void main(String[] args) {
		UserController userController = new UserController();
		User user = userController.queryUser("a", "a");
		System.out.println(user.getUserName());
	}
}
