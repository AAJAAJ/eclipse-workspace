/**
 * 
 */
package cn.yunhe.entiy;
/**
 * @author 魏无羡 
 *2019年9月22日
 */
public class User {
	private int uid;
	private String uname;
	private String password;
	public User() {}
	
	/**
	 * @param uid
	 * @param uname
	 * @param password
	 */
	public User(int uid, String uname, String password) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
	}

	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", password=" + password + "]";
	}
	
}
