/**
 * 
 */
package cn.yunhe.servlet;


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
 * @author 性感渣渣傲在线打bug
 * 2019年9月25日 下午6:29:33
 */
public class test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			addUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @throws IOException 
	 * 
	 */

	public static void addUser() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = factory.openSession();
		
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		List<User> userlist = userDao.allUser();
		for (User user : userlist) {
			System.out.println(user.getUsername());
		}
		
		sqlSession.commit();
		sqlSession.close();
	}
	public static void quUser() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = factory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		User usera = new User();
		usera.setUsername("a");
		usera.setPassword("w");
		User user = userDao.queryUser(usera);
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
