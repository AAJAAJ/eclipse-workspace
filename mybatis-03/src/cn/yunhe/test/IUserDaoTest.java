package cn.yunhe.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.yunhe.dao.IUserDao;
import cn.yunhe.entity.User;

public class IUserDaoTest {

	SqlSessionFactory factory = null;
	
	@Before
	public void setUp() throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void test() {
		SqlSession sqlSession = factory.openSession();
		IUserDao userDao = sqlSession.getMapper(IUserDao.class);
		User user = userDao.findUserById(1);
		System.out.println(user);
		
		user.setUname("Saint");
		userDao.updateUser(user);
		sqlSession.commit();
		
		User user2 = userDao.findUserById(1);
		System.out.println(user2);
		
		sqlSession.close();
	}
	
	@Test
	public void test1() {
		SqlSession sqlSession1 = factory.openSession();
		SqlSession sqlSession2 = factory.openSession();
		SqlSession sqlSession3 = factory.openSession();
		
		IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
		IUserDao userDao2 = sqlSession2.getMapper(IUserDao.class);
		IUserDao userDao3 = sqlSession3.getMapper(IUserDao.class);
		
		userDao1.findUserById(1);
		sqlSession1.commit();
		
		userDao2.findUserById(1);
		//上述两次查询只执行一次SQL文件,然后修改数据再次进行查询
		User user = new User();
		user.setUname("Juni");
		user.setUid(1);
		userDao1.updateUser(user);
		sqlSession1.commit();
		
		userDao3.findUserById(1);
		sqlSession3.commit();
		userDao1.findUserById(1);
		
		
		sqlSession1.close();
		sqlSession2.close();
		sqlSession3.close();
	}

}
