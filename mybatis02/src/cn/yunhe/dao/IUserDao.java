package cn.yunhe.dao;

import cn.yunhe.entity.User;

public interface IUserDao {

	/**
	 * ����ID��ѯ�û���Ϣ
	 * @return
	 */
	User findUserById(int uid);
	
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	int updateUser(User user);
}
