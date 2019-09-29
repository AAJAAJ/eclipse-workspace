/**
 * 
 */
package cn.yunhe.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.yunhe.entity.User;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月24日 下午2:19:57
 */
public class test {

	public static void main(String[] args) {
		try {
			findUserById();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void findUserById() throws IOException {
		InputStream inputStream = new FileInputStream("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = factory.openSession();
		User user = sqlSession.selectOne("test.findUserById",4);
		System.out.println(user);
		
		inputStream.close();
		
		
	}
	
	
}
