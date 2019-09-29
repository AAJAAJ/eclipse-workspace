/**
 * 
 */
package cn.yunhe.jdbc;



import java.sql.*;

import org.junit.Test;


/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月29日 下午4:22:14
 */
public class JDBCTest01 {
	@Test
	public void insert() {
		Connection conn = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/pet";
			String user="root";
		    String password="123456";
		    conn = DriverManager.getConnection(url, user, password);
		    statement = conn.createStatement();
		    String sql = "insert into petdata(name,gender,lv) values('刘备','女',10001)";
		    int result = statement.executeUpdate(sql);
			System.out.println(result);
		    
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
	
	
	
	
	
	
	
	
	
}
