package cn.yunhe.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtils {

	private static InputStream inputStream = null;
	private static final String SOURCE_PATH = "config/SqlMapConfig.xml";
	
	/**
	 * 获取SqlSession对象
	 * @return
	 * @throws FileNotFoundException
	 */
	public static SqlSession getSqlSession() throws FileNotFoundException {
		inputStream = new FileInputStream(SOURCE_PATH);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		return factory.openSession();
	}
	
	/**
	 * 	关闭SqlSession
	 * @param sqlSession
	 * @throws IOException 
	 */
	public static void closeSqlSession(SqlSession sqlSession) throws IOException {
		
		sqlSession.commit();
		inputStream.close();
		sqlSession.close();
	}
}
