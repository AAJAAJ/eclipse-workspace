/**
 * 
 */
package cn.yunhe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * @author 魏无羡 
 *2019年9月10日
 *	数据库链接
 */
public class DBLinks {
	private static final String name = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/news";
	private static final String user = "root";
	private static final String password = "190010";
	//静态代码块 类加载时加载
	static {
		//反射
		try {
			Class.forName(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取数据库链接对象
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			//注册驱动
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 预编译形式增删改功能封装
	 * 
	 * @param sql
	 * @param objects
	 * @return
	 */
	public static int cudPre(String sql, Object... objects) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			// 获取数据库连接对象
			conn = getConnection();
			// 获取执行SQL的对象
			ps = conn.prepareStatement(sql);
			// 设置传递过来的参数
			for (int i = 0; i < objects.length; i++) {
				// 数组的下标是从零开始,目的是为了取数组中的数据
				// 占位符(?)从1开始,标识的是占位符的位置
				ps.setObject(i + 1, objects[i]);
			}
			result = ps.executeUpdate();
		}catch (MySQLIntegrityConstraintViolationException t) {
			System.out.println("用户名已存在");
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库链接对象
			close(conn, ps, null);
		}
		return result;
	}
	//关闭
		public static void close(Connection cn,PreparedStatement ps,ResultSet rs) {
			try {
				if (rs!=null) {
					rs.close();
				}
				if (ps!=null) {
					ps.close();
				}
				if (cn!=null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
