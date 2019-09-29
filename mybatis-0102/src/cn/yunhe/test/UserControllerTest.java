package cn.yunhe.test;

import static org.junit.Assert.fail;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.yunhe.dao.IUserDao;
import cn.yunhe.entity.User;

public class UserControllerTest {

	SqlSession sqlSession = null;
	
	/**
	 * 	�÷�������ִ��@Test֮ǰִ��
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		//��ȡ�����ļ�
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//����SqlSession����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//����SqlSession����
		sqlSession = factory.openSession();
	}

	@Test
	public void testAddUser() {
		IUserDao userDao = sqlSession.getMapper(IUserDao.class);
		User user = new User();
		user.setUname("¶¶");
		user.setUpass("111");
		int result = userDao.addUser(user);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(result);
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryUserById() {
		IUserDao userDao = sqlSession.getMapper(IUserDao.class);
		User user = userDao.queryUserById(6);
		System.out.println(user);
	}

	@Test
	public void testQueryUserList() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryAllUsers() {
		IUserDao userDao = sqlSession.getMapper(IUserDao.class);
		List<User> userList = userDao.queryAllUsers();
		System.out.println(userList);
	}

}
