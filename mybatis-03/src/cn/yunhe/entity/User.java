package cn.yunhe.entity;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int uid;
	
	private String uname;
	
	private String upwd;
	
	private String address;
	
	/**
	 * 是否是会员 0 普通用户 1 会员
	 */
	private int flag;
	
	private String sex;

	public User() {}
	
	public User(int uid, String uname, String upwd, String address, int flag, String sex) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.address = address;
		this.flag = flag;
		this.sex = sex;
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

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", address=" + address + ", flag=" + flag
				+ ", sex=" + sex + "]";
	}
}
