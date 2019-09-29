/**
 * 
 */
package cn.yunhe.service;

import cn.yunhe.entity.User;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月10日 下午7:44:31
 */
public interface UserService {
	User queryUser(String userName,String pwd);
}
