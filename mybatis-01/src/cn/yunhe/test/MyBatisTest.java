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
 * Mybatis������
 */
public class MyBatisTest {

	/**
	 * 	��ȡ���е��û���Ϣ
	 * @throws IOException 
	 */
	@Test
	public void findUserById() throws IOException {
		//����SqlSession����
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		User user = (User)sqlSession.selectOne("test.findUserById",6);
		System.out.println(user);
		SqlSessionUtils.closeSqlSession(sqlSession);
	}
	
	/**
	 * 	��������ģ����ѯ
	 * @throws IOException
	 */
	@Test
	public void queryByName() throws IOException {
		//��ȡ�����ļ�
		InputStream inputStream = new FileInputStream("config/SqlMapConfig.xml");
		//����SQLSession����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//����SqlSession����
		SqlSession sqlSession = factory.openSession();
		
		//List<User> userList = sqlSession.selectList("test.queryByName", "%��%");
		List<User> userList = sqlSession.selectList("test.queryByName", "��");
		for(User user : userList) {
			System.out.println(user.getUid()+"\t"+user.getUname());
		}
		
		inputStream.close();
		sqlSession.close();
	}
	
	
	/**
	 * 	����û�
	 * @throws IOException
	 */
	@Test
	public void addUser() throws IOException {
		//��ȡ�����ļ�
		InputStream inputStream = new FileInputStream("config/SqlMapConfig.xml");
		//����SQLSession����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//����SqlSession����
		SqlSession sqlSession = factory.openSession();
		
		User user = new User();
		user.setUname("������");
		user.setUpass("123");
		
		int result = sqlSession.insert("test.addUser", user);
		System.out.println(result);
		
		sqlSession.commit();
		//�ر�IO������
		inputStream.close();
		sqlSession.close();
	}
	
	/**
	 * 	����IDɾ���û�
	 * @throws IOException
	 */
	@Test
	public void delUserById() throws IOException {
		//��ȡ�����ļ�
		InputStream inputStream = new FileInputStream("config/SqlMapConfig.xml");
		//����SQLSession����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//����SqlSession����
		SqlSession sqlSession = factory.openSession();
		
		int result = sqlSession.delete("test.delUserById", 8);
		System.out.println(result);
		
		sqlSession.commit();
		//�ر�IO������
		inputStream.close();
		sqlSession.close();
	}
	
	/**
	 * 	����û�
	 * @throws IOException
	 */
	@Test
	public void addUser2() throws IOException {
		//��ȡ�����ļ�
		InputStream inputStream = new FileInputStream("config/SqlMapConfig.xml");
		//����SQLSession����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//����SqlSession����
		SqlSession sqlSession = factory.openSession();
		
		User user = new User();
		user.setUname("������6");
		user.setUpass("123");
		user.setState(1);
		
		sqlSession.insert("test.addUser", user);
		
		sqlSession.commit();
		
		System.out.println(user);
		//�ر�IO������
		inputStream.close();
		sqlSession.close();
	}
}
