package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.Order;
import cn.yunhe.entity.User;
import cn.yunhe.entity.UserCustom;

public interface IUserDao {

	/**
	 * 	添加用户
	 * @param user
	 * @return
	 */
	int addUser(User user) ;
	
	/**
	 * 	根据用户ID修改用户信息
	 * @param user
	 * @return
	 */
	int updateUser(User user) ;
	
	/**
	 *	 根据ID删除用户
	 * @param uid
	 * @return
	 */
	int delUser(int uid) ;
	
	/**
	 * 	根据ID查询用户信息
	 * @param uid
	 * @return
	 */
	User queryUserById(int uid) ;
	
	/**
	 * 	根据用户名模糊查询
	 * @param uname
	 * @return
	 */
	List<User> queryUserList(String uname) ;
	
	/**
	 * 	查询所有的用户信息
	 * @return
	 */
	List<User> queryAllUsers() ;
	
	/**
	 * 查询用户及对应的订单等等信息
	 * @param userCustom
	 * @return
	 */
	List<User> queryInfoList(UserCustom userCustom) ;
	
	/**
	 * 查询指定用户对应的订单列表
	 * @param user
	 * @return
	 */
	User queryOrderListByUserId(int uid) ; 
}
