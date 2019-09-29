package cn.yunhe.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库工具类
 */
public class DBUtils {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/tribune?serverTimezone=UTC";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	
	//注册驱动
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	获取数据库连接对象
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 	增删改通用
	 * @param sql
	 * @param objects
	 * @return
	 */
	public static int insertOrUpdateOrDel(String sql,Object...objects) {
		Connection conn =  getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			//预编译SQL
			ps = conn.prepareStatement(sql);
			//赋值
			if(null != objects) {
				for(int i=0;i<objects.length;i++) {
					ps.setObject(i+1, objects[i]);
				}
			}
			//执行SQL
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn,ps,null);
		}
		return result;
	}
	
	/**
	 *	 关闭数据库连接对象
	 * @param conn
	 * @param statement
	 * @param rs
	 */
	public static void close(Connection conn,Statement statement,ResultSet rs) {
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
