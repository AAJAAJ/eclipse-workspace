/**
 * 
 */
package yunhe.controller;

import java.util.ArrayList;


import yunhe.entity.User;
import yunhe.service.AdminService;
import yunhe.service.impl.AdminServiceImpl;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月3日 上午11:20:15
 */
public class AdminController {

	AdminService adminService = new AdminServiceImpl();
	//查看所有用户
	public void selectUser() {
		ArrayList<User> list = adminService.selectUser();
		String flagString = null;
		String stateString = null;
		System.out.println("-----所有用户-----");
		System.out.print("\t id \t\t 用户名 \t\t 状态 \t\t 身份 \t\n");
		for (User user : list) {
			//封禁判断
			if (user.getState() == 0) {
				stateString = "正常";
			} else {
				stateString = "禁用";
			}
			//管理员判断
			if (user.getFlag() == 0) {
				flagString = "管理员";
			}else if(user.getFlag() == 2){
				flagString = "站长";
			} else {
				flagString = "用户";
			}
			System.out.println();
			System.out.print("\t"+user.getUid() +"\t\t"+ user.getUname()+"\t\t"+ stateString +"\t\t"+ flagString+"\t\n");
		}
		System.out.println("---------------");
	}

	public int alterUser(int uid, int state) {
		
		return adminService.alterUser(uid, state);
	}

	public int addBlock(String bname) {
		
		
		return adminService.addBlock(bname);
	}

	public int removeTopic(int tid) {
		
		
		return adminService.removeTopic(tid);
	}

	public User selectHotUser() {
		
		
		return adminService.selectHotUser();
	}
}
