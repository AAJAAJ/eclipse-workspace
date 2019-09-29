package cn.yunhe.entity;

public class User {

	private int uid;
	
	private String uname;
	
	private String upass;
	
	private int state;
	
	private int flag;
	
	public User() {}

	public User(int uid, String uname, String upass, int state, int flag) {
		super();
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
