package cn.yunhe.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.yunhe.entity.User;
import cn.yunhe.utils.SqlSessionUtils;

/**
 * Mybatis测试类
 */
public class MyBatisTest {

	/**
	 * 	获取所有的用户信息
	 * @throws IOException 
	 */
	@Test
	public void findUserById() throws IOException {
		//创建SqlSession对象
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		User user = (User)sqlSession.selectOne("test.findUserById",6);
		System.out.println(user);
		SqlSessionUtils.closeSqlSession(sqlSession);
	}
	
	/**
	 * 	根据姓名模糊查询
	 * @throws IOException
	 */
	@Test
	public void queryByName() throws IOException {
		//读取配置文件
		InputStream inputStream = new FileInputStream("config/SqlMapConfig.xml");
		//创建SQLSession工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//创建SqlSession对象
		SqlSession sqlSession = factory.openSession();
		
		//List<User> userList = sqlSession.selectList("test.queryByName", "%白%");
		List<User> userList = sqlSession.selectList("test.queryByName", "白");
		for(User user : userList) {
			System.out.println(user.getUid()+"\t"+user.getUname());
		}
		
		inputStream.close();
		sqlSession.close();
	}
	
	
	/**
	 * 	添加用户
	 * @throws IOException
	 */
	@Test
	public void addUser() throws IOException {
		//读取配置文件
		InputStream inputStream = new FileInputStream("config/SqlMapConfig.xml");
		//创建SQLSession工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//创建SqlSession对象
		SqlSession sqlSession = factory.openSession();
		
		User user = new User();
		user.setUname("张晓松");
		user.setUpass("123");
		
		int result = sqlSession.insert("test.addUser", user);
		System.out.println(result);
		
		sqlSession.commit();
		//关闭IO流对象
		inputStream.close();
		sqlSession.close();
	}
	
	/**
	 * 	根据ID删除用户
	 * @throws IOException
	 */
	@Test
	public void delUserById() throws IOException {
		//读取配置文件
		InputStream inputStream = new FileInputStream("config/SqlMapConfig.xml");
		//创建SQLSession工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//创建SqlSession对象
		SqlSession sqlSession = factory.openSession();
		
		int result = sqlSession.delete("test.delUserById", 8);
		System.out.println(result);
		
		sqlSession.commit();
		//关闭IO流对象
		inputStream.close();
		sqlSession.close();
	}
	
	/**
	 * 	添加用户
	 * @throws IOException
	 */
	@Test
	public void addUser2() throws IOException {
		//读取配置文件
		InputStream inputStream = new FileInputStream("config/SqlMapConfig.xml");
		//创建SQLSession工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//创建SqlSession对象
		SqlSession sqlSession = factory.openSession();
		
		User user = new User();
		user.setUname("张晓松6");
		user.setUpass("123");
		user.setState(1);
		
		sqlSession.insert("test.addUser", user);
		
		sqlSession.commit();
		
		System.out.println(user);
		//关闭IO流对象
		inputStream.close();
		sqlSession.close();
	}
}
