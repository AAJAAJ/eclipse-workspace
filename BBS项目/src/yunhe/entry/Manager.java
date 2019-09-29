/**
 * 
 */
package yunhe.entry;

import java.util.Scanner;

import yunhe.controller.AdminController;
import yunhe.controller.BlockController;
import yunhe.controller.TopicController;
import yunhe.controller.UserController;
import yunhe.entity.User;
import yunhe.factory.MenuFactory;

/**
 * @author 性感渣渣傲在线打bug 2019年9月2日 下午4:56:11 
 * 		1.首界面 init() 
 * 		2.登录后界面 skillList(flag)
 *      3.登录方法 login() 
 *      4.注册方法 register()
 * 		5.登录方法
 * 		6.注册方法
 * 		7.选择版块 返回版块id
 * 		8.查看版块下的帖子
 * 		9.发帖
 * 		10.回帖
 * 		11.任意键返回
 * 		12.打印所有用户
 * 		13.修改用户状态
 * 		14.添加板块功能
 * 		15.删除主帖
 * 		16.查看最活跃用户
 * 		17.返回上一层
 */
public class Manager {
	static Scanner scan = new Scanner(System.in);
	static UserController userCon = new UserController();
	static BlockController blockCon = new BlockController();
	static TopicController topicCon = new TopicController();
	static AdminController adminCon = new AdminController();

	static MenuFactory menu = new MenuFactory();

	// 身份判断需要全局调用
	static int flag = 0;

	// 首界面
	public static void init() {
		// 调用登录菜单
		menu.entryMenu();
		// 获取用户输入的选项
		int number = scan.nextInt();
		// 判断用户的选择
		switch (number) {
		case 1:
			login();

			break;
		case 2:
			register();

			break;
		case 0:
			return;
		default:
			menu.error();
			init();
			break;
		}
	}

	// 登录后界面
	public static void skillList(int flag) {
		// 判断flag 0为管理员 1为普通用户 3为被封禁用户或者登陆失败用户
		if (flag == 3) {
			init();
		} else if (flag == 1) {
			// 普通用户
			menu.userMenu();
			// 功能选择
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				menuChoice(1);

				break;
			case 2:
				menuChoice(2);
				
				break;
			case 0:
				init();
				break;
			}
		} else {
			// 管理员菜单
			menu.admiMenu();
			// 功能选择
			int type = scan.nextInt();
			switch (type) {
			case 1:
				// 调用查看用户功能
				selectAllUser();
				exit();
				skillList(0);
				break;
			case 2:
				selectAllUser();
				// 调用修改用户状态功能
				alterUser();
				skillList(0);
				break;
			case 3:
				// 查看版块
				blockCon.selectAllBlock();
				exit();
				skillList(0);
				break;
			case 4:
				// 调用添加版块功能
				addBlock();
				exit();
				skillList(0);
				break;
			case 5:
				// 调用查看主帖功能
				// 查看版块
				blockCon.selectAllBlock();
				// 版块选择 返回版块id
				// 查看该版块的所有帖子
				int bid = choiceBlock();
				int tid = choiceTopic(bid);
				removeTopic(bid, tid);
				exit();
				skillList(0);
				break;
			case 6:
				// 调用查看最活跃用户功能
				selectHotUser();
				exit();
				skillList(0);
				break;
			case 7:
				blockCon.selectAllBlock();
				topicCon.countTopic(choiceBlock());
				exit();
				skillList(0);
				break;
			case 8:
				skillList(1);
				break;
			case 0:
				init();
				break;
			}

		}
	}

	// 登录方法
	public static void login() {
		System.out.println("请输入用户名");
		String userName = scan.next();
		System.out.println("请输入密码");
		String password = scan.next();
		// 调用登录方法，并判断用户身份
		flag = userCon.login(userName, password);
		skillList(flag);
	}

	// 注册方法
	public static void register() {
		System.out.println("请输入用户名");
		String userName = scan.next();
		System.out.println("请输入密码");
		String pwd = scan.next();
		System.out.println("请再次输入密码");
		String repwd = scan.next();
		if (userName != null && pwd != null) {
			if (!pwd.equals(repwd)) {
				System.out.println("两次密码不一致,请重新输入");
				register();
			} else {
				int result = userCon.register(userName, pwd);
				if (result > 0) {
					System.out.println("注册成功");
					skillList(userCon.login(userName, pwd));
				} else {
					System.out.println("注册失败，请重新输入");
					register();
				}
			}
		}
	}

	// 选择版块 返回版块id
	public static int choiceBlock() {
		int bid = scan.nextInt();
		return bid;
	}

	// 查看版块下的帖子
	public static int choiceTopic(int bid) {
		topicCon.selectAllTopic(bid);
		System.out.println("请输入id选择帖子");
		System.out.println("输入0返回");
		int tid = scan.nextInt();
		try {
			
		if (tid == 0) {
			menuChoice(2);
		} else {
			// 查看单个帖子
			topicCon.selectOne(tid);
		}
		} catch (Exception e) {
			System.out.println("该帖子不存在,请重新输入");
			choiceTopic(bid);
		}
		
		return tid;
	}

	// 发帖
	public static void sendTopic(int bid) {
		System.out.println("请输入标题");
		String title = scan.next();
		System.out.println("请输入内容");
		String context = scan.next();
		int result = userCon.sendTopic(title, context, bid);
		if (result == 1) {
			System.out.println("发帖成功");
			System.out.println("------------");
		} else {
			System.out.println("发帖失败");
		}
	}

	// 回帖
	public static void reply(int bid, int tid) {

		// 打印回复选单 1查看回复 2自己回复
		menu.lookORreply();
		int choice = scan.nextInt();
		// 返回上一层
		if (choice == 0) {
			choiceTopic(bid);
			reply(bid, tid);
		}
		else if (choice == 1) {
			topicCon.selectReply(tid);
			exit();
			topicCon.selectOne(tid);
			reply(bid,tid);

		} else if (choice == 2) {
			System.out.println("请输入标题");
			String title = scan.next();
			System.out.println("请输入内容");
			String context = scan.next();
			int result = userCon.reply(title, context, tid);
			if (result == 1) {
				System.out.println("回帖成功");
				System.out.println("------------");
				choiceTopic(bid);
			} else {
				System.out.println("回帖失败");
				exit();
				choiceTopic(bid);
			}
		}
	}

	//任意键返回
	public static void exit() {
		System.out.println("输入任意键返回");
		scan.nextInt();
	}

	// 打印所有用户
	public static void selectAllUser() {
		adminCon.selectUser();
	}

	// 修改用户状态
	public static void alterUser() {
		System.out.println("输入要更改的用户id");
		int uid = scan.nextInt();
		System.out.println("请输入选项,输入其他键返回");
		menu.alterState();
		int state = scan.nextInt();
		if (state == 0 || state == 1) {
			int result = adminCon.alterUser(uid, state);
			if (result == 1) {
				System.out.println("操作成功");
			} else {
				System.out.println("操作失败");
				alterUser();
			}
		} else {
			alterUser();
		}
	}

	// 添加板块功能
	public static void addBlock() {
		System.out.println("请输入要添加的版块名称");
		String bname = scan.next();
		int result = adminCon.addBlock(bname);
		if (result == 1) {
			System.out.println("成功添加版块 【" + bname + "】");
		} else {
			System.out.println("添加失败");
			addBlock();
		}
	}

	// 删除主帖
	public static void removeTopic(int bid, int tid) {
		menu.removeTopic();
		int choice = scan.nextInt();
		if (choice == 1) {
			int result = adminCon.removeTopic(tid);
			if (result == 1) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
				removeTopic(bid, tid);
			}
		} else if (choice == 0) {
			choiceTopic(bid);
		}
	}

	// 查看最活跃用户
	public static void selectHotUser() {
		User user = new User();
		user = adminCon.selectHotUser();
		System.out.println("【最活跃用户】" + user.getUname());
	}

	// 返回上一层方法
	public static void menuChoice(int number) {
		if (number == 1) {
			// 查看版块
			blockCon.selectAllBlock();
			// 版块选择 返回版块id
			// 调用发帖功能
			sendTopic(choiceBlock());
			exit();
			skillList(1);
		} else if (number == 2) {
			// 查看版块
			blockCon.selectAllBlock();
			// 版块选择
			int bid = choiceBlock();
			//帖子选择
			if (bid == 0) {
				skillList(1);
			} else {
				int tid = choiceTopic(bid);
				// 调用回帖功能
				reply(bid, tid);
			}
			
		} else if (number == 3) {
			
		} else if (number == 4) {

		} else if (number == 5) {

		} else if (number == 6) {

		} else if (number == 7) {

		} else if (number == 8) {

		} else if (number == 9) {

		}

	}

	public static void main(String[] args) {
		init();
	}

}
