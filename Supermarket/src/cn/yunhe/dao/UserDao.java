/**
 * 
 */
package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.User;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月25日 下午5:43:30
 */
public interface UserDao {

	/**
	 * 
	 */
	List<User> allUser();
	/**
	 * 
	 */
	int addUser(User user);
	/**
	 * 
	 */
	User queryUser(User usre);
	
}
