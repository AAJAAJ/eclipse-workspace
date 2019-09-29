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

import cn.yunhe.dao.ProductDao;
import cn.yunhe.dao.UserDao;
import cn.yunhe.entity.Product;
import cn.yunhe.entity.User;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月26日 上午11:10:26
 */
public class ProductService {
	
	public List<Product> allProduct() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = factory.openSession();
		ProductDao productDao = sqlSession.getMapper(ProductDao.class);
		
		List<Product> productList = productDao.allProduct();
		sqlSession.close();
		return productList;
	}
}
