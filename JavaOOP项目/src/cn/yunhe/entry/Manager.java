package cn.yunhe.entry;

import java.util.Scanner;

import cn.yunhe.controller.UserController;

public class Manager {
	 static Scanner scan = new Scanner(System.in);
	 static UserController userCon = new UserController();
	
	/**
	 * 初始化
	 */
	public static void init() {
		System.out.println("欢迎来到泛IT学院");
		System.out.println("1 管理员登录 \t\t 2 用户登录\t\t 3 注册");
		System.out.println("请选择登录角色:");
		//获取用户的选择
		int number = scan.nextInt();
		int flag = 1;
		switch(number) {
		case 1:
			flag = 0;
			login(flag);
			break;
		case 2:
			flag = 1;
			login(flag);
			break;
		case 3:
			register();
			break;
		}
	}
	
	/**
	 * 功能列表
	 * @param flag
	 */
	public static void skillList(int flag) {
		//普通用户
		if(flag == 1) {
			System.out.println("1 发送帖子");
			System.out.println("2 回复帖子");
			System.out.println("请选择所需的功能:");
			int type = scan.nextInt();
			switch(type) {
			case 1:
				//调用发帖功能
				break;
			case 2:
				//调用回帖功能
				break;
			}
		}else {//管理员
			System.out.println("1 查看用户列表");
			System.out.println("2 修改用户状态");
			System.out.println("3 添加版块");
			System.out.println("4 删除版块");
		}
	}
	
	/**
	 * 用户登录
	 * @param flag
	 */
	public static void login(int flag) {
		System.out.println("请输入用户名");
		String userName = scan.next();
		System.out.println("请输入密码");
		String password = scan.next();
		userCon.login(userName, password, flag);
	}
	
	/**
	 * 用户注册
	 */
	public static void register() {
		System.out.println("请输入用户名");
		String userName = scan.next();
		System.out.println("请输入密码");
		String pwd = scan.next();
		System.out.println("请再次输入密码");
		String repwd = scan.next();
		if(userName != null && pwd != null) {
			if(!pwd.equals(repwd)) {
				System.out.println("两次密码不一致,请重新输入");
				register();
			}else {
				userCon.register(userName, pwd, repwd);
			}
		}
	}
}
