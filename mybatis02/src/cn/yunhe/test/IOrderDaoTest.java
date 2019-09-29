package cn.yunhe.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.yunhe.dao.IOrderDao;
import cn.yunhe.entity.Order;

public class IOrderDaoTest {

	SqlSessionFactory factory = null;
	
	@Before
	public void setUp() throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void test() {
		//执行SQL语句
		SqlSession sqlSession = factory.openSession();
		//获取接口对象
		IOrderDao orderDao = sqlSession.getMapper(IOrderDao.class);
		//调用方法
		List<Order> orderList = orderDao.queryOrderInfos();
		
		for(Order order : orderList) {
			order.getUser();
		}
		
		sqlSession.close();
	}

}
