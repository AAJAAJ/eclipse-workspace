/**
 * 
 */
package cn.yunhe.dao;
/**
 * @author 魏无羡 
 *2019年9月10日
 */

import cn.yunhe.entity.User;
/**
 * 	查询用户
 */
public interface UserDao {
	User user(String userName,String  password);
}
