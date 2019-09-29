package cn.yunhe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 什么是JDBC?Java Database Connection
 * 为什么要用这个东西?
 * 	连接数据库对数据进行操作(CURD--create update research delete)
 * 步骤:
 * 	连接到数据库
 * 		注册驱动
 * 		登录数据库
 * 	拿数据
 * 		创建
 * 		查询
 * 		删除
 * 		修改
 * 	关闭连接
 * 	业务逻辑处理
 * 
 * 需求:
 * 	根据学号查询成绩
 * 
 * 数据库分析:隔离性--互不关联
 * 	成绩表
 * 		scid
 * 		score
 * 		sid
 * 		cid
 * 	学生表
 * 		sid
 * 		sname
 * 		sno
 * 		sex
 * 	课程表
 * 		cid
 * 		cname
 * 	教师表
 * 		tid
 * 		tname
 * 		cid
 * 
 * 步骤:
 * 	1 先将jar包与项目关联
 * 	2 通过反射,注册驱动
 * 	3 输入用户名和密码及数据库地址链接数据库
 * 	4 CURD
 * 	5 业务逻辑处理
 * 	6 关闭数据库
 * 
 * DriverManager		驱动服务类
 * Statement			SQL执行及结果返回接口
 * ResultSet			封装的结果集对象
 * 
 * 
 */
public class JDBCTest {

	/**
	 * 链接数据库添加数据
	 */
	@Test
	public void insertMethod() {
		Connection conn = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/school?serverTimezone=UTC";
			String user = "root";
			String password = "root";
			//注册驱动
			conn = DriverManager.getConnection(url, user, password);
			//获取执行SQL语句的对象
			statement = conn.createStatement();
			String sql = "insert into t_student(sname,sno,sex) values('刘备',10001,'女')";
			//执行sql---返回值为int类型,0代表失败1代表成功
			int result = statement.executeUpdate(sql);
			System.out.println(result);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement != null) {
					statement.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 修改数据
	 */
	@Test
	public void updateMethod() {
		Connection conn = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/school?serverTimezone=UTC";
			String user = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, user, password);
			statement = conn.createStatement();
			String sql = "update t_student set sex='男' where sno=10001";
			int result = statement.executeUpdate(sql);
			System.out.println(result);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement != null) {
					statement.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 删除指定数据
	 */
	@Test
	public void delMethod() {
		Connection conn = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/school?serverTimezone=UTC";
			String user = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, user, password);
			statement = conn.createStatement();
			String sql = "delete from t_student where sno=10001";
			int result = statement.executeUpdate(sql);
			System.out.println(result);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement != null) {
					statement.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 查询数据
	 */
	@Test
	public void queryMethod() {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/school?serverTimezone=UTC";
			String user = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, user, password);
			statement = conn.createStatement();
			String sql = "select * from t_student";
			rs = statement.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"--"+rs.getString(2)+"--"+rs.getString(3)+"--"+rs.getString(4));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
