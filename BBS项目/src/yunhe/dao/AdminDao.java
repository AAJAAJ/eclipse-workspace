/**
 * 
 */
package yunhe.dao;

import java.util.ArrayList;

import yunhe.entity.User;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月2日 上午11:44:57
 * 	要求
 * 		用户管理---查看和禁用
 * 		版块管理---查看和增加
 * 		主帖管理---查看和删除
 * 		统计汇总---最活跃用户和版块总贴数
 *	 实现
 * 		查看用户列表
 * 		修改用户状态
 * 		
 * 		添加版块
 * 		
 * 		删除主贴
 * 		查看最活跃用户
 * 		查看版块总贴数
 * 
 */
public interface AdminDao {

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
