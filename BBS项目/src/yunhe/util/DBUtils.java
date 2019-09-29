/**
 * 
 */
package yunhe.util;

import java.sql.*;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;



/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月2日 上午11:42:18
 * 
 */
public class DBUtils {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/tribune";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "123456";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//获取连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//预编译增删改
	public static int cudPre(String sql,Object...objects) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			//获取数据库连接对象
			conn = getConnection();
			//获取执行SQL的对象
			ps = conn.prepareStatement(sql);
			//遍历参数
			for(int i=0;i<objects.length;i++) {
				//设置占位符的值
				ps.setObject(i+1, objects[i]);
			}
			result = ps.executeUpdate();
		}catch (MySQLIntegrityConstraintViolationException d) {
			System.out.println("重复数据");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭数据库链接对象
			close(conn,ps,null);
		}
		return result;
	}
	//关闭数据库连接
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
