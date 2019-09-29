package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.User;

public interface IUserDao {

	/**
	 * 	����û�
	 * @param user
	 * @return
	 */
	int addUser(User user) ;
	
	/**
	 * 	�����û�ID�޸��û���Ϣ
	 * @param user
	 * @return
	 */
	int updateUser(User user) ;
	
	/**
	 *	 ����IDɾ���û�
	 * @param uid
	 * @return
	 */
	int delUser(int uid) ;
	
	/**
	 * 	����ID��ѯ�û���Ϣ
	 * @param uid
	 * @return
	 */
	User queryUserById(int uid) ;
	
	/**
	 * 	�����û���ģ����ѯ
	 * @param uname
	 * @return
	 */
	List<User> queryUserList(String uname) ;
	
	/**
	 * 	��ѯ���е��û���Ϣ
	 * @return
	 */
	List<User> queryAllUsers() ;
}
