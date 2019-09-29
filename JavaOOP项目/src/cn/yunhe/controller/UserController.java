package cn.yunhe.controller;

import cn.yunhe.entity.User;
import cn.yunhe.entry.Manager;
import cn.yunhe.service.UserService;
import cn.yunhe.service.impl.UserServiceImpl;

/**
 *用户控制层
 */
public class UserController {

	UserService userService = new UserServiceImpl();
	
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @param flag
	 */
	public void login(String userName,String password,int flag) {
		if(userName != null && password != null) {
			User user = userService.login(userName, password,flag);
			if(user != null) {
				System.out.println("欢迎"+user.getUname());
				Manager.skillList(flag);
			}else {
				System.out.println("登录失败,请检查用户名和密码");
			}
		}
	}
	
	/**
	 * 用户注册
	 * @param userName
	 * @param pwd
	 * @param repwd
	 */
	public void register(String userName,String pwd,String repwd) {
		int result = userService.regist(userName, repwd);
		if(result == 1) {
			System.out.println("注册成功");
			Manager.skillList(1);
		}else {
			System.out.println("注册失败");
		}
	}
}
