package cn.yunhe.dao;

import cn.yunhe.entity.User;

public interface IUserDao {

	/**
	 * 根据ID查询用户信息
	 * @return
	 */
	User findUserById(int uid);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	int updateUser(User user);
}
