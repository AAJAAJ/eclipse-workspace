/**
 * 
 */
package yunhe.entity;


/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月2日 上午11:49:51
 */
public class User {

	/**
	 * 用户ID,作为用户的唯一标识
	 */
	private int uid;
	/**
	 * 用户的名称,用户登录的账户
	 */
	private String uname;
	/**
	 * 用户的密码
	 */
	private String upass;
	/**
	 * 用户的当前状态
	 * 0代表正常 1代表禁用
	 */
	private int state;
	/**
	 * 用户的角色
	 * 0代表管理员 1代表用户
	 */
	private int flag=1;
	
	public User() {}

	public User(String uname, String upass) {
		this.uname = uname;
		this.upass = upass;
	}

	public User(int uid, String uname, String upass, int state, int flag) {
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.state = state;
		this.flag = flag;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", state=" + state + ", flag=" + flag
				+ "]";
	}
	
}
