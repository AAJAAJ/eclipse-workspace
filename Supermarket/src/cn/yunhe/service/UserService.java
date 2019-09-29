/**
 * 
 */
package cn.yunhe.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.yunhe.dao.UserDao;
import cn.yunhe.entity.User;

/**
 * @author 性感渣渣傲在线打bug 2019年9月25日 下午7:13:51
 */
public class UserService {

	static SqlSession sqlSession = null;
	// 调用dao层
	static UserDao userDao = null;

	public static void setUp() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = factory.openSession();
		userDao = sqlSession.getMapper(UserDao.class);
	}

	public List<User> allUser() {
		// 调用封装的方法
		try {
			setUp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<User> userList = userDao.allUser();
		sqlSession.close();
		return userList;
	}

	public int addUser(User user) {
		// 调用封装的方法
		try {
			setUp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result = userDao.addUser(user);
		// 提交事务
		sqlSession.commit();
		// 关闭
		sqlSession.close();
		return result;
	}

	public User queryUser(User usera){ //调用封装的方法
		
	try {
		setUp();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	User user = userDao.queryUser(usera);
	// 关闭
	sqlSession.close();return user;
}

}
