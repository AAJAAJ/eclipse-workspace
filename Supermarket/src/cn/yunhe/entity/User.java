/**
 * 
 */
package cn.yunhe.entity;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月25日 下午5:27:05
 */
public class User {
	private int userid;
	private String username;
	private String password;
	 /**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int userid, String username, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
	}
	/**
	 * @return the userid
	 */
	public synchronized int getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public synchronized void setUserid(int userid) {
		this.userid = userid;
	}
	/**
	 * @return the username
	 */
	public synchronized String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public synchronized void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public synchronized String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public synchronized void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + "]";
	}
	
}
