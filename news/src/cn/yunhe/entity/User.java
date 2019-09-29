/**
 * 
 */
package cn.yunhe.entity;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月10日 下午7:47:01
 */
public class User {

	private int id;
	private String userName;
	private String pwd;
	/**
	 * @param id
	 * @param userName
	 * @param pwd
	 */
	public User() {}
	public User(int id, String userName, String pwd) {
		super();
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
	}
	/**
	 * @return the id
	 */
	public synchronized int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public synchronized void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the userName
	 */
	public synchronized String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public synchronized void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the pwd
	 */
	public synchronized String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public synchronized void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", pwd=" + pwd + "]";
	}
	
	
	
	
}
