/**
 * 
 */
package yunhe.controller;

import yunhe.entity.Reply;
import yunhe.entity.Topic;
import yunhe.entity.User;
import yunhe.service.UserService;
import yunhe.service.impl.UserServiceImpl;

/**
 * @author 性感渣渣傲在线打bug 2019年9月2日 下午4:05:57
 * 		登录
 * 		注册
 * 		发帖
 * 		回帖
 */
public class UserController {

	UserService userService = new UserServiceImpl();
	
	public static User user = null;
	/**
	 * 用户登录
	 * 
	 * @param userName
	 * @param password
	 * @param flag
	 * @return
	 */
	public int login(String userName, String password) {
		int flag = 0;
		if (userName != null && password != null) {
			user = userService.login(userName, password);
			if (user != null) {
				if (user.getFlag() == 0) {
					System.out.println("欢迎【管理员】" + user.getUname());
					flag = 0;
				} else {
					if (user.getState() == 1) {
						System.out.println("您已被封禁，请耐心等待解封");
						flag = 3;
					} else {
						System.out.println("欢迎【用户】" + user.getUname());
						flag = user.getFlag();
					}

				}
			} else {
				System.out.println("登录失败,请检查用户名和密码");
				flag = 3;
			}
		}
		return flag;
	}

	/**
	 * 用户注册
	 * 
	 * @param userName
	 * @param pwd
	 * @param repwd
	 */
	public int register(String userName, String pwd) {
		//调用注册返回1成功
		return userService.regist(userName, pwd);
	}

	/**
	 * 发帖
	 * 
	 * @param topic
	 */
	public int sendTopic(String title,String context,int bid) {
		Topic topic = new Topic();
		topic.setBid(bid);
		topic.setTitle(title);
		topic.setContext(context);
		topic.setUid(user.getUid());
		return userService.sendTopic(topic);
	}
	
	/**
	 * 回帖
	 * 
	 * @param reply
	 */
	public int reply(String title,String context,int tid) {
		Reply reply = new Reply();
		reply.setTid(tid);
		reply.setTitle(title);
		reply.setContext(context);
		reply.setUid(user.getUid());
		return userService.reply(reply);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
