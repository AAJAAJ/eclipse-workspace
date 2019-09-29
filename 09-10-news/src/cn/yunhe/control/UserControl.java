/**
 * 
 */
package cn.yunhe.control;
/**
 * @author 魏无羡 
 *2019年9月10日
 */

import cn.yunhe.entity.User;
import cn.yunhe.server.UserServer;
import cn.yunhe.server.imp.UserServerImp;

public class UserControl {
	static UserServer us = new UserServerImp();
	//输入账号密码判断是否存在
	public  User user(String name,String password) {
		return us.user(name, password);
	}
}
