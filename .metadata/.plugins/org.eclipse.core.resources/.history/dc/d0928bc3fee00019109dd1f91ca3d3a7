package cn.yunhe.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.yunhe.dao.IGoodsDao;
import cn.yunhe.entity.Goods;
import cn.yunhe.entity.GoodsDetail;

public class GoodsDaoTest {

	SqlSession sqlSession = null;
	
	@Before
	public void setUp() throws Exception {
		//读取配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建SqlSession工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//创建SqlSession对象
		sqlSession = factory.openSession();
	}

	@Test
	public void queryGoodsTest() {
		IGoodsDao goodsDao = sqlSession.getMapper(IGoodsDao.class);
		Goods goods = new Goods();
		/*
		 * GoodsDetail detail = new GoodsDetail(); detail.setGoodsName("本");
		 * detail.setPrice(6000); goods.setGoodsDetail(detail);
		 */
		List<Goods> goodsList = goodsDao.queryGoods(goods);
		System.out.println(goodsList);
	}

	@After
	public void close() throws Exception {
		sqlSession.commit();
		sqlSession.close();
	}
}
