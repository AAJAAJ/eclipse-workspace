/**
 * 
 */
package yunhe.service.impl;

import java.util.ArrayList;

import yunhe.dao.AdminDao;
import yunhe.dao.impl.AdminDaoImpl;
import yunhe.entity.User;
import yunhe.service.AdminService;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月3日 上午11:22:43
 */
public class AdminServiceImpl implements AdminService{

	AdminDao adminDao = new AdminDaoImpl();
	@Override
	public ArrayList<User> selectUser() {
		ArrayList<User> list = adminDao.selectUser();
		return list;
	}

	@Override
	public int alterUser(int uid, int state) {
		
		return adminDao.alterUser(uid, state);
	}

	@Override
	public int addBlock(String bname) {
		// TODO Auto-generated method stub
		return adminDao.addBlock(bname);
	}

	@Override
	public int removeTopic(int tid) {
		// TODO Auto-generated method stub
		return adminDao.removeTopic(tid);
	}

	@Override
	public User selectHotUser() {
		// TODO Auto-generated method stub
		return adminDao.selectHotUser();
	}

}
