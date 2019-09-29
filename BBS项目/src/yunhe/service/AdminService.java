/**
 * 
 */
package yunhe.service;

import java.util.ArrayList;

import yunhe.entity.User;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月3日 上午11:22:22
 */
public interface AdminService {

	//查看用户
	ArrayList<User> selectUser();
	
	//按ID修改
	int alterUser(int uid,int state);
	
	
	//添加版块
	int addBlock(String bname);
	
	
	// 删除主帖
	int removeTopic(int tid);
	
	
	//活跃用户
	User selectHotUser();
	
	
	
}
